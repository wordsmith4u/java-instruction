
public class HTMLConverterApp {

	public static void main(String[] args) {
		String html = "<h1>Grocery List</h1>\n" + "<ul>\n" + "    <li>Eggs</li>\n" + "    <li>Milk</li>\n"
				+ "    <li>Butter</li>\n" + "</ul>";

		System.out.println("HTML Input:\n" + html);

		// Remove spaces before tags
		while (html.indexOf(" <") != -1) {
			int idx = html.indexOf(" <");
			html = html.replace(" <", "<");
		}

		// Replace list items with asterisks
		html = html.replace("<li>", "* ");

		StringBuilder htmlBldr = new StringBuilder(html);

		// Remove HTML tags
		int beginTagIndex = 0;
		while (beginTagIndex != -1) {
			beginTagIndex = htmlBldr.indexOf("<");
			if (beginTagIndex != -1) {
				int endTagIndex = htmlBldr.indexOf(">", beginTagIndex);
				htmlBldr.delete(beginTagIndex, endTagIndex + 1);

			}
		}

		html = htmlBldr.toString();

		// Remove blank lines
		html = html.replace("\n\n", "\n");

		System.out.println("\nText Output:\n" + html);

	}

}
