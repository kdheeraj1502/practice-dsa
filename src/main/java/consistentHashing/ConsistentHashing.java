package consistentHashing;

import java.util.Map;
import java.util.TreeMap;

public class ConsistentHashing {

    TreeMap<Integer , Server> circle = new TreeMap<>();
    public int replica; //virtual node

    ConsistentHashing(int replica){
        this.replica = replica;
    }
    public void addServer(Server server){
        for(int i = 0; i<replica ; i++){
            int hash = HashFunction.hash(server.getName()+i);
            circle.put(hash, server);
        }
    }

    public void removeServer(Server server){
        for(int i = 0; i<replica ; i++){
            int hash = HashFunction.hash(server.getName()+i);
            circle.remove(hash);
        }
    }

    //get the server for a given key
    public Server getServer(String key){
        if(circle.isEmpty()){
            return null;
        }
        int hash = HashFunction.hash(key);
        Map.Entry<Integer, Server> entry = circle.ceilingEntry(hash);
        if(entry == null){
            entry = circle.firstEntry();
        }
        return entry.getValue();
    }

    public static void main(String[] args) {
        ConsistentHashing consistentHashing = new ConsistentHashing(3);

        // Add servers to the circle
        Server serverA = new Server("ServerA");
        Server serverB = new Server("ServerB");
        consistentHashing.addServer(serverA);
        consistentHashing.addServer(serverB);

        // Get server for a key
        String key = "Pkpc123";
        Server assignedServer = consistentHashing.getServer(key);

        System.out.println("Key '" + key + "' is assigned to Server: " + assignedServer.getName());
    }
}
