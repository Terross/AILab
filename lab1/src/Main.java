public class Main {
    public static void main(String[] args) {
        int state[][] = {
                {0, 4, 3},
                {6, 2, 1},
                {7, 5, 8}
        };

//        int state[][] = {
//                {1, 2, 3},
//                {4, 5, 0},
//                {6, 7, 8}
//        };

        SearchTree searchTree = new SearchTree(state);

        searchTree.DFS();
    }
}
