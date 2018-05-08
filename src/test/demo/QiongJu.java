package test.demo;

/**
 * 穷举算法的基本思想
 从所有可能情况中搜索正确答案
 1. 对于一种可能情况，计算其结果。
 2. 判断结果是否满足，如不能满足者执行第一步来搜索下一个可能的情况；如满足则表示选找到一个正确答案。
 */
public class QiongJu {

    /**
     * 仅有鸡兔同笼，上有三十五头，下有九十四足，问鸡兔各几何？
     */

    int QiongJuAlgorithm(int head,int foot){
        int i,j,chicken,rabbit;

        for (i = 0; i <= head; i++) {
            j = head - i;
            if (i*2 + j*4 == foot){
                chicken = i;
                rabbit = j;
                System.out.println(chicken+","+rabbit);
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new QiongJu().QiongJuAlgorithm(35,94);
    }
}
