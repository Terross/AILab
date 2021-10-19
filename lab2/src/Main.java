public class Main {
    public static void main(String[] args) {
        int state[][] = {
                {0, 4, 3},
                {6, 2, 1},
                {7, 5, 8}
        };

        ASearch aSearch = new ASearch(state);

        long startTime = System.currentTimeMillis();
        aSearch.aSearch();
        long endTime = System.currentTimeMillis();
        System.out.println("Time = " +  (endTime - startTime) + " millis");
        System.out.println("Capacitive complexity = " + aSearch.getMaxQueueSize());
    }
}
