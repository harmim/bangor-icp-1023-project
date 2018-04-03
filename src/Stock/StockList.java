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
	 *
	 * @throws StockListIllegalStateException if item with provided item ID is already present in list
	 */
	void addItem(StockItem item) throws StockListIllegalStateException;


	/**
	 * Removes item from stock list.
	 *
	 * @param itemId ID of item which will be removed from stock list
	 *
	 * @throws StockListIllegalArgumentException if item with provided item ID is not present in list
	 */
	void deleteItem(String itemId) throws StockListIllegalArgumentException;


	/**
	 * Updates price of item in stock list.
	 *
	 * @param itemId ID of item which will be updated
	 * @param price new price to update for
	 *
	 * @throws StockListIllegalArgumentException if item with provided item ID is not present in list
	 */
	void updateItemPrice(String itemId, double price) throws StockListIllegalArgumentException;


	/**
	 * Updates quantity of item in stock list.
	 *
	 * @param itemId ID of item which will be updated
	 * @param quantity new quantity to update for
	 *
	 * @throws StockListIllegalArgumentException if item with provided item ID is not present in list
	 */
	void updateItemQuantity(String itemId, int quantity) throws StockListIllegalArgumentException;


	/**
	 * Updates re-order level of item in stock list.
	 *
	 * @param itemId ID of item which will be updated
	 * @param reOrderLevel new re-order level to update for
	 *
	 * @throws StockListIllegalArgumentException if item with provided item ID is not present in list
	 */
	void updateReOrderLevel(String itemId, int reOrderLevel) throws StockListIllegalArgumentException;


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


	/**
	 * Loads data from the stock file into the stock list.
	 *
	 * @param filename file name from which date will be loaded
	 * @return true if data has been successfully loaded, false otherwise
	 */
	boolean loadStockData(String filename);


	/**
	 * Saves data from stock list to file specified in {@code loadStockData} invocation.
	 * Invocation of {@code saveStockData} must prevent {@code loadStockData} invocation.
	 *
	 * @return true if data has been successfully saved, false otherwise
	 */
	boolean saveStockData();
}
