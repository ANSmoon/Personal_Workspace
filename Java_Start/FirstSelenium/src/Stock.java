import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stock {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naver.com/");
		
		WebElement element = driver.findElement(By.cssSelector("#shortcutArea > ul > li:nth-child(6) > a > span.service_icon.type_stock"));
		element.click();
		
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // 참조 페이지 변경
		
		element = driver.findElement(By.cssSelector("#stock_items"));
		element.sendKeys("포스코DX");
		element.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		Thread.sleep(2000); // Loading 에러 방지
		
		System.out.println(driver.getTitle());
		
		element = driver.findElement(By.cssSelector("div > p.no_today\r\n"));
		System.out.print(element.getText());
		}
}