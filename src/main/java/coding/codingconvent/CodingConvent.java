package coding.codingconvent;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodingConvent {

    public static String encode(String context, String coding) {
        String result = null;
        try {
            result = URLEncoder.encode(context, coding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String decode(String context, String coding) {
        String result = null;
        try {
            result = URLDecoder.decode(context, coding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
