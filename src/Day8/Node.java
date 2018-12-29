package Day8;

import java.util.ArrayList;

public class Node {

    private ArrayList<Node> children;
    private ArrayList<Integer> metadata;

    public Node(ArrayList<Node> children, ArrayList<Integer> metadata) {

        this.children = children;
        this.metadata = metadata;

    }

    public ArrayList<Integer> getMetaData() {

        return this.metadata;
    }

    public ArrayList<Node> getChildren() {

        return this.children;
    }

}
