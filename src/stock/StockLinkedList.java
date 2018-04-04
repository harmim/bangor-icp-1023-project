package stock;


import java.io.*;
import java.util.LinkedList;
import java.util.function.Predicate;


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
	private LinkedList<StockItem> list = new LinkedList<>();

	/**
	 * File name of file for loading and saving data.
	 */
	private String filename = null;


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addItem(StockItem item) throws StockListIllegalStateException
	{
		try {
			getItemById(item.getItemId());
			throw new StockListIllegalStateException("Item ID: " + item.getItemId() + " is already present in list.");
		} catch (StockListIllegalArgumentException e) {
			list.addLast(item);
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteItem(String itemId) throws StockListIllegalArgumentException
	{
		if (!list.removeIf(item -> item.getItemId().equals(itemId))) {
			throw new StockListIllegalArgumentException("Item ID: " + itemId + " is not present in list.");
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateItemPrice(String itemId, double price) throws StockListIllegalArgumentException
	{
		getItemById(itemId).setPrice(price);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateItemQuantity(String itemId, int quantity) throws StockListIllegalArgumentException
	{
		getItemById(itemId).setQuantity(quantity);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateReOrderLevel(String itemId, int reOrderLevel) throws StockListIllegalArgumentException
	{
		getItemById(itemId).setReOrderLevel(reOrderLevel);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String formatStockList()
	{
		return getStockListHeader() + getFormattedList(item -> true);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String formatReOrderList()
	{
		return getStockListHeader() + getFormattedList(item -> item.getQuantity() < item.getReOrderLevel());
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean loadStockData(String filename)
	{
		try (
			FileInputStream fileStream = new FileInputStream(new File(filename));
			ObjectInputStream objectStream = new ObjectInputStream(fileStream)
		) {
			list = (LinkedList<StockItem>) objectStream.readObject();
			this.filename = filename;
			return true;

		} catch (FileNotFoundException e) {
			System.out.println("File for load data has not been found.\n");

		} catch (EOFException e) {
			list = new LinkedList<>();
			this.filename = filename;
			return true;

		} catch (IOException | NullPointerException e) {
			System.out.println("I/0 error occurred during loading data from a file.\n");

		} catch (ClassNotFoundException | ClassCastException e) {
			System.out.println("Unable to load data from a file, input file is probably damaged.\n");
		}

		return false;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean saveStockData()
	{
		try (
			FileOutputStream fileStream = new FileOutputStream(new File(filename));
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)
		) {
			objectStream.writeObject(list);
			return true;

		} catch (NullPointerException e) {
			System.out.println("File for save data has not been specified.\n");

		} catch (FileNotFoundException e) {
			System.out.println("File for save data has not been found.\n");

		} catch (IOException e) {
			System.out.println("I/O error occurred during saving stock data to a file.\n");
		}

		return false;
	}


	/**
	 * Returns item in list by it's ID.
	 *
	 * @param itemId ID of item
	 * @return item in list by it's ID
	 *
	 * @throws StockListIllegalArgumentException if item with provided item ID is not present in list
	 */
	private StockItem getItemById(String itemId) throws StockListIllegalArgumentException
	{
		for (StockItem item : list) {
			if (item.getItemId().equals(itemId)) {
				return item;
			}
		}

		throw new StockListIllegalArgumentException("Item ID: " + itemId + " is not present in list.");
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


	/**
	 * Returns formatted stock list.
	 *
	 * @param filter stock items filter
	 * @return formatted stock list
	 */
	private String getFormattedList(Predicate<StockItem> filter)
	{
		StringBuilder formattedList = new StringBuilder();
		for (StockItem item : list) {
			if (filter.test(item)) {
				formattedList.append('\n').append(item.format());
			}
		}

		return formattedList.toString();
	}
}
