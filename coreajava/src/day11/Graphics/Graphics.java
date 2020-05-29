package day11.Graphics;

public abstract class Graphics implements Comparable, Cloneable {
    public abstract Double area();


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Graphics) {
            Graphics graphics = (Graphics) o;
            // return (int) (this.area()-graphics.area());   //错的
            return this.area().compareTo(graphics.area());
        }
        return 1;
    }
}
