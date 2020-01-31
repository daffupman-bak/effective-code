# effective-code

## lombok

![lombok原理](https://raw.githubusercontent.com/daffupman/markdown-img/master/20200131084918.png)

需要先在idea中安装lombok插件。在使用@Data注解时，是不会区分属性的大小写的。

常用注解：
- @Slf4j：自动为类添加日志支持；
- @SneakyThrows：自动生成try/catch捕捉；
- @Synchronized：自动生成同步锁；
- @Builder：自动生成构造者模式；
- @Cleanup：自动调用变量的close方法释放资源；
- @NonNull：自动生成字段的非空校验；
- val：弱语言变量类型，可以根据值得情况推断变量的类型；
- @Getter：
    - 为属性添加get方法，并支持指定访问权限，默认为public；
    - 还可以在生成的方法上添加注解（onMethod_）；
    - 对于final修饰的变量（开销大的变量），可以选择是否启用懒加载模式（线程安全的，DCL）。
- @Setter：
- @ToString
- @EqualsAndHashCode
- @Data
- @AllArgsConstructor
- @NoArgsConstructor
- @RequiredArgsConstructor