
public class LCI extends Investimento {
	public String nome = "Letra de Crédito Imobiliário(Renda-Fixa)";
	public double rentabilidadeAA = 8.63;
	public double taxaAdm = 0.8;
	public LCI() {
		this.setNome(nome);
		this.setRentabilidadeAA(rentabilidadeAA);
		this.setTaxaAdm(taxaAdm);
	
	}
	public LCI(double valor) {
		this.setNome(nome);
		this.setRentabilidadeAA(rentabilidadeAA);
		this.setTaxaAdm(taxaAdm);
		this.setValorInvestimento(valor);
	}
}
