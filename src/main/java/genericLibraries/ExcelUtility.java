package genericLibraries;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains all reusable methods to perform operations om excel
 * @author nayana
 *
 */

public class ExcelUtility {
	private Workbook wb;
	public void excelInitialization(String excelpath)
	{
		 FileInputStream fis=null;
		try
		{
		  fis=new FileInputStream(excelpath);
		
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try {
			wb=WorkbookFactory.create(fis);
			
		} catch (EncryptedDocumentException|IOException e) {
		e.printStackTrace();
		}
		
	}
	/**
	 * this method is used to fetch the single data from excel 
	 * @param sheetName
	 * @param rowNum
	 * @param cellName
	 * @return
	 */
	public String fetchDataFromExcel(String sheetName,int rowNum,int cellName) {
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellName).getStringCellValue();
			
	}
	/**
	 * this method is used to fetch the multiple data from excel
	 * @param sheetName
	 * @return
	 */
	public List<String> fetchDataFromExcel(String sheetName)
	{
		List<String> dataList=new ArrayList<>();
		Sheet sheet=wb.getSheet(sheetName); 
		for (int i = 0; i <=sheet.getLastRowNum(); i++) {
			String data =sheet.getRow(i).getCell(1).getStringCellValue();
			dataList.add(data);
			
			
		}
		return dataList;
	}
	
	
		public void closeExcel()
		{
			try {
				wb.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

