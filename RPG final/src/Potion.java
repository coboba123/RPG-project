/*
 * @author Daniel
 */
public class Potion implements Item
{

	private String myName;
	private String myDesc;
	private int healValue;

	public Potion(String name, String desc, int heal)
	{
		myName = name;
		myDesc = desc;
		healValue = heal;
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
		//TODO
		return myDesc;
	}
	
	public void setDesc(String desc)
	{
		myDesc = desc;
	}

}
