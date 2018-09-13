import java.util.Scanner;
import java.io.*;

//This handles every interaction with the board essentially
class Board {
    final int TERRITORYNUM = 42;
    final int MAXPLAYERS = 6;
    final int WAIT = 100000;

    //string macros for continents
    final String NA = "North America";
    final String SA = "South America";
    final String AFRICA = "Africa";
    final String ASIA = "Asia";
    final String EUROPE = "Europe";
    final String AUS = "Australia";

    //number of players
    private int playerNum;
    //keeps track of current player and what part of their turn they are in for saving/loading
    private int currentPlayer = 0;
    private int turnPart = 0;
    //array of territories
    private Territory[] territories = new Territory[TERRITORYNUM];
    //array of players
    private Player[] players = new Player[MAXPLAYERS];
    //starting number of armies to place during setup
    private int startingNum;
    //deck for risk cards
    private Deck cardDeck = new Deck();
    //number of card sets turned in by players
    private int setNum = 0;
    //army bonus for turning in sets
    private int setBonus = 4;
    //used for console testing, not neccessary
    Scanner input = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
    private BoardWindow viewBoard = new BoardWindow();

    //constructor for the board, creates player and territory objects and gets everything in order
    public Board() throws IOException{
    	viewBoard.init();
//       bw.write("Load game? ");
//       bw.flush();
//        String selection = input.nextLine();
    	viewBoard.setOutput("Load game?");
    	String selection = viewBoard.getInputS();
    	if (selection.compareTo("yes") == 0 || selection.compareTo("Yes") == 0) {
            loadGame();
//            printBoard();
        }
        else {
//            printBoard();
        
        //will probably make this a separate function later, but for now gets number of players
//    	bw.write("How many players? ");
//        bw.flush();
 //   	playerNum = input.nextInt();
 //       input.nextLine();
        //starting number of armies dependent on number of players, no error checking yet
    	viewBoard.setOutput("How many players?");
    	playerNum = viewBoard.getInputI();
    	if (playerNum == 6)
            startingNum = 20;
        else if (playerNum == 5)
            startingNum = 25;
        else if (playerNum == 4)
            startingNum = 30;
        else
            startingNum = 35;
    	viewBoard.setOutput("Creating game.");
        //creates player objects
        for (int i = 0; i < playerNum; i++) {
            Player temp = new Player(i+1);
            players[i] = temp;
        }
        //makes new territories and their corresponding cards
        Territory Alaska = new Territory("Alaska", NA);
        territories[0] = Alaska;
        cardDeck.addCard(new Card("Alaska", 0));
        Territory Alberta = new Territory("Alberta", NA);
        territories[1] = Alberta;
        cardDeck.addCard(new Card("Alberta", 1));
        Territory CentralAmerica = new Territory("Central America", NA);
        territories[2] = CentralAmerica;
        cardDeck.addCard(new Card("Central America", 2));
        Territory EasternUnitedStates = new Territory("Eastern United States", NA);
        territories[3] = EasternUnitedStates;
        cardDeck.addCard(new Card("Eastern United States", 2));
        Territory Greenland = new Territory("Greenland", NA);
        territories[4] = Greenland;
        cardDeck.addCard(new Card("Greenland", 1));
        Territory NorthwestTerritory = new Territory("Northwest Territory", NA);
        territories[5] = NorthwestTerritory;
        cardDeck.addCard(new Card("Northwest Territory", 2));
        Territory Ontario = new Territory("Ontario", NA);
        territories[6] = Ontario;
        cardDeck.addCard(new Card("Ontario", 1));
        Territory Quebec = new Territory("Quebec", NA);
        territories[7] = Quebec;
        cardDeck.addCard(new Card("Quebec", 1));
        Territory WesternUnitedStates = new Territory("Western United States", NA);
        territories[8] = WesternUnitedStates;
        cardDeck.addCard(new Card("Western United States", 2));
        Territory Argentina = new Territory("Argentina", SA);
        territories[9] = Argentina;
        cardDeck.addCard(new Card("Argentina", 0));
        Territory Brazil = new Territory("Brazil", SA);
        territories[10] = Brazil;
        cardDeck.addCard(new Card("Brazil", 2));
        Territory Peru = new Territory("Peru", SA);
        territories[11] = Peru;
        cardDeck.addCard(new Card("Peru", 0));
        Territory Venezuela = new Territory("Venezuela", SA);
        territories[12] = Venezuela;
        cardDeck.addCard(new Card("Venezuela", 0));
        Territory GreatBritain = new Territory("Great Britain", EUROPE);
        territories[13] = GreatBritain;
        cardDeck.addCard(new Card("Great Britain", 2));
        Territory Iceland = new Territory("Iceland", EUROPE);
        territories[14] = Iceland;
        cardDeck.addCard(new Card("Iceland", 0));
        Territory NorthernEurope = new Territory("Northern Europe", EUROPE);
        territories[15] = NorthernEurope;
        cardDeck.addCard(new Card("Northern Europe", 2));
        Territory Scandinavia = new Territory("Scandinavia", EUROPE);
        territories[16] = Scandinavia;
        cardDeck.addCard(new Card("Scandinavia", 1));
        Territory SouthernEurope = new Territory("Southern Europe", EUROPE);
        territories[17] = SouthernEurope;
        cardDeck.addCard(new Card("Southern Europe", 2));
        Territory Ukraine = new Territory("Ukraine", EUROPE);
        territories[18] = Ukraine;
        cardDeck.addCard(new Card("Ukraine", 1));
        Territory WesternEurope = new Territory("Western Europe", EUROPE);
        territories[19] = WesternEurope;
        cardDeck.addCard(new Card("Western Europe", 2));
        Territory Congo = new Territory("Congo", AFRICA);
        territories[20] = Congo;
        cardDeck.addCard(new Card("Congo", 0));
        Territory EastAfrica = new Territory("East Africa", AFRICA);
        territories[21] = EastAfrica;
        cardDeck.addCard(new Card("East Africa", 0));
        Territory Egypt = new Territory("Egypt", AFRICA);
        territories[22] = Egypt;
        cardDeck.addCard(new Card("Egypt", 0));
        Territory Madagascar = new Territory("Madagascar", AFRICA);
        territories[23] = Madagascar;
        cardDeck.addCard(new Card("Madagascar", 1));
        Territory NorthAfrica = new Territory("North Africa", AFRICA);
        territories[24] = NorthAfrica;
        cardDeck.addCard(new Card("North Africa", 1));
        Territory SouthAfrica = new Territory("South Africa", AFRICA);
        territories[25] = SouthAfrica;
        cardDeck.addCard(new Card("South Africa", 2));
        Territory Afghanistan = new Territory("Afghanistan", ASIA);
        territories[26] = Afghanistan;
        cardDeck.addCard(new Card("Afghanistan", 1));
        Territory China = new Territory("China", ASIA);
        territories[27] = China;
        cardDeck.addCard(new Card("China", 0));
        Territory India = new Territory("India", ASIA);
        territories[28] = India;
        cardDeck.addCard(new Card("India", 1));
        Territory Irkutsk = new Territory("Irkutsk", ASIA);
        territories[29] = Irkutsk;
        cardDeck.addCard(new Card("Irkutsk", 1));
        Territory Japan = new Territory("Japan", ASIA);
        territories[30] = Japan;
        cardDeck.addCard(new Card("Japan", 2));
        Territory Kamchatka = new Territory("Kamchatka", ASIA);
        territories[31] = Kamchatka;
        cardDeck.addCard(new Card("Kamchatka", 0));
        Territory MiddleEast = new Territory("Middle East", ASIA);
        territories[32] = MiddleEast;
        cardDeck.addCard(new Card("Middle East", 0));
        Territory Mongolia = new Territory("Mongolia", ASIA);
        territories[33] = Mongolia;
        cardDeck.addCard(new Card("Mongolia", 0));
        Territory Siam = new Territory("Siam", ASIA);
        territories[34] = Siam;
        cardDeck.addCard(new Card("Siam", 0));
        Territory Siberia = new Territory("Siberia", ASIA);
        territories[35] = Siberia;
        cardDeck.addCard(new Card("Siberia", 1));
        Territory Ural = new Territory("Ural", ASIA);
        territories[36] = Ural;
        cardDeck.addCard(new Card("Ural", 1));
        Territory Yakutsk = new Territory("Yakutsk", ASIA);
        territories[37] = Yakutsk;
        cardDeck.addCard(new Card("Yakutsk", 1));
        Territory EasternAustralia = new Territory("Eastern Australia", AUS);
        territories[38] = EasternAustralia;
        cardDeck.addCard(new Card("Eastern Australia", 2));
        Territory Indonesia = new Territory("Indonesia", AUS);
        territories[39] = Indonesia;
        cardDeck.addCard(new Card("Indonesia", 2));
        Territory NewGuinea = new Territory("New Guinea", AUS);
        territories[40] = NewGuinea;
        cardDeck.addCard(new Card("New Guinea", 0));
        Territory WesternAustralia = new Territory("Western Australia", AUS);
        territories[41] = WesternAustralia;
        cardDeck.addCard(new Card("Western Australia", 2));
    	viewBoard.setOutput("Creating game..");
        //adds list of neighbors to each territory
        Alaska.addNeighbor(Kamchatka, Alberta, NorthwestTerritory);
        Alberta.addNeighbor(Alaska, NorthwestTerritory, Ontario, WesternUnitedStates);
        CentralAmerica.addNeighbor(WesternUnitedStates, EasternUnitedStates, Venezuela);
        EasternUnitedStates.addNeighbor(WesternUnitedStates, CentralAmerica, Ontario, Quebec);
        Greenland.addNeighbor(Iceland, NorthwestTerritory, Quebec, Ontario);
        Ontario.addNeighbor(NorthwestTerritory, Alberta, Quebec, EasternUnitedStates, Greenland, WesternUnitedStates);
        Quebec.addNeighbor(Ontario, Greenland, EasternUnitedStates);
        WesternUnitedStates.addNeighbor(Alberta, Ontario, EasternUnitedStates, CentralAmerica);
        Argentina.addNeighbor(Brazil, Peru);
        Brazil.addNeighbor(NorthAfrica, Venezuela, Peru, Argentina);
        Peru.addNeighbor(Venezuela, Brazil, Argentina);
        Venezuela.addNeighbor(CentralAmerica, Brazil, Peru);
        GreatBritain.addNeighbor(Iceland, Scandinavia, NorthernEurope);
        Iceland.addNeighbor(Greenland, GreatBritain, Scandinavia);
        NorthernEurope.addNeighbor(GreatBritain, WesternEurope, SouthernEurope, Scandinavia, Ukraine);
        Scandinavia.addNeighbor(Ukraine, Iceland, GreatBritain, NorthernEurope);
        SouthernEurope.addNeighbor(Ukraine, NorthernEurope, WesternEurope, NorthAfrica, Egypt, MiddleEast);
        Ukraine.addNeighbor(Afghanistan, Ural, MiddleEast, Scandinavia, NorthernEurope, SouthernEurope);
        WesternEurope.addNeighbor(GreatBritain, NorthernEurope, SouthernEurope, NorthAfrica);
        Congo.addNeighbor(EastAfrica, NorthAfrica, SouthAfrica);
        EastAfrica.addNeighbor(Egypt, NorthAfrica, Congo, Madagascar, SouthAfrica, MiddleEast);
        Egypt.addNeighbor(SouthernEurope, NorthAfrica, MiddleEast, EastAfrica);
        Madagascar.addNeighbor(SouthAfrica, EastAfrica);
        NorthAfrica.addNeighbor(Brazil, Congo, EastAfrica, Egypt, WesternEurope, SouthernEurope);
        SouthAfrica.addNeighbor(Congo, EastAfrica, Madagascar);
        Afghanistan.addNeighbor(Ukraine, MiddleEast, India, China, Ural);
        China.addNeighbor(Mongolia, Siam, India, Afghanistan, Ural, Siberia);
        Irkutsk.addNeighbor(Mongolia, Yakutsk, Kamchatka, Siberia);
        India.addNeighbor(China, Siam, MiddleEast, Afghanistan);
        Japan.addNeighbor(Kamchatka, Mongolia);
        Kamchatka.addNeighbor(Alaska, Japan, Mongolia, Irkutsk, Yakutsk);
        MiddleEast.addNeighbor(EastAfrica, Egypt, SouthernEurope, Ukraine, Afghanistan, India);
        Mongolia.addNeighbor(Japan, Kamchatka, China, Siberia, Irkutsk);
        Siam.addNeighbor(Indonesia, India, China);
        Siberia.addNeighbor(Ural, Irkutsk, Yakutsk, Mongolia, China);
        Ural.addNeighbor(Ukraine, Afghanistan, Siberia, China);
        Yakutsk.addNeighbor(Kamchatka, Irkutsk, Siberia);
        EasternAustralia.addNeighbor(WesternAustralia, NewGuinea);
        Indonesia.addNeighbor(Siam, NewGuinea);
        NewGuinea.addNeighbor(EasternAustralia, WesternAustralia, Indonesia);
        WesternAustralia.addNeighbor(EasternAustralia, NewGuinea);
        //add wild cards to deck and shuffle deck
        cardDeck.addCard(new Card("Wild", -1));
        cardDeck.addCard(new Card("Wild", -1));
        cardDeck.shuffle();
    	viewBoard.setOutput("Creating game...");
        setupArmies();
        }
    }
    //function sets up initial starting armies
    public void setupArmies() throws IOException {
        //must fill up board before placing additional armies
        int territoriesLeft = TERRITORYNUM;
        //run through loop however much the starting army number is
        for (int i = 0; i < startingNum; i++) {
            //run through number of players
            for (int j = 0; j < playerNum; j++) {
                //check to see if there are still territories with no armies
                boolean cont = false;
                //check to make sure user inputs valid territory
                while (!cont) {
//                    bw.write("Player " + (j+1) + " enter a selection: ");
//                    bw.flush();
                	viewBoard.setOutput("Player " + (j+1) + " Select a territory.");
                	int temp = viewBoard.getSelectionI();
                	//                	String choice = input.nextLine();
                	//getTet gets the index of territory in territory list
//                    int temp = getTet(choice);
                    //if valid choice, then check if there are empty territories
                    if (temp != -1) {
                        if (territoriesLeft > 0) {
                            //make sure that territory has no armies on it
                            if (territories[temp].getArmyNum() == 0) {
                                //valid territory, so the check is true
                                cont = true;
                                //add an army to the territory
                                territories[temp].addArmyNum(1);
                                //add territory to list of player territories
                                players[j].addTerritory(territories[temp]);
                                //set the player that controls that territory
                                territories[temp].setPlayer(j + 1);
                                //decrease number of territories that have no armies on them
                                territoriesLeft--;
                                viewBoard.setCountryLabel(temp, (j+1), territories[temp].getArmyNum());
                            }
                            //ask user to reinput a territory
                            else{
                            	for(int w = 0; w < WAIT; w++){
                                	viewBoard.setOutput("Place army on territory with no armies");
                            	}
//                                bw.write("Place army on territory with no armies\n");
//                                bw.flush();
                            }
                        }
                        //if all territories have at least an army on it then players place
                        // armies on territories they own
                        else
                        {
                            if (territories[temp].getPlayer() == j + 1)
                            {
                                cont = true;
                                territories[temp].addArmyNum(1);
                                viewBoard.setCountryLabel(temp, (j+1), territories[temp].getArmyNum());
                                viewBoard.refreshBoard();
                            }
                            else{
                            	for(int w = 0; w < WAIT; w++){
                                   	viewBoard.setOutput("Place army on territory the you own");
                            	}
//                                bw.write("Place army on territory that you own\n");
//                                bw.flush();
                            }
                        }
                    }
                    //if user inputs wrong territory name
                    else{
                    	for(int w = 0; w < WAIT; w++){
                    		viewBoard.setOutput("Invalid territory name, try again.");
                    	}
//                        bw.write("Invalid territory name, try again.\n");
//                        bw.flush();
                    }
                }
            }
        }
    }

