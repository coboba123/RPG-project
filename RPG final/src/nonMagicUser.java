

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

	/**
	 * Constructor of the MagicUser class that holds all the base values of the character
	 * 
	 * @param name: The name of the character
	 * 
	 * @param desc: The description of the chracter
	 */
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

	/**
	 * Gets the name of the user
	 * 
	 * @see Character#getName()
	 * 
	 * @return a string
	 */
	@Override
	public String getName()
	{
		return myName;
	}

	/**
	 * sets the character's name
	 * 
	 * @param name: a string to set name
	 * 
	 * @see Character#setName()
	 */
	@Override
	public void setName(String name)
	{
		myName = name;
	}

	/**
	 * gets the current HP of the user
	 * 
	 * @see Character#getHP()
	 * 
	 * @return an int value that represents current hp
	 */
	@Override
	public int getHP()
	{
		return myHP;
	}

	/**
	 * sets HP to an amount that is no greater than the max HP
	 * 
	 * @param HP: an int value that represents HP that the character is being set to
	 * 
	 * @see Character#setHP()
	 */
	@Override
	public void setHP(int HP)
	{
		if (HP > 100)
			myHP = 100;
		else
			myHP = HP;
	}

	/**
	 * adds HP to the character but the added HP will not allow the character to exceed his max HP
	 * 
	 * @param HP: an int value that is being added
	 * 
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

	/**
	 * subtracts HP to the character but the subtracted HP can't go below 0
	 * 
	 * 
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

	 /**
	  * returns a boolean value to see if character is dead
	  * returns true if character HP is less than or equal to 0
	  * 
	  * @return boolean Returns the boolean value of character's death status
	  */
	@Override
	public boolean isDead()
	{
		if (myHP <= 0)
			return true;
		else
			return false;
	}

	/**
	  * returns the description of the character
	  * 
	  * @return String Returns the description of the character
	  */
	public String getDesc()
	{
		return myDesc;
	}

	 /**
	  * sets the description of the character
	  * 
	  * @param desc the new character description
	  */
	public void setDesc(String desc)
	{
		myDesc = desc;
	}

	 /**
	  * returns the value of money in the character's possession
	  * 
	  * @return int Returns the amount of money that the character has
	  */
	@Override
	public int getMoney()
	{

		return myMoney;
	}

	/**
	  * sets the amount of money in the character's possession
	  * 
	  * @param money new amount of money in the character's possession
	  */
	@Override
	public void setMoney(int money)
	{
		myMoney = money;

	}

	 /**
	  * subtracts money from the character's "wallet"
	  * used when making a purchase in the shop
	  * 
	  * @param money amount of money to be taken out of the character's "wallet"
	  */
	@Override
	public void subMoney(int money)
	{
		myMoney -= money;

	}

	 /**
	  * adds money to the character's "wallet"
	  * used when gaining money from battle
	  * 
	  * @param money amount of money to be added to the character's "wallet"
	  */
	@Override
	public void addMoney(int money)
	{
		if (myMoney + money >= 2000)
			myMoney = 2000;
		else
			myMoney += money;

	}

	/**
	  * Increases the character's potion count by one
	  */
	public void addPotion()
	{
		potions++;
	}

	 /**
	  * Decreases the character's potion count by one (if the count is greater than 0)
	  * @return a true or false statement
	  */
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

	 /**
	  * Returns a boolean value for whether or not the character is in possession of a map
	  * 
	  * @return boolean Returns boolean answer for whether or not character has a map 
	  */
	public boolean isHasMap()
	{
		return hasMap;
	}

	/**
	  * Sets boolean value for whether or not the character is in possession of a map
	  * 
	  * @param hasMap New boolean value for possession of map status
	  */
	public void setHasMap(boolean hasMap)
	{
		this.hasMap = hasMap;
	}

	/**
	  * Returns the character's speed value
	  * Used when considering the probability of missing when attacking a monster
	  * 
	  * @return int Returns the speed of the character
	  */
	public int getSpeed()
	{
		return mySpeed;
	}

	 /**
	  * Returns the character's armor object
	  * 
	  * @return Armor Returns the character's armor object
	  */
	public Armor getArmor()
	{
		return myArmor;
	}

	 /**
	  * Sets a new armor object for the character
	  * 
	  * @param armor New armor for the character
	  */
	public void setArmor(Armor armor)
	{
		myArmor = armor;
	}

	 /**
	  * Returns the character's weapon object
	  * 
	  * @return Weapon Returns the character's weapon object
	  */
	public Weapon getWeapon()
	{
		return myWeapon;
	}

	 /**
	  * Sets a new armor object for the character
	  * 
	  * @param armor New armor for the character
	  */
	public void setWeapon(Weapon weapon)
	{
		myWeapon = weapon;
	}

	 /**
	  * Returns the attack value of the character
	  * 
	  * @return int The attack value of the character
	  */
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

	 /**
	  * Returns the defense value of the character
	  * 
	  * @return int The defense value of the character
	  */
	@Override
	public int getDef()
	{
		if (myArmor != null)
		{
			return myArmor.getDef() + baseDef;
		} else
			return baseDef;
	}

	 /**
	  * Returns a boolean value as to whether or not the character is of a magic type
	  * 
	  * @return boolean Returns whether or not the character is a magic type
	  */
	public boolean isMagic()
	{
		return false;
	}

	 /**
	  * Returns the items in the character's possessions in a string
	  * 
	  * @return String List of the characters possessions
	  */
	@Override
	public String getItems()
	{
		if (potions != 0)
			return "Potions X" + potions;
		else
			return "None";
	}

	 /**
	  * Returns the boolean value for whether or not the character has a key
	  * 
	  * @return boolean Returns whether or not the character has a key
	  */
	public boolean hasKey()
	{
		return hasKey;
	}

	 /**
	  * Sets a new value for whether or not the character is in possession of a key
	  * 
	  * @param key New boolean value for the character's possession of a key
	  */
	public void setHasKey(boolean hasKey)
	{
		this.hasKey = hasKey;
	}
	
	

}