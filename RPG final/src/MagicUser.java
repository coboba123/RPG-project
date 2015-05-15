/**
 * 
 */

/**
 * @author Daniel
 *
 */
public class MagicUser implements Character
{
	private String name;
	private int HP;
	private int MP;
	
	public MagicUser(String myName)
	{	
		name = myName;
		HP = 80;
		MP = 50;
	}
	/* (non-Javadoc)
	 * @see Character#getName()
	 */
	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see Character#setName()
	 */
	@Override
	public void setName(String myName)
	{
		// TODO Auto-generated method stub
		name = myName;		
	}

	/* (non-Javadoc)
	 * @see Character#getHP()
	 */
	@Override
	public int getHP()
	{
		// TODO Auto-generated method stub
		return HP;
	}

	/* (non-Javadoc)
	 * @see Character#setHP()
	 */
	@Override
	public void setHP(int myHP)
	{
		// TODO Auto-generated method stub
		HP = myHP;
	}

	/* (non-Javadoc)
	 * @see Character#addHP(int)
	 */
	@Override
	public void addHP(int myHP)
	{
		// TODO Auto-generated method stub
		HP += myHP;
	}

	/* (non-Javadoc)
	 * @see Character#subHP(int)
	 */
	@Override
	public void subHP(int myHP)
	{
		// TODO Auto-generated method stub
		HP -= hp;
	}

	/* (non-Javadoc)
	 * @see Character#getMP()
	 */
	@Override
	public int getMP()
	{
		// TODO Auto-generated method stub
		return MP;
	}

	/* (non-Javadoc)
	 * @see Character#setMP()
	 */
	@Override
	public void setMP(int myMP)
	{
		// TODO Auto-generated method stub
		MP = myMP;
	}

	/* (non-Javadoc)
	 * @see Character#addMP(int)
	 */
	@Override
	public void addMP(int myMP)
	{
		// TODO Auto-generated method stub
		MP += myMP;
	}

	/* (non-Javadoc)
	 * @see Character#subMP(int)
	 */
	@Override
	public void subMP(int myMP)
	{
		// TODO Auto-generated method stub
		MP -= myMP;
	}

}
