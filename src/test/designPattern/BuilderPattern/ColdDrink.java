package test.designPattern.BuilderPattern;

/**
 * Created by suneee on 2018/5/14.
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
