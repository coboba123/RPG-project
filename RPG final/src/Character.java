/**
 * 
 */

/**
 * @author Cody
 */
public interface Character
{

	public String getName();

	public void setName(String myName);

	public int getHP();

	public void setHP(int myHP);

	public void addHP(int myHP);

	public void subHP(int myHP);
	
	public boolean isDead();
	
	public boolean noMP();
	
	public String getDesc();
	
	public void setDesc(String desc);
	
	public int getMoney();
	
	public void setMoney(int money);
	
	public void subMoney(int money);
	
	public void addMoney(int money);
	
	public void addItem(Item item);
	
	public String useItem(Item item);
	
	public boolean isHasMap();
	
	public void setHasMap(boolean hasMap);

	public int getSpeed();

	public int getDamage();

	public int getDef();
	
	public boolean isMagic();
}

