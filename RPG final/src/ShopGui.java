import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopGui
{

	private JFrame frame;
	private Character myCharacter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ShopGui window = new ShopGui(new nonMagicUser("Cody", "lol", 800));
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShopGui(Character character)
	{
		myCharacter = character;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		String words = "";
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(38, 394, 413, 22);
		frame.getContentPane().add(textArea);
		words = "Current Money: " + myCharacter.getMoney();
		textArea.setText(words);

		String path = "shop.png";
		File file = new File(path);
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(file);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.getContentPane().setLayout(null);
		JLabel label = new JLabel(new ImageIcon(image));
		label.setBounds(38, 0, 413, 385);
		frame.getContentPane().add(label);

		JButton btnHPPotion = new JButton("HP Potion - 200G (50 HP)");
		btnHPPotion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (myCharacter.getMoney() >= 200)
				{
					myCharacter.subMoney(200);
					myCharacter.addItem(new Potion("HP Potion", "Heals your character for 50", 50,
							true));
					textArea.setText("Current Money: " + myCharacter.getMoney());
				} else
				{
					textArea.setText("Current Money: " + myCharacter.getMoney()
							+ "   You don't have enough money!");
				}
			}
		});
		btnHPPotion.setBounds(10, 427, 441, 39);
		frame.getContentPane().add(btnHPPotion);

		JButton btnMPPotion = new JButton("MP Potion - 200G (50 MP)");
		btnMPPotion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (myCharacter.getMoney() >= 200)
				{
					myCharacter.subMoney(200);
					myCharacter.addItem(new Potion("MP Potion",
							"Restores your character's MP for 50", 50, false));
					textArea.setText("Current Money: " + myCharacter.getMoney());
				} else
				{
					textArea.setText("Current Money: " + myCharacter.getMoney()
							+ "   You don't have enough money!");
				}
			}
		});
		btnMPPotion.setBounds(10, 477, 441, 39);
		frame.getContentPane().add(btnMPPotion);

		JButton btnMap = new JButton("Map - 500");
		btnMap.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (myCharacter.getMoney() >= 500)
				{
					myCharacter.subMoney(200);
					myCharacter.setHasMap(true);
					textArea.setText("Current Money: " + myCharacter.getMoney());
				} else
				{
					textArea.setText("Current Money: " + myCharacter.getMoney()
							+ "   You don't have enough money!");
				}
			}
		});
		btnMap.setBounds(10, 527, 441, 39);
		frame.getContentPane().add(btnMap);

	}
}
