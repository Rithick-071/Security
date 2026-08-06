public class VigenereCipher {
    private String plainText;
    private String key;

    public VigenereCipher(String plainText, String key) {
        this.plainText = plainText;
        this.key = key;
    }

    private String cleanString(String str) {
        return str.toUpperCase().replaceAll("[^A-Z]", "");
    }

    public String encrypt() {
        String cleanPt = cleanString(plainText);
        String cleanKey = cleanString(key);
        StringBuilder cipherText = new StringBuilder();
        
        int keyLength = cleanKey.length();
        for (int i = 0, j = 0; i < cleanPt.length(); i++) {
            char c = cleanPt.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char k = cleanKey.charAt(j % keyLength);
                char encrypted = (char) ((c + k - 2 * 'A') % 26 + 'A');
                cipherText.append(encrypted);
                j++;
            } else {
                cipherText.append(c);
            }
        }
        return cipherText.toString();
    }

    public String decrypt(String cipherText) {
        String cleanCt = cleanString(cipherText);
        String cleanKey = cleanString(key);
        StringBuilder decryptedText = new StringBuilder();
        
        int keyLength = cleanKey.length();
        for (int i = 0, j = 0; i < cleanCt.length(); i++) {
            char c = cleanCt.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char k = cleanKey.charAt(j % keyLength);
                char decrypted = (char) ((c - k + 26) % 26 + 'A');
                decryptedText.append(decrypted);
                j++;
            } else {
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        String message = "meet at gate";
        String secretKey = "lemon";

        VigenereCipher cipher = new VigenereCipher(message, secretKey);

        String encrypted = cipher.encrypt();
        String decrypted = cipher.decrypt(encrypted);

        System.out.println("--- Vigenere Cipher Test ---");
        System.out.println("Original Message: " + message);
        System.out.println("Secret Key:       " + secretKey);
        System.out.println("Encrypted Text:   " + encrypted);
        System.out.println("Decrypted Text:   " + decrypted.toLowerCase());
        
    }
}