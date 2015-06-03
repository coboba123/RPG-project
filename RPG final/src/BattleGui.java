import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class BattleGui
{
	// instance variables
	private Character myCharacter;
	private Monster myEnemy;
	private JFrame frame;
	private String path, myHp, myMp, myItems, enemyHp;

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public BattleGui(Character c1, Monster c2)
	{
		 myCharacter = c1;
		 myEnemy = c2;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		if (myCharacter.isMagic())
			path = "wizard.gif";
		else
			path = "knight.gif";

		File file = new File(path);
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(file);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel(new ImageIcon(image));
		label.setBounds(10, 11, 164, 139);
		frame.getContentPane().add(label);

		path = myEnemy.getPath();

		File file1 = new File(path);
		BufferedImage image1 = null;
		try
		{
			image1 = ImageIO.read(file1);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.getContentPane().setLayout(null);
		JLabel label1 = new JLabel(new ImageIcon(image1));
		label1.setBounds(610, 11, 164, 139);
		frame.getContentPane().add(label1);

		JTextArea playerStats = new JTextArea();
		playerStats.setEditable(false);
		playerStats.setBounds(10, 174, 164, 261);
		frame.getContentPane().add(playerStats);
		
		myHp = "HP: " + myCharacter.getHP();
		
		myItems = "Bag" + myCharacter.getItems();
		
		playerStats.setText(myHp + "\n" + myMp + "\n" + myItems);
		

		JTextArea battleText = new JTextArea();
		battleText.setEditable(false);
		battleText.setBounds(200, 11, 383, 424);
		frame.getContentPane().add(battleText);

		JTextArea enemyStats = new JTextArea();
		enemyStats.setEditable(false);
		enemyStats.setBounds(610, 174, 164, 261);
		frame.getContentPane().add(enemyStats);
		
		enemyHp = "HP:" + myEnemy.getHP();
		
		enemyStats.setText(enemyHp + "\n" + myEnemy.getDesc());
		
		JButton btnNewButton = new JButton("Fight");
		btnNewButton.setBounds(168, 463, 135, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnFight = new JButton("Use HP Potion");
		btnFight.setBounds(468, 463, 135, 41);
		frame.getContentPane().add(btnFight);
		
	}

	public void setVisible()
	{
		frame.setVisible(true);
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
				if (myCharacter.isDead() == false && myEnemy.getDef() < myCharacter.getDamage())
				myEnemy.setHP(attackEnemy(myCharacter.getDamage() - myEnemy.getDef()));
				if (myEnemy.isDead() == false && myCharacter.getDef() < myEnemy.getAttack())
					myCharacter.setHP(attackCharacter(myEnemy.getDef()) - myCharacter.getDef());
			}
		} else if (myCharacter.getSpeed() == myEnemy.getSpeed())
		{
			if (Math.random() >= 0.5)
			{
				if (isMiss() == true)
					attackEnemy(0);
				else
				{
					if (myCharacter.isDead() == false && myEnemy.getDef() < myCharacter.getDamage())
						myEnemy.setHP(attackEnemy(myCharacter.getDamage()) - myEnemy.getDef());
					if (myEnemy.isDead() == false && myCharacter.getDef() < myEnemy.getAttack())
						myCharacter.setHP(attackCharacter(myEnemy.getDamage()) - myCharacter.getDef());
				}
			}
			else
			{
				if (isMiss() == true)
					attackCharacter(0);
				else
				{
					if (myEnemy.isDead() == false && myCharacter.getDef() < myEnemy.getAttack())
						myCharacter.setHP(attackCharacter(myEnemy.getDamage()) - myCharacter.getDef());
					if (myCharacter.isDead() == false && myEnemy.getDef() < myCharacter.getDamage())
						myEnemy.setHP(attackEnemy(myCharacter.getDamage()) - myEnemy.getDef());
				}
			}
		} else if (myCharacter.getSpeed() < myEnemy.getSpeed())
		{
			if (myEnemy.isDead() == false && myCharacter.getDef() < myEnemy.getAttack())
			myCharacter.getHP(attackCharacter(myEnemy.getDamage()) - myCharacter.getDef());
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
