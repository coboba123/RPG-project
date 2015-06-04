

/**
 * 
 */

/**
 * @author Daniel
 */
public class nonMagicUser implements Character
{

	private String myName, myDesc;
	private int myHP, myMoney, mySpeed, baseAtt, baseDef, potions;
	private boolean hasMap, hasKey;
	private Armor myArmor;
	private Weapon myWeapon;

	public nonMagicUser(String name, String desc)
	{
		myArmor = null;
		myWeapon = null;
		myName = name;
		myDesc = desc;
		myHP = 100;
		myMoney = 0;
		mySpeed = 5;
		hasMap = false;
		baseAtt = 16;
		baseDef = 7;
		potions = 2;
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

	public boolean isDead()
	{
		if (myHP <= 0)
			return true;
		else
			return false;
	}

	public String getDesc()
	{
		return myDesc;
	}

	public void setDesc(String desc)
	{
		myDesc = desc;
	}

	@Override
	public int getMoney()
	{
		return myMoney;
	}

	@Override
	public void setMoney(int money)
	{
		myMoney = money;

	}

	@Override
	public void subMoney(int money)
	{
		myMoney -= money;

	}

	@Override
	public void addMoney(int money)
	{
		if (myMoney + money >= 2000)
			myMoney = 2000;
		else
			myMoney += money;

	}

	public void addPotion()
	{
		potions++;
	}

	public boolean usePotion()
	{
		if (potions != 0)
		{
			potions--;
			return true;
		} else
			return false;
	}

	public boolean isHasMap()
	{
		return hasMap;
	}

	public void setHasMap(boolean hasMap)
	{
		this.hasMap = hasMap;
	}

	public int getSpeed()
	{
		return mySpeed;
	}

	public Armor getArmor()
	{
		return myArmor;
	}

	public void setArmor(Armor armor)
	{
		myArmor = armor;
	}

	public Weapon getWeapon()
	{
		return myWeapon;
	}

	public void setWeapon(Weapon weapon)
	{
		myWeapon = weapon;
	}

	@Override
	public int getDamage()
	{
		if (myWeapon != null)
		{
			return (baseAtt + myWeapon.getAtt()) - (int) Math.random() * 4;
		} else
		{
			return baseAtt - (int) Math.random() * 4;
		}
	}

	@Override
	public int getDef()
	{
		if (myArmor != null)
		{
			return myArmor.getDef() + baseDef;
		} else
			return baseDef;
	}

	public boolean isMagic()
	{
		return false;
	}

	@Override
	public String getItems()
	{
		if (potions != 0)
			return "Potions X" + potions;
		else
			return "None";
	}

	@Override
	public void setHasKey(boolean key)
	{
		hasKey = key;
	}
	
	public boolean hasKey()
	{
		return hasKey;
	}

}
