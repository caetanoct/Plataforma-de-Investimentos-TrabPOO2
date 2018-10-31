import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AreaCliente extends JFrame {

	JPanel pnPanel1;

	JPanel pnPanel2;
	JButton btDepositButton;
	JButton btResgateButton;
	JButton btExitButton;
	JButton btRefreshButton;
	JButton btInvestButton;
	JButton btSimButton;
	JButton btMyInvestButton;

	Labels pnLabelsPan;

	public AreaCliente() {
		

		pnPanel1 = new JPanel();
		GridBagLayout gbPanel1 = new GridBagLayout();
		GridBagConstraints gbcPanel1 = new GridBagConstraints();
		pnPanel1.setLayout( gbPanel1 );

		pnPanel2 = new JPanel();
		pnPanel2.setBorder( BorderFactory.createTitledBorder( "Área Do Cliente" ) );
		GridBagLayout gbPanel2 = new GridBagLayout();
		GridBagConstraints gbcPanel2 = new GridBagConstraints();
		pnPanel2.setLayout( gbPanel2 );

		btDepositButton = new JButton( "Depositar "  );
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 1;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints( btDepositButton, gbcPanel2 );
		pnPanel2.add( btDepositButton );

		btResgateButton = new JButton( "Resgatar Saldo"  );
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 2;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints( btResgateButton, gbcPanel2 );
		pnPanel2.add( btResgateButton );

		btExitButton = new JButton( "Sair"  );
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 6;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints( btExitButton, gbcPanel2 );
		pnPanel2.add( btExitButton );

		btRefreshButton = new JButton( "Atualizar"  );
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 0;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints( btRefreshButton, gbcPanel2 );
		pnPanel2.add( btRefreshButton );

		btInvestButton = new JButton( "Investir"  );
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 5;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints( btInvestButton, gbcPanel2 );
		pnPanel2.add( btInvestButton );

		btSimButton = new JButton( "Simular"  );
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 4;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints( btSimButton, gbcPanel2 );
		pnPanel2.add( btSimButton );

		btMyInvestButton = new JButton( "Meus Investimentos"  );
		gbcPanel2.gridx = 1;
		gbcPanel2.gridy = 3;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints( btMyInvestButton, gbcPanel2 );
		pnPanel2.add( btMyInvestButton );

		pnLabelsPan = new Labels();
		GridBagLayout gbLabelsPan = new GridBagLayout();
		GridBagConstraints gbcLabelsPan = new GridBagConstraints();
		pnLabelsPan.setLayout( gbLabelsPan );
		gbcPanel2.gridx = 0;
		gbcPanel2.gridy = 0;
		gbcPanel2.gridwidth = 1;
		gbcPanel2.gridheight = 1;
		gbcPanel2.fill = GridBagConstraints.BOTH;
		gbcPanel2.weightx = 1;
		gbcPanel2.weighty = 0;
		gbcPanel2.anchor = GridBagConstraints.NORTH;
		gbPanel2.setConstraints( pnLabelsPan, gbcPanel2 );
		pnPanel2.add( pnLabelsPan );
		gbcPanel1.gridx = 1;
		gbcPanel1.gridy = 1;
		gbcPanel1.gridwidth = 9;
		gbcPanel1.gridheight = 1;
		gbcPanel1.fill = GridBagConstraints.BOTH;
		gbcPanel1.weightx = 1;
		gbcPanel1.weighty = 0;
		gbcPanel1.anchor = GridBagConstraints.NORTH;
		gbPanel1.setConstraints( pnPanel2, gbcPanel1 );
		pnPanel1.add( pnPanel2 );
add(pnPanel1);
	}
	

}
