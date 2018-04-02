package Stock;


/**
 * Signals validation exception in stock list CLI.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
class StockListCliValidationException extends Exception
{
	/**
	 * {@inheritDoc}
	 */
	StockListCliValidationException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
