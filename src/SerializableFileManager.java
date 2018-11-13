import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class SerializableFileManager {
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private ArrayList<Conta> array;

	public SerializableFileManager() {
		File file = new File("contas.ser");
		array = new ArrayList<Conta>();
		if (!file.exists() || file.length() == 0) {
			openOutputFile();
			closeOutputFile();
		} else {
			array = read();
		}
	}

	public void openInputFile() {
		try {
			input = new ObjectInputStream(new FileInputStream("contas.ser"));
		} catch (IOException e) {
			System.err.println("Error opening file");
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Conta> readInput() {
		try {
			return (ArrayList<Conta>) input.readObject();
		} catch (EOFException e) {
			return array;
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Unable to create object.");
		} catch (IOException ioException) {
			System.err.println("Error reading from file.");
			ioException.printStackTrace();
		}

		return array;
	}

	public void closeInputFile() {
		try {
			if (input != null) {
				input.close();
			}
		} catch (IOException e) {
			System.err.println("Error closing file");
			System.exit(1);
		}
	}

	public void openOutputFile() {
		try {
			output = new ObjectOutputStream(new FileOutputStream("contas.ser"));
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
		}
	}

	public void closeOutputFile() {
		try {
			if (output != null) {
				output.close();
			}
		} catch (IOException e) {
			System.err.println("Error closing file");
			System.exit(1);
		}
	}

	public ArrayList<Conta> read() {
		openInputFile();
		ArrayList<Conta> arr = readInput();
		closeInputFile();
		return arr;
	}
	
	public void writeToFile(ArrayList<Conta> contas) {
		try {
			output.writeObject(contas);
		} catch (IOException e) {
			System.err.println("Error writing to file");
		}
	}
	
	public void write(ArrayList<Conta> contas) {
		openOutputFile();
		writeToFile(contas);
		closeOutputFile();
	}
}
