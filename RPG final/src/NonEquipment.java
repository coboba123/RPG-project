/**
 * @author Cody
 *
 */
public class NonEquipment implements Item
{
	private String myName;
	
	private String myDesc;
	
	public NonEquipment(String name, String desc)
	{
		myName = name;
		myDesc = desc;
	}
	/* (non-Javadoc)
	 * @see Item#setName(java.lang.String)
	 */
	@Override
	public void setName(String name)
	{
		myName = name;
	}

	/* (non-Javadoc)
	 * @see Item#getName()
	 */
	@Override
	public String getName()
	{
		return myName;
	}
	
	public void setDesc(String desc)
	{
		myDesc = desc;
	}
	
	public String getDesc()
	{
		return myDesc;
	}
}
