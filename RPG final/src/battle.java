/**
 * Write a description of class Battle here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Battle
{
	// instance variables - replace the example below with your own
	private Character myCharacter;
	private Character myEnemy;

	/**
	 * Constructor for objects of class Battle
	 */
	public Battle(Character c1, Character c2)
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
			return myCharacter.getHP() - 1.5 * eDamage;
		return myCharacter.getHP() - eDamage;
	}

	public int attackEnemy(int cDamage)
	{
		if (isCritical() == true)
			return myEnemy.getHP() - 1.5 * cDamage;
		return myEnemy.getHP() - cDamage;
	}

	public void fight()
	{
		if (myCharacter.getSpeed() > myEnemy.getSpeed())
		{
			if (isMiss(myCharacter) == true)
				attackEnemy(0);
			else
			{
				attackEnemy(myCharacter.getDamage());
				if (myEnemy.isDead == false)
					attackCharacter(myEnemy.getDamage());
			}
		} else if (myCharacter.getSpeed() == myEnemy.getSpeed())
		{
			if (Math.random() >= 0.5)
			{
				if (isMiss(myCharacter) == true)
					attackEnemy(0);
				else
				{
					attackEnemy(myCharacter.getDamage());
					if (myEnemy.isDead == false)
						attackCharacter(myEnemy.getDamage());
				}
			}
		} else if (myCharacter.getSpeed() < myEnemy.getSpeed())
		{
			attackCharacter(myEnemy.getDamage());
			if (myCharacter.isDead == false)
				attackEnemy(myCharacter.getDamage());
		}
	}

	public boolean isCritical()
	{
		if (Math.random >= 0.9)
			return true;
		else
			return false;
	}
}
