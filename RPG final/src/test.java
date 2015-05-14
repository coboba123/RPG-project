import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Label;

public class test extends JFrame
{

	private JPanel contentPane;

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
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNorth = new JButton("North");
		btnNorth.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
		btnNorth.setBounds(486, 338, 120, 45);
		contentPane.add(btnNorth);

		JButton btnSouth = new JButton("South");
		btnSouth.setBounds(486, 394, 120, 45);
		contentPane.add(btnSouth);

		JButton btnWest = new JButton("West");
		btnWest.setBounds(356, 394, 120, 45);
		contentPane.add(btnWest);

		JButton btnEast = new JButton("East");
		btnEast.setBounds(616, 394, 120, 45);
		contentPane.add(btnEast);

		JTextPane textBox = new JTextPane();
		textBox.setEditable(false);
		textBox.setBackground(Color.WHITE);
		textBox.setBounds(20, 11, 764, 316);
		contentPane.add(textBox);

		JButton btnMenu = new JButton("Menu");
		btnMenu.setBounds(30, 338, 120, 45);
		contentPane.add(btnMenu);
	}
}
