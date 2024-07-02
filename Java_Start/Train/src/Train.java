import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Train {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://etk.srail.kr/main.do");
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		Select departure = new Select(driver.findElement(By.cssSelector("#dptRsStnCd")));
		departure.selectByVisibleText("수서"); //element의 이름과 일치 필요
		
		Select arrival = new Select(driver.findElement(By.cssSelector("#arvRsStnCd")));
		arrival.selectByValue("0010");
		
		driver.findElement(By.cssSelector("#search-form > fieldset > a")).click();
	}
}
