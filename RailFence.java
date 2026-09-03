public class RailFence {
    public static String encrypt(String text, int key) {
        char[][] matrix = new char[key][text.length()];
        boolean movingDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {
            if (row == 0 || row == key - 1) {
                movingDown = !movingDown;
            }

            matrix[row][col] = text.charAt(i);
            col++;
            row += movingDown ? 1 : -1;
        }

        StringBuilder ciphertext = new StringBuilder();
        for (int r = 0; r < key; r++) {
            for (int c = 0; c < text.length(); c++) {
                if (matrix[r][c] != '\0') {
                    ciphertext.append(matrix[r][c]);
                }
            }
        }

        return ciphertext.toString();
    }

    public static void main(String[] args) {
        String plaintext = "whereisit";
        int key = 3;
        String ciphertext = encrypt(plaintext, key);

        System.out.println("Input: " + plaintext);
        System.out.println("Output: " + ciphertext);
    }
}

