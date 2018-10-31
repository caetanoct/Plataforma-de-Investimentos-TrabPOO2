import java.util.ArrayList;

public final class SingletonSistema {
	private static final SingletonSistema sistema = new SingletonSistema();

	private SingletonSistema() {
		System.err.println("Singleton object created");
	}

	public static SingletonSistema getInstance() {
		return sistema;
	}
	
}
