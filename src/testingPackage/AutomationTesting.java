package testingPackage;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.SWITCH;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationTesting {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	WebElement phone, password;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "F:\\automation\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;

	}
	// Kiểm tra rằng website có thể truy cập và login bình thường
	@Test
	public void TC_01() {
		 driver.get("https://pmc-ecm-store.dev.pharmacity.io/");
		 //driver.get("hhttps://www.pharmacity.vn/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//p[text()='Đăng nhập']")).click();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//a[text()='Đăng nhập bằng mật khẩu']")).click(); 
		 phone=driver.findElement(By.xpath("//input[@name='phone']"));
		 password=driver.findElement(By.xpath("//input[@name='otp']"));
		 phone.sendKeys("0914497337"); password.sendKeys("123456789");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		 driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 System.out.println("TH1: Test Login thành công");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	}
	// Kiểm tra rằng nếu item được chỉ định có gắn thêm lable thì sẽ click vào detail được
	@Test
	public void TC_02() {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", 
		driver.findElement(By.xpath("//span[text()='DEAL SỐC MUA 2 TẶNG 2 - CHỈ TỪ 34.5000Đ/BỘ']")));
		WebElement lable = driver.findElement(By.xpath("//img[contains(@src,'https://data-service.pharmacity.io/pmc-upload-media/development/pmc-ecm-core/promotions')]//"
				+ "ancestor::div//div[text()='Dụng cụ xét nghiệm nhanh kháng nguyên SARS-CoV-2 SureScreen Diagnostics Covid-19 Test Kit (Hộp 25 Test)']"));
		lable.click();
		
		}


	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
