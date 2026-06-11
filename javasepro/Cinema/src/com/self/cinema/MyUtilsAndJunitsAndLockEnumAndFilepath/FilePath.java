package com.self.cinema.MyUtilsAndJunitsAndLockEnumAndFilepath;

public enum FilePath {
    CINEMA_PATH_TO_TXT("K:\\study\\java+JDBC\\java code\\javasepro\\Cinema\\src\\com\\self\\cinema\\CinemaManage\\Logs\\cinema.txt"),
    CINEMA_PATH_TO_XML("K:\\study\\java+JDBC\\java code\\javasepro\\Cinema\\src\\com\\self\\cinema\\CinemaManage\\Logs\\Cinema.xml"),
    CUSTOMER_PATH_TO_TXT("K:\\study\\java+JDBC\\java code\\javasepro\\Cinema\\src\\com\\self\\cinema\\CustomerManage\\Logs\\customers.txt"),
    CUSTOMER_PATH_TO_XML("K:\\study\\java+JDBC\\java code\\javasepro\\Cinema\\src\\com\\self\\cinema\\CustomerManage\\Logs\\customers.xml"),
    WORKER_PATH_TO_TXT("K:\\study\\java+JDBC\\java code\\javasepro\\Cinema\\src\\com\\self\\cinema\\WorkerManage\\Logs\\workers.txt"),
    WORKER_PATH_TO_XML("K:\\study\\java+JDBC\\java code\\javasepro\\Cinema\\src\\com\\self\\cinema\\WorkerManage\\Logs\\workers.xml");
    private final String path;

    public String getPath() {
        return path;
    }

    FilePath(String path) {
        this.path = path;
    }
}
