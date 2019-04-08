import java.util.ArrayList;

public class Player {

    String name;
    String description;
    ArrayList<Item> items;
    Graph.Node currentRoom;


    public Player(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<Item>();
    }

    public void addItem(Item i){
        items.add(i);
    }

    public void removeItem(Item i){
        if(!items.contains(i)) return;
        items.remove(i);
        currentRoom.removeItem(i);
    }

    public String getItems(){
        String itemNames = "";
        for (int i = 0; i < items.size(); i++) {
            itemNames += items.get(i).getName() + " ";
        }
        return itemNames;
    }

    public Graph.Node getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node newRoom){
        currentRoom = newRoom;
        name = newRoom.getName();
    }
}
