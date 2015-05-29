import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ShopGUI
{
	private Character myCharacter;
	private JFrame frame;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{

					ShopGUI window = new ShopGUI();
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
	public ShopGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
	    JFrame frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
	    frame.setTitle("Shopkeeper");
	    frame.getContentPane().setLayout(new FlowLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    ImageIcon imageIcon = new ImageIcon("shop.png");
	    JLabel label = new JLabel(imageIcon);

	    frame.getContentPane().add(label);
	    
	    
	    frame.pack();
	    frame.setVisible(true);
		
		
	}
}
