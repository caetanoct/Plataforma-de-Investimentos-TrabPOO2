import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JFrame {
	JPanel pnPanel1;

	JPanel pnLoginPanel;
	JLabel lbLabel1;
	JLabel lbLabel2;
	JTextField tfUserField;
	JTextField tfPassWordField;
	JButton btLoginButton;
	public LoginPanel() {
		pnPanel1 = new JPanel();
		GridBagLayout gbPanel1 = new GridBagLayout();
		GridBagConstraints gbcPanel1 = new GridBagConstraints();
		pnPanel1.setLayout( gbPanel1 );

		pnLoginPanel = new JPanel();
		pnLoginPanel.setBorder( BorderFactory.createTitledBorder( "Login" ) );
		GridBagLayout gbLoginPanel = new GridBagLayout();
		GridBagConstraints gbcLoginPanel = new GridBagConstraints();
		pnLoginPanel.setLayout( gbLoginPanel );

		lbLabel1 = new JLabel( "Usuário:"  );
		gbcLoginPanel.gridx = 0;
		gbcLoginPanel.gridy = 0;
		gbcLoginPanel.gridwidth = 4;
		gbcLoginPanel.gridheight = 1;
		gbcLoginPanel.fill = GridBagConstraints.NONE;
		gbcLoginPanel.weightx = 0;
		gbcLoginPanel.weighty = 0;
		gbcLoginPanel.anchor = GridBagConstraints.WEST;
		gbLoginPanel.setConstraints( lbLabel1, gbcLoginPanel );
		pnLoginPanel.add( lbLabel1 );

		lbLabel2 = new JLabel( "Senha:"  );
		gbcLoginPanel.gridx = 0;
		gbcLoginPanel.gridy = 1;
		gbcLoginPanel.gridwidth = 4;
		gbcLoginPanel.gridheight = 1;
		gbcLoginPanel.fill = GridBagConstraints.NONE;
		gbcLoginPanel.weightx = 0;
		gbcLoginPanel.weighty = 0;
		gbcLoginPanel.anchor = GridBagConstraints.WEST;
		gbLoginPanel.setConstraints( lbLabel2, gbcLoginPanel );
		pnLoginPanel.add( lbLabel2 );

		tfUserField = new JTextField( );
		gbcLoginPanel.gridx = 4;
		gbcLoginPanel.gridy = 0;
		gbcLoginPanel.gridwidth = 8;
		gbcLoginPanel.gridheight = 1;
		gbcLoginPanel.fill = GridBagConstraints.BOTH;
		gbcLoginPanel.weightx = 1;
		gbcLoginPanel.weighty = 0;
		gbcLoginPanel.anchor = GridBagConstraints.NORTH;
		gbLoginPanel.setConstraints( tfUserField, gbcLoginPanel );
		pnLoginPanel.add( tfUserField );

		tfPassWordField = new JPasswordField( );
		gbcLoginPanel.gridx = 4;
		gbcLoginPanel.gridy = 1;
		gbcLoginPanel.gridwidth = 8;
		gbcLoginPanel.gridheight = 1;
		gbcLoginPanel.fill = GridBagConstraints.BOTH;
		gbcLoginPanel.weightx = 1;
		gbcLoginPanel.weighty = 0;
		gbcLoginPanel.anchor = GridBagConstraints.NORTH;
		gbLoginPanel.setConstraints( tfPassWordField, gbcLoginPanel );
		
		pnLoginPanel.add( tfPassWordField );
		gbcPanel1.gridx = 2;
		gbcPanel1.gridy = 2;
		gbcPanel1.gridwidth = 11;
		gbcPanel1.gridheight = 6;
		gbcPanel1.fill = GridBagConstraints.BOTH;
		gbcPanel1.weightx = 1;
		gbcPanel1.weighty = 0;
		gbcPanel1.anchor = GridBagConstraints.NORTH;
		gbPanel1.setConstraints( pnLoginPanel, gbcPanel1 );
		pnPanel1.add( pnLoginPanel );

		btLoginButton = new JButton( "Efetuar Login"  );
		gbcPanel1.gridx = 2;
		gbcPanel1.gridy = 8;
		gbcPanel1.gridwidth = 11;
		gbcPanel1.gridheight = 2;
		gbcPanel1.fill = GridBagConstraints.BOTH;
		gbcPanel1.weightx = 1;
		gbcPanel1.weighty = 0;
		gbcPanel1.anchor = GridBagConstraints.NORTH;
		gbPanel1.setConstraints( btLoginButton, gbcPanel1 );
		pnPanel1.add( btLoginButton );
	add(pnPanel1);
	}
	


}
