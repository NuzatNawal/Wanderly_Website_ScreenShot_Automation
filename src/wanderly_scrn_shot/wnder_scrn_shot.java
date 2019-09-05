package wanderly_scrn_shot;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.FileUtils;

public class wnder_scrn_shot {
	
	WebDriver driver = new FirefoxDriver();
	
	
	public void wander_code() throws InterruptedException{
		driver.get("https://www.wanderly.us/nurse");
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/main/div/section[1]/div/div/a")).click();
		//Specialties
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[1]/div")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[1]/div/ul[1]/li/input")).sendKeys("Antepartum");
		WebDriverWait wait = new WebDriverWait(driver,11);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[1]/div/ul[2]/li/div")));
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[1]/div/ul[2]/li/div")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[1]/div/ul[1]/li[2]/input")).sendKeys("Dialysis");
		WebDriverWait wait2 = new WebDriverWait(driver,11);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[1]/div/ul[2]/li/div")));
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[1]/div/ul[2]/li/div")).click();
		//location
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[2]/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[2]/div/ul[1]/li/input")).sendKeys("California");
		WebDriverWait wait3 = new WebDriverWait(driver,11);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[2]/div/ul[2]/li/div")));
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[2]/div/ul[2]/li/div")).click();
        //Agencies
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[3]/div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[3]/div/ul[1]/li/input")).sendKeys("Atlas Medstaff");
		WebDriverWait wait4=new WebDriverWait(driver,11);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[3]/div/ul[2]/li/div")));
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[3]/div/ul[2]/li/div")).click();
		Thread.sleep(5000);
		//pay rate and also cursor hold and move
		WebElement move= driver.findElement(By.xpath("//*[@id=\"desktop-mode\"]/div[2]/div/div/div[1]/div[4]/span/span[6]"));
		Actions act =new Actions(driver);
		act.clickAndHold(move).moveByOffset(40, 0).release(move).build().perform();
		Thread.sleep(5000);
		//calender
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[5]/div/div[1]/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[8]/div[1]/table/tbody/tr[2]/td[4]")).click();
		//shift
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[6]/div/div[3]/label")).click();
		//result
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[1]/div[8]/button")).click();
		//scroll
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-700)");
		
	}
	public void Screen_shot() throws IOException {
		String result= driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div[2]/div[3]/div/p/a")).getText();
		System.out.println(result);
		String actual= "Try widening your criteria";
		System.out.println(actual);		
		
				
		if(actual.equals(result)) {
			System.out.println("passed");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			org.apache.commons.io.FileUtils.copyFile(scrFile, new File("D:\\Automation code\\Screen shot\\screen_shot.png"));
		}	
		
		else
			System.out.println("FAILED");
	}
		
	
public static void main(String[] args) throws IOException, InterruptedException {
		
	wnder_scrn_shot e= new wnder_scrn_shot();
		e.wander_code();
		e.Screen_shot();
		
		
	}

}
