package stock;


import java.io.Serializable;


/**
 * Representation of item in stock.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public class StockItem implements Serializable
{
	/**
	 * Item ID. Five alpha-numeric characters.
	 */
	private String itemId;

	/**
	 * Item description.
	 */
	private String itemDesc;

	/**
	 * Item price in pounds sterling.
	 */
	private double price;

	/**
	 * Quantity of item in stock.
	 */
	private int quantity;

	/**
	 * Level at which to re-order.
	 */
	private int reOrderLevel;


	/**
	 * Creates stock item and initializes it's instance variables.
	 *
	 * @param itemId item ID, five alpha-numeric characters
	 * @param itemDesc item description
	 * @param price item price in pounds
	 * @param quantity quantity of item in stock
	 * @param reOrderLevel level at which to re-order
	 */
	public StockItem(String itemId, String itemDesc, double price, int quantity, int reOrderLevel)
	{
		this.itemId = itemId;
		this.itemDesc = itemDesc;
		this.price = price;
		this.quantity = quantity;
		this.reOrderLevel = reOrderLevel;
	}


	/**
	 * Returns item ID.
	 *
	 * @return item ID
	 */
	public String getItemId()
	{
		return itemId;
	}


	/**
	 * Returns item description.
	 *
	 * @return item description
	 */
	public String getItemDesc()
	{
		return itemDesc;
	}


	/**
	 * Returns item price in pounds.
	 *
	 * @return item price in pounds
	 */
	public double getPrice()
	{
		return price;
	}


	/**
	 * Sets item price.
	 *
	 * @param price item price in pounds
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}


	/**
	 * Returns item quantity in stock.
	 *
	 * @return item quantity in stock
	 */
	public int getQuantity()
	{
		return quantity;
	}


	/**
	 * Sets item quantity in stock.
	 *
	 * @param quantity item quantity in stock
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}


	/**
	 * Returns level at which to re-order.
	 *
	 * @return level at which to re-order
	 */
	public int getReOrderLevel()
	{
		return reOrderLevel;
	}


	/**
	 * Sets level at which to re-order.
	 *
	 * @param reOrderLevel level at which to re-order
	 */
	public void setReOrderLevel(int reOrderLevel)
	{
		this.reOrderLevel = reOrderLevel;
	}


	/**
	 * Returns formatted string representation of stock item.
	 *
	 * @return formatted string representation of stock item
	 */
	public String format()
	{
		return String.format("%-7s %-20s %14.4f %8d %14d", itemId, itemDesc, price, quantity, reOrderLevel);
	}


	/**
	 * Returns string representation of stock item.
	 *
	 * @return string representation of stock item
	 */
	@Override
	public String toString()
	{
		return getClass().getName() + '{' +
			"itemId='" + itemId + '\'' +
			", itemDesc='" + itemDesc + '\'' +
			", price=" + price +
			", quantity=" + quantity +
			", reOrderLevel=" + reOrderLevel +
			'}';
	}
}
