package test.thread.volatileDemo;

/**
 *
 */
public class Counter {

   // public static int count = 0;
   public volatile static int count = 0;

    public static void inc(){
        //延迟1毫秒，使得结果更明显
        try{
            Thread.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }

        count ++;
    }

    public static void main(String[] args) {
        //模拟1000个线程，去进行 i++计算
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }

        System.out.println("运行结果："+count);
    }
}
