import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebtableToExcel 
{

	public static void main(String[] args) throws IOException 
	{
		
		ChromeOptions c_options = new ChromeOptions();
		c_options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "//Users//nikhilredij//Lalkunwar//Java Docs//selenium_jar_files//chromedriver");
		WebDriver driver = new ChromeDriver(c_options);
		driver.get("https://money.rediff.com/gainers");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//.//*[@id='leftcontainer']/table/tbody/tr[1]/td[1]
		//.//*[@id='leftcontainer']/table/tbody/tr[2]/td[1]
		//.//*[@id='leftcontainer']/table/tbody/tr[7]/td[1]
		//String b4xpath = "//*[@id='leftcontainer']/table/tbody/tr[";
		//String aftrxpath ="]/td[1]/a";
		File file = new File("//Users//nikhilredij//Lalkunwar//Workbook2.xlsx");
		FileInputStream f11 = new FileInputStream(file);
		XSSFWorkbook wrkbk = new XSSFWorkbook(f11);
		XSSFSheet sh = wrkbk.createSheet();
		XSSFCell cell;
		XSSFRow row1,row2;
		

		List<WebElement> rows=driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr"));
		System.out.println("Size of rows "+rows.size());
		
		List<WebElement> cols=driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("Size of colm "+cols.size());
		
		for(WebElement e : cols)
		{
			System.out.println(e.getText());
		}
		
		
	
		List<WebElement> tbldata = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr"));
		int rcount= tbldata.size();
		System.out.println("row count at beginning: " +rcount);
		
		WebElement row = driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[1]"));
		//WebElement col = driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[1]/td[1]"));
		
		
		WebElement head1 = driver.findElement(By.xpath("//th[contains(text(),'Company')]"));
		WebElement head2 = driver.findElement(By.xpath("//th[contains(text(),'Group')]"));
		WebElement head3 = driver.findElement(By.xpath("//th[contains(text(),'Prev Close (Rs)')]"));
		WebElement head4 = driver.findElement(By.xpath("//th[contains(text(),'Current Price (Rs)')]"));
		WebElement head5 = driver.findElement(By.xpath("//th[contains(text(),'% Change')]"));
        //System.out.println(col.getText());
		WebElement[] heading_Array = {head1,head2,head3,head4,head5};
		row2 = sh.createRow(0);
		try
		{
			for(int l= 0;l < heading_Array.length;l++)//0<5,1<5,2<5
			{
				
				  XSSFCell status1 = row2.createCell(l);//0-0,0-1,0-2,0-3,0-4//0-0,0-1,0-2
				  
					status1.setCellValue(heading_Array[l].getText());//head1,he2,
					System.out.println(heading_Array[l].getText());
			FileOutputStream foS = new FileOutputStream("//Users//nikhilredij//Lalkunwar//Workbook2.xlsx");
					wrkbk.write(foS);
			}
		
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
		/*sh.createRow(0);
		sh.getRow(0).createCell(0).setCellValue(head1.getText());
		FileOutputStream foS = new FileOutputStream("//Users//nikhilredij//Lalkunwar//Workbook2.xlsx");
		wrkbk.write(foS);
		sh.getRow(0).createCell(2).setCellValue(head3.getText());
		//FileOutputStream foS = new FileOutputStream("//Users//nikhilredij//Lalkunwar//Workbook2.xlsx");
		wrkbk.write(foS);*/
		
		
				
		for(int i=1;i<=10;i++)
		{ row1= sh.createRow(i);
			for(int j=1;j<=5;j++)
		  {
				WebElement col = driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr["+i+"]/td["+j+"]"));
				
				
		        XSSFCell status = sh.getRow(i).createCell(j-1);//0-0,0-1,0-2,0-3,0-4
				status.setCellValue(col.getText());
				FileOutputStream fo = new FileOutputStream("//Users//nikhilredij//Lalkunwar//Workbook2.xlsx");
				wrkbk.write(fo);
				
				//putresultstoreport(wb);
			
		}
			
		}
		if(file.isFile() && file.exists())
		{
			System.out.println("file opened successfully");
		}
		
		
		//wrkbk.close();
	}

	private static void putresultstoreport(XSSFWorkbook wb) throws IOException {
		// TODO Auto-generated method stub
		//F
	}

}
