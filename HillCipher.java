import java.util.Scanner;

public class HillCipher {

    static int[][] key = {
        {3, 25},
        {24, 17}
    };

    static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");

        if (text.length() % 2 != 0) {
            text = text + "Z";
        }

        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            int p1 = text.charAt(i) - 'A';
            int p2 = text.charAt(i + 1) - 'A';

            int c1 = (key[0][0] * p1 + key[0][1] * p2) % 26;
            int c2 = (key[1][0] * p1 + key[1][1] * p2) % 26;

            cipher.append((char) (c1 + 'A'));
            cipher.append((char) (c2 + 'A'));
        }

        return cipher.toString();
    }

    static String decrypt(String cipher) {
        int[][] inverseKey = {
            {3, 17},
            {8, 25}
        };

        StringBuilder plain = new StringBuilder();

        for (int i = 0; i < cipher.length(); i += 2) {
            int c1 = cipher.charAt(i) - 'A';
            int c2 = cipher.charAt(i + 1) - 'A';

            int p1 = (inverseKey[0][0] * c1 + inverseKey[0][1] * c2) % 26;
            int p2 = (inverseKey[1][0] * c1 + inverseKey[1][1] * c2) % 26;

            plain.append((char) (p1 + 'A'));
            plain.append((char) (p2 + 'A'));
        }

        return plain.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String plaintext = sc.nextLine();

        String cipher = encrypt(plaintext);

        System.out.print("Encrypted Message: ");

        for (int i = 0; i < cipher.length(); i += 2) {
            System.out.print(cipher.substring(i, i + 2) + " ");
        }

        System.out.println();

        String decrypted = decrypt(cipher);

        System.out.println("Decrypted Message: " + decrypted);

        sc.close();
    }
}
