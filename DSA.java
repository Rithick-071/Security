import java.util.Scanner;
import java.math.BigInteger;

public class DSA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int p = 3;
        int q = 11;

        int n = p * q;
        int phi = (p - 1) * (q - 1);

        int e = 7;
        int d = 1;

      
        while ((d * e) % phi != 1) {
            d++;
        }

        System.out.println("Public Key = (" + e + ", " + n + ")");
        System.out.println("Private Key = (" + d + ", " + n + ")");

        System.out.print("Enter message (number): ");
        int m = sc.nextInt();

        BigInteger M = BigInteger.valueOf(m);

        
        BigInteger C = M.pow(e).mod(BigInteger.valueOf(n));

        System.out.println("Encrypted message = " + C);

        
        BigInteger D = C.pow(d).mod(BigInteger.valueOf(n));

        System.out.println("Decrypted message = " + D);

        sc.close();
    }
}

