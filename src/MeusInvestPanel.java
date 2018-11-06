import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MeusInvestPanel extends JFrame {
	JLabel patrimonioLabel;
	JLabel invest1Label;
	JLabel invest2Label;
	JLabel invest3Label;
	JLabel invest4Label;
	public MeusInvestPanel(Conta Usuario) {
		
		setLayout(new GridLayout(5, 1));
		double valorCarteira = Usuario.getValorCarteira();
		patrimonioLabel = new JLabel("Seu patrimônio: "+ valorCarteira);
		double investidoEmTDPR = UtilMethods.getTotalInvestidoEm(new TDPR(), Usuario.getInvestimentos());
		double investidoEmFIM = UtilMethods.getTotalInvestidoEm(new FIM(), Usuario.getInvestimentos());
		double investidoEmCDB=	UtilMethods.getTotalInvestidoEm(new CDB(), Usuario.getInvestimentos());
		double investidoEmLCI =UtilMethods.getTotalInvestidoEm(new LCI(), Usuario.getInvestimentos());
		invest1Label = new JLabel("Tesouro Direto: "+investidoEmTDPR+"R$"+" Representa "+String.format("%.2f", (investidoEmTDPR/valorCarteira)*100)+"% do patrimônio");
		invest2Label = new JLabel("Fundos de Investimento: "+investidoEmFIM+"R$"+" Representa "+String.format("%.2f", (investidoEmFIM/valorCarteira)*100)+"% do patrimônio");
		invest3Label = new JLabel("Certificados: "+investidoEmCDB+"R$"+" Representa "+String.format("%.2f", (investidoEmCDB/valorCarteira)*100)+"% do patrimônio");
		invest4Label = new JLabel("Letras de Crédito: "+investidoEmLCI+"R$"+" Representa "+String.format("%.2f", (investidoEmLCI/valorCarteira)*100)+"% do patrimônio");
		add(patrimonioLabel);
		add(invest1Label);
		add(invest2Label);
		add(invest3Label);
		add(invest4Label);
	}

}
