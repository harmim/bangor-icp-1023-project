package Stock;


/**
 * Interface for list of StockItem.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public interface StockList
{
	/**
	 * Adds item to stock list.
	 *
	 * @param item item to be added to stock list
	 */
	void addItem(StockItem item);


	/**
	 * Removes item from stock list.
	 *
	 * @param itemId ID of item which will be removed from stock list
	 */
	void deleteItem(String itemId);


	/**
	 * Updates price of item in stock list.
	 *
	 * @param itemId ID of item which will be updated
	 * @param price new price to update for
	 */
	void updateItemPrice(String itemId, double price);


	/**
	 * Updates quantity of item in stock list.
	 *
	 * @param itemId ID of item which will be updated
	 * @param quantity new quantity to update for
	 */
	void updateItemQuantity(String itemId, int quantity);


	/**
	 * Updates re-order level of item in stock list.
	 *
	 * @param itemId ID of item which will be updated
	 * @param reOrderLevel new re-order level to update for
	 */
	void updateReOrderLevel(String itemId, int reOrderLevel);


	/**
	 * Returns formatted string representation of the stock list.
	 *
	 * @return formatted string representation of the stock list
	 */
	String formatStockList();


	/**
	 * Returns formatted string representation of re-order list.
	 * Items are on this list if {@code quantity < reOrderLevel}.
	 *
	 * @return formatted string representation of re-order list
	 */
	String formatReOrderList();
}
