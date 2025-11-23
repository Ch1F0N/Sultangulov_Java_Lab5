package cats;

public class MeowHelper {

    public static void makeAllMeow(Meowable... meowers) {
        for (Meowable m : meowers) {
            m.meow();
        }
    }
}
