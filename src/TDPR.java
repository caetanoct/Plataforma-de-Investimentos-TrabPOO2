
public class TDPR extends Investimento {
	public  String nome = "Tesouro direto pré-fixado";
	public  double rentabilidadeAA = 10.1;
	public  double taxaAdm = 1.5;
	public TDPR() {
		this.setNome(nome);
		this.setRentabilidadeAA(rentabilidadeAA);
		this.setTaxaAdm(taxaAdm);
	}
	public TDPR(double valor) {
		this.setNome(nome);
		this.setRentabilidadeAA(rentabilidadeAA);
		this.setTaxaAdm(taxaAdm);
		this.setValorInvestimento(valor);
	}
}