    //at beginning of turn players get a number of armies and place them
    public void placeArmies(int num, int player) throws IOException
    {
        //how many armies player can place
        int armiesLeft = num;
        //only place armies while there are armies left
        while (armiesLeft > 0)
        {
            //check to make sure player inputs a correct territory
            boolean cont = false;
            while (!cont)
            {
            	viewBoard.setOutput("P" + player + " Enter a territory you own:");

//                bw.write("Enter a territory you own: ");
//                bw.flush();
//                String selection = input.nextLine();
//            	int temp = getTet(selection);
            	int temp = viewBoard.getSelectionI();
            	if (temp != -1)
                {
                    //check if player actually owns territory
                    if (territories[temp].getPlayer() == player)
                    {
                        cont = true;
                        //get number of armies from player
//                        bw.write("How many armies on this territory? ");
//                        bw.flush();
//                        int choice = input.nextInt();
//                        input.nextLine();
                        viewBoard.setOutput("How many armies on this territory? Armies remaining:" + armiesLeft);
                        int choice = viewBoard.getInputI();
                        //make sure choice is valid, has to be at least 1 and <= however many armies they have
                        while (choice > armiesLeft || choice < 1)
                        {
                        	viewBoard.setOutput("Enter number less than or equal to armies left.");
                        	choice = viewBoard.getInputI();
//                            bw.write("Enter number less than or equal to armies left: ");
//                            bw.flush();
//                            choice = input.nextInt();
//                            input.nextLine();
                        }
                        //add that number of armies to the territory
                        territories[temp].addArmyNum(choice);
                        viewBoard.setCountryLabel(temp, player, territories[temp].getArmyNum());
                        //subtract from armies left
                        armiesLeft = armiesLeft - choice;
                        viewBoard.refreshBoard();
                    }
                    //if check fails, let player know
                    else
                    {
                    	for(int i = 0; i < WAIT; i++){
                    		viewBoard.setOutput("You don't own this territory.");
//                        bw.write("You don't own this territory.\n");
//                        bw.flush();
                    	}
                    }
                }
                //if wrong territory name, let player know
                else
                {
                	for(int i = 0; i < WAIT; i++){
                    	for(int w = 0; w < WAIT; w++){
                    		viewBoard.setOutput("Invalid territory name");
                    	}
//                    bw.write("Invalid territory name \n");
//                    bw.flush();

                	}
                }
            }
        }
    }
    //accessor
    public int getPlayerNum() {
        return playerNum;
    }

