package helpers;

import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.io.File;

import static java.lang.Thread.sleep;

/**
 * Created by Arkuz on 24.09.2016.
 */
public class FunctionsOS {

    protected WebDriver driver;

    public FunctionsOS(WebDriver driver){
        this.driver = driver;
        }

    // Проверить, что файл существует
    public boolean isFileExist(String path){
        File file = new File(path);
        return file.exists();
    }

    // Удалить файл, если существует
    public void deleteFile(String path){
        File file = new File(path);
        if (isFileExist(path)) {
            file.delete();
        }
    }

    // Ожидание появления файла
    public boolean waitFileExist(String path) throws InterruptedException {
        int i = 0;
        while (i < 15) {
            if (isFileExist(path)) {
                return true;
            }
            sleep(1000);
            i++;
        }
        return false;
    }
}
