package ui;

import model.AllAccounts;
import persistence.JsonReader;
import persistence.JsonWriter;

// A Dashboard with a GUI for user to interact and give inputs
public class DashboardGUI {
    public static final String JSON_STORE = "./data/data.json";
    public static final JsonWriter JSON_WRITER = new JsonWriter("./data/data.json");
    public static final JsonReader JSON_READER = new JsonReader("./data/data.json");

    private AllAccounts accounts;

    // EFFECTS: Constructs new Dashboard with a LoginMenu and initialize accounts.
    public DashboardGUI() {
        accounts = new AllAccounts();
        new LoginMenu(accounts);
    }

}
