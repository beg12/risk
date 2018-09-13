//class of territory
class Territory
{
    //name, how many armies are on it, what player owns it, the continent its on, and list of neighbors
    private String name;
    private int armyNum;
    private int player;
    private String continent;
    Territory [] neighbors = new Territory[6];

    //constructor
    public Territory(String n, String c)
    {
        name = n;
        continent = c;
        player = 0;
        armyNum = 0;
    }

    //accessors
    public int getArmyNum() {
        return armyNum;
    }

    public int getPlayer() {
        return player;
    }

    public String getContinent() {
        return continent;
    }

    public String getName() {
        return name;
    }

    //mutators
    public void addArmyNum(int a) {
        armyNum = armyNum + a;
    }

    public void addNeighbor(Territory... n)
    {
        for (int i = 0; i<n.length; i++)
        {
            neighbors[i] = n[i];
        }

    }

    public void setPlayer(int player) {
        this.player = player;
    }

    //check if territory is a neighbor
    public boolean isNeighbor(String check) {
        for (int i = 0; i < neighbors.length; i++)
        {
            if (check.compareTo(neighbors[i].getName()) == 0)
                return true;
        }
        return false;
    }
}