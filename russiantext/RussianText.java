package russiantext;

import java.util.*;

public class RussianText {

    public static Set<Character> getSymbolsInEvenWords(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("Список слов пустой.");
        }

        Set<Character> result = new TreeSet<>();
        for (int i = 1; i < words.size(); i += 2) {
            String word = words.get(i);
            for (char c : word.toCharArray()) {
                result.add(c);
            }
        }

        return result;
    }
}
