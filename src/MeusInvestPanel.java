import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class MeusInvestPanel extends JFrame {
	JLabel patrimonioLabel;
	JLabel invest1Label;
	JLabel invest2Label;
	JLabel invest3Label;
	JLabel invest4Label;
	public MeusInvestPanel(Conta Usuario) {
		
		setLayout(new BorderLayout());
		 ChartPanel chartPanel = new ChartPanel( graficoMeusInvest(Usuario) );
		 JPanel panelPatrimonio = new JPanel();
		 JPanel panelText = new JPanel();
		double valorCarteira = Usuario.getValorCarteira();
		patrimonioLabel = new JLabel("Seu patrimÃ´nio: "+ valorCarteira);
		double investidoEmTDPR = UtilMethods.getTotalInvestidoEm(new TDPR(), Usuario.getInvestimentos());
		double investidoEmFIM = UtilMethods.getTotalInvestidoEm(new FIM(), Usuario.getInvestimentos());
		double investidoEmCDB=	UtilMethods.getTotalInvestidoEm(new CDB(), Usuario.getInvestimentos());
		double investidoEmLCI =UtilMethods.getTotalInvestidoEm(new LCI(), Usuario.getInvestimentos());
		invest1Label = new JLabel("Tesouro Direto: "+investidoEmTDPR+"R$"+" Representa "+String.format("%.2f", (investidoEmTDPR/valorCarteira)*100)+"% do patrimÃ´nio");
		invest2Label = new JLabel("Fundos de Investimento: "+investidoEmFIM+"R$"+" Representa "+String.format("%.2f", (investidoEmFIM/valorCarteira)*100)+"% do patrimÃ´nio");
		invest3Label = new JLabel("Certificados: "+investidoEmCDB+"R$"+" Representa "+String.format("%.2f", (investidoEmCDB/valorCarteira)*100)+"% do patrimÃ´nio");
		invest4Label = new JLabel("Letras de CrÃ©dito: "+investidoEmLCI+"R$"+" Representa "+String.format("%.2f", (investidoEmLCI/valorCarteira)*100)+"% do patrimÃ´nio");
		panelPatrimonio.add(patrimonioLabel);
		panelText.add(invest1Label);
		panelText.add(invest2Label);
		panelText.add(invest3Label);
		panelText.add(invest4Label);
		panelText.setPreferredSize(new Dimension(100,100));
		add(panelPatrimonio, BorderLayout.NORTH);
		add(chartPanel, BorderLayout.CENTER);
		//add(panelText, BorderLayout.SOUTH);
		
	}

	public JFreeChart graficoMeusInvest(Conta Usuario) {
		double valorCarteira = Usuario.getValorCarteira();
		double saldo = Usuario.getSaldo();
		System.out.println(saldo);
		patrimonioLabel = new JLabel("Seu patrimÃ´nio: "+ valorCarteira);
		double investidoEmTDPR = UtilMethods.getTotalInvestidoEm(new TDPR(), Usuario.getInvestimentos());
		double investidoEmFIM = UtilMethods.getTotalInvestidoEm(new FIM(), Usuario.getInvestimentos());
		double investidoEmCDB=	UtilMethods.getTotalInvestidoEm(new CDB(), Usuario.getInvestimentos());
		double investidoEmLCI =UtilMethods.getTotalInvestidoEm(new LCI(), Usuario.getInvestimentos());
		
			DefaultPieDataset dataset = new DefaultPieDataset();
			dataset.setValue(String.format("TDPR( %.2f )",investidoEmTDPR ), new Double(investidoEmTDPR));
			dataset.setValue(String.format("FIM( %.2f )",investidoEmFIM ), new Double(investidoEmFIM));
			dataset.setValue(String.format("CDB( %.2f )",investidoEmCDB ), new Double(investidoEmCDB));
			dataset.setValue(String.format("LCI( %.2f )",investidoEmLCI ), new Double(investidoEmLCI));
			dataset.setValue(String.format("SALDO( %.2f )", saldo), new Double(saldo));
		
		
			JFreeChart chart = ChartFactory.createPieChart(
					"Meus Investimentos",
					dataset,
					true,
					true,
					true);
			
			
			  PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
				        " {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
				    
			  ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
		
		
		
		return chart;
		
	}
	
	
}
