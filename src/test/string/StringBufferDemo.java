package test.string;


public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
       // StringBuffer append = a.append(b);
//        System.out.println(append);
//        b = a;
//        System.out.println(a +","+b);
        operate(a,b);
        System.out.println(a + ","+b);

    }

    static void operate(StringBuffer x,StringBuffer y){//java只有值传递
        x.append(y);
        y = x;
        System.out.println(x + ":::"+ y);
    }
}
