public class Main {
    public static void main(String[] args) {
        int state[][] = {
                {0, 4, 3},
                {6, 2, 1},
                {7, 5, 8}
        };

        SearchTree searchTree = new SearchTree(state);

        long startTime = System.currentTimeMillis();
        searchTree.DFS(300);
        long endTime = System.currentTimeMillis();
        System.out.println("Time = " + (endTime - startTime));
        System.out.println("Size = " + (searchTree.getMaxQueueSize()));
//        long startTime = System.currentTimeMillis();
//        searchTree.IDS();
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);
    }
}
