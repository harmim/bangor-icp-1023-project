package Stock;


/**
 * Entry point to stock list application.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public class StockListApp
{
	public static void main(String[] args)
	{
		new StockListCli(new StockLinkedList()).run();
	}
}
