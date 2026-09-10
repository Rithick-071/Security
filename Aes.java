import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;
public class Aes {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
keyGenerator.init(128);
SecretKey secretKey = keyGenerator.generateKey();
System.out.print("Enter customer data: ");
String data = sc.nextLine();
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encryptedData = cipher.doFinal(data.getBytes());
String encryptedText =
Base64.getEncoder().encodeToString(encryptedData);
System.out.println("\nOriginal Data : " + data);
System.out.println("Encrypted Data : " + encryptedText);
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decryptedData = cipher.doFinal(encryptedData);
String decryptedText = new String(decryptedData);
System.out.println("Decrypted Data : " + decryptedText);
sc.close();
}
}
