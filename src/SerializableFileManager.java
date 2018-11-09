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

//	public void writeToFile(Conta obj) {
//		System.out.println("Array length before write "+array.size());
//		array.add(obj);
//		System.out.println("Array length2 after write "+array.size());
//		try {
//			output.writeObject(array);
//		} catch (IOException e) {
//			System.err.println("Error writing to file");
//		}
//	}

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

//	public void write(Conta obj) {
//		openOutputFile();
//		writeToFile(obj);
//		closeOutputFile();
//	}
	
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

//	public void update(Conta conta) {
//		try {
//			Conta c = UtilMethods.getContaByUser(conta.getUsuario(), array);
//			for (Conta c1 : array) {
//				if (c.getUsuario().equals(c1.getUsuario())) {
//					System.out.printf("Conta removida: %.2f, %s, %s", c1.getSaldo(), c1.getUsuario(), c1.getSenha() + "\n\n");
//					array.remove(c1);
//				}
//			}
//			System.out.println("Array length after update " +array.size());
//		} catch (UserNotFoundException e) {
//			System.err.println("User not found");
//		} catch(ConcurrentModificationException e) {
//			System.err.println("1");
//		}finally {
//			write(conta);
//		}
//	}
	
	public void update(ArrayList<Conta> contas) {
		write(contas);
	}
}
