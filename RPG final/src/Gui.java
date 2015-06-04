import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import chn.util.FileInput;

import java.io.File;
import java.io.IOException;
import java.awt.Font;

public class Gui
{

	private JFrame frame;
	private Character myCharacter;
	private String desc;
	private Monster[] monsters = new Monster[3];
	private String mName, path, mDesc;
	private int hp, speed, att, def, num;
	private boolean magic;
	private Monster boss;

	/**
	 * Create the application.
	 */
	public Gui(String name, boolean isMagic)
	{
		if (isMagic)
		{
			desc = "You inspect yourself. Your name is "
					+ name
					+ " and you are a Magic User. You prefer to use your natural talent for magic over your strengths,"
					+ " thus you are squishier than others, but you make up for it in Magical Power.";
			myCharacter = new MagicUser(name, desc);
		} else
		{
			desc = "You inspect yourself. Your name is "
					+ name
					+ " and you are not a Magic User. While you cannot use Magic, you make up for it in Strength and your ability to survive longer,"
					+ " thus you are more resiliant than others and can last longer in a fight.";
			myCharacter = new nonMagicUser(name, desc);
		}
		FileInput input = new FileInput("Monsters.txt");
		num = input.readInt();
		for (int i = 0; i < num; i++)
		{
			mName = input.readLine();
			mDesc = input.readLine();
			path = input.readLine();
			hp = input.readInt();
			speed = input.readInt();
			att = input.readInt();
			def = input.readInt();
			monsters[i] = new Monster(mName, mDesc, path, hp, speed, att, def);
		}
		magic = isMagic;
		boss = new Monster("Cho'Gath", "The Devourer of Worlds, The Master of this Dungeon",
				"chogath.png", 200, 5, 25, 0);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Map map = new Map("dungeon.txt");
		if (magic)
			map.setMagicItems();
		else
			map.setNonMagicItems();

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea1 = new JTextArea();
		textArea1.setWrapStyleWord(true);
		textArea1.setLineWrap(true);
		textArea1.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		textArea1
				.setText("You are a Adventurer who is at the entrance to the Dungeon of Doom to defeat the dungeon master."
						+ "He is threatening the world and you are here to defeat him.");
		textArea1.setEditable(false);
		textArea1.setBounds(10, 10, 764, 291);
		frame.getContentPane().add(textArea1);

		String path5 = "dunegon_map.png";
		File file5 = new File(path5);
		BufferedImage image5 = null;
		try
		{
			image5 = ImageIO.read(file5);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.getContentPane().setLayout(null);
		JLabel label5 = new JLabel(new ImageIcon(image5));
		label5.setBounds(177, 312, 164, 139);
		label5.setVisible(false);
		frame.getContentPane().add(label5);

		JButton btnWest = new JButton("West");
		btnWest.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnWest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea1.setText(((Room) map.moveWest(myCharacter)).getDesc());
				if (myCharacter.isHasMap())
					label5.setVisible(true);
				if (map.getCurrent().HasBoss())
				{
					BattleGui battle = new BattleGui(myCharacter, boss);
					battle.setVisible();
					textArea1
							.setText("You Deafeated the Dungeon Master and saved the world! congratulations!");
				} else if ((map.getCurrent()).getRate() > Math.random() * 100)
				{

					BattleGui battle = new BattleGui(myCharacter,
							monsters[(int) ((Math.random() * 4) - 1)]);
					battle.setVisible();

				}

			}
		});
		btnWest.setBounds(351, 372, 125, 40);
		frame.getContentPane().add(btnWest);

		JButton btnSouth = new JButton("South");
		btnSouth.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnSouth.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea1.setText(((Room) map.moveSouth(myCharacter)).getDesc());
				if (map.getCurrent().HasBoss())
				{
					BattleGui battle = new BattleGui(myCharacter, boss);
					battle.setVisible();
					textArea1
							.setText("You Deafeated the Dungeon Master and saved the world! congratulations!");
				} else if (myCharacter.isHasMap())
					label5.setVisible(true);
				if ((map.getCurrent()).getRate() > Math.random() * 100)
				{

					BattleGui battle = new BattleGui(myCharacter,
							monsters[(int) ((Math.random() * 4) - 1)]);
					battle.setVisible();

				}

			}
		});
		btnSouth.setBounds(486, 372, 125, 40);
		frame.getContentPane().add(btnSouth);

		JButton btnEast = new JButton("East");
		btnEast.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnEast.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea1.setText(((Room) map.moveEast(myCharacter)).getDesc());
				if (myCharacter.isHasMap())
					label5.setVisible(true);
				if (map.getCurrent().HasBoss())
				{
					BattleGui battle = new BattleGui(myCharacter, boss);
					battle.setVisible();
					textArea1
							.setText("You Deafeated the Dungeon Master and saved the world! congratulations!");
				} else if ((map.getCurrent()).getRate() > Math.random() * 100)
				{

					BattleGui battle = new BattleGui(myCharacter,
							monsters[(int) ((Math.random() * 4) - 1)]);
					battle.setVisible();

				}
			}
		});
		btnEast.setBounds(621, 372, 125, 40);
		frame.getContentPane().add(btnEast);

		JButton btnNorth = new JButton("North");
		btnNorth.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnNorth.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea1.setText(((Room) map.moveNorth()).getDesc());
				if (map.getCurrent().HasBoss())
				{
					BattleGui battle = new BattleGui(myCharacter, boss);
					battle.setVisible();
					textArea1
							.setText("You Deafeated the Dungeon Master and saved the world! congratulations!");
				} else if (myCharacter.isHasMap())
					label5.setVisible(true);
				if ((map.getCurrent()).getRate() > Math.random() * 100)
				{

					BattleGui battle = new BattleGui(myCharacter,
							monsters[(int) ((Math.random() * 4) - 1)]);
					battle.setVisible();

				}
			}
		});
		btnNorth.setBounds(486, 321, 125, 40);
		frame.getContentPane().add(btnNorth);

		String path = "key.gif";
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
		JLabel label2 = new JLabel(new ImageIcon(image));
		label2.setBounds(10, 414, 135, 107);
		label2.setVisible(false);
		frame.getContentPane().add(label2);

		String path1, path2;
		if (magic)
		{
			path1 = "cloak.gif";
			path2 = "staff.gif";
		} else
		{
			path1 = "armor.gif";
			path2 = "sword.gif";
		}
		File file1 = new File(path1);
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
		JLabel label3 = new JLabel(new ImageIcon(image1));
		label3.setBounds(576, 433, 135, 107);
		label3.setVisible(false);
		frame.getContentPane().add(label3);

		File file2 = new File(path2);
		BufferedImage image2 = null;
		try
		{
			image2 = ImageIO.read(file2);
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.getContentPane().setLayout(null);
		JLabel label4 = new JLabel(new ImageIcon(image2));
		label4.setBounds(361, 433, 135, 107);
		label4.setVisible(false);
		frame.getContentPane().add(label4);

		JButton btnInteract = new JButton("Interact");
		btnInteract.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnInteract.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				if ((map.getCurrent()).getShop())
				{
					ShopGui shop = new ShopGui(myCharacter, myCharacter.isHasMap());
					shop.getFrame().setVisible(true);

					if (myCharacter.isHasMap())
					{
						label5.setVisible(true);
					}
				} else if (map.getCurrent().HasKey())
				{
					myCharacter.setHasKey(true);
					label2.setVisible(true);
					textArea1.setText(map.getCurrent().getDesc() + " \n\n You picked up the Key!");

				} else if (map.getCurrent().hasArmor() || map.getCurrent().hasWeapon())
				{
					if (map.getCurrent().hasArmor())
					{
						textArea1.setText("You opened the chest and found a "
								+ map.getCurrent().getItem().getName() + "!");
						myCharacter.setArmor((Armor) map.getCurrent().getItem());
						myCharacter.setDesc(myCharacter.getDesc() + "You are wearing a "
								+ myCharacter.getArmor().getName() + ".");
						label3.setVisible(true);

						map.getCurrent()
								.setDesc(
										"It's a dead end, the only way out is to the east."
												+ " There is an empty chest where you found your new armor.");
						map.getCurrent().setHasArmor(false);
					} else if (map.getCurrent().hasWeapon())
					{
						textArea1.setText("You opened the chest and found a "
								+ map.getCurrent().getItem().getName() + "!");
						myCharacter.setWeapon((Weapon) map.getCurrent().getItem());
						myCharacter.setDesc(myCharacter.getDesc() + "You are Holding a "
								+ myCharacter.getWeapon().getName() + ".");
						label4.setVisible(true);

						map.getCurrent()
								.setDesc(
										"It's a dead end, the only way out is to the north."
												+ " There is an empty chest where you found your new weapon.");
						map.getCurrent().setHasWeapon(false);
					}

				} else
				{
					textArea1.setText(map.getCurrent().getDesc() + "\n\n" + myCharacter.getDesc());
				}

			}
		});

		btnInteract.setBounds(47, 321, 125, 40);
		frame.getContentPane().add(btnInteract);
	}

	public void setVisible()
	{
		frame.setVisible(true);
	}

	public void setMapVisible()
	{

	}

}
