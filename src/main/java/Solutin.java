import java.util.*;

class Solutin {

    public static void main(String[] args) {
        String s = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
        int ans = solution(s);

        System.out.println(ans);
    }
    public static int solution(String S) {
        String[] logs = S.split("\n");
        Map<String, Integer> callDurations = new HashMap<>();
        int maxDuration = 0;

        for (String log : logs) {
            String[] parts = log.split(",");

            if (parts.length < 2) {
                continue; // Skip lines that don't have both duration and phone number
            }

            String durationStr = parts[0];
            String phoneNumber = parts[1];

            int duration = calculateDurationInSeconds(durationStr);
            callDurations.put(phoneNumber, callDurations.getOrDefault(phoneNumber, 0) + duration);

            if (callDurations.get(phoneNumber) > maxDuration) {
                maxDuration = callDurations.get(phoneNumber);
            }
        }

        int totalCost = 0;
        for (String log : logs) {
            String[] parts = log.split(",");

            if (parts.length < 2) {
                continue; // Skip lines that don't have both duration and phone number
            }

            String durationStr = parts[0];
            String phoneNumber = parts[1];

            int duration = calculateDurationInSeconds(durationStr);

            if (callDurations.get(phoneNumber) == maxDuration) {
                continue; // This call is free
            }

            int roundedMinutes = (int) Math.ceil((double) duration / 60);

            if (roundedMinutes <= 5) {
                totalCost += duration * 3;
            } else {
                totalCost += roundedMinutes * 150;
            }
        }

        return totalCost;
    }

    private static int calculateDurationInSeconds(String durationStr) {
        String[] timeParts = durationStr.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }
}

