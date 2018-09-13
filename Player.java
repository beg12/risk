import java.util.Random;
import java.util.Scanner;
import java.io.*;

//class for player
class Player
{
    //if skip check is true, player is eliminated
    private boolean skipCheck;
    //identifies
    private int playerNum;
    //number of territories player owns
    private int territoryNum;
    private String color;
    //list of territories they own
    private Territory territoryList [] = new Territory[42];
    //players 'deck' of cards
    Deck hand = new Deck();
    Scanner input = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));

    //constructor
    public Player(int p)
    {
        territoryNum = 0;
        playerNum = p;
        skipCheck = false;
    }

    //check skip check
    public boolean isSkipCheck() {
        return skipCheck;
    }

    //set skip check
    public void setSkipCheck(boolean skipCheck) {
        this.skipCheck = skipCheck;
    }

    //get player num
    public int getPlayerNum() {
        return playerNum;
    }

    //get number of territories
    public int getTerritoryNum() {
        return territoryNum;
    }

    //add territory to list
    public void addTerritory(Territory t)
    {
        territoryList[territoryNum++] = t;
    }

    //remove territory from list
    public void removeTerritory(Territory t)
    {
        int index = 0;
        for (int i = 0; i < territoryNum; i++)
        {
            if (territoryList[i].getName() == t.getName()) {
                index = i;
                break;
            }
        }
        for (int i = index; i < territoryNum - 1; i++)
        {
            territoryList[i] = territoryList[i + 1];
        }
        territoryNum--;
    }

    //check players territories to award bonuses
    public int getNewArmies(int set)
    {
        int total = 0;
        int numNA, numSA, numEur, numAfr, numAsia, numAus;
        numNA = numAfr = numAsia = numAus = numEur = numSA = 0;
        for (int i = 0; i < territoryNum; i++)
        {
            if (territoryList[i].getContinent().compareTo("North America") == 0)
                numNA += 1;
            else if (territoryList[i].getContinent().compareTo("South America") == 0)
                numSA += 1;
            else if (territoryList[i].getContinent().compareTo("Africa") == 0)
                numAfr += 1;
            else if (territoryList[i].getContinent().compareTo("Asia") == 0)
                numAsia += 1;
            else if (territoryList[i].getContinent().compareTo("Europe") == 0)
                numEur += 1;
            else
                numAus += 1;
        }
        if (numNA == 9)
            total += 5;
        if (numSA == 4)
            total += 2;
        if (numAfr == 6)
            total += 3;
        if (numAsia == 12)
            total += 7;
        if (numAus == 4)
            total += 2;
        if (numEur == 7)
            total += 5;

        if (territoryNum > 8)
            total += territoryNum/3;
        else
            total += 3;
        return total + set;
    }

    //functions rolls dice
    public void rollDice(int numDice, int[] dice)
    {
        Random r = new Random();
        for (int i = 0; i < numDice; i++)
        {
            int roll = r.nextInt(5) + 1;
            dice[i] = roll;
        }
        for (int j = 0; j < numDice-1; j++) {
            for (int i = 0; i < numDice - 1; i++) {
                if (dice[i] < dice[i + 1]) {
                    int temp = dice[i];
                    dice[i] = dice[i + 1];
                    dice[i + 1] = temp;
                }
            }
        }
    }

    //choose territory to attack with
    public String chooseAttackingTerritory() throws IOException {
        bw.write("Choose territory to attack with: ");
        bw.flush();
        boolean check = false;
        String selection = "";
        while (!check) {
            selection = input.nextLine();
            for (int i = 0; i < territoryNum; i++) {
                if (selection.compareTo(territoryList[i].getName()) == 0) {
                    check = true;
                }
            }
            if (!check)
            {
                bw.write("Please choose a territory you control: ");
                bw.flush();
            }
        }
        return selection;
    }

    //choose territory to attack
    public String chooseDefendingTerritory(Territory attacking) throws IOException
    {
        bw.write("Choose a territory to attack: ");
        bw.flush();
        boolean check = false;
        String selection = "";
        while (!check)
        {
            selection = input.nextLine();
            for (int i = 0; i < attacking.neighbors.length; i++)
            {
                if (selection.compareTo(attacking.neighbors[i].getName()) == 0)
                {
                    check = true;
                    break;
                }
            }
            if (!check)
            {
                bw.write("Please choose territory neighboring yours: ");
                bw.flush();
            }
        }
        return selection;
    }

    //print territories player owns
    public void printTerritories() throws IOException
    {
        for (int i = 0; i < territoryNum; i++)
        {
            bw.write(territoryList[i].getName() + " ");
        }
        bw.write('\n');
        bw.flush();
    }

    //check if player has a set
    public boolean hasSet()
    {
        int [] typeTrack = new int[4];
        for (int i = 0; i < hand.getNumCard(); i++)
        {
            if (hand.getCard(i).getType() == -1)
                return true;
            typeTrack[i] = hand.getCard(i).getType();
        }
        for (int j = 0; j < hand.getNumCard() - 1; j++) {
            for (int i = 0; i < hand.getNumCard() - 1; i++) {
                if (typeTrack[i] < typeTrack[i + 1]) {
                    int temp = typeTrack[i];
                    typeTrack[i] = typeTrack[i + 1];
                    typeTrack[i + 1] = temp;
                }
            }
        }
        if (typeTrack[0] == typeTrack[1] && typeTrack[1] != typeTrack[2])
        {
            if (hand.getNumCard() == 3)
                return false;
            else if (hand.getNumCard() == 4 && typeTrack[2] == typeTrack[3])
                return false;
        }
        return true;
    }

    //function to turn in set
    public void turnInSet() throws IOException
    {
        boolean check = false;
        int card1, card2, card3;
        while (!check)
        {
            bw.write("Choose 3 cards: ");
            bw.flush();
            card1 = input.nextInt();
            card2 = input.nextInt();
            card3 = input.nextInt();
            input.nextLine();
            if (hand.getCard(card1).getType() == -1 || hand.getCard(card2).getType() == -1
                    || hand.getCard(card3).getType() == -1)
                check = true;
            else if (hand.getCard(card1).getType() == hand.getCard(card2).getType()
                    && hand.getCard(card1).getType() == hand.getCard(card3).getType())
                check = true;
            else if (hand.getCard(card1).getType() != hand.getCard(card2).getType()
                    && hand.getCard(card2).getType() != hand.getCard(card3).getType())
                check = true;
            else
            {
                bw.write("Choose a set that has a wild card, has matching icons, or 3 different icons.\n");
                bw.flush();
            }
            hand.removeCard(card1);
            hand.removeCard(card2);
            hand.removeCard(card3);
        }
    }
}