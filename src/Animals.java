import java.util.ArrayList;

public abstract class Animals {

    protected Graph.Node currentRoom;
    protected String name;
    protected String description;

    public Animals(String name,String description, Graph.Node currentRoom){
        this.name = name;
        this.description = description;
        this.currentRoom = currentRoom;

    }

    public abstract void move();

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateRoom(Graph.Node currentRoom, Graph.Node nextRoom) {
        setCurrentRoom(nextRoom);
    }
}
