import java.security.*;

import java.util.*;

public class DSA {

public static void main(String[] args) throws Exception {

Scanner sc = new Scanner(System.in);

System.out.print("Enter message: ");

String msg = sc.nextLine();

KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");

kpg.initialize(2048);

KeyPair kp = kpg.generateKeyPair();

Signature sign = Signature.getInstance("SHA256withDSA");

sign.initSign(kp.getPrivate());

sign.update(msg.getBytes());

byte[] signature = sign.sign();

System.out.println("Digital Signature: " +

Base64.getEncoder().encodeToString(signature));

Signature verify = Signature.getInstance("SHA256withDSA");

verify.initVerify(kp.getPublic());

verify.update(msg.getBytes());

if (verify.verify(signature))

System.out.println("Signature Verified Successfully");

else

System.out.println("Signature Verification Failed");

sc.close();

}

} 
