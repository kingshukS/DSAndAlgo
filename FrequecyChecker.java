package DSAndAlgo;

import java.util.*;

class FrequecyChecker {
    public static List<String> getFrequent(int k, String[] keywords, String[] reviews) {

        Map<String, Integer> map = new HashMap<>();
        for (String words : reviews) {
            for (String keyWord : keywords) {
                if (words.toLowerCase().contains(keyWord))
                    map.put(keyWord, map.getOrDefault(keyWord, 0) + 1);
            }
        }
        for (String keyWord : keywords) {
            map.put(keyWord, map.getOrDefault(keyWord, 0));
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return ((o1.getValue() == o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));
            }
        });
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> e : list) {
            System.out.println("keyword:"+e.getKey()+" Count:"+e.getValue());
            res.add(e.getKey());
        }
        return res.subList(0,k);
    }

    public static void main(String[] args) {
        String[] keywords1 = {"anacell", "cetracular", "betacellular"};
        String[] reviews1 = {"Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", "Betacellular has awesome services", "betacellular has awesome services",
                "Anacell provides the best services in the city"};
        System.out.println(getFrequent(3, keywords1, reviews1));

    }
}