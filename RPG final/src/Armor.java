/**
 * @author Cody and Alex and Daniel
 */
public class Armor implements Item
{

	/**
	 * 
	 */
	private String myName;
	private int defValue;

	/**
	 * @param name
	 * @param def
	 */
	public Armor(String name, int def)
	{
		myName = name;
		defValue = def;
	}

	@Override
	public void setName(String name)
	{
		myName = name;
	}

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

}
