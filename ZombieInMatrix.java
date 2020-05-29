import java.util.*;

public class ZombieInMatrix {

    private static int maxRow;
    private static int maxCol;

    public static void main(String[] args){
        List<List<Integer>> matrix = MyCollections.asList(MyCollections.asList(0, 1, 1, 0, 1), MyCollections.asList(0, 1, 0, 1, 0),
                MyCollections.asList(0, 0, 0, 0, 1),MyCollections.asList(0, 1, 0, 0, 0));
        maxRow = matrix.size();
        maxCol = matrix.get(0).size();
        System.out.println("Time Required: "+zombieInMatrix(matrix,maxRow,maxCol));
    }
    private static int zombieInMatrix(List<List<Integer>> matrix, int row, int col) {

        int count = 0;
        int target = (row)*(col);
        int resTime = 0;

        Queue<Position> queue = new LinkedList<>();

        //Adding initial starting points
        for(int i =0; i< row;i++){
            for(int j =0; j<col;j++){
                if(matrix.get(i).get(j).equals(1)) {
                    queue.add(new Position(i, j));
                    count++;
                }
            }
        }
        while(!queue.isEmpty()){

            if(count==target)
                return resTime;

            int size = queue.size();

            for(int j =0; j<size; j++){
                Position position = queue.poll();

                List<Position> positionList = new ArrayList<>();
                Position position1 = new Position(position.getX(),position.getY()-1);
                Position position2 = new Position(position.getX(),position.getY()+1);
                Position position3 = new Position(position.getX()-1,position.getY()-1);
                Position position4 = new Position(position.getX()+1,position.getY()-1);
                positionList.add(position1);
                positionList.add(position2);
                positionList.add(position3);
                positionList.add(position4);

                for(Position p: positionList){
                    int pX = p.getX();
                    int pY = p.getY();
                    if(pX>=0&&pX<maxRow && pY>=0&&pY<maxCol && matrix.get(pX).get(pY)==0) {
                        matrix.get(pX).set(pY, 1);
                        count++;
                        queue.offer(p);
                    }
                }
            }
            resTime++;
        }
        if(count==target)
            return resTime;
        else
            return -1;
    }
}

class Position{
    int x;
    int y;
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

 class MyCollections {
    public static <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }

        return list;
    }
}
