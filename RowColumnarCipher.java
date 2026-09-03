public class RowColumnarCipher {
    public static void main(String[] args) {
        String message = "HERE YOU GO";
        message = message.replace(" ", "");
        int columns = 3;
        int rows = (int) Math.ceil((double) message.length() / columns);
        char[][] matrix = new char[rows][columns];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (k < message.length()) {
                    matrix[i][j] = message.charAt(k);
                    k++;
                } else {
                    matrix[i][j] = 'X';
                }
            }
        }
        String result = "";
        for (int i = 0; i < rows; i++) {
            result += matrix[i][2];
        }

        for (int i = 0; i < rows; i++) {
            result += matrix[i][1];
        }

        for (int i = 0; i < rows; i++) {
            result += matrix[i][0];
        }
        System.out.println("Original  : " + message);
        System.out.println("Encrypted : " + result);
    }
}
