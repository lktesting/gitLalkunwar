import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateWorkbook 
{

	public static void main(String[] args) 
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		try
		{
			FileOutputStream fo = new FileOutputStream("//Users//nikhilredij//Lalkunwar//CreatWorkBook.xlsx");
			XSSFSheet sheet1 = workbook.createSheet("First Sheet");
			XSSFSheet sheet2 = workbook.createSheet("Second Sheet");
			XSSFRow row = sheet1.createRow(0);
			XSSFCell cell = row.createCell(1);
			CreationHelper ch = workbook.getCreationHelper();
			CellStyle cellstyle = workbook.createCellStyle();
			
			cellstyle.setDataFormat(ch.createDataFormat().getFormat("d-m-yy h:mm"));
			
			cell.setCellValue(new Date());
			cell.setCellStyle(cellstyle);
			
			workbook.write(fo);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	   
		

	}

}
