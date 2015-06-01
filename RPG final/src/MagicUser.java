/**
 * 
 */

/**
 * @author Daniel
 */
public class MagicUser implements Character
{
	private String myName, myDesc;
	private int myHP;
	private int myMP;
	private Item[] bag;

	public MagicUser(String name, String desc)
	{
		myName = name;
		myHP = 80;
		myMP = 50;
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
	@Override
	public int getMP()
	{
		return myMP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#setMP()
	 */
	@Override
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
	@Override
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
	@Override
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

	public Item getItem(int i)
	{
		return bag[i];
	}

	public void setBag(Item[] bag)
	{
		this.bag = bag;
	}
}
