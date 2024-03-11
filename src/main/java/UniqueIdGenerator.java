import java.time.Duration;
import java.time.Instant;

public class UniqueIdGenerator {
    private static final long EPOCH = 1288834974657L; // Twitter Snowflake default epoch
    private static final int TIMESTAMP_BITS = 41;
    private static final int DATA_CENTER_ID_BITS = 5;
    private static final int MACHINE_ID_BITS = 5;
    private static final int SEQUENCE_BITS = 12;

    private long lastTimestamp = -1L;
    private int sequence = 0;
    private int lastSequenceId = -1;
    private volatile boolean running = true;

    // Background task to monitor time and reset sequence at the start of every millisecond
    private Thread timeMonitorThread = new Thread(() -> {
        while (running) {
            long currentTimestamp = getCurrentTimestamp();
            if (currentTimestamp != lastTimestamp) {
                sequence = 0; // Reset sequence number for the new millisecond
                lastTimestamp = currentTimestamp;
            }
        }
    });

    public UniqueIdGenerator() {
        timeMonitorThread.start();
    }

    public void shutdown() {
        running = false;
        try {
            timeMonitorThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized long generateUniqueId(int dataCenterId, int machineId) {
        // Increment sequence number for each ID generated within the same millisecond
        sequence = (sequence + 1) & ((1 << SEQUENCE_BITS) - 1);
        if (sequence == 0) {
            // Sequence overflow, wait until next millisecond
            waitNextMillis();
        }

        // Generate and return unique ID using the timestamp, datacenter ID, machine ID, and sequence number
        long timestamp = getCurrentTimestamp();
        int sequenceId = getNextSequenceId();
        long uniqueId = generateId(timestamp, dataCenterId, machineId, sequence, sequenceId);
        lastSequenceId = sequenceId;
        return uniqueId;
    }

    private int getNextSequenceId() {
        // Increment the sequence ID for each sequence within the same millisecond
        lastSequenceId++;
        return lastSequenceId;
    }

    private long getCurrentTimestamp() {
        // Get current timestamp in milliseconds since the epoch
        Instant now = Instant.now();
        return Duration.between(Instant.ofEpochMilli(EPOCH), now).toMillis();
    }

    private void waitNextMillis() {
        long currentTimestamp;
        do {
            currentTimestamp = getCurrentTimestamp();
        } while (currentTimestamp <= lastTimestamp);
    }

    private long generateId(long timestamp, int dataCenterId, int machineId, int sequence, int sequenceId) {
        // Implement logic to generate the unique ID using the provided parameters
        // For example, combine timestamp, datacenter ID, machine ID, sequence number, and sequence ID
        long id = ((timestamp - EPOCH) << (SEQUENCE_BITS + DATA_CENTER_ID_BITS + MACHINE_ID_BITS))
                | (dataCenterId << (SEQUENCE_BITS + MACHINE_ID_BITS))
                | (machineId << SEQUENCE_BITS)
                | sequence
                | (sequenceId << SEQUENCE_BITS);
        return id;
    }

    // Main method for testing
    public static void main(String[] args) {
        UniqueIdGenerator idGenerator = new UniqueIdGenerator();

        // Generate some IDs for testing
        for (int i = 0; i < 10; i++) {
            System.out.println(idGenerator.generateUniqueId(1, 1));
        }

        // Shutdown the generator
      //  idGenerator.shutdown();
    }
}
