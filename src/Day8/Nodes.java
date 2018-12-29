package Day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Nodes {


    private ArrayList<Integer> nums;
    private Node root;


    public Nodes() throws FileNotFoundException {

        nums = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/Day8/nodes.txt"));
        while(scanner.hasNext()) {
            nums.add(scanner.nextInt());
        }

        root = this.readNode();
    }


    private int position = 0;


    int getNextValue() {

        if(position == this.nums.size())
            return 0;

        int x = nums.get(position);
        this.position++;

        return x;
    }


    private Node readNode() {

        int nodeChildren = this.getNextValue();
        int nodeMetaData = this.getNextValue();

        ArrayList<Node> children = new ArrayList<>();

        for(int i = 0; i < nodeChildren; i++)
            children.add(readNode());

        ArrayList<Integer> metaData = new ArrayList<>();

        for(int i = 0; i < nodeMetaData; i++)
            metaData.add(this.getNextValue());

        return new Node(children, metaData);
    }


    private int getListSum(ArrayList<Integer> list) {

        int sum = 0;
        for(int n : list)
            sum += n;
        return sum;
    }


    private int metaDataSum(Node root) {

        int sum = 0;

        sum += this.getListSum(root.getMetaData());

        for(Node n : root.getChildren())
            sum += this.metaDataSum(n);

        return sum;
    }


    public int getMetaDataSum() {

        return this.metaDataSum(this.root);
    }


    private int getNodeValue(Node node) {

        if(node.getChildren().size() > 0) {

            int sum = 0;

            for(int i : node.getMetaData()) {

                i--;
                if(i >= 0 && i < node.getChildren().size())
                    sum += this.getNodeValue(node.getChildren().get(i));
            }

            return sum;

        } else {

            return this.getListSum(node.getMetaData());
        }
    }


    public int getRootValue() {

        return this.getNodeValue(this.root);
    }



}

