package dev.que;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>(10);
    }

    private Branch findBranch(String branchName) {
        for (Branch elem : branches) {
            if (elem.getName().equalsIgnoreCase(branchName)) {
                return elem;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double Transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, Transaction);
        }
        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            var customers = branch.getCustomers();

            System.out.printf("Customer details for branch %s%n", branch.getName());
            int i = 0;
            for (Customer customer : customers) {
                i++;
                System.out.printf("Customer: %s[%d]%n", customer.getName(), i);
                if (printTransactions){
                    int j = 0;
                    var transactions = customer.getTransactions();

                    System.out.println("Transactions");
                    for (double transaction : transactions){
                        j++;
                        System.out.printf("[%d]  Amount %.2f%n", j, transaction);
                    }
                }
            }
            return true;
        }
        return false;
    }
}
