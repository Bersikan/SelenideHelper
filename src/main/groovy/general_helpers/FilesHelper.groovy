package general_helpers

import org.openqa.selenium.TimeoutException
import org.openqa.selenium.support.ui.FluentWait

import java.time.Duration

class FilesHelper {
    static void waitForFileDownloaded(String path, String fileName, Duration timeout) {
        File file = new File(path, fileName);
        FluentWait<File> fileWait = new FluentWait<>(file)
                .withTimeout(timeout)
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(TimeoutException.class);
        fileWait.until(f -> f.exists() && f.canRead());
    }
}
