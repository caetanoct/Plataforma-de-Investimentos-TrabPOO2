

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class SimulacaoPanel extends JFrame{

	public SimulacaoPanel(Conta Usuario) {
		setLayout(new GridLayout(1,1));
		 ChartPanel chartPanel = new ChartPanel( criaGrafico(Usuario) );
		 add(chartPanel);
	}
	
	public JFreeChart criaGrafico(Conta Usuario) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		double investidoEmTDPR = UtilMethods.getTotalInvestidoEm(new TDPR(), Usuario.getInvestimentos());
		double investidoEmFIM  = UtilMethods.getTotalInvestidoEm(new FIM(),  Usuario.getInvestimentos());
		double investidoEmCDB  = UtilMethods.getTotalInvestidoEm(new CDB(),  Usuario.getInvestimentos());
		double investidoEmLCI  = UtilMethods.getTotalInvestidoEm(new LCI(),  Usuario.getInvestimentos());
		double rentabilidadeTDPR = (new TDPR().getRentabilidadeAA()/100);
		double rentabilidadeFIM = (new FIM().getRentabilidadeAA()/100);
		double rentabilidadeCDB = (new CDB().getRentabilidadeAA()/100);
		double rentabilidadeLCI = (new LCI().getRentabilidadeAA()/100);
		for(int i = 1; i < 26; i++) {  
			
			// Cria um valor para o dataset a cada ano.
			// Calcula a rentabilidade de cada investimento em 25 anos.
			
			double TDPR = investidoEmTDPR * Math.pow((1 + rentabilidadeTDPR),i);
			//System.out.println("Em ("+ i+") anos em TDPR Montante = "+ TDPR);
			double FIM  = investidoEmFIM  * Math.pow((1 + rentabilidadeFIM),i);
			
			double CDB  = investidoEmCDB  * Math.pow((1 + rentabilidadeCDB),i);
			
			double LCI  = investidoEmLCI  * Math.pow((1 + rentabilidadeLCI),i);
			//System.out.println("Em ("+ i+") anos em LCI Montante = "+ LCI);
			dataset.addValue(TDPR,"TDPR",""+i);
			dataset.addValue(FIM,"FIM",""+i);
			dataset.addValue(CDB,"CDB",""+i); 
			dataset.addValue(LCI,"LCI",""+i);  
			  
		}
		
		JFreeChart lineChart = ChartFactory.createLineChart(
				"Simula��o dos investimentos",
				"Anos","Montante",
				dataset,
				PlotOrientation.VERTICAL,
				true,true,false
				);
			
		return lineChart;
	}
	
	
	
	
	
}