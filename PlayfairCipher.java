import java.util.*;

public class PlayfairCipher {
    private char[][] matrix = new char[5][5];
    private String key;
    private String plainText;

    public PlayfairCipher(String key, String plainText) {
        this.key = cleanKey(key);
        this.plainText = cleanPlainText(plainText);
        generateMatrix();
    }

    private String cleanKey(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        boolean[] seen = new boolean[26];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!seen[c - 'A']) {
                seen[c - 'A'] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private void generateMatrix() {
        boolean[] seen = new boolean[26];
        seen['J' - 'A'] = true; 
        
        StringBuilder fullKey = new StringBuilder();

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!seen[c - 'A']) {
                seen[c - 'A'] = true;
                fullKey.append(c);
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!seen[c - 'A']) {
                fullKey.append(c);
                seen[c - 'A'] = true;
            }
        }

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = fullKey.charAt(idx++);
            }
        }
    }

    private String cleanPlainText(String pt) {
        pt = pt.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        StringBuilder sb = new StringBuilder(pt);

        for (int i = 0; i < sb.length() - 1; i += 2) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'X'); 
            }
        }

        if (sb.length() % 2 != 0) {
            sb.append('Z'); 
        }
        return sb.toString();
    }

    private int[] findPosition(char c) {
        if (c == 'J') c = 'I';
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public String encrypt() {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i += 2) {
            char a = plainText.charAt(i);
            char b = plainText.charAt(i + 1);
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            int r1 = posA[0], c1 = posA[1];
            int r2 = posB[0], c2 = posB[1];

            if (r1 == r2) { 
                cipherText.append(matrix[r1][(c1 + 1) % 5]);
                cipherText.append(matrix[r2][(c2 + 1) % 5]);
            } else if (c1 == c2) { 
                cipherText.append(matrix[(r1 + 1) % 5][c1]);
                cipherText.append(matrix[(r2 + 1) % 5][c2]);
            } else { 
                cipherText.append(matrix[r1][c2]);
                cipherText.append(matrix[r2][c1]);
            }
        }
        return cipherText.toString();
    }

    public void printMatrix() {
        System.out.println("--- Playfair Key Matrix ---");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        String key = "MONARCHY";
        String plaintext = "instruments";

        PlayfairCipher cipher = new PlayfairCipher(key, plaintext);
        
        cipher.printMatrix();
        System.out.println("Plaintext (Formatted): " + cipher.plainText);
        System.out.println("Encrypted Text: " + cipher.encrypt());
    }
}