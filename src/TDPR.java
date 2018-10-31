
public class TDPR extends Investimento {
	public String nome = "Tesouro direto pré-fixado";
	public double rentabilidadeAA = 10.1;
	public double taxaAdm = 1.5;
	public TDPR(double valor) {
		this.setValorInvestimento(valor);
	}
}
