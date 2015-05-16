/**
 * 
 */

/**
 * @author danielzhang
 *
 */
public class nonMagicUser implements Character {

	private String name;
	private int HP;
	private int MP;
	private int damage;
	
	public nonMagicUser(String myName){
		name = myName;
		HP = 100;
		MP = 0;
		damage = 10;
	}
	/* (non-Javadoc)
	 * @see Character#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see Character#setName(java.lang.String)
	 */
	@Override
	public void setName(String myName) {
		// TODO Auto-generated method stub
		name = myName;
	}

	/* (non-Javadoc)
	 * @see Character#getHP()
	 */
	@Override
	public int getHP() {
		// TODO Auto-generated method stub
		return HP;
	}

	/* (non-Javadoc)
	 * @see Character#setHP(int)
	 */
	@Override
	public void setHP(int myHP) {
		// TODO Auto-generated method stub
		HP = myHP;
	}

	/* (non-Javadoc)
	 * @see Character#addHP(int)
	 */
	@Override
	public void addHP(int myHP) {
		// TODO Auto-generated method stub
		HP += myHP;
	}

	/* (non-Javadoc)
	 * @see Character#subHP(int)
	 */
	@Override
	public void subHP(int myHP) {
		// TODO Auto-generated method stub
		HP -= myHP;
	}

	/* (non-Javadoc)
	 * @see Character#getMP()
	 */
	@Override
	public int getMP() {
		// TODO Auto-generated method stub
		return MP;
	}

	/* (non-Javadoc)
	 * @see Character#setMP(int)
	 */
	@Override
	public void setMP(int myMP) {
		// TODO Auto-generated method stub
		MP = myMP;
	}

	/* (non-Javadoc)
	 * @see Character#addMP(int)
	 */
	@Override
	public void addMP(int myMP) {
		// TODO Auto-generated method stub
		MP += myMP;
	}

	/* (non-Javadoc)
	 * @see Character#subMP(int)
	 */
	@Override
	public void subMP(int myMP) {
		// TODO Auto-generated method stub
		MP -= myMP;
	}
	
	public boolean isDead()
	{
		if (HP <= 0)
			return true;
		else
			return false;
	}

}
