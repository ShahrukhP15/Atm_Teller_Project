package persistence;

import model.Account;
import model.AllAccounts;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads data of accounts from file and returns it;
    // throws IOException if an error occurs reading data from file
    public AllAccounts read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAccounts(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses allAccounts from JSON object and returns it
    private AllAccounts parseAccounts(JSONObject jsonObject) {
        AllAccounts allAccounts = new AllAccounts();
        JSONArray jsonArray = jsonObject.getJSONArray("accounts");
        for (Object json : jsonArray) {
            JSONObject nextAccount = (JSONObject) json;
            addAccount(allAccounts,nextAccount);
        }
        return allAccounts;
    }


    // MODIFIES: account
    // EFFECTS: add each Account read from JSON object to account
    private void addAccount(AllAccounts accounts, JSONObject jsonObject) {
        Integer balance = jsonObject.getInt("balance");
        String password = jsonObject.getString("password");
        String username = jsonObject.getString("username");
        Account account = accounts.addAccount(username,password);
        account.setBalance(balance);
    }
}
