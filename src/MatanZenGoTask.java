import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MatanZenGoTask {

    public static void main(String[] args) throws InterruptedException {
        // Init
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matan\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Lunch the ZenGo website
        driver.manage().window().maximize();
        driver.get("http://www.zengo.com/");
        js.executeScript("alert('The site was displayed successfully')");
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Press "Free Bitcoin" button on the menu
        driver.findElement(By.cssSelector("#menu-item-6043 > a")).click();
        js.executeScript("alert('I was redirected to https://zengo.com/free-bitcoin/')");
        Thread.sleep(4000);
        alert = driver.switchTo().alert();
        alert.accept();

        // Scroll down to the “Download ZenGo” button and press it
        WebElement Element = driver.findElement(By.cssSelector("#post-5881 > div > div > div > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-77289cc.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div > div > div > div > h2"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(2000);

        // Verifying the page that opens
        driver.findElement(By.cssSelector("main#main li:nth-child(1) > a")).click();
        js.executeScript("alert('There was no pop up, but I was redirected to a page with a QR code')");
        Thread.sleep(4000);
        alert = driver.switchTo().alert();
        alert.accept();

        // Get back to the home page and close browser
        driver.findElement(By.cssSelector("#page > div.nav-container > header > div.site-branding > p.site-title > a > img")).click();
        Thread.sleep(4000);
        driver.quit();


    }
}
