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

	public int getMP();

	public void setMP(int myMP);

	public void addMP(int myMP);

	public void subMP(int myMP);
	
	public boolean isDead();
	
	public boolean noMP();
	
	public String getDesc();
	
	public void setDesc(String desc);
	
}
