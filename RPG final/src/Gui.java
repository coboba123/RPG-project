import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Toolkit;

public class Gui
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

					Gui window = new Gui();
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
	public Gui()
	{
		
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
		textArea1.setText("Welcome to the game");
		textArea1.setEditable(false);
		textArea1.setBounds(10, 10, 764, 291);
		frame.getContentPane().add(textArea1);

		JButton btnWest = new JButton("West");
		btnWest.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea1.setText(((Room) map.moveWest()).getDesc());
				/*
				if ((map.getCurrent()).getRate() < Math.random() * 100)
				{
					Battle battle = new Battle(myCharacter, enemy);
				}
				*/
			}
		});
		btnWest.setBounds(351, 372, 125, 40);
		frame.getContentPane().add(btnWest);

		JButton btnSouth = new JButton("South");
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
		btnInteract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((map.getCurrent()).getShop())
				{
					ShopGui shop = new ShopGui(myCharacter);
					shop.initialize();
				}
			
			}
		});
		btnInteract.setBounds(47, 321, 125, 40);
		frame.getContentPane().add(btnInteract);
	}
}
