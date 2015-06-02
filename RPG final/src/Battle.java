/**
 * Write a description of class Battle here.
 * 
 * @author (Alex Zuo)
 * @version (a version number or a date)
 */
public class battle
{
	// instance variables - replace the example below with your own
	private Character myCharacter;
	private Character myEnemy;

	/**
	 * Constructor for objects of class Battle
	 */
	public battle(Character c1, Monster c2)
	{
		myCharacter = c1;
		myEnemy = c2;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public int attackCharacter(int eDamage)
	{
		if (isCritical() == true)
			return myCharacter.getHP() - 2 * eDamage;
		return myCharacter.getHP() - eDamage;
	}

	public int attackEnemy(int cDamage)
	{
		if (isCritical() == true)
			return myEnemy.getHP() - 2 * cDamage;
		return myEnemy.getHP() - cDamage;
	}

	public void fight()
	{
		if (myCharacter.getSpeed() > myEnemy.getSpeed())
		{
			if (isMiss() == true)
				attackEnemy(0);
			else
			{
				myEnemy.setHP(attackEnemy(myCharacter.getDamage() - myEnemy.getArmor()));
				if (myEnemy.isDead() == false && myCharacter.getArmor() < myEnemy.getAttack())
					myCharacter.setHP(attackCharacter(myEnemy.getDamage() - myCharacter.getArmor()));						
			}
		} else if (myCharacter.getSpeed() == myEnemy.getSpeed())
		{
			if (Math.random() >= 0.5)
			{
				if (isMiss() == true)
					attackEnemy(0);
				else
				{
					attackEnemy(myCharacter.getDamage());
					if (myEnemy.isDead() == false)
						attackCharacter(myEnemy.getDamage());
				}
			}
		} else if (myCharacter.getSpeed() < myEnemy.getSpeed())
		{
			attackCharacter(myEnemy.getDamage());
			if (myCharacter.isDead() == false)
				attackEnemy(myCharacter.getDamage());
		}
	}

	public boolean isCritical()
	{
		if (Math.random() <= 0.1)
			return true;
		else
			return false;
	}
	
	public boolean isMiss()
	{
		if (Math.random() >= .95)
			return true;
		else
			return false;
	}
}
