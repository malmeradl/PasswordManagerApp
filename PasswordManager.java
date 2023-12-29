import java.io.Serializable;
import java.util.*;

class PasswordManager implements Serializable {
    private Map<String, PasswordEntry> passwordEntries;// уникальность названий обеспечена тем, что они в hashmap
                                                       // является ключи, которые не могут повторяться

    public PasswordManager() {
        this.passwordEntries = new HashMap<>();
    }

    public PasswordManager(String path, String decryptionPassword) {
        PasswordManager decryptedPasswordManager = FileManager.readFromFileAndDecrypt(path, decryptionPassword);

        if (decryptedPasswordManager != null) {
            this.passwordEntries = decryptedPasswordManager.passwordEntries;
        } else {
            this.passwordEntries = new HashMap<>();
        }
    }

    public void addEntry(PasswordEntry entry) {
        if (!passwordEntries.containsKey(entry.getName())) {
            passwordEntries.put(entry.getName(), entry);
        } else {
            System.out.println("Entry with this name: " + entry.getName() + " is already exist");
        }
    }

    public void updateEntry(PasswordEntry entry) {
        if (passwordEntries.containsKey(entry.getName())) {
            passwordEntries.put(entry.getName(), entry);
        } else {
            System.out.println("Entry not found: " + entry.getName());
        }
    }

    public void deleteEntry(String name) {
        if (passwordEntries.containsKey(name)) {
            passwordEntries.remove(name);
        } else {
            System.out.println("Entry not found: " + name);
        }
    }

    public PasswordEntry getEntry(String name) {
        return passwordEntries.get(name);
    }

    public List<PasswordEntry> getAllEntries() {
        return new ArrayList<>(passwordEntries.values());
    }

    public void printAllEntries() {
        for (PasswordEntry entry : passwordEntries.values()) {
            System.out.println(entry);
        }
    }
}
