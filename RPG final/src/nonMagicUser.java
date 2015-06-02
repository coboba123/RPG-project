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
	private Item[] bag;
	private double myWallet;
	private int mySpeed;
	private Armor myArmor;
	private Weapon myWeapon;
	
	public nonMagicUser(String name, String desc, double wallet, Armor armor, Weapon weapon)
	{
		myName = name;
		myDesc = desc;
		myHP = 100;
		myWallet = wallet;
		mySpeed = 7;
		myArmor = armor;
		myWeapon = weapon;
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
		if (HP > 100)
			myHP = 100;
		else
			myHP = HP;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#addHP(int)
	 */
	@Override
	public void addHP(int HP)
	{
		if (myHP + HP <= 100)
			myHP += HP;
		else
			myHP = 100;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#subHP(int)
	 */
	@Override
	public void subHP(int HP)
	{
		if (myHP - HP >= 0)
			myHP -= HP;
		else
			myHP = 0;
	}

	/*
	 * (non-Javadoc)
	 * @see Character#getMP()
	 */
	@Override
	public int getMP()
	{
		return 0;
	}

	public boolean isDead()
	{
		if (myHP <= 0)
			return true;
		else
			return false;
	}
	
	public boolean noMP()
	{
		return true;
	}
	
	public String getDesc()
	{
		return myDesc;
	}

	public void setDesc(String desc)
	{
		myDesc = desc;
	}
	
	public Item getItem(int i)
	{
		return bag[i];
	}

	public void setBag(Item[] bag)
	{
		this.bag = bag;
	}
	
	public void addMoney(double num)
	{
		myWallet += num;
		if (myWallet > 1000)
		{
			myWallet = 1000;
		}
	}
	
	public void subMoney(double num)
	{
		myWallet -= num;
	}
	
	public double getMoney()
	{
		return myWallet;
	}
	
	public int getSpeed()
	{
		return mySpeed;
	}

	public Armor getArmor() {
		return myArmor;
	}

	public void setMyArmor(Armor armor) {
		myArmor = armor;
	}

	public Weapon getWeapon() {
		return myWeapon;
	}

	public void setWeapon(Weapon weapon) {
		myWeapon = weapon;
	}
}
