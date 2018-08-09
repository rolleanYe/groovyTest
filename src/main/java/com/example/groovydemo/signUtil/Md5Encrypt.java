package com.example.groovydemo.signUtil;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;


/**
* 功能：MD5签名处理核心文件，不需要修改
* */

public class Md5Encrypt {

    /**
     * 对字符串进行MD5签名
     */
    public static String md5(String text,String inputCharset) {
        return DigestUtils.md5Hex(getContentBytes(text, inputCharset));
    }

    /**
     * 签名字符串
     */
    public static String sign(String text, String key,String inputCharset) {
    	text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, inputCharset));
    }
    
    /**
     * 验证签名
     */
    public static boolean verify(String text, String sign, String key, String input_charset) {
    	text = text + key;
    	String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

}
