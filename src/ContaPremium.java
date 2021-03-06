import java.util.ArrayList;
import java.io.Serializable;

public class ContaPremium extends Conta implements Carteira, Serializable {
	
	private double saldo;
	private String usuario;
	private String senha;
	private ArrayList<Investimento> investimentos = new ArrayList<>();
	public final boolean pagaTaxa = false;
	
	public ContaPremium(double saldo, String usuario, String senha) {
		this.saldo = saldo;
		this.usuario = usuario;
		this.senha = senha;
	}
	public boolean isPremium() {
		return true;
	}
	@Override
	public double getValorCarteira() {
		double valor = saldo;
		for(Investimento i: investimentos) {
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
}
