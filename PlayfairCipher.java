import java.util.*;

public class PlayfairCipher {

    static char[][] matrix = new char[5][5];

    
    static void generateMatrix(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.replace('J', 'I');

        StringBuilder letters = new StringBuilder();

       
        for (char c : key.toCharArray()) {
            if (letters.indexOf(String.valueOf(c)) == -1) {
                letters.append(c);
            }
        }

       
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J')
                continue;

            if (letters.indexOf(String.valueOf(c)) == -1) {
                letters.append(c);
            }
        }

        
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = letters.charAt(k++);
            }
        }
    }


    static void printMatrix() {
        System.out.println("\nPlayfair Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    static int[] findPosition(char c) {
        if (c == 'J')
            c = 'I';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    
    static String prepareText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        text = text.replace('J', 'I');

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < text.length()) {
            char a = text.charAt(i);

            if (i + 1 == text.length()) {
                result.append(a).append('X');
                i++;
            } else {
                char b = text.charAt(i + 1);

                if (a == b) {
                    result.append(a).append('X');
                    i++;
                } else {
                    result.append(a).append(b);
                    i += 2;
                }
            }
        }

        return result.toString();
    }

    
    static String processPair(char a, char b, boolean encrypt) {
        int[] p1 = findPosition(a);
        int[] p2 = findPosition(b);

        int r1 = p1[0], c1 = p1[1];
        int r2 = p2[0], c2 = p2[1];

        
        if (r1 == r2) {
            if (encrypt) {
                c1 = (c1 + 1) % 5;
                c2 = (c2 + 1) % 5;
            } else {
                c1 = (c1 + 4) % 5;
                c2 = (c2 + 4) % 5;
            }
        }

        
        else if (c1 == c2) {
            if (encrypt) {
                r1 = (r1 + 1) % 5;
                r2 = (r2 + 1) % 5;
            } else {
                r1 = (r1 + 4) % 5;
                r2 = (r2 + 4) % 5;
            }
        }

      
        else {
            int temp = c1;
            c1 = c2;
            c2 = temp;
        }

        return "" + matrix[r1][c1] + matrix[r2][c2];
    }

    
    static String encrypt(String plaintext) {
        plaintext = prepareText(plaintext);

        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i += 2) {
            encrypted.append(
                processPair(plaintext.charAt(i),
                            plaintext.charAt(i + 1),
                            true)
            );
        }

        return encrypted.toString();
    }

    
    static String decrypt(String ciphertext) {
        ciphertext = ciphertext.toUpperCase().replaceAll("[^A-Z]", "");

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            decrypted.append(
                processPair(ciphertext.charAt(i),
                            ciphertext.charAt(i + 1),
                            false)
            );
        }

        return decrypted.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        generateMatrix(key);
        printMatrix();

        System.out.print("\nEnter plaintext: ");
        String plaintext = sc.nextLine();

        String encrypted = encrypt(plaintext);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}
