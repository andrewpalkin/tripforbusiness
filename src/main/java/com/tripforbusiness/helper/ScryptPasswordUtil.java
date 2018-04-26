package com.tripforbusiness.helper;

import com.lambdaworks.crypto.SCryptUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ScryptPasswordUtil {

    protected String getEncryptedPassword(String originalPassword)
    {
        String encryptedPass = "";

        try {
            encryptedPass = URLEncoder.encode(SCryptUtil.scrypt(originalPassword, 16, 16, 16), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encryptedPass;
    }

    protected boolean checkPassword(String originalPassword, String dbPassword)
    {
        String generatedSecuredPasswordHash = getEncryptedPassword(originalPassword);
        return  SCryptUtil.check(dbPassword , generatedSecuredPasswordHash);
    }

}
