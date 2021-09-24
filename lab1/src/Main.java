public class Main {
    public static void main(String[] args) {
        int state[][] = {
                {0, 4, 3},
                {6, 2, 1},
                {7, 5, 8}
        };

        SearchTree searchTree = new SearchTree(state);

//        long startTime = System.currentTimeMillis();
//        searchTree.DFS(Integer.MAX_VALUE);
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);

        long startTime = System.currentTimeMillis();
        searchTree.IDS();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
