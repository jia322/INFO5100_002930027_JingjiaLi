package exercise6;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.KeyGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;

class CipherPeople
{
    public static final int AES_KEY_SIZE = 256;
    public static final int GCM_TAG_LENGTH = 16;

    // key for symmetric encryption/decryption
    private SecretKey symmetric_key;
    private byte[] IV;

    // keys for asymmetric encryption/decryption
    private PublicKey publicKey;
    private PrivateKey privateKey;



    public CipherPeople(SecretKey key, byte[] iv, PublicKey public_key, PrivateKey private_key){
        symmetric_key = key;
        IV = iv;
        publicKey = public_key;
        privateKey =private_key;
    }

    private String encode(byte[] data) throws Exception{
        return new String(data,StandardCharsets.UTF_8);
    }

    private byte[] decode(String data) throws Exception{
        return data.getBytes();
    }

    public byte[] symmetric_encrypt(String message) throws Exception
    {
        byte[] plaintext = decode(message);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(symmetric_key.getEncoded(), "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

        byte[] cipherText = cipher.doFinal(plaintext);

        return cipherText;
    }

    public String symmetric_decrypt(byte[] cipherText ) throws Exception
    {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(symmetric_key.getEncoded(), "AES");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

        byte[] decryptedText = cipher.doFinal(cipherText);

        return encode(decryptedText);
    }

    public byte[] asymmetric_encrypt(String message) throws Exception{
        byte[] messageToBytes = decode(message);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encryptedBytes;
    }

    public String asymmetric_decrypt(byte[] encryptedBytes) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return encode(decryptedMessage);
    }
}

public class Exercise_6
{
    public static void main(String[] args) {
        // Test for symmetric encryption and decription between Alice and Bob using AES-256 GCM/NoPadding cipher
        try{
            // generate symmetric key for Alice and Bob communication
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);

            SecretKey key = keyGenerator.generateKey();
            byte[] IV = new byte[12];
            SecureRandom random = new SecureRandom();
            random.nextBytes(IV);

            // generate ssymmetric key for Alice and Bob communication
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();

            CipherPeople alice = new CipherPeople(key, IV, publicKey, privateKey);
            CipherPeople bob = new CipherPeople(key, IV, publicKey, privateKey);

            String message_1 = "Hello Symmetric Cipher!";
            System.out.println("raw message between Alice and Bob for symmetric encryption: " + message_1);
            byte[] entryped_msg_1 = alice.symmetric_encrypt(message_1);
            System.out.println("message Encrypted by Alice: " + new String(entryped_msg_1, StandardCharsets.UTF_8));
            String decrypted_msg_1 = bob.symmetric_decrypt(entryped_msg_1);
            System.out.println("message Decrypted by Bob: " + decrypted_msg_1);
            System.out.println("");

            String message_2 = "Hello Asymmetric Cipher!";
            System.out.println("raw message between Alice and Bob for asymmetric encryption: " + message_2);
            byte[] entryped_msg_2 = alice.asymmetric_encrypt(message_2);
            System.out.println("message Encrypted by Alice: " + new String(entryped_msg_2, StandardCharsets.UTF_8));
            String decrypted_msg_2 = bob.asymmetric_decrypt(entryped_msg_2);
            System.out.println("message Decrypted by Bob: " + decrypted_msg_2);

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

