import java.util.ArrayList;

public class Wumpus extends Animals{
    private Player p;

    public Wumpus(String name, String description, Graph.Node currentRoom, Player p) {
        super(name, description, currentRoom);
        this.p = p;
    }

    @Override
    public void move() {
        ArrayList<Graph.Node> wumpusNeighbor = new ArrayList<>(currentRoom.getNeighbors().values());
        if(wumpusNeighbor.size() < 1)return;
        ArrayList<Graph.Node> playerNeighbor = p.getCurrentRoom().getNeighnorNamesArrayList();
        ArrayList<Graph.Node> availableRooms = twoSpacesApart(playerNeighbor, wumpusNeighbor);

        if(availableRooms.size() < wumpusNeighbor.size()){
            int randomRoom =(int) (Math.random()* availableRooms.size());
            setCurrentRoom(availableRooms.get(randomRoom));
        }else{
            int randomRoom =(int) (Math.random()* availableRooms.size());
            setCurrentRoom(availableRooms.get(randomRoom));
        }


    }

    private ArrayList<Graph.Node> twoSpacesApart(ArrayList<Graph.Node> playerNeighbor, ArrayList<Graph.Node> wumpusNeighbor) {
        ArrayList<Graph.Node> nonPlayerNeighbors = wumpusNeighbor;

        for (int i = 0; i < playerNeighbor.size(); i++) {
            for (int j = 0; j < wumpusNeighbor.size(); j++) {
                if(playerNeighbor.get(i).equals(wumpusNeighbor.get(j))){
                    nonPlayerNeighbors.remove(wumpusNeighbor.get(i));
                }
            }
        }
        return nonPlayerNeighbors;
    }
}
