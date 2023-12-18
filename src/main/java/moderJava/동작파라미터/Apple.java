package moderJava.동작파라미터;

public class Apple implements Comparable<Apple> {

    private Color color;
    private Integer weight;

    public Apple(Color color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Apple apple) {
        return Integer.compare(this.weight, apple.weight);
    }

}