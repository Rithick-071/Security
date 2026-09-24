import java.math.BigInteger;

import java.util.Scanner;

public class RSA {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

System.out.print("Enter prime number p: ");

BigInteger p = sc.nextBigInteger();

System.out.print("Enter prime number q: ");

BigInteger q = sc.nextBigInteger();

BigInteger n = p.multiply(q);

BigInteger phi = p.subtract(BigInteger.ONE)

.multiply(q.subtract(BigInteger.ONE));

System.out.println("n = " + n);

System.out.println("phi(n) = " + phi);


System.out.print("Enter public key e: ");

BigInteger e = sc.nextBigInteger();

BigInteger d = e.modInverse(phi);

System.out.println("Public Key = (" + e + ", " + n + ")");

System.out.println("Private Key = (" + d + ", " + n + ")");

sc.nextLine();

System.out.print("Enter message (as a number less than n): ");

BigInteger message = new BigInteger(sc.nextLine());

BigInteger encrypted = message.modPow(e, n);

System.out.println("\n--- CONFIDENTIALITY ---");

System.out.println("Original Message : " + message);

System.out.println("Encrypted Message: " + encrypted);

BigInteger decrypted = encrypted.modPow(d, n);

System.out.println("Decrypted Message: " + decrypted);

BigInteger signature = message.modPow(d, n);

System.out.println("\n--- AUTHENTICATION ---");

System.out.println("Digital Signature: " + signature);


BigInteger verifiedMessage = signature.modPow(e, n);

System.out.println("Verified Message : " + verifiedMessage);

if (message.equals(verifiedMessage)) {

System.out.println("Authentication Successful!");

} else {

System.out.println("Authentication Failed!");

}

sc.close();

}

} 
