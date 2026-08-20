import java.util.Arrays;

public class RowColumnarCipher {

    public static String encrypt(String text, String key) {
        text = text.replaceAll("\\s+", "").toUpperCase();
        int numCols = key.length();
        int numRows = (int) Math.ceil((double) text.length() / numCols);

        char[][] grid = new char[numRows][numCols];
        int charIndex = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (charIndex < text.length()) {
                    grid[r][c] = text.charAt(charIndex++);
                } else {
                    grid[r][c] = 'X';
                }
            }
        }

        Integer[] colOrder = getColumnOrder(key);

        StringBuilder result = new StringBuilder();
        for (int colIndex : colOrder) {
            for (int r = 0; r < numRows; r++) {
                result.append(grid[r][colIndex]);
            }
        }

        return result.toString();
    }

    private static Integer[] getColumnOrder(String key) {
        int len = key.length();
        Integer[] indices = new Integer[len];
        for (int i = 0; i < len; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> Character.compare(key.charAt(a), key.charAt(b)));
        return indices;
    }

    public static void main(String[] args) {
        String message = "MEET AT GATE";
        String secretKey = "HACK";

        String encrypted = encrypt(message, secretKey);

        System.out.println("Original Message : " + message);
        System.out.println("Secret Key       : " + secretKey);
        System.out.println("Encrypted Text   : " + encrypted);
    }
}
