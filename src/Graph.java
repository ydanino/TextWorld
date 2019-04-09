import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<String, Node> nodes;
    private ArrayList<Animals> allAnimals;
    private Player p;

    public Graph(){
        nodes = new HashMap<String, Node>();
        allAnimals = new ArrayList<Animals>();
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

    public void addAnimal(Animals a){
        allAnimals.add(a);
    }

    public Animals removeAnimal(String name){
        for (int i = 0; i < allAnimals.size() ; i++) {
            if(allAnimals.get(i).getName().equals(name)){

                return allAnimals.remove(i);
            }
        }
        return null;
    }

    public void removeAnimal(Animals a){
        if(!allAnimals.contains(a))return;

        allAnimals.remove(a);
    }

    public void updateAllAnimals(){
        for (Animals a : allAnimals) {
            System.out.println("all animals size" + allAnimals.size());
            a.move();
        }
    }

    public String displayAnimals(Node room){
        String animalNames = "";
        for(Animals a : allAnimals){
            if(a.getCurrentRoom().equals(room)){
                animalNames += a.getName() + " ";
            }
        }
        return animalNames;
    }

    public String displayAnimalsRoom(){
        String animalANDRoom = "";
        for (Animals a : allAnimals) {
            animalANDRoom = a.getName() + " is at the " + a.getCurrentRoom().getName() + " ";
        }
        return animalANDRoom;
    }

    public class Node{
        private String name; // room name
        private HashMap<String, Node> neighbors;
        private String description;
        public ArrayList<Item> roomItems;
        public ArrayList<Animals> aninmals;

        private Node(String name, String description) {
            neighbors = new HashMap<String, Node>();
            this.name = name;
            this.description = description;
            this.roomItems = new ArrayList<Item>();
        }



        public String getItems(){
            String itemNames = "";
            for (int i = 0; i < roomItems.size(); i++) {
                itemNames += roomItems.get(i).getName() + " ";
            }
            return itemNames;
        }

        public void addItem(Item i){
            roomItems.add(i);
        }

        public void removeItem(Item i){
            if(!roomItems.contains(i))return;

            roomItems.remove(i);

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
                names += neighbors.get(n).getName() + " ";
            }
            return names;
        }

        public ArrayList<Node> getNeighnorNamesArrayList(){
            ArrayList<Node> neighborNames = new ArrayList<Node>();

            for( String n: neighbors.keySet()){
                neighborNames.add(neighbors.get(n));
            }

            return neighborNames;
        }

        public HashMap getNeighbors(){
            return neighbors;
        }



        public Node getNeighbor(String name){
            return neighbors.get(name);

        }

        public String getName(){
            return name;
        }
    }

}
