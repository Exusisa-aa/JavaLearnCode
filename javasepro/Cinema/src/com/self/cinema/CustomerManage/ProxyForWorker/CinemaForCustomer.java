package com.self.cinema.CustomerManage.ProxyForWorker;

import com.self.cinema.CustomerManage.Customer.Customer;


public interface CinemaForCustomer {
    void startSystemForCustomer();
    Customer customerLogin();
    void successLogin(Customer customer);
    void createCustomer();
    void showMovieInfo();
    void addMoney(Customer customer);
    void showMoneyAndInfo(Customer customer);
    void toFeedback(Customer customer);
    void addFriend(Customer customer);
    void chatWithFriend(Customer customer);
    void printRecord(Customer customer);
    void buyTicket(Customer customer);
    void returnTicket(Customer customer);
}
