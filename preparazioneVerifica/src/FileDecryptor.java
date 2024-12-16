import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class FileDecryptor {
    private static final String ALGORITHM = "AES";
    //la chiave AES da usare è di 16 caratteri, chiedila al prof!
    public static void main(String[] args) throws Exception {
        String encryptedFilePath = "src/compito.txt"; // File criptato
        String decryptedFilePath = "src/decriptato.txt"; // File decriptato.txt
        String key = "ViolaMarchesini!"; // Chiave AES (16 caratteri)

        // Legge il contenuto criptato del file
        String encryptedContent = new String(Files.readAllBytes(Paths.get(encryptedFilePath)));

        // Decripta il contenuto
        String decryptedContent = decrypt(encryptedContent, key);

        // Scrive il contenuto decriptato.txt in un nuovo file
        Files.write(Paths.get(decryptedFilePath), decryptedContent.getBytes());
        System.out.println("File decriptato.txt salvato in: " + decryptedFilePath);
    }

    public static String decrypt(String data, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedData = Base64.getDecoder().decode(data);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }
}
