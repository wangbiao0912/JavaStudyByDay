package com.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Predicate;


/**
 * http://www.importnew.com/16436.html
 */

/**
 *
 *jdk8的新特性和python比较
 * Created by pc5 on 2017/3/22.
 */
@Slf4j
public class lambda {
    /**
     * jdk8 之前线程实现方式
     */
    @Test
    public void theread_before()
    {
        System.out.print("11111");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("线程启动了" );
                try{
                    Thread.sleep(1000);
                }catch (Exception e)
                {
                    System.out.print(e.getMessage());
                }
                System.out.print("线程跑完了");
            }
        }).start();
    }

    /**
     * 线程之后的新语法
     */
    @Test
    public void thread_afther(){
        System.out.println("11111");
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
        new Thread(
                () -> {System.out.print("///////////////////");
                try {
                    Thread.sleep(1000);
                }catch (Exception E)
                {
                    System.out.print("/....");
                }}
        ).start();
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !000000!") ).start();
        new Thread( () -> System.out.println("////////////////00000///")).start();
    }


    /**
     * 表达式进行事件处理
     */
    @Test
    public  void swingMessage(){
        // Java 8之前：
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
        // Java 8方式：
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }
    /**
     * 使用lambda表达式对列表进行迭代
     * 如果你使过几年Java，你就知道针对集合类，最常见的操作就是进行迭代，并将业务逻辑应用于各个元素，例如处理订单、交易和事件的列表。由于Java是命令式语言，Java 8之前的所有循环代码都是顺序的，即可以对其元素进行并行化处理。如果你想做并行过滤，就需要自己写代码，这并不是那么容易。通过引入lambda表达式和默认方法，将做什么和怎么做的问题分开了，这意味着Java集合现在知道怎样做迭代，并可以在API层面对集合元素进行并行处理。下面的例子里，我将介绍如何在使用lambda或不使用lambda表达式的情况下迭代列表。你可以看到列表现在有了一个 forEach()  方法，它可以迭代所有对象，并将你的lambda代码应用在其中。
     *  使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
     看起来像C++的作用域解析运算符
     * */
    @Test
    public  void lanbdaUpdate()
    {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (Object f:features){
            System.out.println(f);
        }
        //jdk8 afther -------------------------------
       // List features2 = Arrays.asList("Lambdas", "Default Method", "
        features.forEach(n -> System.out.print(n));
    }



        public static void filter(List names, Predicate condition) {
            log.info("-----------------------------");
            for(Object name: names)  {
                if(condition.test(name)) {
                    log.info(name + " ");
                }
            }
        }

    /**
     * 使用lambda表达式和函数式接口Predicate
     * 除了在语言层面支持函数式编程风格，Java 8也添加了一个包，叫做 java.util.function。它包含了很多类，用来支持Java的函数式编程。其中一个便是Predicate，使用 java.util.function.Predicate 函数式接口以及lambda表达式，可以向API方法添加逻辑，用更少的代码支持更多的动态行为。下面是Java 8 Predicate 的例子，展示了过滤集合数据的多种常用方法。Predicate接口非常适用于做过滤。
     */
    @Test
    public void Predicate()
    {
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

  /*      System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));
*/
        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);
/*
        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);*/

        log.info("+++++++++++++++++++++++++++++++++++");
        // 更好的办法
    }


    /**
     * Java 8中使用lambda表达式的Map和Reduce示例
     本例介绍最广为人知的函数式编程概念map。它允许你将对象进行转
     换。例如在本例中，我们将 costBeforeTax 列表的每个元素转换成为税后的值。
     我们将 x -> x*x lambda表达式传到 map() 方法，后者将其应用到流中的每一个元素。
     然后用 forEach() 将列表元素打印出来。使用流API的收集器类，
     可以得到所有含税的开销。
     有 toList() 这样的方法将 map 或任何其他操作的结果合并起来。
     由于收集器在流上做终端操作，因此之后便不能重用流了。
     你甚至可以用流API的 reduce() 方法将所有数字合成一个，下一个例子将会讲到。
     */
    @Test
    public void changeMap()
    {
        // 不使用lambda表达式为每个订单加上12%的税
        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Object cost : costBeforeTax) {
            double price = (Integer)cost + .12*(Integer)cost;
            System.out.println(price);
        }
          //jdk 8后的便利
        //List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost2) -> (Integer)cost2 + .12*(Integer)cost2).forEach(System.out::println);
    }



