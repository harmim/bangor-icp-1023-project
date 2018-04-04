package Stock;


import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Allows the user to interact with the stock list via the keyboard and console screen.
 *
 * @author Dominik Harmim harmim6@gmail.com
 */
class StockListCli
{
	/**
	 * Menu options labels.
	 */
	private static final String[] MENU_OPTIONS = {
		"Add an item",
		"Delete an item",
		"Update item price",
		"Update item quantity",
		"Update item re-order level",
		"Print stock list",
		"Print re-order list",
		"Save stock data",
		"Exit"
	};


	/**
	 * Stock list.
	 */
	private StockList list;

	/**
	 * Java utils Scanner instance for input.
	 */
	private Scanner input = new Scanner(System.in);


	/**
	 * Creates and initializes stock list CLI.
	 *
	 * @param list initial stock list
	 */
	StockListCli(StockList list)
	{
		this.list = list;
	}


	/**
	 * Runs stock list CLI interface.
	 * Displays menu and processing user actions until an error will occur or user wants to quit.
	 */
	void run()
	{
		clearScreen();
		do {
			displayMenu();
		} while (processUserAction());
	}


	/**
	 * Displays menu.
	 */
	private void displayMenu()
	{
		System.out.println("Stock list main menu");
		System.out.println("********************\n");

		for (int i = 0; i < MENU_OPTIONS.length; i++) {
			System.out.printf("%d. %s\n", i + 1, MENU_OPTIONS[i]);
		}
		System.out.printf("\nSelect option [1-%d] :> ", MENU_OPTIONS.length);
	}


	/**
	 * Processes user action. (Reads users input and generate appropriate output.)
	 *
	 * @return false in case of user wants quit, true otherwise
	 */
	private boolean processUserAction()
	{
		int option;
		try {
			option = input.nextInt();
		} catch (InputMismatchException e) {
			input.nextLine();
			clearScreen();
			System.out.println("Invalid option.\n");
			return true;
		}

		clearScreen();

		if (option >= 1 && option <= 7) {
			System.out.println(MENU_OPTIONS[option - 1]);
			System.out.println("**************************");
		}

		switch (option) {
			case 1:
				addItem();
				break;

			case 2:
				deleteItem();
				break;

			case 3:
				updateItemPrice();
				break;

			case 4:
				updateItemQuantity();
				break;

			case 5:
				updateReOrderLevel();
				break;

			case 6:
				printStockList();
				break;

			case 7:
				printReOrderList();
				break;

			case 8:
				saveStockData();
				break;

			case 9:
				return false;

			default:
				System.out.println("Unknown option.\n");
				return true;
		}

		System.out.println("\nPress Enter key to continue...");
		try {
			//noinspection ResultOfMethodCallIgnored
			System.in.read();
		} catch (Exception ignored) {
		}

		clearScreen();

		return true;
	}


	/**
	 * Performs stock item addition operation.
	 */
	private void addItem()
	{
		boolean add = true;
		while (add) {
			try {
				list.addItem(new StockItem(getItemId(), getDescription(), getPrice(), getQuantity(), getReOrderLevel()));
			} catch (StockListCliValidationException | StockListIllegalStateException e) {
				System.out.println(e.getMessage());
				return;
			}
			add = performOperationAgain("Add another item");
		}
	}


	/**
	 * Performs stock item deletion operation.
	 */
	private void deleteItem()
	{
		boolean delete = true;
		while (delete) {
			try {
				list.deleteItem(getItemId());
			} catch (StockListIllegalArgumentException e) {
				System.out.println(e.getMessage());
				return;
			}
			delete = performOperationAgain("Delete another item");
		}
	}


	/**
	 * Performs stock item price update operation.
	 */
	private void updateItemPrice()
	{
		boolean update = true;
		while (update) {
			try {
				list.updateItemPrice(getItemId(), getPrice());
			} catch (StockListCliValidationException | StockListIllegalArgumentException e) {
				System.out.println(e.getMessage());
				return;
			}
			update = performOperationAgain("Update another item price");
		}
	}


	/**
	 * Performs stock item quantity update operation.
	 */
	private void updateItemQuantity()
	{
		boolean update = true;
		while (update) {
			try {
				list.updateItemQuantity(getItemId(), getQuantity());
			} catch (StockListCliValidationException | StockListIllegalArgumentException e) {
				System.out.println(e.getMessage());
				return;
			}
			update = performOperationAgain("Update another item quantity");
		}
	}


	/**
	 * Performs stock item re-order level update operation.
	 */
	private void updateReOrderLevel()
	{
		boolean update = true;
		while (update) {
			try {
				list.updateReOrderLevel(getItemId(), getReOrderLevel());
			} catch (StockListCliValidationException | StockListIllegalArgumentException e) {
				System.out.println(e.getMessage());
				return;
			}
			update = performOperationAgain("Update another item re-order level");
		}
	}


	/**
	 * Prints contents of stock list.
	 */
	private void printStockList()
	{
		System.out.println('\n' + list.formatStockList());
	}


	/**
	 * Prints contents of re-order list.
	 */
	private void printReOrderList()
	{
		System.out.println('\n' + list.formatReOrderList());
	}


	private void saveStockData()
	{
		if (list.saveStockData()) {
			System.out.println("Stock data has been successfully saved.\n");
		}
	}


	/**
	 * Clears output screen.
	 */
	private void clearScreen()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}


	/**
	 * Finds out if user wants performs operation again.
	 *
	 * @param message message which asks the user if he wants perform operation again
	 * @return true if operation should be performed again, false otherwise
	 */
	private boolean performOperationAgain(String message)
	{
		System.out.println();
		while (true) {
			System.out.print(message + " (Y/N) :> ");
			String decision = input.next();

			if (decision.equalsIgnoreCase("N")) {
				return false;
			} else if (decision.equalsIgnoreCase("Y")) {
				return true;
			}
		}
	}


	/**
	 * Retrieves item ID from user.
	 *
	 * @return item ID from user
	 */
	private String getItemId()
	{
		System.out.print("\nEnter item ID :> ");
		return input.next();
	}


	/**
	 * Retrieves item description form user.
	 *
	 * @return item description form user
	 */
	private String getDescription()
	{
		System.out.print("Enter description :> ");
		return input.next();
	}


	/**
	 * Retrieves item price from user.
	 *
	 * @return item price from user
	 *
	 * @throws StockListCliValidationException in case of validation error
	 */
	private double getPrice() throws StockListCliValidationException
	{
		try {
			System.out.print("Enter new price :> ");
			return input.nextDouble();
		} catch (InputMismatchException e) {
			input.nextLine();
			throw new StockListCliValidationException("Invalid price.", e);
		}
	}


	/**
	 * Retrieves item quantity from user.
	 *
	 * @return item quantity from user
	 *
	 * @throws StockListCliValidationException in case of validation error
	 */
	private int getQuantity() throws StockListCliValidationException
	{
		try {
			System.out.print("Enter new quantity :> ");
			return input.nextInt();
		} catch (InputMismatchException e) {
			input.nextLine();
			throw new StockListCliValidationException("Invalid quantity.", e);
		}
	}


	/**
	 * Retrieves item re-order level from user.
	 *
	 * @return item re-order level from user
	 *
	 * @throws StockListCliValidationException in case of validation error
	 */
	private int getReOrderLevel() throws StockListCliValidationException
	{
		try {
			System.out.print("Enter new re-order level :> ");
			return input.nextInt();
		} catch (InputMismatchException e) {
			input.nextLine();
			throw new StockListCliValidationException("Invalid re-order level.", e);
		}
	}
}
