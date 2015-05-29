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
	private Boolean locked = false, shop = false;
	private Item item;

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

	public void setLocked(boolean loc)
	{
		locked = loc;
	}

	public boolean getLocked()
	{
		return locked;
	}

	public Item getItem()
	{
		return item;
	}

	public void setItem(Item temp)
	{
		item = temp;
	}

	public boolean getShop()
	{
		return shop;
	}

	public void setShop(boolean temp)
	{
		shop = temp;
	}

}
