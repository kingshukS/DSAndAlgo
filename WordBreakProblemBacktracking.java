package DSAndAlgo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakProblemBacktracking {
    private static Set<String> dictionarySet;

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem");
        dictionarySet = new HashSet<>(dict);

        String word = "Wordbreakproblem";
        String out = "";
        printPossibleWordBreak(word, out);
    }

    private static void printPossibleWordBreak(String word, String out) {
        if (word.length() == 0) {
            System.out.println(out);
            return;
        }
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (dictionarySet.contains(prefix)) {
                printPossibleWordBreak(word.substring(i), out + " " + prefix);
            }
        }
    }
}
