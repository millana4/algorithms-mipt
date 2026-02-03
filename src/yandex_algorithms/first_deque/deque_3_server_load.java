package yandex_algorithms.first_deque;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class deque_3_server_load {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String loadData = br.readLine();
        String[] parts = loadData.split(" ");
        int packagesQuantity = Integer.parseInt(parts[0]);
        int serversQuantity = Integer.parseInt(parts[1]);

        long[] servers = new long[serversQuantity];
        for (int i = 0; i < serversQuantity; i++) {servers[i] = 0;}

        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < packagesQuantity; i++) {
            String packageData = br.readLine();
            String[] partsPack = packageData.split(" ");
            long comingTime = Long.parseLong(partsPack[0]);
            long workingTime = Long.parseLong(partsPack[1]);

            int serverToDo = 0;
            long min = servers[0];
            for (int j = 1; j < serversQuantity; j++) {
                if (servers[j] < min) {
                    min = servers[j];
                    serverToDo = j;
                }
            }

            long startTime = Math.max(servers[serverToDo], comingTime);
            long finishTime = startTime + workingTime;
            servers[serverToDo] = finishTime;
            
            output.append(finishTime).append(" ");
        }
        
        System.out.println(output.toString().trim());
    }
}
