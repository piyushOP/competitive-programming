package LRU_Cache;

public class Main {
    public static void main(String[] args) {
        Cache ch = new Cache();
        ch.put(3,"D");
        ch.put(4,"E");
        ch.put(5,"F");    
        ch.put(6,"G");
        ch.put(4,"piyush");

        System.out.println(ch.get(6));
        ch.show();
        System.out.println();

        System.out.println(ch.get(3));
        ch.show();
        System.out.println();

        System.out.println(ch.get(4));
        ch.show();
        System.out.println();

    }
}
