package com.skr.dsa.roundrobin;

public final class Server {

    private final String name;
    private boolean isUp;

    public Server(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isUp() {
        return isUp;
    }

    public void markDown() {
        isUp = false;
    }

    public void markUp() {
        isUp = true;
    }
}
