import java.io.Serializable;

public abstract class Investimento implements Serializable {
	public String nome;
	public double rentabilidadeAA;
	public double taxaAdm;
	private double valorInvestimento;
	
	public double getRentabilidadeAA() {
		return rentabilidadeAA;
	}

	public double getTaxaAdm() {
		return taxaAdm;
	}
	
	public double getValorInvestimento() {
		return valorInvestimento;
	}
	public void setRentabilidadeAA(double rentabilidadeAA) {
		this.rentabilidadeAA = rentabilidadeAA;
	}

	public void setTaxaAdm(double taxaAdm) {
		this.taxaAdm = taxaAdm;
	}

	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
