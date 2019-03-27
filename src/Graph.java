import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<String, Node> nodes;


    public Graph(){
        nodes = new HashMap<String, Node>();
    }

    public void addNode(String name) {
        Node n = new Node(name);
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
        private String descrip;

        private Node(String name, String descrip) {
            neighbors = new ArrayList<Node>();
            this.name = name;
        }
        public String getDescrip(){
            return descrip;
        }

        public void setDescrip(String n){
            descrip =  n;
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
