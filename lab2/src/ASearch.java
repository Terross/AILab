import java.util.*;

public class ASearch {
    private Node initialNode;
    public final static int[][] searchState = {
            {1, 2, 3},
            {4, 0, 5},
            {6, 7, 8}
    };
    private Queue<Node> nodeQueue;
    private Deque<Node> checkedNodes;
    private int maxQueueSize = 0;

    public ASearch(int[][] state, Type type) {

        nodeQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.findMetric(type)));

        checkedNodes = new ArrayDeque<>();

        int emptyI = 0;
        int emptyJ = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == 0) {
                    emptyI = i;
                    emptyJ = j;
                }
            }
        }
        this.initialNode = new Node(state, emptyI, emptyJ, null);

    }

    public void makeQueue(Node node) {
        int emptyI = node.getEmptyI();
        int emptyJ = node.getEmptyJ();

        if (emptyI > 0) {
            nodeQueue.add(makeNode(node, emptyI - 1, emptyJ));
        }
        if (emptyI < 2) {
            nodeQueue.add(makeNode(node, emptyI + 1, emptyJ));
        }
        if (emptyJ > 0) {
            nodeQueue.add(makeNode(node, emptyI, emptyJ - 1));
        }
        if (emptyJ < 2) {
            nodeQueue.add(makeNode(node, emptyI, emptyJ + 1));
        }
    }

    public boolean checkCycle(Node node) {
        for (Node n:
                checkedNodes) {
            int[][] state = n.getState();
            int[][] newState = node.getState();
            if (compareState(n.getState(), node.getState())) {
                return false;
            }
        }

        return true;
    }

    public boolean compareState(int[][] s1, int[][] s2) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s1[i][j] != s2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public Node makeNode(Node node, int emptyI, int emptyJ) {
        int[][] state = new int[3][3];
        for (int i = 0;i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                state[i][j] =  node.getState()[i][j];
            }
        }

        int oldEmptyI = node.getEmptyI();
        int oldEmptyJ = node.getEmptyJ();

        state[oldEmptyI][oldEmptyJ] = state[emptyI][emptyJ];
        state[emptyI][emptyJ] = 0;

        return new Node(state, emptyI, emptyJ, node);
    }

    public boolean goalTest(int[][] state) {
        boolean result = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j< 3; j++) {
                if (state[i][j] != searchState[i][j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean aSearch() {
        makeQueue(initialNode);
        while(true) {
            if (nodeQueue.size() > maxQueueSize) {
                maxQueueSize = nodeQueue.size();
            }
            if (nodeQueue.isEmpty()) {
                return false;
            }
            Node node = nodeQueue.poll();
            if (goalTest(node.getState())) {
                showSolution(node);
                return true;
            } else {
                if (checkCycle(node)) {
                    makeQueue(node);
                    checkedNodes.add(node);
                }
            }
        }
    }


    public void showSolution(Node node) {
        while (node.getParentNode() != null) {
            System.out.println(showState(node));
            node = node.getParentNode();
        }
        System.out.println(showState(node));
    }


    public String showState(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ^   \n").append("   |   \n");
        int[][] state = node.getState();
        for (int i = 0; i < 3; i++) {
            stringBuilder.append("[");
            for (int j = 0; j < 2; j++) {
                stringBuilder.append(state[i][j]).append(" ");
            }
            stringBuilder.append(state[i][2]);
            stringBuilder.append("]\n");
        }
        stringBuilder.append("Metrics : {\n");
        stringBuilder.append("    h1 = ").append(node.findH1()).append(",\n");
        stringBuilder.append("    h2 = ").append(node.findH2()).append(",\n").append("}");
        return stringBuilder.toString();
    }

    public Node getInitialNode() {
        return initialNode;
    }

    public void setInitialNode(Node initialNode) {
        this.initialNode = initialNode;
    }

    public int[][] getSearchState() {
        return searchState;
    }

    public Queue<Node> getNodeQueue() {
        return nodeQueue;
    }

    public void setNodeQueue(Deque<Node> nodeQueue) {
        this.nodeQueue = nodeQueue;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    @Override
    public String toString() {
        return "SearchTree{" +
                "\ninitialNode=\n" + initialNode +
                "\nsearchState=\n"       + Arrays.toString(searchState[0]) +
                "\n" + Arrays.toString(searchState[1]) +
                "\n" + Arrays.toString(searchState[2]) + "\n" +
                "nodeQueue=\n" + nodeQueue +
                '}';
    }
}
