package stream.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetBytes {
    public static List<Byte> getBytes(String path) throws IOException {
        File file = new File(path);
        FileInputStream io = new FileInputStream(file);
        byte[] buf = new byte[1024 * 1024];
        List<Byte> bytes = new ArrayList<>();
        int length = 0;
        while ((length = io.read(buf)) != -1) {
            for (int a = 0; a < length; a++) {
                bytes.add(buf[a]);
            }
        }
        io.close();
        return bytes;
    }
}
