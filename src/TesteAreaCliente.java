import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TesteAreaCliente extends JFrame {

	JPanel pnPanel1;

	JPanel pnPanel2;
	JLabel lbLabel2;
	JLabel lbLabel3;
	JLabel lbSaldoLabel;
	JLabel lbPatrimonioLabel;
	JButton btDepositButton;
	JButton btResgateButton;

	public TesteAreaCliente() {

		pnPanel1 = new JPanel();
		GridBagLayout gbPanel1 = new GridBagLayout();
		GridBagConstraints gbcPanel1 = new GridBagConstraints();
		pnPanel1.setLayout(gbPanel1);

		pnPanel2 = new JPanel();
		pnPanel2.setBorder(BorderFactory.createTitledBorder("Área Do Cliente"));
		GridBagLayout gbPanel2 = new GridBagLayout();
		GridBagConstraints gbcPanel2 = new GridBagConstraints();
		pnPanel2.setLayout(gbPanel2);

		lbLabel2 = new JLabel("Saldo disponível:");
		gbcPanel2.gridx = 0;
		gbcPanel2.gridy = 0;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 1;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints(lbLabel2, gbcPanel2);
		pnPanel2.add(lbLabel2);

		lbLabel3 = new JLabel("Patrimômio:");
		gbcPanel2.gridx = 0;
		gbcPanel2.gridy = 1;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 1;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints(lbLabel3, gbcPanel2);
		pnPanel2.add(lbLabel3);

		lbSaldoLabel = new JLabel("0");
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 0;
		gbcPanel2.gridwidth = 2;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 1;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints(lbSaldoLabel, gbcPanel2);
		pnPanel2.add(lbSaldoLabel);

		lbPatrimonioLabel = new JLabel("0");
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 1;
		gbcPanel2.gridwidth = 2;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 1;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints(lbPatrimonioLabel, gbcPanel2);
		pnPanel2.add(lbPatrimonioLabel);

		btDepositButton = new JButton("Depositar ");
		gbcPanel2.gridx = 2;
		gbcPanel2.gridy = 2;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints(btDepositButton, gbcPanel2);
		pnPanel2.add(btDepositButton);

		btResgateButton = new JButton("Resgatar Saldo");
		gbcPanel2.gridx = 2;
		gbcPanel2.gridy = 3;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints(btResgateButton, gbcPanel2);
		pnPanel2.add(btResgateButton);
		gbcPanel1.gridx = 1;
		gbcPanel1.gridy = 1;
		gbcPanel1.gridwidth = 9;
		gbcPanel1.gridheight = 1;
		gbcPanel1.fill = GridBagConstraints.BOTH;
		gbcPanel1.weightx = 1;
		gbcPanel1.weighty = 0;
		gbcPanel1.anchor = GridBagConstraints.NORTH;
		gbPanel1.setConstraints(pnPanel2, gbcPanel1);
		pnPanel1.add(pnPanel2);

		add(pnPanel1);
	}
}
