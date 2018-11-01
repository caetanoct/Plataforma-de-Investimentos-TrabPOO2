
public class CDB extends Investimento {
	public String nome = "Certificado de depósito bancário(Renda-Fixa)";
	public double rentabilidadeAA = 8.3;
	public double taxaAdm = 0.75;
	public CDB() {
		this.setNome(nome);
		this.setRentabilidadeAA(rentabilidadeAA);
		this.setTaxaAdm(taxaAdm);
	}
	public CDB(double valor) {
		this.setNome(nome);
		this.setRentabilidadeAA(rentabilidadeAA);
		this.setTaxaAdm(taxaAdm);
		this.setValorInvestimento(valor);
	}
	
}
