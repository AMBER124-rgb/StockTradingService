package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Stocks implements Serializable {

	private String stockId;
	private String stockName;
	private String companyName;
	private double price;
	private LocalDate closingDate;
	private int quantity;

	public Stocks(String stockId, String stockName, String companyName, double price, LocalDate closingDate,
			int quantity) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.companyName = companyName;
		this.price = price;
		this.closingDate = closingDate;
		this.quantity = quantity;
	}

	public Stocks(String stockId) {
		super();
		this.stockId = stockId;
	}

	@Override
	public String toString() {
		return "Stocks [stockId=" + stockId + ", stockName=" + stockName + ", companyName=" + companyName + ", price="
				+ price + ", closingDate=" + closingDate + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(closingDate, companyName, price, quantity, stockId, stockName);
	}

	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Stocks other = (Stocks) obj;
//		return Objects.equals(closingDate, other.closingDate) && Objects.equals(companyName, other.companyName)
//				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
//				&& Objects.equals(stockId, other.stockId) && Objects.equals(stockName, other.stockName);
		System.out.println("In stock equals");
		if (obj instanceof Stocks) {
			return this.getStockId().equals(((Stocks) obj).getStockId());
		}
		return false;

	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
