package Stock;


import java.util.LinkedList;


/**
 * Implementation of StockList using linked list.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public class StockLinkedList implements StockList
{
	/**
	 * Stock list as LinkedList collection.
	 */
	private LinkedList<StockItem> list;


	/**
	 * Creates and initializes stock list.
	 */
	public StockLinkedList()
	{
		list = new LinkedList<>();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItem(StockItem item)
	{
		list.addLast(item);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteItem(String itemId)
	{
		list.removeIf(item -> item.getItemId().equals(itemId));
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateItemPrice(String itemId, double price)
	{
		for (StockItem item : list) {
			if (item.getItemId().equals(itemId)) {
				item.setPrice(price);
				break;
			}
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateItemQuantity(String itemId, int quantity)
	{
		for (StockItem item : list) {
			if (item.getItemId().equals(itemId)) {
				item.setQuantity(quantity);
				break;
			}
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateReOrderLevel(String itemId, int reOrderLevel)
	{
		for (StockItem item : list) {
			if (item.getItemId().equals(itemId)) {
				item.setReOrderLevel(reOrderLevel);
				break;
			}
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String formatStockList()
	{
		StringBuilder formattedList = new StringBuilder(getStockListHeader());
		for (StockItem item : list) {
			formattedList.append('\n').append(item.format());
		}

		return formattedList.toString();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String formatReOrderList()
	{
		StringBuilder formattedList = new StringBuilder(getStockListHeader());
		for (StockItem item : list) {
			if (item.getQuantity() >= item.getReOrderLevel()) {
				continue;
			}
			formattedList.append('\n').append(item.format());
		}

		return formattedList.toString();
	}


	/**
	 * Returns stock list table header for printing stock list out.
	 *
	 * @return stock list table header for printing stock list out
	 */
	private String getStockListHeader()
	{
		String header = String.format(
			"%-7s %-20s %-14s %-8s %-14s\n", "Item ID", "Description", "Price", "Quantity", "Re-order level"
		);
		header += String.format("%07d %020d %014d %08d %014d", 0, 0, 0, 0, 0).replace('0', '*');

		return header;
	}
}
