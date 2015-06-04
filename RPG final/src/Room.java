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
	private Boolean locked = false, shop = false, hasKey = false, hasArmor = false,
			hasWeapon = false, hasBoss = false;
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

	public Boolean HasKey()
	{
		return hasKey;
	}

	public void setHasKey(Boolean hasKey)
	{
		this.hasKey = hasKey;
	}

	public boolean hasArmor()
	{
		return hasArmor;
	}

	public boolean hasWeapon()
	{
		return hasWeapon;
	}

	public void setHasArmor(boolean temp)
	{
		hasArmor = temp;
	}

	public void setHasWeapon(boolean temp)
	{
		hasWeapon = temp;
	}

	public Boolean HasBoss()
	{
		return hasBoss;
	}

	public void setHasBoss(Boolean hasBoss)
	{
		this.hasBoss = hasBoss;
	}

}
