import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class XMLParser {
    private static final String FILE_PATH = "src/lr10_1/lr10_1.xml";

    public static void main(String[] args) {
        // Пример использования функций
        createBook("New Book", "John Doe", "2023");
        searchBooksByAuthor("John Doe");
        searchBooksByYear("2023");
        deleteBook("New Book");
    }

    public static void createBook(String title, String author, String year) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(FILE_PATH);

            Element rootElement = doc.getDocumentElement();
            Element bookElement = doc.createElement("book");

            Element titleElement = doc.createElement("title");
            titleElement.setTextContent(title);

            Element authorElement = doc.createElement("author");
            authorElement.setTextContent(author);

            Element yearElement = doc.createElement("year");
            yearElement.setTextContent(year);

            bookElement.appendChild(titleElement);
            bookElement.appendChild(authorElement);
            bookElement.appendChild(yearElement);

            rootElement.appendChild(bookElement);

            saveChanges(doc);
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchBooksByAuthor(String author) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(FILE_PATH);

            NodeList bookNodes = doc.getElementsByTagName("book");

            List<Element> books = getNodeListAsStream(bookNodes)
                    .filter(element -> {
                        String bookAuthor = getElementTextContent(element, "author");
                        return bookAuthor.equalsIgnoreCase(author);
                    })
                    .collect(Collectors.toList());

            if (books.isEmpty()) {
                System.out.println("No books found by author: " + author);
            } else {
                System.out.println("Books found by author: " + author);
                for (Element book : books) {
                    String title = getElementTextContent(book, "title");
                    System.out.println("Title: " + title);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchBooksByYear(String year) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(FILE_PATH);

            NodeList bookNodes = doc.getElementsByTagName("book");

            List<Element> books = getNodeListAsStream(bookNodes)
                    .filter(element -> {
                        String bookYear = getElementTextContent(element, "year");
                        return bookYear.equals(year);
                    })
                    .collect(Collectors.toList());

            if (books.isEmpty()) {
                System.out.println("No books found in year: " + year);
            } else {
                System.out.println("Books found in year: " + year);
                for (Element book : books) {
                    String title = getElementTextContent(book, "title");
                    System.out.println("Title: " + title);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(String title) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(FILE_PATH);

            NodeList bookNodes = doc.getElementsByTagName("book");

            List<Element> books = getNodeListAsStream(bookNodes)
                    .filter(element -> {
                        String bookTitle = getElementTextContent(element, "title");
                        return bookTitle.equals(title);
                    })
                    .collect(Collectors.toList());

            if (books.isEmpty()) {
                System.out.println("Book not found: " + title);
            } else {
                for (Element book : books) {
                    Node parentNode = book.getParentNode();
                    parentNode.removeChild(book);
                }

                saveChanges(doc);
                System.out.println("Book deleted successfully: " + title);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveChanges(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    private static Stream<Element> getNodeListAsStream(NodeList nodeList) {
        return IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item)
                .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                .map(node -> (Element) node);
    }

    private static String getElementTextContent(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }
}