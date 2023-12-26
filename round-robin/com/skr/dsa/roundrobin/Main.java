package com.skr.dsa.roundrobin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Server> servers = new ArrayList<>();
        servers.add(new Server("Server1"));
        servers.add(new Server("Server2"));
        servers.add(new Server("Server3"));

        LoadBalancer loadBalancer = new LoadBalancer(servers);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Get next server");
            System.out.println("2. Mark server as down");
            System.out.println("3. Mark server as up");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Server nextServer = loadBalancer.getNextServer();
                    if (nextServer != null) {
                        System.out.println("Next server: " + nextServer.getName());
                    } else {
                        System.out.println("No available servers.");
                    }
                    break;
                case 2:
                    System.out.print("Enter server name to mark as down: ");
                    String downServerName = scanner.next();
                    markServerDown(servers, downServerName);
                    break;
                case 3:
                    System.out.print("Enter server name to mark as up: ");
                    String upServerName = scanner.next();
                    markServerUp(servers, upServerName);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Exiting the load balancer.");
    }

    private static void markServerDown(List<Server> servers, String serverName) {
        for (Server server : servers) {
            if (server.getName().equalsIgnoreCase(serverName)) {
                server.markDown();
                System.out.println(serverName + " is marked as down.");
                return;
            }
        }
        System.out.println("Server not found.");
    }

    private static void markServerUp(List<Server> servers, String serverName) {
        for (Server server : servers) {
            if (server.getName().equalsIgnoreCase(serverName)) {
                server.markUp();
                System.out.println(serverName + " is marked as up.");
                return;
            }
        }
        System.out.println("Server not found.");
    }
}

