import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

public class Gui
{

	private JFrame frame;
	private Character myCharacter;
	private String desc;


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
		}
		else
		{
			desc = "You inspect yourself. Your name is "
					+ name
					+ " and you are not a Magic User. While you cannot use Magic, you make up for it in Strength and your ability to survive longer,"
					+ " thus you are more resiliant than others and can last longer in a fight.";
			myCharacter = new nonMagicUser(name, desc);
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		Map map = new Map("dungeon.txt");

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea textArea1 = new JTextArea();
		textArea1.setWrapStyleWord(true);
		textArea1.setLineWrap(true);
		textArea1.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		textArea1.setText("Welcome to the game");
		textArea1.setEditable(false);
		textArea1.setBounds(10, 10, 764, 291);
		frame.getContentPane().add(textArea1);

		JButton btnWest = new JButton("West");
		btnWest.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnWest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea1.setText(((Room) map.moveWest()).getDesc());
				/*
				 * if ((map.getCurrent()).getRate() < Math.random() * 100) {
				 * Battle battle = new Battle(myCharacter, enemy); }
				 */
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
				textArea1.setText(((Room) map.moveSouth()).getDesc());
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
				textArea1.setText(((Room) map.moveEast()).getDesc());
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
			}
		});
		btnNorth.setBounds(486, 321, 125, 40);
		frame.getContentPane().add(btnNorth);

		JButton btnInteract = new JButton("Interact");
		btnInteract.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnInteract.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				if ((map.getCurrent()).getShop())
				{
					ShopGui shop = new ShopGui(myCharacter);
					shop.getFrame().setVisible(true);

					if (myCharacter.isHasMap())
					{
						String path = "dunegon_map.png";
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
						label.setBounds(177, 312, 164, 139);
						frame.getContentPane().add(label);
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
}
