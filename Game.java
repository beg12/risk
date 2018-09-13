import java.io.*;
import java.util.Scanner;

//class with main, runs the game
public class Game
{
    public static void main(String args[]) throws IOException
    {
        Scanner input = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        Board b = new Board();
//        bw.write("Load game? ");
//        bw.flush();
//        String selection = input.nextLine();
//        if (selection.compareTo("yes") == 0) {
//           b.loadGame();
//            b.printBoard();
//        }
//        else {
//            b.printBoard();
//           b.setupArmies();
//        }
        b.turn();
    }
}