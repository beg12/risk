//class of card, info is what territory it is and what "type"
class Card
{
    private String Territory;
    private int type;

    public Card(String t, int s)
    {
        Territory = t;
        type = s;
    }

    public int getType() {
        return type;
    }

    public String getTerritory() {
        return Territory;
    }
}