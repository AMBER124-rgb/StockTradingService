package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.core.Stocks;

public interface CollectionUtils {

	public static List<Stocks> populateStocksList() {
		List<Stocks> stockList = new ArrayList<>();
		stockList.add(new Stocks("123", "APS", "AsianPaints", 150.12, LocalDate.parse("2023-05-22"), 25));
		stockList.add(new Stocks("587", "RIL", "Reliance", 220.36, LocalDate.parse("2023-06-12"), 87));
		stockList.add(new Stocks("248", "HDFC", "HDFC Banks", 97.54, LocalDate.parse("2023-07-30"), 34));
		stockList.add(new Stocks("957", "BA", "Bajaj Auto", 41.75, LocalDate.parse("2023-09-21"), 102));
		stockList.add(new Stocks("364", "TATA", "Tata Motors", 124.26, LocalDate.parse("2023-08-12"), 94));
		stockList.add(new Stocks("957", "AIT", "Bharti Airtel", 234.15, LocalDate.parse("2023-12-08"), 74));
		stockList.add(new Stocks("854", "MS", "AsianPaints", 31.76, LocalDate.parse("2023-11-23"), 50));

		return stockList;
	}
}
