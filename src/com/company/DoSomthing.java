package com.company;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import java.util.TimerTask;

public class DoSomthing extends TimerTask {
    DoSomthing(){}
    @Override
    public void run() {
        System.out.println(" checking in 10 seconds");
        TimeCalc timeCalc = new TimeCalc();
        File file = new File("/Users/mac/Desktop/licenses/license.lsc");
        StringBuilder builder = new StringBuilder();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert sc != null;
        while (sc.hasNextLine()) {
            builder.append(sc.nextLine()).append("\n");
        }
        String[] keyLic = builder.toString().split("\n");
        ConvertToPubKey convertToPubKey = new ConvertToPubKey();
        PublicKey pubKey = null;
        try {
            pubKey = convertToPubKey.toPublic(keyLic[1]);
        } catch (Base64DecodingException | InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Decrypt.decrypt(keyLic[0], pubKey));
            //Calculate the time and validity
            if(SourceLicense.getSource(Decrypt.decrypt(keyLic[0], pubKey))){
                System.out.println("License is valid calculating time");
                if(timeCalc.calculateTime(Decrypt.decrypt(keyLic[0], pubKey))> 0){
                    System.out.println(timeCalc.calculateTime(Decrypt.decrypt(keyLic[0], pubKey)) + " Days left");
                }else{
                    System.out.println("License is expired");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
