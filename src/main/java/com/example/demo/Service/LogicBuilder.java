package com.example.demo.Service;

import com.example.demo.Data.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;


import javax.crypto.Cipher;
import java.io.File;
import java.io.FileOutputStream;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LogicBuilder {
    @Autowired
    Key key;

    @Autowired
    DataRespository dataRespository;

    @Autowired
    KycRepository kycRepository;

    public String pdfConveter(ConvertData convertDataRequest) {
        String result = "Bad Request";
        if (convertDataRequest != null && convertDataRequest.getType().equalsIgnoreCase("PDF")) {
            if (!convertDataRequest.getData().isEmpty() && StringUtils.isNotBlank(convertDataRequest.getFileName())) {
                File file = new File(convertDataRequest.getFileName());
                try (FileOutputStream fos = new FileOutputStream(file);) {
                    String b64 = convertDataRequest.getData();
                    byte[] decoder = Base64.getDecoder().decode(b64);
                    fos.write(decoder);
                    result = "Data is successfully converted to PDF and file is created at " + convertDataRequest.getFileName();
                } catch (Exception e) {
                    result = e.getMessage();
                }
            }

        }
        return result;
    }


    Map<String, Object> map = new HashMap<>();

    public Map<String, Object> createKeys() {

        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2480);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            map.put("publicKey",publicKey);
            map.put("privateKey",privateKey);
            } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public String encrypt(EnDnData enDnData) {
        String encString = "";
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
            PublicKey publicKey = (PublicKey) map.get("publicKey");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encrypt = cipher.doFinal(enDnData.getEnDndata().getBytes());
            encString = new String(Base64.getEncoder().encodeToString(encrypt));
        } catch (Exception e) {

        }
        return encString;
    }

    public String decrypt(String encryptedMessgae) {
        String decString = null;
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
            PrivateKey privateKey = (PrivateKey) map.get("privateKey");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(encryptedMessgae));
            decString =  new String(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decString;
    }

   // validate the user's details
    public boolean validateKyc(Kyc kyc){
        boolean isUserValid = false;

        Optional<Kyc> byId = kycRepository.findById(kyc.getId());
        if(byId.isPresent()){
            isUserValid = true;
        }
        return isUserValid;
    }

}