    //get index of territory in territory array given a string. return -1 if string isnt a territory
    public int getTet(String s) {
        for (int i = 0; i < TERRITORYNUM; i++) {
            if (s.compareTo(territories[i].getName()) == 0)
                return i;
        }
        return -1;
    }

    //for console, prints board info
    public void printBoard() throws IOException
    {
        for (int i = 0; i < TERRITORYNUM; i++)
        {
        	viewBoard.setOutput(territories[i].getName() + " " + territories[i].getContinent() + " " + territories[i].getPlayer() + " " + territories[i].getArmyNum());
//            bw.write(territories[i].getName() + " " + territories[i].getContinent() + " " + territories[i].getPlayer()
//            + " " + territories[i].getArmyNum() + '\n');
//            bw.flush();
        }
    }

    //calculates new set bonus when set of cards is turned in
    public void newSetBonus()
    {
        setNum++;
        if (setNum < 5)
            setBonus = setBonus + 2;
        else if (setNum > 5)
            setBonus = setBonus + 5;
        else
            setBonus = setBonus + 3;
    }
    //function goes through a players turn
    public void turn() throws IOException
    {
        //check for win condition
        while (!winCond())
        {
            //cycle through players to do their turns
            for (int i = currentPlayer; i < playerNum; i++)
            {
                String selection;
                //if player is eliminated then skip check will skip their turn
                if (!players[i].isSkipCheck()) {
//                    printBoard();
                    //variable for armies to place at beginning of turn
                    int extraArmies = 0;
                    //if player has more than 4 cards, they have to turn in a set
           /*         if (players[i].hand.getNumCard() > 4) {
                        //if a player can, call function too see if they want to turn in set
                        players[i].turnInSet();
                        //add set bonus to extra armies and update the set bonus
                        extraArmies = extraArmies + setBonus;
                        newSetBonus();
                    }
                    //if they have less than 4 but could possibly turn in a set, ask user
                    if (players[i].hand.getNumCard() > 2) {
                        if (players[i].hasSet()) {
                        	viewBoard.setOutput("Would you like to turn in a set?");
                        	String setChoice = viewBoard.getInputS();
 //                           bw.write("Would you like to turn in a set? ");
 //                           bw.flush();
 //                           String setChoice = input.nextLine();
                            //if they want to, have them turn in a set
                            if (setChoice.compareTo("yes") == 0 || setChoice.compareTo("Yes") == 0) {
                                players[i].turnInSet();
                                extraArmies = extraArmies + setBonus;
                                newSetBonus();
                            }
                        }
                    }
                    */
                    //get armies depending on how many territories a player owns and any continent bonuses
                    int armies = players[i].getNewArmies(extraArmies);
                    //begining of turn, place armies
                    if (turnPart == 0) {
                        placeArmies(armies, i + 1);
                        turnPart++;
                        saveGame();
                    }
                    //seconds part of turn, combat
                    if (turnPart == 1) {
                        //attacking is optional
                    	viewBoard.setOutput("Would you like to attack?");
//                        bw.write("Would you like to attack? ");
//                        bw.flush();
//                        selection = input.next();
                    	selection = viewBoard.getInputS();
//                    	input.nextLine();
                        //if they want to, go to attack function
                        if (selection.compareTo("yes") == 0 || selection.compareTo("Yes") == 0) {
                            combat(players[i]);
                        }
                        //if player wins during combat, break from loop
                        if (winCond()) {
                            break;
                        }
                        turnPart++;
                        saveGame();
                    }
                    //end of turn is to fortify territories
                    if (turnPart == 2) {
                        //fortifying is optional
                    	viewBoard.setOutput("Would you like to fortify?");
//                        bw.write("Would you like to fortify? ");
//                        bw.flush();
//                        selection = input.nextLine();
                    	selection = viewBoard.getInputS();
                    	//if they want to, go to fortify function
                        if (selection.compareTo("yes") == 0 || selection.compareTo("Yes") == 0)
                            fortify(i + 1);
                        turnPart = 0;
                    }
                }
                //increase current player
                currentPlayer = (i+1)%playerNum;
                saveGame();
            }
        }
    }
    //function for combat
    public void combat(Player attacker) throws IOException
    {
        //check to see if player draws a card for conquering a territory and to check input
        boolean cardDraw = false;
        boolean cond = false;
        while (!cond)
        {
        	viewBoard.setOutput("Choose a territory to attack with:");
        	//have player choose territory they want to attack with and territory they want to attack
        	String attacking = viewBoard.getSelectionS();
//           String attacking = attacker.chooseAttackingTerritory();
           Territory attackTer = territories[getTet(attacking)];
           viewBoard.setOutput("Choose a territory to attack:");
        	String defending = viewBoard.getSelectionS();
//           String defending = attacker.chooseDefendingTerritory(attackTer);
           Territory defTer = territories[getTet(defending)];
            //output to make sure everything worked
//            viewBoard.setOutput(attackTer.getName() + " " + attackTer.getContinent() + " " + attackTer.getPlayer() + " " + attackTer.getArmyNum());
//            bw.write(attackTer.getName() + " " + attackTer.getContinent() + " " + attackTer.getPlayer()
//                    + " " + attackTer.getArmyNum() + '\n');
//            bw.flush();
//            viewBoard.setOutput(defTer.getName() + " " + defTer.getContinent() + " " + defTer.getPlayer() + " " + defTer.getArmyNum());
//            bw.write(defTer.getName() + " " + defTer.getContinent() + " " + defTer.getPlayer()
//                    + " " + defTer.getArmyNum() + '\n');
//            bw.flush();
            //variables for number of dice each player wants to roll
            int attackingDiceNum, defendingDiceNum;
            //start off as 0
            attackingDiceNum = defendingDiceNum = 0;
            Player defender = players[defTer.getPlayer() - 1];
            //if attacking player only has 2 armies, they can only use one dice
            if (attackTer.getArmyNum() == 2)
                attackingDiceNum = 1;
            //otherwise, have them select number of dice to use, ranging from 1-3
            else
            {
                //check for valid number of dice
                boolean diceCheck = false;
                while (!diceCheck) {
                	viewBoard.setOutput("Enter number of dice to attack with: ");
//                	bw.write("Enter number of dice to attack with: ");
//                    bw.flush();
//                    attackingDiceNum = input.nextInt();
//                    input.nextLine();
                	attackingDiceNum = viewBoard.getInputI();
                	//if territory has more than 3 armies, attacker can use either 1, 2, or 3 dice
                    if (attackTer.getArmyNum() > 3 && attackingDiceNum <= 3 && attackingDiceNum > 0)
                        diceCheck = true;
                    //if territory has 3 armies, then attacker can either use 1 or 2 dice
                    else if (attackTer.getArmyNum() == 3 && attackingDiceNum <= 2 && attackingDiceNum > 0)
                        diceCheck = true;
                    if (!diceCheck)
                    {
                    	for(int w = 0; w < WAIT; w++){
                        	viewBoard.setOutput("Enter a valid amount of dice");
                    	}
//                        bw.write("Enter a valid amount of dice\n");
//                        bw.flush();
                    }
                }
            }
            //if defender has 1 army, can only roll 1 dice
            if (defTer.getArmyNum() == 1)
                defendingDiceNum = 1;
            //otheriwise, give defender a choice
            else
            {
                boolean diceCheck = false;
                while (!diceCheck)
                {
                	viewBoard.setOutput("Enter number of dice: ");
//                    bw.write("Enter number of dice: ");
//                    bw.flush();
                	defendingDiceNum = viewBoard.getInputI();
//                    defendingDiceNum = input.nextInt();
//                    input.nextLine();
                    //defender can either choose 1 or 2 dice
                    if (defendingDiceNum == 1 || defendingDiceNum == 2)
                        diceCheck = true;
                    if (!diceCheck)
                    {
                    	viewBoard.setOutput("Enter a valid number of dice: ");
                    	for(int w = 0; w < WAIT; w++){
                        	viewBoard.setOutput("Enter a valid number of dice: ");
                    	}
//                       bw.write("Enter a valid number of dice: ");
//                       bw.flush();
                    }
                }
            }
            //array for die rolls and call functions to roll dice
            int [] attackDice = new int[3];
            attacker.rollDice(attackingDiceNum, attackDice);
            int [] defendDice = new int[2];
            defender.rollDice(defendingDiceNum, defendDice);
            //check dice rolls against the other and remove armies as necessary
            for (int i = 0; i < defendingDiceNum; i++)
            {
                if (attackDice[i] > defendDice[i])
                    defTer.addArmyNum(-1);
                else
                    attackTer.addArmyNum(-1);

                if (attackingDiceNum == 1)
                    break;
            }
            //check to make sure functions work
//            viewBoard.setOutput(attackTer.getName() + " " + attackTer.getContinent() + " " + attackTer.getPlayer() + " " + attackTer.getArmyNum());
//            bw.write(attackTer.getName() + " " + attackTer.getContinent() + " " + attackTer.getPlayer()
//                    + " " + attackTer.getArmyNum() + '\n');
//            bw.flush();
//            viewBoard.setOutput(defTer.getName() + " " + defTer.getContinent() + " " + defTer.getPlayer() + " " + defTer.getArmyNum());
//            bw.write(defTer.getName() + " " + defTer.getContinent() + " " + defTer.getPlayer()
//                    + " " + defTer.getArmyNum() + '\n');
//            bw.flush();
            //if defender loses all armies on territory, then attacker takes control of it
            if (defTer.getArmyNum() == 0)
            {
                //allows player to draw a card and ask how many armies attacker wants to move to new territory
                cardDraw = true;
                viewBoard.setOutput("How many armies do you want to move to new territory?");
//                bw.write("How many armies do you want to move to new territory? ");
//                bw.flush();
                boolean flag = false;
                while (!flag) {
                	int choice = viewBoard.getInputI();
//                    int choice = input.nextInt();
//                    input.nextLine();
                    //make sure choice is valid
                    if (choice < attackTer.getArmyNum() && choice >= attackingDiceNum)
                    {
                        //subtract from attacking territory and add to defending territory
                        flag = true;
                        attackTer.addArmyNum(-choice);
                        defTer.addArmyNum(choice);
                        //change control of territory
                        defTer.setPlayer(attacker.getPlayerNum());
                        //add territory to attacking player list and remove from defending player list
                        attacker.addTerritory(defTer);
                        defender.removeTerritory(defTer);
                    }
                    if (!flag)
                    {
                    	viewBoard.setOutput("Enter a valid amount.");
                    	for(int w = 0; w < WAIT; w++){
                           	viewBoard.setOutput("Enter a valid amount.");
                    	}
//                        bw.write("Enter a valid amount.");
//                        bw.flush();
                    }
                }
                //if defender has no territories left, remove them from game
                if (defender.getTerritoryNum() == 0)
                    removePlayer(defender, attacker);
            }
            //prompt if they want to attack again
            viewBoard.setOutput("Attack again?");
//            bw.write("Attack again?");
//            bw.flush();
            String choice = viewBoard.getInputS();
//            String choice = input.next();
//            input.nextLine();
            if (choice.compareTo("no") == 0 || choice.compareTo("No") == 0)
            {
                cond = true;
            }

        }
        //draw card if player took a territory this turn
        //if (cardDraw)
            attacker.hand.addCard(cardDeck.drawCard());
    }

