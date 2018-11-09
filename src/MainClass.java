import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainClass extends JFrame {
	public SerializableFileManager fileManager = new SerializableFileManager();
	public ArrayList<Conta> contasSistema = fileManager.read();
	public Investimento[] investimentosDisponiveis = { new TDPR(), new FIM(), new CDB(), new LCI(), };
	RegisterPanel panelRegistro;
	LoginPanel panelLogin;
	AreaCliente clientePanel;
	InvestGUI areaInvestir;
	JPanel pnPanel0;
	JLabel lbLabel1;
	JButton btBut0;
	JButton btBut1;
	Conta usuarioLogado = null;

	public MainClass() {
		super("app");
		pnPanel0 = new JPanel();
		pnPanel0.setLayout(new GridLayout(3, 1));
		lbLabel1 = new JLabel("Plataforma de Investimentos: ");
		pnPanel0.add(lbLabel1);
		btBut0 = new JButton("Entrar na �rea do cliente");
		pnPanel0.add(btBut0);
		btBut1 = new JButton("Criar nova conta");
		pnPanel0.add(btBut1);
		ButtonHandler handler = new ButtonHandler();
		btBut0.addActionListener(handler);
		btBut1.addActionListener(handler);
		add(pnPanel0);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(null , 
		            "Are you sure you want to close this window?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    }
		});
	}

	private class ButtonHandler implements ActionListener {

		boolean but1JaApertado, but0JaApertado, loginEfetuado, investPanelIsRunning = false;

		@Override
		public void actionPerformed(ActionEvent e) {
			// Se � apertado bot�o 0(Login) � aberto o frame de login
			if (e.getSource().equals(btBut0)) {
				panelLogin = new LoginPanel();
				panelLogin.setSize(200, 145);
				panelLogin.setVisible(true);
				panelLogin.btLoginButton.addActionListener(this);
				but0JaApertado = true;
			}

			// Se � apertado bot�o 1(registro) � aberto o frame de registro
			if (e.getSource().equals(btBut1)) {
				panelRegistro = new RegisterPanel();
				panelRegistro.setSize(200, 175);
				panelRegistro.setVisible(true);
				panelRegistro.btBut1.addActionListener(this);
				but1JaApertado = true;
			}
			if (but1JaApertado == true) {
				// Efetuar registro
				if (e.getSource().equals(panelRegistro.btBut1)) {
					String atrib1 = panelRegistro.tfField1.getText();
					String atrib2 = panelRegistro.tfField2.getText();
					if (panelRegistro.cbBox1.isSelected()) {
						ContaPremium newConta = new ContaPremium(0, atrib1, atrib2);
						
						if (!UtilMethods.isUserAlreadyInData(atrib1, contasSistema)) {
							contasSistema.add(newConta);
							fileManager.write(newConta);
						} else {
							System.out.println("j� existe esse user1");
						}

					} else {
						ContaNormal newConta = new ContaNormal(0, atrib1, atrib2);

						if (!UtilMethods.isUserAlreadyInData(atrib1, contasSistema)) {
							contasSistema.add(newConta);
							fileManager.write(newConta);
						} else {
							System.out.println("j� existe esse user2");
						}

					}

					panelRegistro.setVisible(false);

				}
			}
			if (but0JaApertado == true) {
				// Efetuar Login
				if (e.getSource().equals(panelLogin.btLoginButton)) {
					String fieldUser = panelLogin.tfUserField.getText();
					String fieldPass = panelLogin.tfPassWordField.getText();
					boolean ok = UtilMethods.autentica(fieldUser, fieldPass, contasSistema);
					if (ok == true) {
						JOptionPane.showMessageDialog(null, "Login Aceito", "Abrindo �rea do cliente...",
								JOptionPane.PLAIN_MESSAGE);

						try {
							usuarioLogado = UtilMethods.getContaByUser(fieldUser, contasSistema);
						} catch (UserNotFoundException err) {
							System.err.println(err.getMessage());
						}
						clientePanel = new AreaCliente();
						if (usuarioLogado.isPremium()) {
							clientePanel.setTitle(usuarioLogado.getUsuario() + "(Conta Premium)");
						} else {
							clientePanel.setTitle(usuarioLogado.getUsuario() + "(Conta Normal)");
						}

						clientePanel.pnLabelsPan.label2.setText(Double.toString(usuarioLogado.getSaldo()) + "R$");
						clientePanel.btDepositButton.addActionListener(this);
						clientePanel.btResgateButton.addActionListener(this);
						clientePanel.btExitButton.addActionListener(this);
						clientePanel.btInvestButton.addActionListener(this);
						clientePanel.btMyInvestButton.addActionListener(this);
						clientePanel.btRefreshButton.addActionListener(this);
						clientePanel.btSimButton.addActionListener(this);

						clientePanel.setSize(375, 250);
						clientePanel.setVisible(true);
						loginEfetuado = true;
						// Botao sair loginCorreto = false, usuarioLogado = null
						// Botao refresh saldo = usuarioLogado.saldo...
					} else {
						JOptionPane.showMessageDialog(null, "Login Incorreto", "ERRO!", JOptionPane.ERROR_MESSAGE);

					}
					panelLogin.setVisible(false);
				}
			}
			if (loginEfetuado == true) {
				// Caso botao depositar seja apertado
				if (e.getSource().equals(clientePanel.btDepositButton)) {
					try {
						Double valor = Double.parseDouble(JOptionPane.showInputDialog(null,
								"Digite o valor que deseja depositar", "Deposit", JOptionPane.PLAIN_MESSAGE));
						usuarioLogado.creditar(valor);
           
						clientePanel.pnLabelsPan.label2.setText(usuarioLogado.getSaldo() + "R$");	
					} catch (Exception e2) {
						// TODO: handle exception
						System.err.println(e2.getMessage());
					}
					fileManager.update(usuarioLogado);
				}
				// Caso botao investir seja apertado
				if (e.getSource().equals(clientePanel.btInvestButton)) {
					// Abrir nova janela listando os investimentos disponiveis(com respectivas
					// rentabilidades) com a botao investir
					areaInvestir = new InvestGUI();
					areaInvestir.setSize(500, 500);
					areaInvestir.setVisible(true);
					for (int i = 0; i < 4; i++) {
						areaInvestir.btnInvestirButton[i].addActionListener(this);
					}
					investPanelIsRunning = true;
					fileManager.update(usuarioLogado);
				}
				// Caso botao atualizar seja apertado
				if (e.getSource().equals(clientePanel.btRefreshButton)) {
					clientePanel.pnLabelsPan.label2.setText(usuarioLogado.getSaldo() + "R$");
					fileManager.update(usuarioLogado);
				}
				// Caso botao meus investimentos seja apertado
				if (e.getSource().equals(clientePanel.btMyInvestButton)) {
					// Abrir uma janela mostrando os investimentos e os valores neles
					// Mostrar patrimonio total = valor investido + saldo disponive
					MeusInvestPanel panel = new MeusInvestPanel(usuarioLogado);
					panel.setSize(500, 500);
					panel.setVisible(true);
					
				}
				// Caso botao resgate seja apertado
				if (e.getSource().equals(clientePanel.btResgateButton)) {
					if (usuarioLogado.getSaldo() > 0) {
						Double valor = Double.parseDouble(JOptionPane.showInputDialog(null,
								"Digite o valor que deseja resgatar", "Resgate", JOptionPane.PLAIN_MESSAGE));
						if (valor <= usuarioLogado.getSaldo()) {
							usuarioLogado.debitar(valor);
             
							clientePanel.pnLabelsPan.label2.setText(usuarioLogado.getSaldo() + "R$");
						} else {
							JOptionPane.showMessageDialog(null,
									"O valor que deseja resgatar � maior que o seu saldo dispon�vel.", "ERRO!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					 fileManager.update(usuarioLogado);
					 fileManager.update(usuarioLogado);
				}
				// Caso botao simular investimento seja apertado
				if (e.getSource().equals(clientePanel.btSimButton)) {
					// C�digo para simular investimento
				}

				// Caso botao sair seja apertado
				if (e.getSource().equals(clientePanel.btExitButton)) {
					clientePanel.setVisible(false);
					fileManager.update(usuarioLogado);
					usuarioLogado = null;
					loginEfetuado = false;
					 
				}

				// Dentro do invest panel
				/*
				 * new TDPR(), new FIM(), new CDB(), new LCI(),
				 */
				if (investPanelIsRunning == true) {
					try {

						if (e.getSource().equals(areaInvestir.btnInvestirButton[0])) {
							double valor = Double.parseDouble(
									JOptionPane.showInputDialog(null, "Digite a quantidade que deseja investir",
											"Efetuar Investimento", JOptionPane.PLAIN_MESSAGE));
							if (valor < usuarioLogado.getSaldo()) {

								TDPR invest = new TDPR(valor);
								usuarioLogado.efetuarInvest(valor, invest);
							}
							int a = JOptionPane.showConfirmDialog(null, "Deseja continuar investindo?");
							if (a == 1) {
								areaInvestir.setVisible(false);
								investPanelIsRunning = false;
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
						System.err.println(e2.getMessage());
					}

					if (e.getSource().equals(areaInvestir.btnInvestirButton[1])) {
						try {

							double valor = Double.parseDouble(
									JOptionPane.showInputDialog(null, "Digite a quantidade que deseja investir",
											"Efetuar Investimento", JOptionPane.PLAIN_MESSAGE));
							if (valor < usuarioLogado.getSaldo()) {

								FIM invest = new FIM(valor);
								usuarioLogado.efetuarInvest(valor, invest);
							}
							int a = JOptionPane.showConfirmDialog(null, "Deseja continuar investindo?");
							if (a == 1) {
								areaInvestir.setVisible(false);
								investPanelIsRunning = false;
							}
						} catch (Exception e2) {
							System.err.println(e2.getMessage());
						}

					}
					if (e.getSource().equals(areaInvestir.btnInvestirButton[2])) {
						try {
							double valor = Double.parseDouble(
									JOptionPane.showInputDialog(null, "Digite a quantidade que deseja investir",
											"Efetuar Investimento", JOptionPane.PLAIN_MESSAGE));
							if (valor < usuarioLogado.getSaldo()) {

								CDB invest = new CDB(valor);
								usuarioLogado.efetuarInvest(valor, invest);
							}
							int a = JOptionPane.showConfirmDialog(null, "Deseja continuar investindo?");
							if (a == 1) {
								areaInvestir.setVisible(false);
								investPanelIsRunning = false;
							}
						} catch (Exception e2) {
							// TODO: handle exception
							System.err.println(e2.getMessage());
						}

					}
					if (e.getSource().equals(areaInvestir.btnInvestirButton[3])) {
						try {
							double valor = Double.parseDouble(
									JOptionPane.showInputDialog(null, "Digite a quantidade que deseja investir",
											"Efetuar Investimento", JOptionPane.PLAIN_MESSAGE));
							if (valor < usuarioLogado.getSaldo()) {

								LCI invest = new LCI(valor);
								usuarioLogado.efetuarInvest(valor, invest);

							}
							int a = JOptionPane.showConfirmDialog(null, "Deseja continuar investindo?");
							if (a == 1) {
								areaInvestir.setVisible(false);
								investPanelIsRunning = false;
							}
						} catch (Exception except) {
							// TODO: handle exception
							System.err.println(except.getMessage());
						}

					}
					 fileManager.update(usuarioLogado);
					clientePanel.pnLabelsPan.label2.setText(usuarioLogado.getSaldo() + "R$");
				}
			}
		}

	}

	public static void main(String[] args) {
	
		MainClass app = new MainClass();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(200, 150);
		app.setVisible(true);
	}
}
