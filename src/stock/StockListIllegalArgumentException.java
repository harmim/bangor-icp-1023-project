package stock;


/**
 * Signals illegal argument in StockItem methods.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public class StockListIllegalArgumentException extends Exception
{
	/**
	 * {@inheritDoc}
	 */
	StockListIllegalArgumentException(String message)
	{
		super(message);
	}
}
