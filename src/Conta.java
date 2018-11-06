import java.util.ArrayList;
import java.io.Serializable;

public abstract class Conta implements Serializable {
	

	abstract void creditar(double valor);
	abstract void debitar(double valor);
	abstract  void efetuarInvest(double valor, Investimento tipoInvest);
	abstract public double getSaldo();
	abstract public void setSaldo(double saldo);
	abstract public boolean isPremium();
	abstract public String getUsuario();

	abstract public void setUsuario(String usuario);

	abstract public String getSenha();

	abstract public void setSenha(String senha);

	abstract public ArrayList<Investimento> getInvestimentos();

	abstract public void setInvestimentos(ArrayList<Investimento> investimentos);
	abstract public double getValorCarteira();
}
