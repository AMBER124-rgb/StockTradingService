package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Stocks;

public class IOUtils {

	public static void storeStockList(List<Stocks> stockList, String fileName) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(stockList);

		}
	}

	@SuppressWarnings("unchecked")
	public static List<Stocks> restoreStockList(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException {

		File testFile = new File(fileName);
		if (testFile.isFile() && testFile.canRead()) {

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
				return (List<Stocks>) ois.readObject();

			}
		}
		return new ArrayList<>();

	}

}
