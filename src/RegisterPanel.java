import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPanel extends JFrame {

	JPanel pnPanel1;
	JPanel pnPanelRegistramento;
	JLabel lbLabel1;
	JLabel lbLabel2;
	JTextField tfField1;
	JTextField tfField2;
	JCheckBox cbBox1;
	JButton btBut1;

	public RegisterPanel() {

		pnPanel1 = new JPanel();
		GridBagLayout gbPanel1 = new GridBagLayout();
		GridBagConstraints gbcPanel1 = new GridBagConstraints();
		pnPanel1.setLayout(gbPanel1);

		pnPanelRegistramento = new JPanel();
		pnPanelRegistramento.setBorder(BorderFactory.createTitledBorder("Registrar"));
		GridBagLayout gbPanelRegistramento = new GridBagLayout();
		GridBagConstraints gbcPanelRegistramento = new GridBagConstraints();
		pnPanelRegistramento.setLayout(gbPanelRegistramento);

		lbLabel1 = new JLabel("Usuário:");
		gbcPanelRegistramento.gridx = 0;
		gbcPanelRegistramento.gridy = 0;
		gbcPanelRegistramento.gridwidth = 4;
		gbcPanelRegistramento.gridheight = 1;
		gbcPanelRegistramento.fill = GridBagConstraints.NONE;
		gbcPanelRegistramento.weightx = 0;
		gbcPanelRegistramento.weighty = 0;
		gbcPanelRegistramento.anchor = GridBagConstraints.WEST;
		gbPanelRegistramento.setConstraints(lbLabel1, gbcPanelRegistramento);
		pnPanelRegistramento.add(lbLabel1);

		lbLabel2 = new JLabel("Senha:");
		gbcPanelRegistramento.gridx = 0;
		gbcPanelRegistramento.gridy = 1;
		gbcPanelRegistramento.gridwidth = 4;
		gbcPanelRegistramento.gridheight = 1;
		gbcPanelRegistramento.fill = GridBagConstraints.NONE;
		gbcPanelRegistramento.weightx = 0;
		gbcPanelRegistramento.weighty = 0;
		gbcPanelRegistramento.anchor = GridBagConstraints.WEST;
		gbPanelRegistramento.setConstraints(lbLabel2, gbcPanelRegistramento);
		pnPanelRegistramento.add(lbLabel2);

		tfField1 = new JTextField();
		gbcPanelRegistramento.gridx = 4;
		gbcPanelRegistramento.gridy = 0;
		gbcPanelRegistramento.gridwidth = 8;
		gbcPanelRegistramento.gridheight = 1;
		gbcPanelRegistramento.fill = GridBagConstraints.BOTH;
		gbcPanelRegistramento.weightx = 1;
		gbcPanelRegistramento.weighty = 0;
		gbcPanelRegistramento.anchor = GridBagConstraints.NORTH;
		gbPanelRegistramento.setConstraints(tfField1, gbcPanelRegistramento);
		pnPanelRegistramento.add(tfField1);

		tfField2 = new JTextField();
		gbcPanelRegistramento.gridx = 4;
		gbcPanelRegistramento.gridy = 1;
		gbcPanelRegistramento.gridwidth = 8;
		gbcPanelRegistramento.gridheight = 1;
		gbcPanelRegistramento.fill = GridBagConstraints.BOTH;
		gbcPanelRegistramento.weightx = 1;
		gbcPanelRegistramento.weighty = 0;
		gbcPanelRegistramento.anchor = GridBagConstraints.NORTH;
		gbPanelRegistramento.setConstraints(tfField2, gbcPanelRegistramento);
		pnPanelRegistramento.add(tfField2);

		cbBox1 = new JCheckBox("Conta Premium");
		gbcPanelRegistramento.gridx = 0;
		gbcPanelRegistramento.gridy = 2;
		gbcPanelRegistramento.gridwidth = 12;
		gbcPanelRegistramento.gridheight = 1;
		gbcPanelRegistramento.fill = GridBagConstraints.BOTH;
		gbcPanelRegistramento.weightx = 1;
		gbcPanelRegistramento.weighty = 0;
		gbcPanelRegistramento.anchor = GridBagConstraints.NORTH;
		gbPanelRegistramento.setConstraints(cbBox1, gbcPanelRegistramento);
		pnPanelRegistramento.add(cbBox1);
		gbcPanel1.gridx = 2;
		gbcPanel1.gridy = 2;
		gbcPanel1.gridwidth = 11;
		gbcPanel1.gridheight = 6;
		gbcPanel1.fill = GridBagConstraints.BOTH;
		gbcPanel1.weightx = 1;
		gbcPanel1.weighty = 0;
		gbcPanel1.anchor = GridBagConstraints.NORTH;
		gbPanel1.setConstraints(pnPanelRegistramento, gbcPanel1);
		pnPanel1.add(pnPanelRegistramento);

		btBut1 = new JButton("Efetuar Cadastro");
		gbcPanel1.gridx = 2;
		gbcPanel1.gridy = 8;
		gbcPanel1.gridwidth = 11;
		gbcPanel1.gridheight = 2;
		gbcPanel1.fill = GridBagConstraints.BOTH;
		gbcPanel1.weightx = 1;
		gbcPanel1.weighty = 0;
		gbcPanel1.anchor = GridBagConstraints.NORTH;
		gbPanel1.setConstraints(btBut1, gbcPanel1);
		pnPanel1.add(btBut1);

		add(pnPanel1);
	}

}
