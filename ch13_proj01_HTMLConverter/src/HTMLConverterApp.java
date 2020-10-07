
public class HTMLConverterApp {

	public static void main(String[] args) {
		System.out.println("HTML Converter");
		System.out.println();

		String html = "<h1>Grocery List<h1>\n" + "<ul>\n" + "   <li>Eggs</li>\n" + "   <li>Milk</li>\n"
				+ "   <li>Butter</li>\n" + "</ul>";

		System.out.println("INPUT");
		System.out.println(html);
		System.out.println();

		String html1 = "<h1>Grocery List<h1>\n";
		String html2 = "<li>Eggs</li>\n" + "<li>Milk</li>\n" + "<li>Butter</li>\n";

		System.out.println("OUTPUT");

		html1 = html1.replace("<h1>", "");
		html2 = html2.replace("<ul>", "");
		html2 = html2.replace("<li>", "* ");
		html2 = html2.replace("</li>", "");
		html2 = html2.replace("</ul>", "");
		html2 = html2.trim();

		System.out.println(html1 + html2);
	}

}
