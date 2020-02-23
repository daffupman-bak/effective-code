package io.daff.lambda;

import org.junit.Test;

import java.io.IOException;

/**
 * 测试
 *
 * @author daffupman
 * @since 2020/2/23
 */
public class Main {

    @Test
    public void testFileService() throws IOException {
        FileService fileService = new FileService();
        String url = "E:\\workspace\\idea\\effective-code\\src\\test\\java\\io\\daff\\lambda\\FileService.java";
        // 可针对url指定的文件文本内容做自定义操作， 如果打印，统计词频等
        fileService.fileHandle(url, System.out::println);
        fileService.fileHandle(url, fileContent -> {
            // 如果当前类是类文件，则获取当前文件的类名
            int classIndex = fileContent.indexOf("class ");
            int classNameEndIndex = fileContent.indexOf(" ", classIndex + 6);
            String className = fileContent.substring(classIndex + 6, classNameEndIndex);
            System.out.println("当前类的类名为：" + className);
        });
    }
}
