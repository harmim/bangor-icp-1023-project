package Stock;


/**
 * Signals illegal state of StockItem.
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
