package pw.buttercup.mobile;

import org.spongycastle.util.encoders.Base64;

/**
 * Created by perry on 11/10/17.
 */

public class BCHelpers {

    private final static char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    public static String base64ToString(String base64String) {
        byte[] decodedData = Base64.decode(base64String);
        return new String(decodedData);
    }

    public static String byteArrayToHexString(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_CHARS[v >>> 4];
            hexChars[j * 2 + 1] = HEX_CHARS[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static String stringToBase64(String s) {
        byte[] encodedBuffer = Base64.encode(s.getBytes());
        return new String(encodedBuffer);
    }

}
