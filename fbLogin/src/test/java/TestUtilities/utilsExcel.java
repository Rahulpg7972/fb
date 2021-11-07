package TestUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class utilsExcel {
	static String data;
	public static String fetchExcelData(int row,int cell) throws EncryptedDocumentException, IOException
	{
		String path=("D:\\A TESTING COURSE\\OneDrive\\Desktop\\Book1.xlsx");
		FileInputStream file=new FileInputStream(path);
		Workbook w=WorkbookFactory.create(file);
		
		        try {
	        	  
			    data=w.getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
			 
			    }
				catch(IllegalStateException s)
				{
					
				double data1=w.getSheet("Sheet1").getRow(row).getCell(cell).getNumericCellValue();
				
				long v = (long)data1;      //converting double data into long
				data=Long.toString(v);     //converting long data into string alternate method data=String.valueOf(v);
				
				}
				catch(NullPointerException e) 
				{
					System.out.println("the selected cell is empty");
				}
				catch(Exception g) {
//					g.printStackTrace();
//					g.toString();
				}
		return data;
		
	}
}