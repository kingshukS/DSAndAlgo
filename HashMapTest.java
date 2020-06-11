package DSAndAlgo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource(new HashMap<>());
        Runnable1 r1 = new Runnable1(resource);
        Runnable2 r2 = new Runnable2(resource);

        Thread T1 = new Thread(r1);
        Thread T2 = new Thread(r2);

        T1.start();
        T2.start();

    }
}

class Resource {
    Map<Integer, String> map;

    public Resource(Map<Integer, String> map) {
        this.map = map;
    }

    void putData(Integer key, String value) {
        System.out.println("......Putting element.....");
        this.map.put(key, value);
    }

    String getData(Integer key) {
        return this.map.get(key);
    }

    void printMap() {
        Iterator<Integer> itr = this.map.keySet().iterator();
        while (itr.hasNext()) {
            System.out.println("Printing........");
            Integer i = itr.next();
            System.out.println("Key:" + i + " Value:" + this.map.get(i));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runnable1 implements Runnable {

    Resource resource;

    public Runnable1(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Started:" + Thread.currentThread().getName());
        int i = 0;
        while (true) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.resource.putData(i, "Ponu : " + i);
            i++;
        }
    }
}


class Runnable2 implements Runnable {

    Resource resource;

    public Runnable2(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        System.out.println("Started:" + Thread.currentThread().getName());
        while (true) {
            resource.printMap();
        }
    }
}