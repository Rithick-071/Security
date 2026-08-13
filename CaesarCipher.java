import java.util.Scanner;
public class caesar1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String text = sc.nextLine();
        System.out.print("Enter the key value: ");
        int k = sc.nextInt();
        System.out.print("Enter your choice (1-Encrypt, 2-Decrypt): ");
        int choice = sc.nextInt();
        String output = "";
        switch (choice) {
            case 1:
                for (int i = 0; i < text.length(); i++) {
                    char ch = text.charAt(i);

                    if (ch >= 'A' && ch <= 'Z') {
                        ch = (char) ((ch - 'A' + k) % 26 + 'A');
                    } else if (ch >= 'a' && ch <= 'z') {
                        ch = (char) ((ch - 'a' + k) % 26 + 'a');
                    }

                    output += ch;
                }
                System.out.println("Encrypted message: " + output);
                break;
            case 2:
                for (int i = 0; i < text.length(); i++) {
                    char ch = text.charAt(i);

                    if (ch >= 'A' && ch <= 'Z') {
                        ch = (char) ((ch - 'A' - k + 26) % 26 + 'A');
                    } else if (ch >= 'a' && ch <= 'z') {
                        ch = (char) ((ch - 'a' - k + 26) % 26 + 'a');
                    }

                    output += ch;
                }
                System.out.println("Decrypted message: " + output);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}
