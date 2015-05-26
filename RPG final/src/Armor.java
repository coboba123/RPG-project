/**
 * @author Cody and Alex and Daniel
 */
public class Armor implements Item
{

	/*
	 * (non-Javadoc)
	 * @see Item#setName(java.lang.String)
	 */
	private String myName;
	private String myDesc;
	private int defValue;

	public Armor(String name, String desc, int def)
	{
		myName = name;
		myDesc = desc;
		defValue = def;
	}

	@Override
	public void setName(String name)
	{
		myName = name;
	}
	
	/*
	 * (non-Javadoc)
	 * @see Item#getName()
	 */
	@Override
	public String getName()
	{
		return myName;
	}

	public int getDef()
	{
		return defValue;
	}

	public void setDef(int def)
	{
		defValue = def;

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
