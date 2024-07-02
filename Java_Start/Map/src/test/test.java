package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.kr/maps");
		driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	    
	    WebElement arrival = driver.findElement(By.cssSelector("#searchboxinput"));
	    arrival.click();
	    arrival.sendKeys("대전역");
	    //도착지 입력
	    
	    Thread.sleep(100); 
	    
	    WebElement arrival1 = driver.findElement(By.cssSelector("#hArJGc"));
	    arrival1.click();
	    //경로 검색
	
	    while (true) {
	        
	        Thread.sleep(500);
	        
	        WebElement departure = driver.findElement(By.cssSelector("#sb_ifc50 > input"));
	        departure.click();
	        departure.sendKeys("내위치");
	        departure.sendKeys(Keys.ENTER);
	        //출발지로 내위치
	        
	        Thread.sleep(3000);
	        
	        WebElement button = driver.findElement(By.cssSelector("#section-directions-trip-0"));
	        button.click();
	        //최적경로
	        Thread.sleep(1000);
	        
	        WebElement open = driver.findElement(By.cssSelector("#QA0Szd > div > div > div.w6VYqd > div.bJzME.tTVLSc > div > div.e07Vkf.kA9KIf > div > div > div.szK3Wb.Hk4XGb > button > span"));
	        open.click();
	        //뒤로가기
    }
}
}