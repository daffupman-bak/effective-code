package io.daff.lambda;

/**
 * 文件处理函数式接口
 *
 * @author daffupman
 * @since 2020/2/23
 */
@FunctionalInterface
public interface FileConsumer {

    /**
     * 函数式接口方法
     *
     * @param fileContent 文件内容字符串
     */
    void fileHandler(String fileContent);
}
