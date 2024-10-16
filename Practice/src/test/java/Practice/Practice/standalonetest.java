package Practice.Practice;

import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class standalonetest {

	public static void main(String args[]) throws InterruptedException, MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("A/B Testing")).click();
		String getText = driver.findElement(By.xpath("//div[@class='example'] //p")).getText();
		Assert.assertEquals(getText, "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).");
		driver.navigate().back();
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		for(int i=0;i<10;i++) {
			driver.findElement(By.xpath("//button[text()='Add Element']")).click();
		}
		for(int i=0;i<10;i++) {
			driver.findElement(By.xpath("//button[contains(text(),'Delete')][1]")).click();
		}
		//comment added to the list !!!
		driver.navigate().back();
		driver.findElement(By.linkText("Basic Auth")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("Broken Images")).click();
		
		String urlString = driver.findElement(By.xpath("//div[@class='example'] //img[1]")).getAttribute("src");
		
		HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
		connection.connect();
		System.out.print(connection.getResponseCode());
		
		String  urlCorrectSring = driver.findElement(By.xpath("//div[@class='example'] //img[3]")).getAttribute("src");
		HttpURLConnection conn = (HttpURLConnection)new URL(urlCorrectSring).openConnection();
		conn.connect();
		System.out.println(conn.getResponseCode());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Challenging DOM")).click();
		driver.findElement(By.xpath("(//tr //td[1]/following-sibling::td//a[text()='edit'])[1]")).click();
		
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.linkText("Checkboxes")).click();
		driver.findElement(By.xpath("//input")).click();
		Thread.sleep(2000);
		String val = driver.findElement(By.xpath("//input")).getAttribute("checked");
		if(val != null) {
			System.out.println("checkbox is checked! " + true);
		}
		System.out.println(driver.findElement(By.id("checkboxes")).isSelected());
		System.out.println(driver.findElement(By.id("checkboxes")).isEnabled());
		System.out.println(driver.findElement(By.id("checkboxes")).isDisplayed());
		
		driver.navigate().back();
		driver.findElement(By.linkText("Context Menu")).click();
		Actions as = new Actions(driver);
		WebElement elment = driver.findElement(By.xpath("//div[@id='hot-spot']"));
		as.moveToElement(elment).contextClick().build().perform();
		Thread.sleep(2000);
		String getAlert = driver.switchTo().alert().getText();
		System.out.println(getAlert);
		driver.switchTo().alert().accept();
		driver.manage().window().fullscreen();
		
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Digest")).click();
		
		driver.navigate().back();
		
		driver.findElement(By.partialLinkText("Drag and Drop")).click();
		WebElement b = driver.findElement(By.id("column-b"));
		WebElement a = driver.findElement(By.id("column-a"));
		as.dragAndDrop(b, a).build().perform();
				
		
		
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Dropdown")).click();
		
		Select s = new Select(driver.findElement(By.tagName("select")));
		s.selectByVisibleText("Option 2");
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.navigate().back();
		
		driver.findElement(By.partialLinkText("Dynamic Controls")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		waits.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
		System.out.println(driver.findElement(By.id("message")).getText());
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		waits.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("I Love you!");
		driver.findElement(By.xpath("//button[text()='Disable']")).click();
		
		driver.navigate().back();
		driver.findElement(By.linkText("Entry Ad")).click();
		
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal']")));
		
		System.out.println(driver.findElement(By.xpath("//div[@class='modal']")).isDisplayed());
		
		driver.findElement(By.xpath("//p[text()='Close']")).click();
		
		driver.navigate().back();
		driver.findElement(By.linkText("File Upload")).click();
		
		WebElement fileUploaded = driver.findElement(By.xpath("//input[@type='file']"));
		File f = new File("src\\krishna_updated_automation_resume_20240617_011439_0000 (2).pdf");
		fileUploaded.sendKeys(f.getAbsolutePath());
		File ScreenShot = driver.findElement(By.xpath("//input[@value='Upload']")).getScreenshotAs(OutputType.FILE);
		Files.copy(ScreenShot,new File("C:/Users/ssaty/Selenium/Practice/src/ele.png"));
		
		File ScreenshotEntire = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ScreenshotEntire, new File("C:/Users/ssaty/Selenium/Practice/src/ele2.png"));
		driver.findElement(By.xpath("//input[@value='Upload']")).click();
		Thread.sleep(2000);
		
		
		driver.navigate().back();
		driver.navigate().back();
		
		
		driver.findElement(By.linkText("Frames")).click();
		
		driver.findElement(By.linkText("Nested Frames")).click();
		
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().defaultContent();
		driver.navigate().back();
		
		
		driver.findElement(By.linkText("iFrame")).click();
		
		
		driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
		
		System.out.println(driver.findElement(By.xpath("//p")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.navigate().back();
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("Horizontal Slider")).click();
		
		as.clickAndHold(driver.findElement(By.xpath("//input"))).moveByOffset(50, 0).release().build().perform();
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> ids = driver.getWindowHandles();
		
		Iterator<String> i = ids.iterator();
		
		String parentId = i.next();
		
		String childId = i.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.close();
		
//		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.switchTo().window(parentId);
		
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
		List<String> getList = new ArrayList<String>();
		for(WebElement e: ele) {
			getList.add(e.getText());
			System.out.println(e.getText());
		}
		
		Collections.sort(getList);
		
		System.out.println(getList);
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("Status Codes")).click();
		
		List<WebElement> elem = driver.findElements(By.tagName("li"));
		
		for(WebElement el : elem) {
			HttpURLConnection c = (HttpURLConnection) new URL(el.findElement(By.tagName("a")).getAttribute("href")).openConnection();
			c.connect();
			System.out.println(c.getResponseCode());
		}
		
	
		
		
		driver.close();
		
		
		
			
		
	}
	
}
