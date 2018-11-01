
public class FIM extends Investimento {
	public String nome = "Fundo de investimento multi-mercado";
	public double rentabilidadeAA = 15.03;
	public double taxaAdm = 1.5;
	public FIM() {
		this.setNome(nome);
		this.setRentabilidadeAA(rentabilidadeAA);
		this.setTaxaAdm(taxaAdm);
	}
	public FIM(double valor) {
		this.setNome(nome);
		this.setRentabilidadeAA(rentabilidadeAA);
		this.setTaxaAdm(taxaAdm);
		this.setValorInvestimento(valor);
	}
	
}
