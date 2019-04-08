import java.util.ArrayList;

public class Chicken extends Animals {

    public Chicken(String name, String description, Graph.Node currentRoom) {
        super(name, description, currentRoom);
    }

    public void move(){



        ArrayList<Graph.Node> neighbor = new ArrayList<>(currentRoom.getNeighbors().values());
        if(neighbor.size() < 1)return;
         int randomRoom =(int) (Math.random()* neighbor.size());

        setCurrentRoom(neighbor.get(randomRoom ));


    }



}
