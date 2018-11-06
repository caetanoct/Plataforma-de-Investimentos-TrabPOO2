import java.util.ArrayList;

public class UtilMethods {
	public static boolean autentica(String usuario, String senha, ArrayList<Conta> contasSistema) {
		for (Conta c : contasSistema) {
			if (c.getUsuario().equals(usuario) && c.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}
	public static boolean isUserAlreadyInData(String usuario, ArrayList<Conta> contasSistema) {
		for(Conta c : contasSistema) {
			if(c.getUsuario().equals(usuario)) {
				return true;
			}
		}
		return false;
	}
	public static Conta getContaByUser (String usuario, ArrayList<Conta> contasSistema) throws UserNotFoundException {
		for(Conta c : contasSistema) {
			if(c.getUsuario().equals(usuario)) {
				return c;
			}
		}
		throw new UserNotFoundException("User not found");
	} 
	
	public static double getTotalInvestidoEm(Investimento i, ArrayList<Investimento> arrayInvest) {
		double valorTotal = 0;
		for(Investimento in: arrayInvest) {
			if(i.getNome().equals(in.getNome())) {
				valorTotal += in.getValorInvestimento();
			}
		}
		return valorTotal;
	}
}
