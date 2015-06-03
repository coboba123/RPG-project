/**
 * @author Daniel 
 */
public class Monster 
{
	private int myHP, mySpeed, attVal, baseDef;
	private String path;
	
	public Monster (int HP, int speed, int att, int baseDef)
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
	
	public int getDef()
	{
		return baseDef;
	}

	public int getDamage()
	{
		return attVal;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
	
}
