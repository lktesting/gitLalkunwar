import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExploringHtmlXpath 
{

	public static void main(String[] args)
	{

		ChromeOptions c_options = new ChromeOptions();
		c_options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "//Users//nikhilredij//Lalkunwar//Java Docs//selenium_jar_files//chromedriver");
		WebDriver driver = new ChromeDriver(c_options);
		driver.get("https://money.rediff.com/gainers");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		List<WebElement> headList = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
		System.out.println(headList.size());
		for(WebElement e : headList)
		{
			System.out.print(e.getText() + " ");
		}
		//System.out.println(driver.findElement(By.xpath("//tr[10]//td[3]")).getText());
		System.out.println();
		for(int i = 1;i <= 10;i++)
		{
			for(int j = 1;j <= 5;j++)
			{
				System.out.print(driver.findElement(By.xpath("//tr["+i+"]//td["+j+"]")).getText() + " ");
				
			}
			System.out.println();
		}
		System.out.println();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody//tr"));
		System.out.println(rows.size());
		driver.close();

	}

}
