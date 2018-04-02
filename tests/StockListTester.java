import Stock.*;


/**
 * StockLinkedList tester.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
public class StockListTester
{
	public static void main(String[] args)
	{
		System.out.println("StockList testing\n");


		System.out.println(
			"Test No 1 - Creating StockList using constructor and display list using formatStockList method."
		);
		StockList list = new StockLinkedList();
		System.out.println(
			"Expected output:\n" +
			"Item ID Description          Price          Quantity Re-order level\n" +
			"******* ******************** ************** ******** **************"
		);
		System.out.println("Actual output:\n" + list.formatStockList());


		System.out.println(
			"\nTest No 2 - " +
			"Add three items to the list using addItem method and display list using formatStockList method."
		);
		try {
			list.addItem(new StockItem("A1111", "Test 1", 100.0, 10, 5));
			list.addItem(new StockItem("B2222", "Test 2", 200.0, 3, 5));
			list.addItem(new StockItem("C3333", "Test 3", 300.0, 500000, 15));
		} catch (StockListIllegalStateException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Actual output:\n" + list.formatStockList());
		System.out.println(
			"Expected output:\n" +
			"Item ID Description          Price          Quantity Re-order level\n" +
			"******* ******************** ************** ******** **************\n" +
			"A1111   Test 1                     100.0000       10              5\n" +
			"B2222   Test 2                     200.0000        3              5\n" +
			"C3333   Test 3                     300.0000   500000             15\n"
		);


		System.out.println(
			"\nTest No 3 - Update price of one of items in list using updateItemPrice method and display list " +
			"using formatStockList method."
		);
		try {
			list.updateItemPrice("A1111", 150.0);
		} catch (StockListIllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Actual output:\n" + list.formatStockList());
		System.out.println(
			"Expected output:\n" +
			"Item ID Description          Price          Quantity Re-order level\n" +
			"******* ******************** ************** ******** **************\n" +
			"A1111   Test 1                     150.0000       10              5\n" +
			"B2222   Test 2                     200.0000        3              5\n" +
			"C3333   Test 3                     300.0000   500000             15\n"
		);


		System.out.println(
			"\nTest No 4 - Update quantity of one of items in list using updateItemQuantity method and display list " +
			"using formatStockList method."
		);
		try {
			list.updateItemQuantity("B2222", 4);
		} catch (StockListIllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Actual output:\n" + list.formatStockList());
		System.out.println(
			"Expected output:\n" +
				"Item ID Description          Price          Quantity Re-order level\n" +
				"******* ******************** ************** ******** **************\n" +
				"A1111   Test 1                     150.0000       10              5\n" +
				"B2222   Test 2                     200.0000        4              5\n" +
				"C3333   Test 3                     300.0000   500000             15\n"
		);


		System.out.println(
			"\nTest No 5 - Update re-order level of one of items in list using updateReOrderLevel method and " +
			"display list using formatStockList method."
		);
		try {
			list.updateReOrderLevel("C3333", 10);
		} catch (StockListIllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Actual output:\n" + list.formatStockList());
		System.out.println(
			"Expected output:\n" +
				"Item ID Description          Price          Quantity Re-order level\n" +
				"******* ******************** ************** ******** **************\n" +
				"A1111   Test 1                     150.0000       10              5\n" +
				"B2222   Test 2                     200.0000        4              5\n" +
				"C3333   Test 3                     300.0000   500000             10\n"
		);


		System.out.println("\nTest No 6 - Test formatReOrderList method.");
		System.out.println("Actual output:\n" + list.formatReOrderList());
		System.out.println(
			"Expected output:\n" +
				"Item ID Description          Price          Quantity Re-order level\n" +
				"******* ******************** ************** ******** **************\n" +
				"B2222   Test 2                     200.0000        4              5\n"
		);


		System.out.println(
			"\nTest No 7 - Remove one of items in list using deleteItem method and display list " +
			"using formatStockList method."
		);
		try {
			list.deleteItem("B2222");
		} catch (StockListIllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Actual output:\n" + list.formatStockList());
		System.out.println(
			"Expected output:\n" +
				"Item ID Description          Price          Quantity Re-order level\n" +
				"******* ******************** ************** ******** **************\n" +
				"A1111   Test 1                     150.0000       10              5\n" +
				"C3333   Test 3                     300.0000   500000             10\n"
		);
	}
}
