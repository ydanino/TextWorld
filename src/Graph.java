import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Node> nodes;

    public Graph(){
        nodes = new ArrayList<Node>();
    }

    public void addNode(String name) {
        nodes.add(new Node(name));
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);

        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);

        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public Node getNode(String name) {
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).getName().equals(name)){
                return nodes.get(i);
            }
        }
        return null;
    }



    public class Node{
        private String name; // room name
        private ArrayList<Node> neighbors;

        private Node(String name) {
            neighbors = new ArrayList<Node>();
            this.name = name;
        }

        private void addNeighbor(Node n){
            neighbors.add(n);
        }

        public String getNeighborNames(){
            String names = "";
            for (int i = 0; i < neighbors.size(); i++) {
                names += neighbors.get(i).getName() + " ";
            }
            return names;
        }

        public Node getNeighbor(String name){
            for (int i = 0; i < neighbors.size(); i++) {
                if(neighbors.get(i).getName().equals(name)){
                    return neighbors.get(i);
                }
            }

            return null;
        }



        public String getName(){
            return name;
        }
    }

}
