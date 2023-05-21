package tester;

import static utils.CollectionUtils.populateStocksList;
import static validataions.ValidationRules.checkForDuplicate;
import static validataions.ValidationRules.checkForclosingdate;
import static validataions.ValidationRules.checkForStockandQuantityforSellStock;
import static validataions.ValidationRules.checkForStockandQuantityforPurchaseStock;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import static utils.IOUtils.storeStockList;
import static utils.IOUtils.restoreStockList;
import com.app.core.Stocks;

public class StockTrading {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<Stocks> stockList = populateStocksList();
			boolean exit = false;
			while (!exit) {

				System.out.println("Menu : 1.Add 5 samplestocks in beggining. \n" + "2.Add new stock \n"
						+ "3.View Available stocks by company \n" + "4. Purchase stocks \n" + "5.Sell stocks \n"
						+ "6.Serialization \n 7.DeSerialization 8.EXit");
				System.out.println("Select your option");

				try {

					switch (sc.nextInt()) {
					case 1:// Add 5 samplestocks in beggining
						for (Stocks s : stockList)
							System.out.println(s);

						break;
					case 2:// Add new stock
							// String stockId, String stockName, String companyName, double price, LocalDate
							// closingDate,
							// int quantity
						System.out.println(
								"Enter Stock details: stockId,stockName,companyName,price,closingDate,quantity");
						String stockID = checkForDuplicate(stockList, sc.next());
						String stockName = sc.next();
						String comapString = sc.next();
						double price = sc.nextDouble();
						LocalDate date = checkForclosingdate(stockList, sc.next());
						int quantity = sc.nextInt();
						new Stocks(stockID, stockName, comapString, price, date, quantity);
						System.out.println("Stock has been added successfully!!!");

						break;
					case 3:// View Available stocks by company
						System.out.println("Enter company name");
						String compname = sc.next();
						for (Stocks s : stockList) {
							if (s.getCompanyName().equals(compname))
								System.out.println(s);

						}
						break;
					case 4:// Purchase stocks
						System.out.println("Enter StockId and quantity ");
						String stockId = checkForStockandQuantityforPurchaseStock(stockList, sc.next(), sc.nextInt());

						break;
					case 5:// Sell stocks
						System.out.println("Enter StockId and quantity ");
						String stockId3 = checkForStockandQuantityforSellStock(stockList, sc.next(), sc.nextInt());

						break;
					case 6:// Serialization
						System.out.println("Enter filename");
						storeStockList(stockList, sc.next());
						System.out.println("Serialization done");

						break;

					case 7:// DeSerialization
						System.out.println("Enter filename ,to restore data!!");
						List<Stocks> deSerList = restoreStockList(sc.next());
						System.out.println("De Serialization done");
						deSerList.forEach(s -> {
							System.out.println(s);
						});

					case 8:
						exit = true;

					default:
						System.out.println("Invalid choice selection!!");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
