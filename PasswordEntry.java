import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

class PasswordEntry implements Serializable {
    private String name;
    private String username;
    private String password;
    private Date lastModified;
    private String notes;

    public PasswordEntry(String name, String username, String password, String notes) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.notes = notes;
        this.lastModified = new Date();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
        updateLastModified();
    }

    private void updateLastModified() {
        this.lastModified = new Date();
    }

    @Override
    public String toString() {
        return name;
    }

    public void printInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("\nName: " + name);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Last Modified: " + dateFormat.format(lastModified));
        System.out.println("Notes: " + notes);
    }
}
