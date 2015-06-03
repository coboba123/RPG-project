import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Daniel
 */
public class nonMagicUser implements Character
{

	private String myName, myDesc;
	private int myHP, myMoney;
	private ArrayList<Item> bag = new ArrayList<Item>(1);
	private boolean hasMap;

	private int myWallet;
	private int mySpeed;
	private Armor myArmor;
	private Weapon myWeapon;

	public nonMagicUser(String name, String desc, int wallet, Armor armor, Weapon weapon)
	{
		myName = name;
		myDesc = desc;
		myHP = 100;
		myMoney = wallet;
		setHasMap(false);
	}

	/*
	 * (non-Javadoc)
	 * @see Character#getName()
	 */
	@Override
	public String getName()
	{
		return myName;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#setName(java.lang.String)
	 */
	@Override
	public void setName(String name)
	{
		myName = name;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#getHP()
	 */
	@Override
	public int getHP()
	{
		return myHP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#setHP(int)
	 */
	@Override
	public void setHP(int HP)
	{
		if (HP > 100)
			myHP = 100;
		else
			myHP = HP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#addHP(int)
	 */
	@Override
	public void addHP(int HP)
	{
		if (myHP + HP <= 100)
			myHP += HP;
		else
			myHP = 100;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#subHP(int)
	 */
	@Override
	public void subHP(int HP)
	{
		if (myHP - HP >= 0)
			myHP -= HP;
		else
			myHP = 0;
	}

	public boolean isDead()
	{
		if (myHP <= 0)
			return true;
		else
			return false;
	}

	public boolean noMP()
	{
		return true;
	}

	public String getDesc()
	{
		return myDesc;
	}

	public void setDesc(String desc)
	{
		myDesc = desc;
	}

	@Override
	public int getMoney()
	{
		return myMoney;
	}

	@Override
	public void setMoney(int money)
	{
		myMoney = money;

	}

	@Override
	public void subMoney(int money)
	{
		myMoney -= money;

	}

	@Override
	public void addMoney(int money)
	{
		if (myMoney + money >= 2000)
			myMoney = 2000;
		else
			myMoney += money;

	}

	@Override
	public void addItem(Item item)
	{
		bag.add(item);

	}

	private boolean subItem(Item item)
	{
		int i = 0;
		while ((Item) bag.get(i) != item && i < bag.size())
		{
			i++;
		}
		if (i != bag.size() && (Item) bag.get(i) == item)
		{
			bag.remove(i);
			return true;
		} else
			return false;

	}

	@Override
	public String useItem(Item item)
	{
		if (subItem(item))
		{
			return "Item successfully used";
		} else
			return "You don't have any more of that Item!";

	}

	public boolean isHasMap()
	{
		return hasMap;
	}

	public void setHasMap(boolean hasMap)
	{
		this.hasMap = hasMap;
	}

	public int getSpeed()
	{
		return mySpeed;
	}

	public Armor getArmor()
	{
		return myArmor;
	}

	public void setMyArmor(Armor armor)
	{
		myArmor = armor;
	}

	public Weapon getWeapon()
	{
		return myWeapon;
	}

	public void setWeapon(Weapon weapon)
	{
		myWeapon = weapon;
	}
}
