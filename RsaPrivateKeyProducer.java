//package com.example.demo.publicPrivateKey;
//
//import sun.misc.BASE64Decoder;
//
//import javax.xml.bind.DatatypeConverter;
//import java.security.KeyFactory;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//
//public class RsaPrivateKeyProducer {
//
//    public static PrivateKey produce(byte[] encodedByteArrayForPrivateKey) {
//        try {
//            PrivateKey privateKey = KeyFactory.getInstance("RSA")
//                    .generatePrivate(new PKCS8EncodedKeySpec(encodedByteArrayForPrivateKey));
//
//            return privateKey;
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            /*byte[] keyBytes;
//            keyBytes = (new BASE64Decoder()).decodeBuffer(key);
//            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PublicKey publicKey = keyFactory.generatePublic(keySpec);
//            return publicKey;*/
//
//            String key = "3082012230"; // full key omitted for brevity
//            byte[] b = DatatypeConverter.parseHexBinary(key);
//            System.out.printf("result : " + RsaPrivateKeyProducer.produce(b));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}