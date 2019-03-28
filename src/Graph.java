import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<String, Node> nodes;


    public Graph(){
        nodes = new HashMap<String, Node>();
    }

    public void addNode(String name, String description) {
        Node n = new Node(name, description);
        nodes.put(name, n);
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
        return nodes.get(name);

    }



    public class Node{
        private String name; // room name
        private HashMap<String, Node> neighbors;
        private String description;

        private Node(String name, String description) {
            neighbors = new HashMap<String, Node>();
            this.name = name;
            this.description = description;
        }
        public String getDescrip(){
            return description;
        }

        public void setDescrip(String n){
            description =  n;
        }

        private void addNeighbor(Node n){

            String nodeNmae =  n.getName();
            neighbors.put(nodeNmae, n);

        }

        public String getNeighborNames(){
            String names = "";
            for (String n : neighbors.keySet()) {
                names += neighbors.get(n);
            }
            return names;
        }


        public Node getNeighbor(String name){
            return neighbors.get(name);

        }



        public String getName(){
            return name;
        }
    }

}
