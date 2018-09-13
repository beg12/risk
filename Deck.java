import java.util.Random;
//class handles deck of cards
class Deck
{
    private Card [] deck = new Card[44];
    private int numCard;

    //constructor
    public Deck()
    {
        numCard = 0;
    }

    //accessor
    public int getNumCard() {
        return numCard;
    }

    //add card to decj
    public void addCard(Card c)
    {
        deck[numCard++] = c;
    }

    //shuffle deck
    public void shuffle()
    {
        Random r = new Random();
        int newPlace;
        for (int i = 0; i < numCard; i++)
        {
            newPlace = r.nextInt(43);
            Card temp = deck[newPlace];
            deck[i] = deck[newPlace];
            deck[newPlace] = deck[i];
        }
    }

    //draw from top of deck
    public Card drawCard()
    {
        numCard--;
        return deck[numCard];
    }

    //get card from index
    public Card getCard(int index)
    {
        return deck[index];
    }

    //remove specific card from deck
    public Card removeCard(int index)
    {
        Card temp = deck[index];
        if (index != numCard-1)
        {
            for (int i = index; i < numCard - 1; i++)
                deck[i] = deck[i+1];
        }
        numCard--;
        return temp;
    }
}