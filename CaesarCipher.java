public class CaesarCipher {
    private String plainText;
    private int shiftKey;

    public CaesarCipher(String plainText, int shiftKey) {
        this.plainText = plainText;
        this.shiftKey = shiftKey % 26;
    }

    public String encrypt() {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                char encrypted = (char) ((ch - 'A' + shiftKey) % 26 + 'A');
                cipherText.append(encrypted);
            }
            else if (ch >= 'a' && ch <= 'z') {
                char encrypted = (char) ((ch - 'a' + shiftKey) % 26 + 'a');
                cipherText.append(encrypted);
            } 
            else {
                cipherText.append(ch);
            }
        }
        return cipherText.toString();
    }

    public String decrypt(String cipherText) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                char decrypted = (char) ((ch - 'A' - shiftKey + 26) % 26 + 'A');
                decryptedText.append(decrypted);
            }
            else if (ch >= 'a' && ch <= 'z') {
                char decrypted = (char) ((ch - 'a' - shiftKey + 26) % 26 + 'a');
                decryptedText.append(decrypted);
            } 
            else {
                decryptedText.append(ch);
            }
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        String message = "Hello, World!";
        int shift = 3;

        CaesarCipher cipher = new CaesarCipher(message, shift);

        String encrypted = cipher.encrypt();
        String decrypted = cipher.decrypt(encrypted);

        System.out.println("--- Caesar Cipher Test ---");
        System.out.println("Original Message: " + message);
        System.out.println("Shift Key:        " + shift);
        System.out.println("Encrypted Text:   " + encrypted);
        System.out.println("Decrypted Text:   " + decrypted);
        System.out.println("--------------------------");
    }
}