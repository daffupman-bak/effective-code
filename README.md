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

## Google Guava

Guava工程包含了若干被Google的Java项目广泛原地的核心库，如：集合、缓存、原生类型支持、并发库、通用注解、字符串处理、IO等。

### 使用和避免null

Guava引入Optional<T>表明可能为null的T类型引用。Optional实例可能包含非null的引用（引用存在），也可能什么也不包括（引用缺失）。Java8已经引入了Optional类。

### 不可变集合

创建对象的不可变拷贝是一项很好的防御性编程技巧。Guava为所有jdk标准集合类型和Guava新集合类型都提供了简单易用的不可变版本。不可变对象的优点：
- 当对象被不可信的库调用时，不可变形式是安全的；
- 不可变对象被多个线程调用时，不存在竞态条件问题；
- 不可变集合不需要考虑变化，因此可以节省时间和空间
- 不可变对象因为有固定不变，可以作为常量来安全使用。

### 新集合类型

Guava引入了很多jdk没有的、但明显有用的的新集合类型。这些新类型是为了和jdk集合狂叫宫村，而没有往jdk集合抽象中硬塞其他概念。
- Multiset：结合set和list的一些特性，即无序且可重复。
    - 视角一：没有元素顺序限制的ArrayList
        - add(E)
        - iterator()
        - size()
    - 视角二：Map<E, Integer>，键为元素，值为计数
        - count(Object)：返回Object在集合中出现的次数
        - entrySet()：返回Set<Multiset.Entry<E>>，和Map的entrySet类似
        - elementSet()：返回所有不重复元素的Set<E>，和Map的keySet类似
    - 多种实现：
        - HashMultiset
        - TreeMultiset
        - LinkedHashMultiset
        - ConcurrentHashMultiset
        - ImmutableMultiset
- 集合工具类
    - Lists：
    - Sets：
    - Maps：
- IO流相关
    - ByteStreams：提供对InputStream和OutputStream的操作；
    - CharStreams：提供对Reader和Writer的操作；
    - 对源（Source）与汇（Sink）的抽象
        - 源是可读的：ByteSource/CharSource
        - 汇是可写的：ByteSink/CharSink
        
## 线程池

通过事先开启多个线程等待请求，可以降低资源消耗，提供响应速度
，提高线程的可管理性。

线程池的核心参数：
- corePoolSize：核心线程数
- maximumPoolSize：最大线程数
- keepAliveTime：线程空闲后的存活时间
- unit：时间单位
- workQueue：用于存放任务的阻塞队列
- threadFactory：线程工程类
- handler：当队列和最大线程池都满了之后的饱和策略

线程池的执行流程：

线程池可选的阻塞队列：
- ArrayBlockingQueue：有界队列
- LinkedBlockingQueue：有/无界队列
- Synchronous：同步移交队列

线程池可选择的饱和策略：
- AbortPolicy：终止策略（默认）；
- DiscardPolicy：抛弃策略；
- DiscardOldestPolicy：抛弃旧任务策略；
- CallerRunsPolicy：调用者运行策略。

线程池状态

![](https://raw.githubusercontent.com/daffupman/markdown-img/master/20200201145219.png)

### 设计一个简单的线程池