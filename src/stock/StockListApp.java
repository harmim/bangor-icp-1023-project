package stock;


/**
 * Entry point to stock list application.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public class StockListApp
{
	public static void main(String[] args)
	{
		StockList list = new StockLinkedList();
		if (args.length >= 1) {
			list.loadStockData(args[0]);
		}

		new StockListCli(list).run();
	}
}
