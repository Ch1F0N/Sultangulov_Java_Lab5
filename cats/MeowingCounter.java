package cats;

public class MeowingCounter implements Meowable {

    private final Meowable cat;
    private int count = 0;

    public MeowingCounter(Meowable cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        cat.meow();
        count++;
    }

    public int getCount() {
        return count;
    }
}
