package io.daff.lambda;

import java.io.*;
import java.util.function.Consumer;

/**
 * 文件服务类
 *
 * @author daffupman
 * @since 2020/2/23
 */
public class FileService {

    /**
     * 对指定的路径下资源，做自定义操作
     *
     * @param url 指定的路径
     * @param fileConsumer 自定义的操作
     */
    public void fileHandle(String url, FileConsumer fileConsumer) {
        // 从本地指定的url处构建文件读取流
        try (
            // 需要自动关闭的资源
            FileInputStream fis = new FileInputStream(url);
            InputStreamReader reader = new InputStreamReader(fis);
            final BufferedReader bufferedReader = new BufferedReader(reader)
        ){
            // 记录当前行
            String line;
            // 记录整个文件的信息
            StringBuilder builder = new StringBuilder();
            // 读取文件内容
            while ((line = bufferedReader.readLine()) != null) {
                // 如果读取的这行不为空，则将读取的内容放入builder中
                builder.append(line).append("\n");
            }

            // 调用FileConsumer对象执行自定义的操作
            fileConsumer.fileHandler(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
