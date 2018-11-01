import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InvestGUI extends JFrame {
	public static Investimento[] investimentosDisponíveis = {
			new TDPR(),
			new FIM(),
			new CDB(),
			new LCI(),
		};
	public JLabel[] labelNome = new JLabel[4];
	public JLabel[] labelRentabilidade = new JLabel[4];
	public JButton[] btnInvestirButton = new JButton[4];
	public InvestGUI() {
		super();
		setLayout(new GridLayout(4, 3));
		for(int i = 0 ; i < 4 ; i++) {
			labelNome[i] = new JLabel(investimentosDisponíveis[i].getNome()) ;
			labelRentabilidade[i] = new JLabel(Double.toString(investimentosDisponíveis[i].getRentabilidadeAA()));
			btnInvestirButton[i] = new JButton("Investir");
			add(labelNome[i]);
			add(labelRentabilidade[i]);
			add(btnInvestirButton[i]);
		}
	}
	/*public static void main(String[] args) {
		TDPR a = new TDPR(12);
		System.out.println(investimentosDisponíveis[1]);
		InvestGUI app = new InvestGUI();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(200, 150);
		app.setVisible(true);
	}*/
}
