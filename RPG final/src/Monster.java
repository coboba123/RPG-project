/**
 * @author Daniel 
 */
public class Monster 
{
	private int maxHp,myHP, mySpeed, attVal, baseDef;
	private String myPath, Desc, myName;
	
	public Monster (String name, String desc, String path, int HP, int speed, int att, int def)
	{
		myName = name;
		Desc = desc;
		maxHp = HP;
		myHP = HP;
		mySpeed = speed;
		attVal = att;
		baseDef = def;
		myPath = path;
		
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
		return myPath;
	}

	public void setPath(String path)
	{
		myPath = path;
	}

	public String getDesc()
	{
		return Desc;
	}

	public void setDesc(String desc)
	{
		Desc = desc;
	}

	public String getName()
	{
		return myName;
	}

	public void setName(String name)
	{
		myName = name;
	}
	
	public void heal()
	{
		myHP = maxHp;
	}
	
}
