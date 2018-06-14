package test.designPattern.BuilderPattern;

/**
 * 创建实现Packing 接口的实体类
 */
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "Wrapper";
    }
}
