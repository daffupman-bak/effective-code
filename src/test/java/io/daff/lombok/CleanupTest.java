package io.daff.lombok;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Cleanup注解的demo
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class CleanupTest {

    public void copyFile(String in, String out) throws Exception {
        @Cleanup
        FileInputStream fis = new FileInputStream(in);
        @Cleanup
        FileOutputStream fos = new FileOutputStream(out);

        int r;
        while ((r = fis.read()) != -1) {
            fos.write(r);
        }
    }
}
