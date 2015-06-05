
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

/**
 * @author Cody and Alex and Daniel
 * This is the battle system used in the game. This is called when a battle occurs, 
 * usually at a random chance or in the boss room.
 *
 */
public class BattleGui
{
	// instance variables
	private Character myCharacter;
	private Monster myEnemy;
	private JFrame frame;
	private String path, myHp, myItems, enemyHp, battleText1 = "";
	private int money, times = 0;

	/**
	 * Create the application.
	 * @param c1 needs the player character.
	 * @param c2 needs a Monster for the player to fight.
	 * @wbp.parser.entryPoint
	 */
	public BattleGui(Character c1, Monster c2)
	{
		myCharacter = c1;
		myEnemy = c2;
		initialize();
	}

	/**
	 * Initialize the contents of the frame. This creates and gets all the images and values
	 * that are used in the battle for the stats and interactions.
	 */
	private void initialize()
	{
		//creates the frame of the battle
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 800, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//imports the pictures for the character, depending if it is a wizard or knight
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

		//imports the image for the enemy being battled with
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

		//Holds the stats of the player, such as HP and Name and amount of potions left.
		JTextArea playerStats = new JTextArea();
		playerStats.setEditable(false);
		playerStats.setBounds(10, 174, 164, 261);
		frame.getContentPane().add(playerStats);

		myHp = "HP: " + myCharacter.getHP();

		myItems = "Bag: " + myCharacter.getItems();

		playerStats.setText(myCharacter.getName() + "\n" + myHp + "\n" + myItems);
		
		//The battle text that shows what is occurring during the battle 
		JTextArea battleText = new JTextArea();
		battleText.setLineWrap(true);
		battleText.setEditable(false);
		battleText.setBounds(200, 11, 383, 424);
		frame.getContentPane().add(battleText);

		JTextArea enemyStats = new JTextArea();
		enemyStats.setLineWrap(true);
		enemyStats.setWrapStyleWord(true);
		enemyStats.setEditable(false);
		enemyStats.setBounds(610, 174, 164, 261);
		frame.getContentPane().add(enemyStats);

		enemyHp = "HP:" + myEnemy.getHP();

		enemyStats.setText(myEnemy.getName() + "\n" + enemyHp + "\n\n" + myEnemy.getDesc());

		JButton btnHp = new JButton("Use HP Potion");
		btnHp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (myCharacter.usePotion())
				{
					battleText1 += "Potion used. 50 HP restored.\n\n";
					myCharacter.addHP(50);
				} else
					battleText1 += "You don't have any potions left!\n\n";
				battleText.setText(battleText1);
				myHp = "HP: " + myCharacter.getHP();

				myItems = "Bag: " + myCharacter.getItems();

				playerStats.setText(myCharacter.getName() + "\n" + myHp + "\n" + myItems);

				enemyHp = "HP:" + myEnemy.getHP();

				enemyStats.setText(myEnemy.getName() + "\n" + enemyHp + "\n\n" + myEnemy.getDesc());

			}
		});
		btnHp.setBounds(458, 463, 135, 41);
		frame.getContentPane().add(btnHp);

		JButton btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				fight();

				myHp = "HP: " + myCharacter.getHP();

				myItems = "Bag: " + myCharacter.getItems();

				playerStats.setText(myCharacter.getName() + "\n" + myHp + "\n" + myItems);

				enemyHp = "HP:" + myEnemy.getHP();

				enemyStats.setText(myEnemy.getName() + "\n" + enemyHp + "\n\n" + myEnemy.getDesc());

				if (times > 3)
				{
					battleText1 = "";
					times = 0;
				}

				else
					times++;

				battleText.setText(battleText1);
				if (myCharacter.isDead())
				{
					battleText1 += "You have been defeated. Game Over";
					battleText.setText(battleText1);
					btnFight.setVisible(false);
					btnHp.setVisible(false);
					JButton btnExit = new JButton("Exit");
					btnExit.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent arg0)
						{
							System.exit(0);
						}
					});
					btnExit.setBounds(313, 463, 135, 41);
					frame.getContentPane().add(btnExit);
				}
				if (myEnemy.isDead())
				{
					money = 100 + (int) (Math.random() * 200);
					battleText1 += "You successfully Defeated " + myEnemy.getName()
							+ "!\n\nYou earned " + money + " Gold!";
					myCharacter.addMoney(money);
					battleText.setText(battleText1);
					btnFight.setVisible(false);
					btnHp.setVisible(false);

					JButton btnExit = new JButton("Exit");
					btnExit.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent arg0)
						{
							myEnemy.heal();
							frame.setVisible(false);
						}
					});
					btnExit.setBounds(313, 463, 135, 41);
					frame.getContentPane().add(btnExit);
					btnExit.setVisible(true);

				}

			}
		});
		btnFight.setBounds(168, 463, 135, 41);
		frame.getContentPane().add(btnFight);

	}

	public void setVisible()
	{
		frame.setVisible(true);
	}

	/**
	 * A method called whenever the character is attacked
	 * 
	 * @param The base damage that the enemy will deal to the character
	 *            
	 * @return The remaining HP without armor reductions when the character gets hit
	 */
	public int attackCharacter(int eDamage)
	{
		if (isCritical() == true)
		{
			battleText1 += "The " + myEnemy.getName() + " critically attacked you for "
					+ ((eDamage * 2) + myCharacter.getDef()) + " damage!\n\n";
			return myCharacter.getHP() - 2 * eDamage;
		}
		if (eDamage == 0)
			battleText1 += "The " + myEnemy.getName() + " missed you!";
		else
			battleText1 += "The " + myEnemy.getName() + " attacked you for "
					+ (eDamage + myCharacter.getDef()) + " damage!\n\n";
		return myCharacter.getHP() - eDamage;
	}

	/**
	 * A method called whenever the enemy is attacked
	 * 
	 * @param The base damage that the enemy will deal to the enemy
	 *            
	 * @return The remaining HP without armor reductions when the enemy gets hit
	 */
	public int attackEnemy(int cDamage)
	{
		if (cDamage != 0)
		{
			if (isCritical() == true)
			{
				battleText1 += "You attacked and it was a critical hit for " + ((cDamage * 2))
						+ " damage!\n\n";
				return myEnemy.getHP() - 2 * cDamage;
			}
			battleText1 += "You attacked for " + (cDamage) + " damage!\n\n";
			return myEnemy.getHP() - cDamage;
		} else
			return 0;
	}


	/**
	 * This method goes through a single attack from the player and the enemy. The method accounts for the order of attacking by comparing the speed of the player and the enemy.
	 * 
	 */
	public void fight()
	{
		if (myCharacter.getSpeed() > myEnemy.getSpeed())
		{
			if (isMiss() == true)
			{
				attackEnemy(0);
				battleText1 += "You attacked but it was a miss!\n\n";
			} else
			{
				if (myCharacter.isDead() == false)
					myEnemy.setHP(attackEnemy((myCharacter.getDamage() - myEnemy.getDef())));

				if (myEnemy.isDead() == false)
					myCharacter.setHP(attackCharacter(myEnemy.getAttack()) - myCharacter.getDef());
			}
		} else if (myCharacter.getSpeed() == myEnemy.getSpeed())
		{
			if (Math.random() >= 0.5)
			{
				if (isMiss() == true)
				{
					attackEnemy(0);
					battleText1 += "You attacked but it was a miss!\n\n";
				} else
				{
					if (myCharacter.isDead() == false)
						myEnemy.setHP(attackEnemy(myCharacter.getDamage()) - myEnemy.getDef());
					if (myEnemy.isDead() == false)
						myCharacter.setHP(attackCharacter(myEnemy.getAttack()
								- myCharacter.getDef()));
				}
			} else
			{
				if (isMiss() == true)
				{
					attackCharacter(0);
					battleText1 += "You attacked but it was a miss!\n\n";
				} else
				{
					if (myEnemy.isDead() == false)
						myCharacter.setHP(attackCharacter(myEnemy.getAttack())
								- myCharacter.getDef());
					if (myCharacter.isDead() == false)
						myEnemy.setHP(attackEnemy(myCharacter.getDamage()) - myEnemy.getDef());
				}
			}
		} else if (myCharacter.getSpeed() < myEnemy.getSpeed())
		{
			if (myEnemy.isDead() == false)
				myCharacter.setHP(attackCharacter(myEnemy.getAttack()) - myCharacter.getDef());
			if (myCharacter.isDead() == false)
				attackEnemy(myCharacter.getDamage() - myEnemy.getDef());
		}
	}

	/**
	 * This method determines if a hit is a critical
	 * 
	 * @return a true or false statement 
	 */
	public boolean isCritical()
	{
		if (Math.random() <= 0.1) //rng. 10% chance of landing a critical
			return true;
		else
			return false; //not a critical, regular hit
	}

	/**
	 * This method determines if a hit is a miss
	 * 
	 * @return a true or false statement
	 */
	public boolean isMiss()
	{
		if (Math.random() >= .95) //rng. 5% chance of missing
			return true;
		else
			return false; //not a miss, hit lands
	}
}
