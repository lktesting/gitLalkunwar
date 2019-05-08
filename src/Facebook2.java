import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook2 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream f1 = new FileInputStream("//Users//nikhilredij//Lalkunwar//Workbook1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f1);
		XSSFSheet sh = wb.getSheetAt(0);
		XSSFRow rw;
		XSSFCell un,pwd;

		//un = sh.getRow(2).getCell(0);
		//pwd = sh.getRow(2).getCell(1);

		System.out.println(sh.getPhysicalNumberOfRows());
		System.out.println(sh.getRow(0).getLastCellNum());

		for(int i = 0;i <= sh.getLastRowNum();i++)
		{
			un = sh.getRow(i).getCell(0);

			pwd = sh.getRow(i).getCell(1);
			//System.out.println(pwd.getCellType().toString());
			//System.out.println(un.toString() + pwd.toString());
			ChromeOptions c_options = new ChromeOptions();
			c_options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "//Users//nikhilredij//Lalkunwar//Java Docs//selenium_jar_files//chromedriver");
			WebDriver chrome_driver = new ChromeDriver(c_options);
			chrome_driver.get("https://www.facebook.com/");
			
			System.out.print(un.toString() +" " + pwd.toString());
			System.out.println();
			Thread.sleep(4000);
			chrome_driver.findElement(By.xpath("//input[@name='email']")).sendKeys(un.toString());
			//Thread.sleep(300);
			chrome_driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd.toString());

			chrome_driver.findElement(By.xpath("//input[@value='Log In']")).click();
			//Thread.sleep(200);
			String s = login_testcase(chrome_driver);
			System.out.println(s);
			XSSFCell status = sh.getRow(i).createCell(2);
			status.setCellValue(s);
			FileOutputStream fo = new FileOutputStream("//Users//nikhilredij//Lalkunwar//Workbook1.xlsx");
			wb.write(fo);
			System.out.println("first change in clone code");
			System.out.println("second change");
			System.out.println("develop branch created");
			System.out.println("first develop change");
			System.out.println("final work done by lkc: merging done");
			chrome_driver.close();
			Thread.sleep(1000);
		}


	}

	public static String login_testcase(WebDriver d)
	{
		String s = null;
		try
		{
			if(d.findElement(By.xpath("//a[@class='_2s25']")).isDisplayed())
			{
				s = "log in successful";
				//System.out.print(s);

			}
		}
		catch(Exception e)
		{
			s = "login failed";
			//System.out.println(s);
			return s;
		}
		return s;
	}
}
