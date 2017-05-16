package cn.ivan.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 加密工具类
 * Created by IntelliJ IDEA.
 * User: 仙人球
 * Date: 2017/3/1
 * Time: 13:49
 */
public class EncryptUtil {

    /**
     * MD5加密  信息摘要算法
     *
     * @param originStr 原始字符串
     * @return 加密后的字符串, 32位十六进制的字符串
     */
    public static String MD5Encrypt(String originStr) {
        try {
            //返回实现指定摘要算法的 MessageDigest 对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //添加进行计算的信息
            messageDigest.update(originStr.getBytes());
            //获取摘要
            byte[] digest = messageDigest.digest();
            System.out.println(Arrays.toString(digest));
            return byteToHexStr(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * SHA 加密  安全散列算法
     *
     * @param originStr 原始字符串
     * @return 加密后的字符串 40位16进制字符串
     */
    public static String SHAEncrypt(String originStr) {
        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(originStr.getBytes());
            byte[] digest = messageDigest.digest();
            System.out.println(Arrays.toString(digest));
            return byteToHexStr(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将字节数组转为十六进制字符串，每一个字节为2位16进制字符串
     *
     * @param bytes
     * @return 16进制字符串
     */
    public static String byteToHexStr(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bytes) {
            // 取byte后8位，高位补0，转为32位int,这样可取到0-256
            int i = b & 0xff;
            if (i <= 0xf) {   // 当小于15时，前面补0，保证两位16进制字符
                stringBuffer.append(0);
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        return stringBuffer.toString().toUpperCase();

    }
}
