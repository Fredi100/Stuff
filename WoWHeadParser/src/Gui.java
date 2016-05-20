import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Gui extends JFrame {

	// Center-Stuff
	private JTextArea sqlOutput;

	// Bottom-Stuff
	private JPanel bottom;
	private JTextField eingabe;
	private JLabel errors;

	// Others
	private Control c;

	public Gui(Control c) {
		this.c = c;
		this.setLayout(new BorderLayout());
		this.bottom = new JPanel();
		this.sqlOutput = new JTextArea();
		this.prepareBottom();
		this.prepareCenter();
		this.prepareWindow();
	}

	/**
	 * Prepares the bottom half of the windows including the input field and the
	 * message output
	 */
	public void prepareBottom() {
		this.bottom.setLayout(new GridLayout(2,1));
		this.eingabe = new JTextField();
		this.eingabe.setActionCommand("eingabeFeld");
		this.eingabe.addFocusListener(this.c);
		this.eingabe.addMouseListener(this.c);
		this.eingabe.addKeyListener(this.c);
		this.errors = new JLabel("Just insert the link to the spell and press enter!");
		this.bottom.add(this.errors);
		this.bottom.add(this.eingabe);
		this.add(bottom, BorderLayout.SOUTH);
	}

	/**
	 * Prepares the center of the window which includes the output field for the
	 * prepared sql commands
	 */
	public void prepareCenter() {
		this.sqlOutput.setEditable(false);
		this.add(this.sqlOutput, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 */
	public void prepareWindow(){
		this.setTitle("WoWHead-Parser");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	/**
	 * Returns the input component
	 * 
	 * @return The input field
	 */
	public JTextField getEingabe() {
		return this.eingabe;
	}

	/**
	 * Append the given string to the text already existing in the output window
	 * 
	 * @param output
	 *            The string which should be appended
	 */
	public void setOutput(String output) {
		this.sqlOutput.append(output);
	}

	/**
	 * Changes the displayed text off the error message field
	 * 
	 * @param error
	 *            The string which should appear in the message field
	 */
	public void setError(String error) {
		this.errors.setText(error);
	}
}
