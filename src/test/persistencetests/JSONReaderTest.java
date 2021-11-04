package persistencetests;

import model.Account;
import model.AllAccounts;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JSONReaderTest extends JSONTest{
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            AllAccounts accounts = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyAccounts() {
        JsonReader reader = new JsonReader("./data/emptydata.json");
        try {
            AllAccounts accounts = reader.read();
            assertEquals(0, accounts.getAccounts().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralAccounts() {
        JsonReader reader = new JsonReader("./data/testData.json");
        try {
            AllAccounts allAccounts = reader.read();
            List<Account> accounts = allAccounts.getAccounts();
            assertEquals(2, accounts.size());

            checkAccount("abc","123",100,accounts.get(0));
            checkAccount("srk","321",200,accounts.get(1));


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
