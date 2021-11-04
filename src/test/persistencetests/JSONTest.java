package persistencetests;

import model.Account;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTest {
    protected void checkAccount(String username, String password, int balance, Account account){
        assertEquals(account.getUsername(),username);
        assertEquals(account.getPassword(),password);
        assertEquals(account.getBalance(),balance);
    }
}
