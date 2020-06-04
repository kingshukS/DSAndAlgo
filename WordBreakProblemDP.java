package DSAndAlgo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Commented lines of code can be used to use recursion
public class WordBreakProblemDP {
    private static boolean[] t;
    private static Set<String> dictionarySet;

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem");
        dictionarySet = new HashSet<>(dict);

        String word = "Wordbreakproblem";
        System.out.print(isWordBreak(word));

    }

    private static boolean isWordBreak(String word) {
        if (word == null || word.length() == 0)
            return true;
        int n = word.length();
        t = new boolean[n];
        for (int i = 0; i < n; i++) {
            String prefix = word.substring(0, i + 1);
            if (dictionarySet.contains(prefix)) //&& isWordBreak(word.substring(i + 1)))
            {
//                return true;
                t[i] = true;
            }
            if (t[i] == true && i == n - 1) {
                return true;
            }

            if (t[i] == true) {
                for (int j = i + 1; j < n; j++) {
                    String suffix = word.substring(i + 1, j + 1);
                    if (dictionarySet.contains(suffix)) {
                        t[j] = true;
                    }
                    if (j == n - 1 && t[j] == true)
                        return true;
                }
            }
        }
        return false;
    }
    //       return false;
}
//}