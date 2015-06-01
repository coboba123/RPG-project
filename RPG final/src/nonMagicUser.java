/**
 * 
 */

/**
 * @author Daniel
 */
public class nonMagicUser implements Character
{

	private String myName, myDesc;
	private int myHP;
	
	public nonMagicUser(String name, String desc)
	{
		myName = name;
		myDesc = desc;
		myHP = 100;
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

	/*
	 * (non-Javadoc)
	 * @see Character#getMP()
	 */
	@Override
	public int getMP()
	{
		return 0;
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
}
