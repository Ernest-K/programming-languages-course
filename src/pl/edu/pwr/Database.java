package pl.edu.pwr;

import java.util.Arrays;
import java.util.HashMap;

// Singleton pattern
public class Database {
    private static Database instance;
    public static final HashMap<String, char[]> usernamePasswordMap = new HashMap<>();

    private Database() {
    }

    public static Database getInstance(){
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public void add(String username, char[] password){
        usernamePasswordMap.put(username, password);
    }

    public static boolean login(String username, char[] password){
        return Arrays.equals(usernamePasswordMap.get(username), password);
    }
}
