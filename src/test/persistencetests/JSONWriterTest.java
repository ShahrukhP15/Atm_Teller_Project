package persistencetests;

import model.Account;
import model.AllAccounts;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JSONWriterTest extends JSONTest{
    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }


    @Test
    void testWriterEmptyAccounts() {
        try {
            AllAccounts allAccounts = new AllAccounts();
            JsonWriter writer = new JsonWriter("./data/testWriterEmpty.json");
            writer.open();
            writer.write(allAccounts);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmpty.json");
            allAccounts = reader.read();
            assertEquals(0, allAccounts.getAccounts().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralAccounts() {
        try {
            AllAccounts allAccounts = new AllAccounts();

            Account a1 = new Account("a","222");
            Account a2 = new Account("b","333");
            a2.setBalance(20);

            allAccounts.getAccounts().add(a1);
            allAccounts.getAccounts().add(a2);


            JsonWriter writer = new JsonWriter("./data/testWriterGeneralAccounts.json");
            writer.open();
            writer.write(allAccounts);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralAccounts.json");
            AllAccounts allAccounts1 = reader.read();
            List<Account> accounts = allAccounts1.getAccounts();

            checkAccount("a","222",0,accounts.get(0));
            checkAccount("b","333",20,accounts.get(1));


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
