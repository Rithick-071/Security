public class vigne {
    public static void main(String[] args) {

        String plaintext = "WELCOME TO ALL";
        String keyword = "YOU";

        String cleanText = plaintext.replace(" ", "").toUpperCase();
        String upperKey = keyword.toUpperCase();

        StringBuilder ciphertext = new StringBuilder();
        int keyIndex = 0;

        System.out.println("Plaintext:  " + plaintext);
        System.out.println("Keyword:    " + keyword);
        System.out.print("Ciphertext: ");

        for (int i = 0; i < cleanText.length(); i++) {

            char pChar = cleanText.charAt(i);

            if (Character.isLetter(pChar)) {

                char kChar = upperKey.charAt(keyIndex % upperKey.length());

                int shift = kChar - 'A';

                char encryptedChar =
                    (char) ((pChar - 'A' + shift) % 26 + 'A');

                ciphertext.append(encryptedChar);

                keyIndex++;
            }
        }

        System.out.println(ciphertext.toString());
    }
}
