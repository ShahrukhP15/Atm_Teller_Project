package modeltests;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidException;
import model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Unit tests for Account class
class AccountsTest {
    private Account account;

    @BeforeEach
    public void runBefore() {
        account = new Account("abc", "123");
    }

    @Test
    public void getterTest() {
        assertEquals(account.getUsername(), "abc");
        assertEquals(account.getPassword(), "123");
        assertEquals(account.getBalance(), 0);
        account.setBalance(100);
        assertEquals(account.getBalance(), 100);

    }

    @Test
    public void depositLegal() {
        try {
            account.deposit(120);
        } catch (InvalidException e) {
            fail();
        }
        assertEquals(account.getBalance(), 120);
    }

    @Test
    public void depositNegative() {
        try {
            account.deposit(-120);
            fail();
        } catch (InvalidException e) {
            // expected
        }
        assertEquals(account.getBalance(), 0);
    }

    @Test
    public void withdrawLessThanFullAmount(){
        account.setBalance(100);
        try {
            account.withdraw(99);
        } catch (InvalidException e) {
            fail();
        } catch (InsufficientBalanceException e) {
            fail();
        }
        assertEquals(account.getBalance(),1);
    }

    @Test
    public void withdrawFullAmount(){
        account.setBalance(100);
        try {
            account.withdraw(100);
        } catch (InvalidException e) {
            fail();
        } catch (InsufficientBalanceException e) {
            fail();
        }
        assertEquals(account.getBalance(),0);
    }
    @Test
    public void withdrawMoreThanFullAmount(){
        account.setBalance(100);
        try {
            account.withdraw(101);
            fail();
        } catch (InvalidException e) {
            fail();
        } catch (InsufficientBalanceException e) {
            //expected
        }
        assertEquals(account.getBalance(),100);
    }
    @Test
    public void withdrawNegativeAmount(){
        account.setBalance(100);
        try {
            account.withdraw(-1);
            fail();
        } catch (InvalidException e) {
            // expected
        } catch (InsufficientBalanceException e) {
            fail();
        }
        assertEquals(account.getBalance(),100);
    }
    @Test
    public void withdrawZero(){
        account.setBalance(100);
        try {
            account.withdraw(0);
        } catch (InvalidException e) {
            fail();
        } catch (InsufficientBalanceException e) {
            fail();
        }
        assertEquals(account.getBalance(),100);
    }

}

