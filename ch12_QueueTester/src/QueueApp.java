public class QueueApp {

	public static void main(String args[]) {

		Queue<String> invoices = new Queue<>();
		invoices.push("Invoice 1");
		invoices.push("Invoice 2");
		invoices.push("Invoice 3");
		System.out.println("The queue contains " + invoices.size() + " invoices");

		while (invoices.size() > 0) {
			String invoice = invoices.pull();
			System.out.println("Processing: " + invoice);
		}
		System.out.println("The queue contains " + invoices.size() + " invoices");

	}
}