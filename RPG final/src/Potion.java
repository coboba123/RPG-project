/*
 * @author Daniel
 */
public class Potion implements Item
{

	private String myName;
	private String myDesc;
	private int healValue;
	private boolean HPPot;

	public Potion(String name, String desc, int heal, boolean isHp )
	{
		myName = name;
		myDesc = desc;
		healValue = heal;
		setHPPot(isHp);
	}

	@Override
	public void setName(String name)
	{
		// TODO Auto-generated method stub
		myName = name;
	}

	@Override
	public String getName()
	{
		// TODO Auto-generated method stub
		return myName;
	}

	public void setHeal(int heal)
	{
		healValue = heal;
	}

	public int getHeal()
	{
		return healValue;
	}
	
	public String getDesc()
	{
		return myDesc;
	}
	
	public void setDesc(String desc)
	{
		myDesc = desc;
	}

	public boolean isHPPot()
	{
		return HPPot;
	}

	public void setHPPot(boolean hPPot)
	{
		HPPot = hPPot;
	}

}
