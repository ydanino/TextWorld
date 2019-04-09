import java.util.ArrayList;

public class Devil extends Animals {

    private Player p;

    public Devil(String name, String description, Graph.Node currentRoom, Player p) {
        super(name, description, currentRoom);
        this.p = p;
    }


    @Override
    public void move() {
        ArrayList<Graph.Node> devilNeighbor = new ArrayList<>(currentRoom.getNeighbors().values());
        if(devilNeighbor.size() < 1)return;
        ArrayList<Graph.Node> playerNeighbor = p.getCurrentRoom().getNeighnorNamesArrayList();
        ArrayList<Graph.Node> availableRooms = twoSpacesApart(playerNeighbor, devilNeighbor);

        if(availableRooms.size() > 0){
            int randomRoom =(int) (Math.random()* availableRooms.size());
            setCurrentRoom(availableRooms.get(randomRoom));
        }else{
            int randomRoom =(int) (Math.random()* availableRooms.size());
            setCurrentRoom(availableRooms.get(randomRoom));
        }
    }


    private ArrayList<Graph.Node> twoSpacesApart(ArrayList<Graph.Node> playerNeighbor, ArrayList<Graph.Node> devilNeighbor) {
        ArrayList<Graph.Node> PlayerNeighbors = new ArrayList<>();

        for (int i = 0; i < playerNeighbor.size(); i++) {
            for (int j = 0; j < devilNeighbor.size(); j++) {
                if(playerNeighbor.get(i).equals(devilNeighbor.get(j))){
                    PlayerNeighbors.add(devilNeighbor.get(i));
                }
            }
        }
        return PlayerNeighbors;
    }
}
