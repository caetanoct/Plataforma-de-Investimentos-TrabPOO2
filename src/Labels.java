import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Labels extends JPanel {
	JLabel label1;
	JLabel label2;
	public Labels() {
		setLayout(new GridLayout(1,2));
		label1 = new JLabel("Saldo Disponível: ");
		label2 = new JLabel("0R$");
		add(label1);
		add(label2);
	}
	
}
