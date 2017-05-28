package com.bank.dao;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

import java.util.ArrayList;

public interface Dao {
    User getUser(String email);
    User getUser(int id);
    ArrayList<User> getUsersForAccount(Account a);
    boolean addUser(String fName, String lName, String password, String email);
    boolean updateUser(User u);
    boolean addUserToAccount(User u, Account a);

    Account getAccount(int id);
    ArrayList<Account> getAccountsForUser(User u);
    int getNumOfAccounts(User u);
    Account addAccount(User u, int typeId);
    boolean updateAccount(Account a);

    boolean transferFunds(int fromId, int toId, double amt);
    ArrayList<AccountType> getAccountTypes();
}
