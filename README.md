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

## 验证框架

### 验证模型
- 分层验证
![分层验证模型](https://raw.githubusercontent.com/daffupman/markdown-img/master/20200131110127.png)

存在大量重复的验证代码

- JavaBean验证 
![JavaBean验证模型](https://raw.githubusercontent.com/daffupman/markdown-img/master/20200131131603.png)

### Bean Validation

Bean Validation为JavaBean验证定义了相应的元数据模型和API。

### JCP、JSR

JCP(Java Community Process)使用JSR（Java Specification Requests）作为正式规范文档，描述被提议加入到Java体系中的规范和技术。
- JSR303，Bean Validation1.0，JavaEE6
- JSR349，Bean Validation1.1，JavaEE7
- JSR380，Bean Validation2.0，JavaEE8

Spring Validation在Hibernate Validator的基础上，对其进行了二次封装，以满足在Spring环境中更简单、高效的对数据进行验证。

### 常用约束注解

- 空值校验类：@Null、@NotNull、@NotEmpty、@NotBlank等
- 范围校验类：@Min、@Size、@Digits、@Future、@Negative等
- 其他校验：@Email、@URL、@AssertTrue、@Pattern等
- 级联验证：@Valid
- 分组验证：groups = T.class
- 组序列：@GroupSequence
- 校验参数：
- 校验返回值：
- 校验构造方法：

#### 完成验证的步骤：
1. 约束注解的定义
2. 约束验证规则（约束验证器）
3. 约束注解的声明
4. 约束验证流程
> 代码见 `Phone.java` 和 `PhoneValidator.java`。