/**
 * @author Cody and Alex and Daniel
 */
public class Armor implements Item
{

	
	private String myName;
	private int defValue;

	/**
	 * The constructor that requires 2 parameters, the name and defense value and will set those values for the armor
	 * @param The name of the Armor
	 * @param The Defense Value of the Armor
	 */
	public Armor(String name, int def)
	{
		myName = name;
		defValue = def;
	}

	
	/**
	 * This method will set the name of the Armor as well change the name
	 */
	public void setName(String name)
	{
		myName = name;
	}

	
	/**
	 * This will return the Armor's name
	 * @return returns the name of the Armor
	 */
	public String getName()
	{
		return myName;
	}

	/**
	 * This will get the defense value of the armor
	 * @return returns the defense Value
	 */
	public int getDef()
	{
		return defValue;
	}

	public void setDef(int def)
	{
		defValue = def;

	}

}
