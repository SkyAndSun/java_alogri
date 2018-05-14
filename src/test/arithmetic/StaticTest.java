package test.arithmetic;

/**
 * Created by suneee on 2018/5/8.
 */
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
        // 112  1   3   110 112   4
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    //实例化代码块儿,先于构造方法执行
    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}
