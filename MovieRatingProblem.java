import java.util.*;

public class MovieRatingProblem {
    private static Map<String, List<Double>> movieMap = new HashMap<>();

    public static void main(String[] args){


        putRating("ABCD",null);
        putRating("Don",4.1);
        putRating("ABCD",1.1);
        putRating("ABCD",3.1);
        putRating("ABCD",2.2);
        putRating("Don",4.3);
        putRating("Don",4.5);

        System.out.println(getAverageRating("ABCD"));

    }

    private static void putRating(String movieName, Double rating) {

        if(movieMap!=null && rating!=null) {
            List<Double> ratingList = movieMap.get(movieName);
            if (ratingList == null) {
                ratingList = new ArrayList<>();
            }
            ratingList.add(rating);
            movieMap.put(movieName, ratingList);
        }
    }

    public static double getAverageRating(String movie) {
        if (movieMap != null) {
            if (movieMap.containsKey(movie)) {
                List<Double> ratingList = movieMap.get(movie);
                double sum = 0.00;
                if (ratingList == null)
                    return 0.00;
                else {
                    for (Double d : ratingList) {
                        sum += d;
                    }
                    return sum / ratingList.size();
                }
            } else {
                return 0.00;
            }
        }
        return 0.00;
    }

    public int getRatingCount(String movie){
        if (movieMap!=null && movieMap.get(movie)!=null)
            return movieMap.get(movie).size();
        else
            return 0;
    }


}
