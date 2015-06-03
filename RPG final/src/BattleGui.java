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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleGui
{
	// instance variables
	private Character myCharacter;
	private Monster myEnemy;
	private JFrame frame;
	private String path, myHp, myMp, myItems, enemyHp, battleText1;

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

		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				fight();
				myHp = "HP: " + myCharacter.getHP();

				myItems = "Bag" + myCharacter.getItems();

				playerStats.setText(myCharacter.getName() + "\n" + myHp + "\n" + myMp + "\n"
						+ myItems);

				enemyHp = "HP:" + myEnemy.getHP();

				enemyStats.setText(enemyHp + "\n" + myEnemy.getDesc());
				battleText.setText(battleText1);

			}
		});
		btnFight.setBounds(168, 463, 135, 41);
		frame.getContentPane().add(btnFight);

		JButton btnHp = new JButton("Use HP Potion");
		btnHp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (myCharacter.useItem(new Potion("HP Potion", "Heals your character for 50", 50)))
				{
					battleText1 += "\n\nPotion used. 50 HP restored.";
					myCharacter.addHP(50);
				} else
					battleText1 += "\n\nYou don't have any potions left!";
				battleText.setText(battleText1);
				myHp = "HP: " + myCharacter.getHP();

				myItems = "Bag" + myCharacter.getItems();

				playerStats.setText(myCharacter.getName() + "\n" + myHp + "\n" + myMp + "\n"
						+ myItems);

				enemyHp = "HP:" + myEnemy.getHP();

				enemyStats.setText(enemyHp + "\n" + myEnemy.getDesc());

			}
		});
		btnHp.setBounds(468, 463, 135, 41);
		frame.getContentPane().add(btnHp);

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
						myCharacter.setHP(attackCharacter(myEnemy.getDamage())
								- myCharacter.getDef());
				}
			} else
			{
				if (isMiss() == true)
					attackCharacter(0);
				else
				{
					if (myEnemy.isDead() == false && myCharacter.getDef() < myEnemy.getAttack())
						myCharacter.setHP(attackCharacter(myEnemy.getDamage())
								- myCharacter.getDef());
					if (myCharacter.isDead() == false && myEnemy.getDef() < myCharacter.getDamage())
						myEnemy.setHP(attackEnemy(myCharacter.getDamage()) - myEnemy.getDef());
				}
			}
		} else if (myCharacter.getSpeed() < myEnemy.getSpeed())
		{
			if (myEnemy.isDead() == false && myCharacter.getDef() < myEnemy.getAttack())
				myCharacter.setHP(attackCharacter(myEnemy.getDamage()) - myCharacter.getDef());
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
