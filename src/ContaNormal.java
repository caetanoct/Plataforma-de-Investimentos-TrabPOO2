import java.util.ArrayList;

public class ContaNormal extends Conta implements Carteira {
	private double saldo;
	private String usuario;
	private String senha;
	private ArrayList<Investimento> investimentos;
	public final boolean pagaTaxa = true;
	public boolean isPremium() {
		return false;
	}
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<Investimento> getInvestimentos() {
		return investimentos;
	}

	public void setInvestimentos(ArrayList<Investimento> investimentos) {
		this.investimentos = investimentos;
	}

	

	public ContaNormal(double saldo, String usuario, String senha) {
		this.senha = senha;

		this.saldo = saldo;
		this.usuario = usuario;

	}

	@Override
	public double getValorCarteira() {
		double valor = saldo;
		for (Investimento i : investimentos) {
			valor = valor + i.getValorInvestimento();
		}
		return valor;
	}

	@Override
	void creditar(double valor) {
		this.saldo += valor;

	}

	@Override
	void debitar(double valor) {
		this.saldo -= valor;

	}

	@Override
	void efetuarInvest(double valor, Investimento tipoInvest) {
		if(valor < saldo) {
			saldo -= valor;
			tipoInvest.setValorInvestimento(valor);
			investimentos.add(tipoInvest);
		}
	}

}
