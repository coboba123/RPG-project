/**
 * 
 */

/**
 * @author Cody
 */
public class Room
{
	private String roomDesc;
	private int enemyRate;
	private Room north = null, south = null, east = null, west = null;

	public Room(String description, int rate)
	{
		roomDesc = description;
		enemyRate = rate;
	}

	public Room()
	{
		this("", 0);
	}
	
	public Room(String description)
	{
		this(description, 0);
	}

	public String getDesc()
	{
		return roomDesc;
	}

	public void setDesc(String desc)
	{
		roomDesc = desc;
	}

	public int getRate()
	{
		return enemyRate;
	}

	public void setRate(int rate)
	{
		enemyRate = rate;
	}

	public String toString()
	{
		return roomDesc;
	}

	public Room getNorth()
	{
		return north;
	}

	public Room getSouth()
	{
		return south;
	}

	public Room getEast()
	{
		return east;
	}

	public Room getWest()
	{
		return west;
	}

	public void setNorth(Room loc)
	{
		north = loc;
	}

	public void setSouth(Room loc)
	{
		south = loc;
	}

	public void setEast(Room loc)
	{
		east = loc;
	}

	public void setWest(Room loc)
	{
		west = loc;
	}

}
