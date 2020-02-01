package io.daff.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 使用源和汇复制文件
 *
 * @author daffupman
 * @since 2020/2/1
 */
public class IoTest {

    @Test
    public void testCopyFile() throws IOException {

        //流与汇会自动关闭

        CharSource charSource = Files.asCharSource(
                new File("source.txt"),
                Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(
                new File("target.txt"),
                Charsets.UTF_8);

        // 拷贝
        charSource.copyTo(charSink);
    }
}
