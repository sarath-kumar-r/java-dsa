package com.sarathkumar.dsa.roundrobin;

import java.util.List;

public class LoadBalancer {
    private final List<Server> servers;
    private int currentIndex;

    public LoadBalancer(List<Server> servers) {
        this.servers = servers;
        this.currentIndex = 0;
    }

    public Server getNextServer() {
        int numServers = servers.size();
        if (numServers == 0) {
            return null;
        }

        Server nextServer = servers.get(currentIndex);
        currentIndex = (currentIndex + 1) % numServers;

        // Skip servers that are marked as down
        while (!nextServer.isUp() && currentIndex != 0) {
            nextServer = servers.get(currentIndex);
            currentIndex = (currentIndex + 1) % numServers;
        }

        return nextServer.isUp() ? nextServer : null;
    }
}
