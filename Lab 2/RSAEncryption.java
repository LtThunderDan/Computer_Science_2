import java.math.BigInteger;
import java.util.Random;
public class RSAEncryption
{
  public static void main(String[] args)
  {
  // Choose 2 random prime numbers
  BigInteger p =  BigInteger.probablePrime(256, new Random());
  System.out.println("First prime number: "+ p);
  BigInteger q =  BigInteger.probablePrime(256, new Random());
  System.out.println("Second prime number: " + q);
  // Multiply two random prime numbers
  BigInteger n = q.multiply(p);
  System.out.println("Product of the two prime numbers: "+ n);
  // Compute the totient
  BigInteger y = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
  System.out.println("Totient: "+ y);
  // Choose a random prime number
  BigInteger e = BigInteger.probablePrime(32, new Random());
  System.out.println("Coprime to totient: "+ e);
  // Use mod inverse of e
  BigInteger d = e.modInverse(y);
  System.out.println("Mod Inverse of coprime: "+ d);
  //Encryption
  BigInteger m = BigInteger.valueOf(65);
  BigInteger c = m.modPow(e,n);
  System.out.println("Value needed to be encrypted: " + m);
  System.out.println("Encrypted value: " + c);
  //Decryption
  BigInteger k = c.modPow(d,n);
  System.out.println("Decrypted value: "+ k);
  }
}
