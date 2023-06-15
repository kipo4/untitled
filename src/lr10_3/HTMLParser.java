import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLParser {
    private static final String URL = "https://example.com";
    private static final String FILE_PATH = "data.txt";

    public static void main(String[] args) {
        parseAndSaveData();
    }

    private static void parseAndSaveData() {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements newsElements = doc.select("div.news");

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            for (Element news : newsElements) {
                String title = news.select("h2.title").text();
                String content = news.select("p.content").text();
                writer.write("Title: " + title + "\n");
                writer.write("Content: " + content + "\n");
                writer.write("-------------------\n");
            }
            writer.close();

            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error accessing the website: " + e.getMessage());
            System.out.println("Attempting to reconnect...");
            parseAndSaveData(); // Попытка переподключения к сайту при возникновении ошибки
        }
    }
}