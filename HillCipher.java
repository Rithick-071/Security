import java.util.Scanner;
public class HillCipher {

    static int[][] key = {
        {3, 3},
        {2, 5}
    };

    public static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");

        if (text.length() % 2 != 0) {
            text += "X";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            int x1 = text.charAt(i) - 'A';
            int x2 = text.charAt(i + 1) - 'A';

            int y1 = (key[0][0] * x1 + key[0][1] * x2) % 26;
            int y2 = (key[1][0] * x1 + key[1][1] * x2) % 26;

            result.append((char) (y1 + 'A'));
            result.append((char) (y2 + 'A'));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine();

        String ciphertext = encrypt(plaintext);

        System.out.println("Plaintext : " + plaintext);
        System.out.println("Ciphertext: " + ciphertext);

        sc.close();
    }
}
