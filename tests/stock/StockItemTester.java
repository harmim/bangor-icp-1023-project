package stock;


/**
 * StockItem tester.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public class StockItemTester
{
	public static void main(String[] args)
	{
		System.out.println("StockItem testing\n");


		System.out.println("Test No 1 - Creating StockItem using constructor and test toString method.");
		StockItem item = new StockItem("AB123", "Test item.", 20.0, 10, 1);
		System.out.println(
			"Expected output: " +
			"Stock.StockItem{itemId='AB123', itemDesc='Test item.', price=20.0, quantity=10, reOrderLevel=1}"
		);
		System.out.println("Actual output:   " + item);


		System.out.println("\nTest No 2 - Obtain ID using getItemId method.");
		System.out.println("Expected output: AB123");
		System.out.println("Actual output:   " + item.getItemId());


		System.out.println("\nTest No 3 - Obtain description using getItemDesc method.");
		System.out.println("Expected output: Test item.");
		System.out.println("Actual output:   " + item.getItemDesc());


		System.out.println(
			"\nTest No 4 - Change price using setPrice method and obtain new price using getPrice method."
		);
		item.setPrice(100.0);
		System.out.println("Expected output: 100.0");
		System.out.println("Actual output:   " + item.getPrice());


		System.out.println(
			"\nTest No 5 - Change quantity using setQuantity method and obtain new quantity using getQuantity method."
		);
		item.setQuantity(20);
		System.out.println("Expected output: 20");
		System.out.println("Actual output:   " + item.getQuantity());


		System.out.println(
			"\nTest No 6 - Change level at which to re-order using setReOrderLevel method and obtain new level " +
			"at which to re-order using getReOrderLevel method."
		);
		item.setReOrderLevel(5);
		System.out.println("Expected output: 5");
		System.out.println("Actual output:   " + item.getReOrderLevel());


		System.out.println("\nTest No 7 - Test format method.");
		System.out.println("Expected output: AB123   Test item.                 100.0000       20              5");
		System.out.println("Actual output:   " + item.format());
	}
}
