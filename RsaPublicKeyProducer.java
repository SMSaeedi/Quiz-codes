package com.example.demo.publicPrivateKey;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class RsaPublicKeyProducer {

    public static PublicKey produce(byte[] encodedByteArrayForPublicKey) {
        try {
            PublicKey publicKey = KeyFactory.getInstance("RSA")
                    .generatePublic(new X509EncodedKeySpec(encodedByteArrayForPublicKey));

            return publicKey;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        byte[] b = new byte[987654];
        System.out.printf("result : " + RsaPublicKeyProducer.produce(b));
    }

}