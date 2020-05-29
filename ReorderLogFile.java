import java.util.Arrays;
import java.util.Comparator;

class ReorderLogFile {

    public static void main(String[] args){
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] output = reorderLogFiles(logs);
        for(String str : output){
            System.out.println(str);
        }
    }
    public static String[] reorderLogFiles(String[] logs) {

        int letterCount = 0;
        String[] logSorted = new String[logs.length];
        for(String log : logs){
            if((int)log.charAt(log.length()-1)>57)
                letterCount++;
        }
        int j = 0;
        int k = letterCount;

        for(String log : logs){
            if((int)log.charAt(log.length()-1)>57){
                logSorted[j++] = log;
            }else{
                logSorted[k++] = log;
            }
        }

        Arrays.sort(logSorted, 0, letterCount, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i1 = s1.indexOf(' ');
                String word1 = s1.substring(i1).trim();
                String id1 = s1.substring(0,i1);
                int i2 = s2.indexOf(' ');
                String word2 = s2.substring(i2).trim();
                String id2 = s2.substring(0,i2);
                return (word1.equals(word2)?id1.compareTo(id2):word1.compareTo(word2));
            }
        });

        return logSorted;
    }
}