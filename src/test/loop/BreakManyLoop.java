package test.loop;

/**
 * 跳出多层循环
 */
public class BreakManyLoop {

    public static void main(String[] args) {
        int index = 1;
        label:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    for (int l = 0; l < 100; l++) {
                        index ++;
                        if (index == 500)
                            break label ;
                    }
                }
            }
        }

        System.out.println(index);
        int sum = sum();
        System.out.println(sum);
    }

    public static int sum(){
        int index = 1;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    for (int l = 0; l < 100; l++) {
                        index ++;
                        if (index == 500)
                           return index ;
                    }
                }
            }
        }

        System.out.println(index);
        return index;
    }

}
