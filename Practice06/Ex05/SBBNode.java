package Practice06.Ex05;

public class SBBNode {
    SBBNode left, right;
    int data;
    int height;

    /* Constructor */
    public SBBNode() {
        left = null;
        right = null;
        data = 0;
        height = 0;
    }

    /* Constructor */
    public SBBNode(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}