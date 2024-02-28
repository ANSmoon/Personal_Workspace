import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestRestaurant {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.kr/maps/?entry=ttu");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		WebElement store = driver.findElement(By.cssSelector(
				"#assistive-chips > div > div > div > div.e07Vkf.kA9KIf > div > div > div > div > div.rHNip.cRLbXd > div.dryRY > div:nth-child(1) > button"));
		store.click();

		Thread.sleep(2000);

		WebElement score_1 = driver.findElement(By.cssSelector(
				"#assistive-chips > div > div > div > div.e07Vkf.kA9KIf > div > div > div > div > div.rHNip.cRLbXd > div.dryRY > div:nth-child(1) > button"));
		score_1.click();

		Thread.sleep(3000);

		WebElement high_score_1 = driver.findElement(By.cssSelector("#action-menu > div:nth-child(7)"));
		high_score_1.click();

		Thread.sleep(3000);

		WebElement list_1 = driver.findElement(By.cssSelector(
				"#QA0Szd > div > div > div.w6VYqd > div:nth-child(2) > div > div.e07Vkf.kA9KIf > div > div > div.m6QErb.DxyBCb.kA9KIf.dS8AEf.ecceSd > div.m6QErb.DxyBCb.kA9KIf.dS8AEf.ecceSd > div:nth-child(3) > div > a"));
		list_1.click();

		Thread.sleep(2000);

		list_1 = driver.findElement(By.cssSelector(
				"#QA0Szd > div > div > div.w6VYqd > div.bJzME.Hu9e2e.tTVLSc > div > div.e07Vkf.kA9KIf > div > div > div.m6QErb.DxyBCb.kA9KIf.dS8AEf > div.TIHn2 > div > div.lMbq3e > div:nth-child(1) > h1"));

		WebElement path = driver.findElement(By.cssSelector(
				"#QA0Szd > div > div > div.w6VYqd > div.bJzME.Hu9e2e.tTVLSc > div > div.e07Vkf.kA9KIf > div > div > div.m6QErb.DxyBCb.kA9KIf.dS8AEf > div:nth-child(4) > div.etWJQ.jym1ob.kdfrQc.pChizd.bWQG4d > button"));
		path.click();

		Thread.sleep(2000);

		WebElement departure = driver.findElement(By.cssSelector("#sb_ifc50 > input"));
		departure.click();
		departure.sendKeys("삼성화재연수원");

		Thread.sleep(2000);

		WebElement search = driver.findElement(By.cssSelector("#directions-searchbox-0 > button.mL3xi"));
		search.click();

		Thread.sleep(2000);

		WebElement list_2 = driver.findElement(By.cssSelector("#section-directions-trip-0"));
		list_2.click();		
		
		Thread.sleep(2000);
		
		WebElement back_1 = driver.findElement(By.cssSelector("#QA0Szd > div > div > div.w6VYqd > div:nth-child(2) > div > div.e07Vkf.kA9KIf > div > div > div.szK3Wb.Hk4XGb > button"));
		back_1.click();		
		
		Thread.sleep(2000);

		WebElement back_2 = driver.findElement(By.cssSelector("#omnibox-directions > div > div:nth-child(2) > div > button"));
		back_2.click();		
		
		Thread.sleep(2000);

		WebElement back_3 = driver.findElement(By.cssSelector("#searchbox > div.lSDxNd > button"));
		back_3.click();		
		
		/*
		 * try { // 네이버 지도 열기 driver.get("https://map.naver.com/");
		 * 
		 * // 검색어 입력란 찾기 (id가 "search-input"인 요소) WebElement searchBox =
		 * driver.findElement(By.id("search-input"));
		 * 
		 * // 검색어 입력 searchBox.sendKeys("서울역");
		 * 
		 * // 검색어 입력 후 엔터 키 입력 searchBox.sendKeys(Keys.RETURN);
		 * 
		 * // 일부러 잠시 기다리는 코드 (페이지가 로딩될 때까지 기다리는 것이 좋음) Thread.sleep(3000);
		 * 
		 * // 검색 결과 출력 System.out.println(driver.getCurrentUrl()); } catch (Exception e)
		 * { e.printStackTrace(); } finally { // WebDriver 종료 driver.quit(); }
		 */
		Thread.sleep(2000);

		WebElement search_2 = driver.findElement(By.cssSelector("#searchboxinput"));
		search_2.click();
		search_2.sendKeys("카페");
		search_2.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);

		WebElement score_2 = driver.findElement(By.cssSelector(
				"#assistive-chips > div > div > div > div.e07Vkf.kA9KIf > div > div > div > div > div.rHNip.cRLbXd > div.dryRY > div:nth-child(1) > button"));
		score_2.click();
		
		Thread.sleep(2000);

		WebElement high_score = driver.findElement(By.cssSelector("#action-menu > div:nth-child(7)"));
		high_score.click();
		
		Thread.sleep(2000);

		WebElement list_3 = driver.findElement(By.cssSelector("#QA0Szd > div > div > div.w6VYqd > div:nth-child(2) > div > div.e07Vkf.kA9KIf > div > div > div.m6QErb.DxyBCb.kA9KIf.dS8AEf.ecceSd > div.m6QErb.DxyBCb.kA9KIf.dS8AEf.ecceSd > div:nth-child(9) > div > a"));
		list_3.click();	
	}
}