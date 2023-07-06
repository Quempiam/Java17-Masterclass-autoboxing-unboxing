package dev.que;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>(1000);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String customerName) {
        for(Customer elem : customers){
            if(elem.getName().equalsIgnoreCase(customerName)){
                return elem;
            }
        }
        return null;
    }

    public boolean newCustomer(String customerName, double initTransaction){
        if(findCustomer(customerName) == null){
            customers.add(new Customer(customerName, initTransaction));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transaction){
        Customer customer = findCustomer(customerName);
        if(customer == null){
            return false;
        }
        customer.addTransaction(transaction);
        return true;
    }
}
