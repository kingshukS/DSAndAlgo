package DSAndAlgo;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencyGame {
    public static int LargButMinFreq(int[] arr, int n) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ?
                b.getKey().compareTo(a.getKey()) : a.getValue().compareTo(b.getValue()));
        priorityQueue.addAll(countMap.entrySet());

        return priorityQueue.peek().getKey();
    }

    public static void main(String[] args) {
        int[] arr = {10, 10, 20, 20, 20, 30, 30, 30, 30, 5, 5};
        System.out.println(LargButMinFreq(arr, arr.length));
    }

}