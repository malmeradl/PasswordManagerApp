public class PasswordManagerApp {
    static final String ENCRYPTION_PASSWORD = "someEncryptionPassword";
    static final String FILE_PATH = "passwords.dat";

    public static void main(String[] args) {
        // PasswordManager passwordManager = new PasswordManager();
        // passwordManager.addEntry(new PasswordEntry("entry1", "tls123", "qwerty321",
        // "some note"));
        // passwordManager.addEntry(new PasswordEntry("entry2", "user2007", "pass098",
        // "..."));
        // passwordManager.addEntry(new PasswordEntry("entry3", "jerry", "010101", ""));

        // FileManager.encryptAndSaveToFile(passwordManager,
        // FILE_PATH,ENCRYPTION_PASSWORD);

        PasswordManager passwordManagerFromFile = new PasswordManager(FILE_PATH, ENCRYPTION_PASSWORD);
        passwordManagerFromFile.printAllEntries();
        passwordManagerFromFile.getEntry("entry3").printInfo();

        System.out.println("\n--------------------------\nupdated:\n");
        PasswordEntry updatedEntry = new PasswordEntry("entry3", "Churchhella208", "1111", ":-)");
        passwordManagerFromFile.updateEntry(updatedEntry);
        passwordManagerFromFile.getEntry("entry3").printInfo();

        System.out.println("\n--------------------------\nwithout deleted:\n");
        passwordManagerFromFile.deleteEntry("entry2");
        passwordManagerFromFile.printAllEntries();
    }

}