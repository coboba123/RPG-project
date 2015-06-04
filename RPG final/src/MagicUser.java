

/**
 * @author Daniel
 */
public class MagicUser implements Character
{
	private String myName, myDesc;
	private int myHP, myMoney, baseAtt, baseDef, mySpeed, potions;
	private boolean hasMap, hasKey;
	private Armor myArmor;
	private Weapon myWeapon;
	

	public MagicUser(String name, String desc)
	{
		myName = name;
		myHP = 80;
		myMoney = 800;
		hasMap = false;
		mySpeed = 5;
		myDesc = desc;
		potions = 3;
		baseAtt = 20;
		baseDef = 4;
		setHasKey(false);
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
	 * @see Character#setName()
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
	 * @see Character#setHP()
	 */
	@Override
	public void setHP(int HP)
	{
		if (HP > 80)
			myHP = 80;
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
		if (myHP + HP <= 80)
			myHP += HP;
		else
			myHP = 80;
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

	@Override
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
		}
		else
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
			return (baseAtt + myWeapon.getAtt()) - (int) Math.random() * 6;
		} else
		{
			return baseAtt - (int) Math.random() * 6;
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
		return true;
	}

	@Override
	public String getItems()
	{
		if (potions != 0)
			return "Potions X" + potions;
		else
			return "None";
	}

	public boolean hasKey()
	{
		return hasKey;
	}

	public void setHasKey(boolean hasKey)
	{
		this.hasKey = hasKey;
	}
	
	

}