/**
     例7、通过过滤创建一个String列表

     过滤是Java开发者在大规模集合上的一个常用操作，而现在使用lambda表达式和流API过滤大规模数据集合是惊人的简单。流提供了一个 filter() 方法，接受一个 Predicate 对象，即可以传入一个lambda表达式作为过滤逻辑。下面的例子是用lambda表达式过滤Java集合，将帮助理解。

     1
     2
     3
     // 创建一个字符串列表，每个字符串长度大于2
     List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
     System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
     输出：

     1
     Original List : [abc, , bcd, , defg, jk], filtered list : [abc, bcd, defg]
     另外，关于 filter() 方法有个常见误解。在现实生活中，做过滤的时候，通常会丢弃部分，但使用filter()方法则是获得一个新的列表，且其每个元素符合过滤原则。

     例8、对列表的每个元素应用函数

     我们通常需要对列表的每个元素使用某个函数，例如逐一乘以某个数、除以某个数或者做其它操作。这些操作都很适合用 map() 方法，可以将转换逻辑以lambda表达式的形式放在 map() 方法里，就可以对集合的各个元素进行转换了，如下所示。

     1
     2
     3
     4
     // 将字符串换成大写并用逗号链接起来
     List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
     String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
     System.out.println(G7Countries);
     输出：

     1
     USA, JAPAN, FRANCE, GERMANY, ITALY, U.K., CANADA
     例9、复制不同的值，创建一个子列表

     本例展示了如何利用流的 distinct() 方法来对集合进行去重。

     1
     2
     3
     4
     // 用所有不同的数字创建一个正方形列表
     List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
     List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
     System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
     输出：

     1
     Original List : [9, 10, 3, 4, 7, 3, 4],  Square Without duplicates : [81, 100, 9, 16, 49]
     例10、计算集合元素的最大值、最小值、总和以及平均值

     IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic s，描述流中元素的各种摘要数据。在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum() 和 getAverage() 方法来获得列表的所有元素的总和及平均值。

     1
     2
     3
     4
     5
     6
     7
     //获取数字的个数、最小值、最大值、总和以及平均值
     List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
     IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
     System.out.println("Highest prime number in List : " + stats.getMax());
     System.out.println("Lowest prime number in List : " + stats.getMin());
     System.out.println("Sum of all prime numbers : " + stats.getSum());
     System.out.println("Average of all prime numbers : " + stats.getAverage());
     输出：

     1
     2
     3
     4
     Highest prime number in List : 29
     Lowest prime number in List : 2
     Sum of all prime numbers : 129
     Average of all prime numbers : 12.9
     Lambda表达式 vs 匿名类

     既然lambda表达式即将正式取代Java代码中的匿名内部类，那么有必要对二者做一个比较分析。一个关键的不同点就是关键字 this。匿名类的 this 关键字指向匿名类，而lambda表达式的 this 关键字指向包围lambda表达式的类。另一个不同点是二者的编译方式。Java编译器将lambda表达式编译成类的私有方法。使用了Java 7的 invokedynamic 字节码指令来动态绑定这个方法。

     Java 8 Lambda表达式要点

     10个Java lambda表达式、流API示例
     到目前为止我们看到了Java 8的10个lambda表达式，这对于新手来说是个合适的任务量，你可能需要亲自运行示例程序以便掌握。试着修改要求创建自己的例子，达到快速学习的目的。我还想建议大家使用Netbeans IDE来练习lambda表达式，它对Java 8支持良好。当把代码转换成函数式的时候，Netbeans会及时给你提示。只需跟着Netbeans的提示，就能很容易地把匿名类转换成lambda表达式。此外，如果你喜欢阅读，那么记得看一下Java 8的lambdas，实用函数式编程这本书（Java 8 Lambdas, pragmatic functional programming），作者是Richard Warburton，或者也可以看看Manning的Java 8实战（Java 8 in Action），这本书虽然还没出版，但我猜线上有第一章的免费pdf。不过，在你开始忙其它事情之前，先回顾一下Java 8的lambda表达式、默认方法和函数式接口的重点知识。

     1）lambda表达式仅能放入如下代码：预定义使用了 @Functional 注释的函数式接口，自带一个抽象函数的方法，或者SAM（Single Abstract Method 单个抽象方法）类型。这些称为lambda表达式的目标类型，可以用作返回类型，或lambda目标代码的参数。例如，若一个方法接收Runnable、Comparable或者 Callable 接口，都有单个抽象方法，可以传入lambda表达式。类似的，如果一个方法接受声明于 java.util.function 包内的接口，例如 Predicate、Function、Consumer 或 Supplier，那么可以向其传lambda表达式。

     2）lambda表达式内可以使用方法引用，仅当该方法不修改lambda表达式提供的参数。本例中的lambda表达式可以换为方法引用，因为这仅是一个参数相同的简单方法调用。

     1
     2
     list.forEach(n -> System.out.println(n));
     list.forEach(System.out::println);  // 使用方法引用
     然而，若对参数有任何修改，则不能使用方法引用，而需键入完整地lambda表达式，如下所示：

     1
     list.forEach((String s) -> System.out.println("*" + s + "*"));
     事实上，可以省略这里的lambda参数的类型声明，编译器可以从列表的类属性推测出来。

     3）lambda内部可以使用静态、非静态和局部变量，这称为lambda内的变量捕获。

     4）Lambda表达式在Java中又称为闭包或匿名函数，所以如果有同事把它叫闭包的时候，不用惊讶。

     5）Lambda方法在编译器内部被翻译成私有方法，并派发 invokedynamic 字节码指令来进行调用。可以使用JDK中的 javap 工具来反编译class文件。使用 javap -p 或 javap -c -v 命令来看一看lambda表达式生成的字节码。大致应该长这样：

     1
     private static java.lang.Object lambda$0(java.lang.String);
     6）lambda表达式有个限制，那就是只能引用 final 或 final 局部变量，这就是说不能在lambda内部修改定义在域外的变量。

     1
     2
     3
     List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
     int factor = 2;
     primes.forEach(element -> { factor++; });
     1
     Compile time error : "local variables referenced from a lambda expression must be final or effectively final"
     另外，只是访问它而不作修改是可以的，如下所示：

     1
     2
     3
     List<Integer> primes = Arrays.asList(new Integer[]{2, 3,5,7});
     int factor = 2;
     primes.forEach(element -> { System.out.println(factor*element); });
     输出：

     1
     2
     3
     4
     4
     6
     10
     14
     因此，它看起来更像不可变闭包，类似于Python。

     以上就是Java 8的lambda表达式的全部10个例子。此次修改将成为Java史上最大的一次，将深远影响未来Java开发者使用集合框架的方式。我想规模最相似的一次修改就是Java 5的发布了，它带来了很多优点，提升了代码质量，例如：泛型、枚举、自动装箱（Autoboxing）、静态导入、并发API和变量参数。上述特性使得Java代码更加清晰，我想lambda表达式也将进一步改进它。我在期待着开发并行第三方库，这可以使高性能应用变得更容易写。




     */


}
