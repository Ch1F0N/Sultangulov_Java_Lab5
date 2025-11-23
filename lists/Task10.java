package lists;

import java.util.*;

public class Task10 {

    public static <T> void keepOnlyFirstOccurrences(List<T> list) {
        Set<T> seen = new HashSet<>();
        Iterator<T> it = list.iterator();

        while (it.hasNext()) {
            T element = it.next();
            if (!seen.add(element)) {
                it.remove();
            }
        }
    }
}
