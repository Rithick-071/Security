import java.math.BigInteger;
import java.util.Scanner;

public class RivestShamirAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prime number p: ");
        BigInteger p = sc.nextBigInteger();
        System.out.print("Enter prime number q: ");
        BigInteger q = sc.nextBigInteger();
        System.out.print("Enter encryption key e: ");
        BigInteger e = sc.nextBigInteger();
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));     
        BigInteger d = e.modInverse(phi);
        System.out.println("\n--- RSA Parameters ---");
        System.out.println("Value of p      : " + p);
        System.out.println("Value of q      : " + q);
        System.out.println("Value of n      : " + n);
        System.out.println("Value of phi(n) : " + phi);
        System.out.println("Public Key      : (" + e + ", " + n + ")");
        System.out.println("Private Key     : (" + d + ", " + n + ")");
        System.out.print("\nEnter plaintext number: ");
        BigInteger message = sc.nextBigInteger();
        BigInteger cipherText = message.modPow(e, n);
        System.out.println("Encrypted Text  : " + cipherText);
        BigInteger decryptedText = cipherText.modPow(d, n);
        System.out.println("Decrypted Text  : " + decryptedText);
        sc.close();
    }
}

