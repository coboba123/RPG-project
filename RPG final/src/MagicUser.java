import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Daniel
 */
public class MagicUser implements Character
{
	private String myName, myDesc;
	private int myHP, myMP, myMoney;
	private ArrayList<Item> bag = new ArrayList<Item>(1);
	private boolean hasMap;
	

	public MagicUser(String name, String desc)
	{
		myName = name;
		myHP = 80;
		myMP = 50;
		myMoney = 0;
		hasMap = false;
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
	 * @see Character#setName()
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
	 * @see Character#setHP()
	 */
	@Override
	public void setHP(int HP)
	{
		if (HP > 80)
			myHP = 80;
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
		if (myHP + HP <= 80)
		myHP += HP;
		else
			myHP = 80;
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

	/*
	 * (non-Javadoc)
	 * @see Character#getMP()
	 */
	public int getMP()
	{
		return myMP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#setMP()
	 */
	public void setMP(int MP)
	{
		if (MP > 50)
			myMP = 50;
		else
			myMP = MP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#addMP(int)
	 */
	public void addMP(int MP)
	{
		if (myMP + MP <= 50)
			myMP += MP;
		else
			myMP = 50;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#subMP(int)
	 */
	public void subMP(int MP)
	{
		if (myMP - MP >= 0)
			myMP -= MP;
		else
			myMP = 0;
	}

	@Override
	public boolean isDead()
	{
		if (myHP <= 0)
			return true;
		else
			return false;
	}
	
	public boolean noMP()
	{
		if (myMP <= 0)
			return true;
		else
			return false;
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
		while ((Item)bag.get(i) != item && i < bag.size())
		{
			i++;
		}
		if (i != bag.size() && (Item)bag.get(i) == item )
		{
			bag.remove(i);
			return true;
		}
		else
			return false;
		
	}

	@Override
	public String useItem(Item item)
	{
		if (subItem(item))
		{
			return "Item successfully used";
		}
		else
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
}
