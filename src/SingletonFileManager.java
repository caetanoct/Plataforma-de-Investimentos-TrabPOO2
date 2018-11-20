import java.util.ArrayList;

public final class SingletonFileManager {
	private static final SerializableFileManager sistema = new SerializableFileManager();

	private SingletonFileManager() {
		System.err.println("Singleton object created");
	}

	public static SerializableFileManager getInstance() {
		return sistema;
	}
	
}
