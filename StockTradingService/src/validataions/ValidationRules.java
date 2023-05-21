package validataions;

import java.time.LocalDate;
import java.util.List;

import com.app.core.Stocks;

import customException.InvalidInputException;

public class ValidationRules {

	public static String checkForDuplicate(List<Stocks> stockList, String stockID) throws InvalidInputException {
		if (stockList.contains(new Stocks(stockID))) {

			throw new InvalidInputException("Duplicate stock id entered!!!");

		}
		return stockID;
	}

	public static LocalDate checkForclosingdate(List<Stocks> stockList, String date) throws InvalidInputException {
		LocalDate indate = LocalDate.parse(date);

		if (indate.isBefore(LocalDate.now())) {
			throw new InvalidInputException("Closing date must be a future date!!!");
		}
		return indate;
	}

	public static String checkForStockandQuantityforPurchaseStock(List<Stocks> stockList, String stockID, int quantity)
			throws InvalidInputException {
		int index = stockList.indexOf(new Stocks(stockID));
		if (index == -1) {
			throw new InvalidInputException("Stock not present or invalid stock id entered!!!");
		} else {
			if (stockList.get(index).getQuantity() > quantity) {
				stockList.get(index).setQuantity(stockList.get(index).getQuantity() - quantity);
				System.out
						.println("Stock Quantity has been successfully updated and new updated details are as follow");

				System.out.println(stockList.get(index));
				return stockID;
			} else
				throw new InvalidInputException("Insufficiant quantity available!!!");
		}

	}

	public static String checkForStockandQuantityforSellStock(List<Stocks> stockList, String stockID, int quantity)
			throws InvalidInputException {
		int index = stockList.indexOf(new Stocks(stockID));
		if (index == -1) {
			throw new InvalidInputException("Stock not present or invalid stock id entered!!!");
		} else {
			if (stockList.get(index).getQuantity() > quantity) {
				stockList.get(index).setQuantity(stockList.get(index).getQuantity() + quantity);
				System.out
						.println("Stock Quantity has been successfully updated and new updated details are as follow");

				System.out.println(stockList.get(index));
				return stockID;
			} else
				throw new InvalidInputException("Insufficiant quantity available!!!");
		}

	}

}
