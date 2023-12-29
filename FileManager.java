import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {
    public static void encryptAndSaveToFile(PasswordManager passwordManager, String path, String encryptionPassword) {
        byte[] encryptedData = DEScrypto.encrypt(passwordManager, encryptionPassword);
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(encryptedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PasswordManager readFromFileAndDecrypt(String path, String decryptionPassword) {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] encryptedDataFromFile = new byte[fis.available()];
            fis.read(encryptedDataFromFile);
            return DEScrypto.decrypt(encryptedDataFromFile, decryptionPassword);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
