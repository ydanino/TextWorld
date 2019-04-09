import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Animals> allAnimals;
    public static void main(String[] args) {
        // build up hrapg of connected notes

        Graph g = new Graph();
        g.addNode("hall","long hallway" );
        g.addNode("closet", "massive closet");
        g.addNode("dungeon", "magnificent dungeon");
        g.addNode("bathroom", "clean bathroom");
        g.addNode("shower", "hot ");
        g.addNode("HELL", "LEAVE NOW!!!");

        g.addDirectedEdge("hall", "dungeon");
        g.addDirectedEdge("hall", "closet");
        g.addDirectedEdge("hall", "bathroom");
        g.addDirectedEdge("bathroom", "shower");
        g.addDirectedEdge("dungeon", "HELL");


        Graph.Node current = g.getNode("hall");

        String response = "";
        Scanner in = new Scanner(System.in);
        Player p = new Player("yuval", "junior");
        p.setCurrentRoom(current);

        g.getNode("hall").addItem(new Item("sword"));
        g.getNode("closet").addItem(new Item("towel"));
        g.getNode("dungeon").addItem(new Item("dragon food"));


        g.addAnimal(new Chicken("bobby the chicken ", "cool chicken", g.getNode("hall")));
        g.addAnimal(new Wumpus("ted the wumpus", "fat", g.getNode("dungeon"), p));
        g.addAnimal(new Devil("john the Devil", "scariest man alive", g.getNode("hell"), p));

        do{
            System.out.println("");
            System.out.println("You are in the " + p.getCurrentRoom().getName());
            System.out.print("what do you want to do? >");
            response = in.nextLine();

            if(response.substring(0,2).equals("go")){
                p.setCurrentRoom(g.getNode(getRoomName(response)));
                g.updateAllAnimals(); // how do i run stuff now


            }else if(response.substring(0,4).equals("take")){
                Item m = new Item(getRoomName(response));
                p.addItem(m);
                p.getCurrentRoom().removeItem(m);

            }else if(response.substring(0,4).equals("drop")){
                Item m = new Item(getRoomName(response));
                p.removeItem(m);
                p.getCurrentRoom().addItem(m);
            }else if(response.substring(0,6).equals("search")){
                System.out.println(g.displayAnimalsRoom());
            }

            else if(response.equals("look")){
                System.out.println("You are currently in the " + p.getCurrentRoom().getName() + ":" + p.getCurrentRoom().getDescrip());
                System.out.println("You can go to the " +  p.getCurrentRoom().getNeighborNames());
                System.out.println("The room you're in contains: " + p.getCurrentRoom().getItems());
                System.out.println("The items you currently have are:" + p.getItems());
                System.out.println("The animals in this room are: " + g.displayAnimals(p.getCurrentRoom())  );


            }else if(response.substring(0,3).equals("add")){
                String room = getRoomName(response);
                System.out.print("what will be your room description?");
                String description = in.nextLine();
                g.addNode(room, description);
                g.addDirectedEdge(current.getName(), room);

            }else if(response.equals("quit")){
                break;
            }else {
                System.out.println("type 'go <roomName>' to go room");
                System.out.println("type 'look' to display all neighbors");
                System.out.println("type 'add room <roomname> to add a new neighbor to current room");
                System.out.println("type 'quit' to quit game");
            }


        }while(!response.equals("quit"));

    }

    private static String getRoomName(String response) {
        String end = "";
        for (int i = 0; i < response.length(); i++) {
            if (response.substring(i, i+1).equals("<")){
                int second = findSecond(response, i+1);
                end = response.substring(i+1,second );
                return end;
            }
        }

        return end;
    }

    private static int findSecond(String response, int i) {
        for (int j = i; j < response.length(); j++) {
            if (response.substring(j, j+1).equals(">")){
                return j;
            }
        }
        return -1;
    }
}
