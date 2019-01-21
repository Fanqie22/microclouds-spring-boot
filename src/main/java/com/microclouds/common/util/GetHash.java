package com.microclouds.common.util;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static sun.security.pkcs11.wrapper.Functions.toHexString;

public class GetHash {
    public static String getFileMD5(String fileName, String hashType) throws IOException, NoSuchAlgorithmException {
        File f = new File(fileName);
        InputStream ins = new FileInputStream(f);
        byte[] buffer = new byte[8192];
        MessageDigest md5 = MessageDigest.getInstance(hashType);
        int len;
        while ((len = ins.read(buffer)) != -1) {
            md5.update(buffer, 0, len);
        }
        ins.close();
        return toHexString(md5.digest());
    }

    public static String getFileMD5(File file, String hashType) throws IOException, NoSuchAlgorithmException {
        InputStream ins = new FileInputStream(file);
        byte[] buffer = new byte[8192];
        MessageDigest md5 = MessageDigest.getInstance(hashType);
        int len;
        while ((len = ins.read(buffer)) != -1) {
            md5.update(buffer, 0, len);
        }
        ins.close();
        return toHexString(md5.digest());
    }

}
