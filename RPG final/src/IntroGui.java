import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntroGui
{

	private JFrame frame;
	private JTextField textField;
	private boolean isMagic;
	private String name;

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
					IntroGui window = new IntroGui();
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
	public IntroGui()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		textField.setBounds(82, 57, 224, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JTextArea txtrWhatIsYour = new JTextArea();
		txtrWhatIsYour.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		txtrWhatIsYour.setEditable(false);
		txtrWhatIsYour.setText("What is your name?");
		txtrWhatIsYour.setBounds(103, 11, 177, 35);
		frame.getContentPane().add(txtrWhatIsYour);

		
		

		JTextArea txtrWouldYouRather = new JTextArea();
		txtrWouldYouRather.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		txtrWouldYouRather.setText("Would you rather use Magic or the Strength?");
		txtrWouldYouRather.setEditable(false);
		txtrWouldYouRather.setBounds(10, 105, 398, 35);
		frame.getContentPane().add(txtrWouldYouRather);

		JRadioButton rdbtnMagic = new JRadioButton("Magic");
		rdbtnMagic.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		rdbtnMagic.setBounds(82, 147, 89, 39);
		frame.getContentPane().add(rdbtnMagic);

		JRadioButton rdbtnStrength = new JRadioButton("Strength");
		rdbtnStrength.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		rdbtnStrength.setBounds(199, 147, 107, 39);
		frame.getContentPane().add(rdbtnStrength);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMagic);
		group.add(rdbtnStrength);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				isMagic = rdbtnMagic.isSelected();
				name = textField.getText();
				name.trim();
				frame.setVisible(false);
				Gui gui = new Gui(name, isMagic);
				gui.setVisible();
			}
		});
		btnDone.setFont(new Font("Vivaldi", Font.PLAIN, 25));
		btnDone.setBounds(306, 212, 102, 39);
		frame.getContentPane().add(btnDone);
	}
}
