package stock;


/**
 * Signals illegal state of StockItem.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public class StockListIllegalStateException extends Exception
{
	/**
	 * {@inheritDoc}
	 */
	StockListIllegalStateException(String message)
	{
		super(message);
	}
}
