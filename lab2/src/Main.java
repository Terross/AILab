public class Main {
    public static void main(String[] args) {
        int state[][] = {
                {0, 4, 3},
                {6, 2, 1},
                {7, 5, 8}
        };


        ASearch aSearch = new ASearch(state, Type.H2); //Меняем H2 на H1 для разных способов
        
        long startTime = System.currentTimeMillis();
        aSearch.aSearch();
        long endTime = System.currentTimeMillis();
        System.out.println("Time = " +  (endTime - startTime) + " millis");
        System.out.println("Capacitive complexity = " + aSearch.getMaxQueueSize());
    }
}
