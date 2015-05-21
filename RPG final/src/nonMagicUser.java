/**
 * 
 */

/**
 * @author danielzhang
 */
public class nonMagicUser implements Character
{

	private String name, description;
	private int HP;
	private int MP;

	public nonMagicUser(String myName)
	{
		name = myName;
		HP = 100;
		MP = 0;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#getName()
	 */
	@Override
	public String getName()
	{

		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#setName(java.lang.String)
	 */
	@Override
	public void setName(String myName)
	{

		name = myName;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#getHP()
	 */
	@Override
	public int getHP()
	{

		return HP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#setHP(int)
	 */
	@Override
	public void setHP(int myHP)
	{

		HP = myHP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#addHP(int)
	 */
	@Override
	public void addHP(int myHP)
	{

		HP += myHP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#subHP(int)
	 */
	@Override
	public void subHP(int myHP)
	{

		HP -= myHP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#getMP()
	 */
	@Override
	public int getMP()
	{

		return MP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#setMP(int)
	 */
	@Override
	public void setMP(int myMP)
	{

		MP = myMP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#addMP(int)
	 */
	@Override
	public void addMP(int myMP)
	{

		MP += myMP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#subMP(int)
	 */
	@Override
	public void subMP(int myMP)
	{

		MP -= myMP;
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
		return description;
	}

	public void setDesc(String desc)
	{
		description = desc;
	}
}