    //function removes player from game
    public void removePlayer(Player d, Player a)
    {
        //give cards to player that eliminated them and skip their turn from now on
        for (int i = 0; i < d.hand.getNumCard(); i++)
        {
            a.hand.addCard(d.hand.removeCard(i));
        }
        d.setSkipCheck(true);
    }

    //if a player owns all territories, they win
    public boolean winCond() throws IOException
    {
        for (int i = 0; i < playerNum; i++)
        {
            if (players[i].getTerritoryNum() == TERRITORYNUM)
            {
            	viewBoard.setOutput("Player" + (i+1) + " wins!");
//                bw.write("Player " + (i+1) + " wins!\n");
//                bw.flush();
                return true;
            }
        }
        return false;
    }

    //function to fortify territory (free move an army from one territory to another)
    public void fortify(int p) throws IOException
    {
        String choice1, choice2;
        int move , temp1, temp2;
        move = temp1 = temp2 = 0;
        boolean check = false;
        //ask which territory they want to move from0
        while (!check) {
        	viewBoard.setOutput("Choose territory to move armies from:");
//            bw.write("Choose territory to move armies from: ");
//            bw.flush();
//            choice1 = input.nextLine();
//            temp1 = getTet(choice1);
        	temp1 = viewBoard.getSelectionI();
        	if (temp1 != -1)
            {
                //make sure they own territory and have more than one army on it
                if (territories[temp1].getPlayer() == p && territories[temp1].getArmyNum() > 1)
                    check = true;
                else
                {
                	for(int w = 0; w < WAIT; w++){
                    	viewBoard.setOutput("Choose a territory that you own.");
                	}
//                    bw.write("Choose territory you own\n");
//                    bw.flush();
                }
            }
            else
            {
            	for(int w = 0; w < WAIT; w++){
                   	viewBoard.setOutput("Choose a valid territory");
            	}
//                bw.write("Choose a valid territory\n");
//                bw.flush();
            }
        }
        check = false;
        //ask which territory to move to
        while (!check) {
        	viewBoard.setOutput("Choose territory to move armies to:");
//            bw.write("Choose territory to move armies to: ");
//            bw.flush();
//            choice2 = input.nextLine();
//            temp2 = getTet(choice2);
        	temp2 = viewBoard.getSelectionI();
        	if (temp2 != -1)
            {
                //make sure they own territory and that it is a neighbor to previous territory
                if (territories[temp2].getPlayer() == p && territories[temp2].isNeighbor(territories[temp1].getName())) {
                    check = true;
                }
                else
                {
                	for(int w = 0; w < WAIT; w++){
                    	viewBoard.setOutput("Choose a territory that you own.");
                	}
//                    bw.write("Choose territory you own\n");
//                    bw.flush();
                }
            }
            else
            {
            	for(int w = 0; w < WAIT; w++){
            		viewBoard.setOutput("Choose a valid territory.");
            	}
//                bw.write("Choose a valid territory\n");
//                bw.flush();
            }
        }
        check = false;
        //ask how many armies they want to move
        while (!check)
        {
        	viewBoard.setOutput("How many armies would you like to move?");
//            bw.write("How many armies do you want to move? ");
//            bw.flush();
//            move = input.nextInt();
//            input.nextLine();
        	move = viewBoard.getInputI();
            //make sure number is positive and less than the full army amount on territory
            if (move <= territories[temp1].getArmyNum() - 1 && move > 0)
                check = true;
            else
            {
            	for(int w = 0; w < WAIT; w++){
                	viewBoard.setOutput("Not enough armies, enter a valid amount.");
            	}
//                bw.write("Invalid amount\n");
//                bw.flush();
            }
        }
        //remove and add armies to appropriate territories
        territories[temp1].addArmyNum(-move);
        territories[temp2].addArmyNum(move);
        viewBoard.setCountryLabel(temp1, territories[temp1].getPlayer(), territories[temp1].getArmyNum());
        viewBoard.setCountryLabel(temp2, territories[temp2].getPlayer(), territories[temp2].getArmyNum());
    }

