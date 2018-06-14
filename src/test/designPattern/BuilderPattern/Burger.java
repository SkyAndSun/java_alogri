package test.designPattern.BuilderPattern;

/**
 * 创建实现Item接口的抽象类，该类提供了默认的功能
 */
public abstract class Burger implements Item {


    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price() ;
}
