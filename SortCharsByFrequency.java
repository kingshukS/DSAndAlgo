package DSAndAlgo;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharsByFrequency {

    public static void main(String[] args) {

        String input = "treer";
        System.out.print(sortByCharsFrequency(input));
    }

    private static String sortByCharsFrequency(String input) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) == map.get(a) ? a.compareTo(b) : map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.remove();
            for (int i = 0; i < map.get(c); i++) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
