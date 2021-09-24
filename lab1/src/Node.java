import java.util.Arrays;

public class Node {
    private int[][] state;
    private Node parentNode;
    private int depth;
    private int emptyI;
    private int emptyJ;

    public Node(int[][] state, int emptyI, int emptyJ, Node parentNode) {
        this.state = state;
        this.emptyI = emptyI;
        this.emptyJ = emptyJ;
        this.parentNode = parentNode;
        this.depth = parentNode == null ? 0 : parentNode.getDepth() + 1;
    }

    public int[][] getState() {
        return state;
    }

    public void setState(int[][] state) {
        this.state = state;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getEmptyI() {
        return emptyI;
    }

    public void setEmptyI(int emptyI) {
        this.emptyI = emptyI;
    }

    public int getEmptyJ() {
        return emptyJ;
    }

    public void setEmptyJ(int emptyJ) {
        this.emptyJ = emptyJ;
    }

    @Override
    public String toString() {
        return "Node{" +
                "\nstate=\n" + Arrays.toString(state[0]) + "\n" + Arrays.toString(state[1]) + "\n" + Arrays.toString(state[2]) + "\n" +
                "parentNode=" + parentNode +
                ", depth=" + depth +
                ", emptyI=" + emptyI +
                ", emptyJ=" + emptyJ +
                '}';
    }
}