    //function to save
    public void saveGame() throws IOException
    {
        File saveFile = new File("save.txt");
        saveFile.createNewFile();

        FileWriter writer = new FileWriter(saveFile);
        writer.write(Integer.toString(playerNum));
        writer.write('\n');
        writer.write(Integer.toString(currentPlayer));
        writer.write('\n');
        writer.write(Integer.toString(turnPart));
        writer.write('\n');
        writer.flush();
        for (int i = 0; i<TERRITORYNUM; i++)
        {
            writer.write(Integer.toString(territories[i].getArmyNum()));
            writer.write(" ");
            writer.write(Integer.toString(territories[i].getPlayer()));
            writer.write('\n');
            writer.flush();
        }
    }

    //function to load
    public void loadGame() throws IOException
    {
        Scanner reader = new Scanner(new File("save.txt"));

        playerNum = reader.nextInt();
        currentPlayer = reader.nextInt();
        turnPart = reader.nextInt();
        for (int i = 0; i < playerNum; i++)
        {
            players[i] = new Player(i+1);
        }

        for (int i = 0; i < TERRITORYNUM; i++)
        {
            territories[i].addArmyNum(reader.nextInt());
            territories[i].setPlayer(reader.nextInt());
            for (int j = 0; j < playerNum; j++)
            {
                if (territories[i].getPlayer() == players[j].getPlayerNum())
                {
                    players[j].addTerritory(territories[i]);
                }
            }
        }
    }
}

