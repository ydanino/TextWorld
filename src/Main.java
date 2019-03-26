import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // build up hrapg of connected notes

        Graph g = new Graph();
        g.addNode("hall");
        g.addNode("closet");
        g.addNode("dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");


        Graph.Node current = g.getNode("hall");


        String response = "";
        Scanner in = new Scanner(System.in);

        do{
            System.out.println("You are in the " + current.getName());
            System.out.print("what do you want to do? >");
            response = in.nextLine();

            if(response.substring(0,2).equals("go")){
                current = g.getNode(getRoomName(response));

            }else if(response.equals("look")){
                System.out.println("You are currently in the " + current.getName());
                System.out.println("You can go to the " +  current.getNeighborNames());

            }else if(response.substring(0,3).equals("add")){
                String room = getRoomName(response);
                g.addNode(room);
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
                System.out.println(second);
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
