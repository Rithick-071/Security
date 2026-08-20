public class CaesarCipher {
    public static void main(String[] args) {
        String message = "MEET AT GATE";
        int shift = 3;
        
        String encrypted = "";
        String decrypted = "";

       
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            
           
            if (c != ' ') {
                c = (char) (c + shift);
            }
            encrypted += c;
        }

       
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            
            if (c != ' ') {
                c = (char) (c - shift);
            }
            decrypted += c;
        }

    

        System.out.println("Original:  " + message);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
