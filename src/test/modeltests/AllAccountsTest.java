package modeltests;

import exceptions.NotFoundException;
import model.Account;
import model.AllAccounts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AllAccountsTest {
    AllAccounts testAccounts;
    Account account;


    @BeforeEach
    public void runBefore() {
        testAccounts = new AllAccounts();
    }

    @Test
    public void addAccountTest(){
        assertEquals(0, testAccounts.getAccounts().size());
        account = testAccounts.addAccount("abc","123");
        assertEquals(1, testAccounts.getAccounts().size());
        assertTrue(testAccounts.getAccounts().contains(account));
    }
    @Test
    public void lookupAccountTestFound(){
        assertEquals(0, testAccounts.getAccounts().size());
        account = testAccounts.addAccount("abc","123");
        try {
            Account test = testAccounts.lookupAccount("abc","123");
            assertEquals(test,account);
        } catch (NotFoundException e) {
            fail();
        }
    }
    @Test
    public void lookupAccountTestNotFoundListEmpty(){
        assertEquals(0, testAccounts.getAccounts().size());
        try {
            Account test = testAccounts.lookupAccount("xD","123");
            fail();
        } catch (NotFoundException e) {
            //expected
        }
    }
    @Test
    public void lookupAccountTestNotFoundWrongUserID(){
        assertEquals(0, testAccounts.getAccounts().size());
        account = testAccounts.addAccount("abc","123");
        try {
            Account test = testAccounts.lookupAccount("xD","123");
            fail();
        } catch (NotFoundException e) {
            //expected
        }
    }
    @Test
    public void lookupAccountTestNotFoundWrongPassword(){
        assertEquals(0, testAccounts.getAccounts().size());
        account = testAccounts.addAccount("abc","123");
        try {
            Account test = testAccounts.lookupAccount("abc","321");
            fail();
        } catch (NotFoundException e) {
            //expected
        }
    }

    @Test
    public void lookupAccountTestNotFoundWrongPasswordAndUser(){
        assertEquals(0, testAccounts.getAccounts().size());
        account = testAccounts.addAccount("abc","123");
        try {
            Account test = testAccounts.lookupAccount("dad","321");
            fail();
        } catch (NotFoundException e) {
            //expected
        }
    }
}