import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class Gui
{

	private JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnWest = new JButton("West");
		btnWest.setBounds(351, 372, 125, 40);
		frame.getContentPane().add(btnWest);

		JButton btnSouth = new JButton("South");
		btnSouth.setBounds(486, 372, 125, 40);
		frame.getContentPane().add(btnSouth);

		JButton btnEast = new JButton("East");
		btnEast.setBounds(621, 372, 125, 40);
		frame.getContentPane().add(btnEast);

		JTextArea textArea1 = new JTextArea();
		textArea1.setText("Welcome to the game");
		textArea1.setEditable(false);
		textArea1.setBounds(10, 10, 764, 291);
		frame.getContentPane().add(textArea1);

		JButton btnNorth = new JButton("North");
		btnNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea1.setText("");
			}
		});
		btnNorth.setBounds(486, 321, 125, 40);
		frame.getContentPane().add(btnNorth);
	}
	
	
}
