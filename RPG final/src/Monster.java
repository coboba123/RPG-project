/**
 * @author Daniel
 */
public class Monster 
{
	private int myHP;
	private int mySpeed;
	private int attVal;
	
	public Monster (int HP, int speed, int att)
	{
		myHP = HP;
		mySpeed = speed;
		attVal = att;
	}
	
	public int getHP()
	{
		return myHP;
	}
	
	public void setHP(int HP)
	{
		myHP = HP;
	}
	
	public int getAttack()
	{
		return (int) (attVal - (5*Math.random()));
	}
	
	public int getSpeed()
	{
		return mySpeed;
	}
	
	public boolean isDead()
	{
		if (myHP <= 0)
			return true;
		else
			return false;
	}
}
