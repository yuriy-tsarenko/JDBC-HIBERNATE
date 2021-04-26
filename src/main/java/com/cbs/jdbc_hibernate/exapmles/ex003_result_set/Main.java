package com.cbs.jdbc_hibernate.exapmles.ex003_result_set;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataBaseConnector worker = new DataBaseConnector();
        List<Customer> clients = worker.getAllClients();
        System.out.printf("db has customers: %d", clients.size());
    }

}
