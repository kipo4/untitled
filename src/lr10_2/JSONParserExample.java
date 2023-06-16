import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class JSONParserExample {
    private static final String FILE_PATH = "src/lr10_2/books.json";

    public static void main(String[] args) {
        JSONParserExample parser = new JSONParserExample();

        // Чтение JSON файла
        JSONObject jsonObject = parser.readJSONFile(FILE_PATH);

        if (jsonObject != null) {
            // Поиск книг по автору
            String authorToSearch = "Иванов";
            parser.searchBooksByAuthor(jsonObject, authorToSearch);

            // Добавление новой книги
            JSONObject newBook = new JSONObject();
            newBook.put("title", "Новая книга");
            newBook.put("author", "Новый автор");
            newBook.put("year", 2023);
            parser.addBook(jsonObject, newBook);

            // Удаление книги по названию
            String bookTitleToRemove = "Название книги";
            parser.removeBookByTitle(jsonObject, bookTitleToRemove);

            // Сохранение изменений в JSON файл
            parser.writeJSONFile(jsonObject, FILE_PATH);
        }
    }

    private JSONObject readJSONFile(String filePath) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            return (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeJSONFile(JSONObject jsonObject, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(jsonObject.toJSONString());
            System.out.println("JSON файл успешно обновлен.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchBooksByAuthor(JSONObject jsonObject, String author) {
        JSONArray booksArray = (JSONArray) jsonObject.get("books");

        System.out.println("Книги автора " + author + ":");
        for (Object bookObj : booksArray) {
            if (bookObj instanceof JSONObject) {
                JSONObject book = (JSONObject) bookObj;
                String bookAuthor = (String) book.get("author");
                if (author.equals(bookAuthor)) {
                    System.out.println("\nНазвание книги: " + book.get("title"));
                    System.out.println("Автор: " + bookAuthor);
                    System.out.println("Год издания: " + book.get("year"));
                }
            }
        }
    }

    private void addBook(JSONObject jsonObject, JSONObject newBook) {
        JSONArray booksArray = (JSONArray) jsonObject.get("books");
        booksArray.add(newBook);
        System.out.println("Новая книга успешно добавлена.");
    }

    private void removeBookByTitle(JSONObject jsonObject, String title) {
        JSONArray booksArray = (JSONArray) jsonObject.get("books");
        Iterator iterator = booksArray.iterator();
        while (iterator.hasNext()) {
            Object bookObj = iterator.next();
            if (bookObj instanceof JSONObject) {
                JSONObject book = (JSONObject) bookObj;
                String bookTitle = (String) book.get("title");
                if (title.equals(bookTitle)) {
                    iterator.remove();
                    System.out.println("Книга \"" + title + "\" успешно удалена.");
                    return; // Если нужно удалить только одну книгу, можно закомментировать эту строку
                }
            }
        }
        System.out.println("Книга с названием \"" + title + "\" не найдена.");
    }
}