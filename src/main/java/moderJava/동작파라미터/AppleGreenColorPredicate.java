package moderJava.동작파라미터;

import static moderJava.동작파라미터.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

}