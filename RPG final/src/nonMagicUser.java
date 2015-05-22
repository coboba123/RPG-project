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
	private int MP;

	public nonMagicUser(String name, String desc)
	{
		myName = name;
		myDesc = desc;
		myHP = 100;
		myMP = 0;
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
		myHP = HP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#addHP(int)
	 */
	@Override
	public void addHP(int HP)
	{

		myHP += HP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#subHP(int)
	 */
	@Override
	public void subHP(int HP)
	{

		myHP -= HP;
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
	 * @see Character#setMP(int)
	 */
	@Override
	public void setMP(int MP)
	{

		myMP = MP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#addMP(int)
	 */
	@Override
	public void addMP(int MP)
	{

		myMP += MP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#subMP(int)
	 */
	@Override
	public void subMP(int MP)
	{

		myMP -= MP;
	}

	public boolean isDead()
	{
		if (HP <= 0)
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
}
