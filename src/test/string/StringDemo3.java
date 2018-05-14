package test.string;


public class StringDemo3 {

    public void show(){
        System.out.println(1);
    }

    public static void main(String[] args) {
        new Demo3().show();
    }
}

class Demo3 extends StringDemo3{
    public void show(){
        System.out.println(2);
    }
}
