import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelParser {
    public static void main(String[] args) {
        boolean hasErrors = true;

        while (hasErrors) {
            try {
                // Путь к Excel файлу
                String filePath = "path/to/your/excel/file.xlsx";

                // Открытие Excel файла
                Workbook workbook = WorkbookFactory.create(new File(filePath));

                // Получение нужного листа
                Sheet sheet = workbook.getSheet("Sheet1");

                // Чтение данных из листа
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        // Обработка ячейки
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }

                // Закрытие Excel файла
                workbook.close();

                hasErrors = false; // Если выполнение дошло до этого момента, значит ошибок нет

            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
                // Дополнительные действия для исправления ошибки чтения файла
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
                // Дополнительные действия для обработки других ошибок
            }
        }
    }
}