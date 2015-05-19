/*
 * @author Daniel
 */
public class Potion implements Item {

	private String myName;
	private int healValue;
	
	public Potion(String name, int heal)
	{
		myName = name;
		healValue = heal;
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		myName = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return myName;
	}
	
	}
	public void setHeal(int heal)
	{
		healValue = heal;
	}
	
	public int getHeal()
	{
		return healValue;
	}

}
