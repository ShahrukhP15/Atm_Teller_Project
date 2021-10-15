package modeltests;

import model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for Account class
class AccountsTest {
    public static int INITIAL_BALANCE = 1000;

    Account testAccount;

    @BeforeEach
    public void runBefore() {
        testAccount = new Account(INITIAL_BALANCE);
    }

    @Test
    public void testConstructor() {
        assertEquals(INITIAL_BALANCE, testAccount.getBalance());
    }

    @Test
    public void testDepositOnce() {
        int depositedAmount = 500;
        testAccount.deposit(depositedAmount);
        assertEquals(INITIAL_BALANCE + depositedAmount, testAccount.getBalance());
    }

    @Test
    public void testDepositManyTimes() {
        int depositedAmount = 500;
        testAccount.deposit(depositedAmount);
        assertEquals(INITIAL_BALANCE + depositedAmount, testAccount.getBalance());
        testAccount.deposit(depositedAmount);
        assertEquals(INITIAL_BALANCE + depositedAmount + depositedAmount, testAccount.getBalance());
    }

    @Test
    public void testUnsuccessfulWithdraw() {
        int temp = 1500;
        assertFalse(testAccount.withdraw(temp));
    }

    @Test
    public void testSuccessfulWithdrawOnce() {
        int temp = 500;
        testAccount.withdraw(temp);
        assertEquals(INITIAL_BALANCE - temp, testAccount.getBalance());
    }

    @Test
    public void testSuccessfulWithdrawFullBalance() {
        testAccount.withdraw(INITIAL_BALANCE);
        assertEquals(0, testAccount.getBalance());
    }

    @Test
    public void testSuccessfulWithdrawManyTimes() {
        int temp = 300;
        testAccount.withdraw(temp);
        assertEquals(INITIAL_BALANCE - temp, testAccount.getBalance());
        testAccount.withdraw(temp);
        assertEquals(INITIAL_BALANCE - temp - temp, testAccount.getBalance());
        testAccount.withdraw(temp);
        assertEquals(INITIAL_BALANCE - (temp * 3) , testAccount.getBalance());
    }

    @Test
    public void testSuccessfulWithdrawManyTimesFullAmount() {
        int temp = 500;
        testAccount.withdraw(temp);
        assertEquals(INITIAL_BALANCE - temp, testAccount.getBalance());
        testAccount.withdraw(temp);
        assertEquals(INITIAL_BALANCE - temp - temp, testAccount.getBalance());
    }

    @Test
    public void testSuccessfulWithdrawOnceThenFail() {
        int temp = 600;
        testAccount.withdraw(temp);
        assertEquals(INITIAL_BALANCE - temp, testAccount.getBalance());
        testAccount.withdraw(temp);
        assertFalse(testAccount.withdraw(temp));
    }

    @Test
    public void testGetBalance() {
        //testAccount.checkBalance(INITIAL_BALANCE);
        assertEquals(INITIAL_BALANCE, testAccount.getBalance());
        testAccount.deposit(100);
        assertEquals(INITIAL_BALANCE + 100, testAccount.getBalance());
    }

    @Test
    public void testSetUserName() {
        String name= "xyz";
        testAccount.setUsername(name);
        assertEquals(name,testAccount.getUsername());
    }

    @Test
    public void testSetPassword() {
        int temp = 122334;
        testAccount.setPassword(temp);
        assertEquals(temp, testAccount.getPassword());
    }
}