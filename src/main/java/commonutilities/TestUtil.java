package commonutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import testbase.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=70;
	public static long IMPLICIT_WAIT=80;
	
	//public static String TEST_DATA_SHEET_PATH="C:\\Users\\Kumuad Sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\testdata\\ServiceRequest.xlsx";
	
	
	public static String TEST_DATA_SHEET_PATH="C:\\Users\\Kumuad Sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\testdata\\AccountCreation.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	public static String currentDir;
	public static String Screenshot;
	
	public static String FailedScreenShotFolder;
	public static String PassScreenShotFolder;
	public static String PassScreenShot;
	public static String FailedScreenShot;
	
	public static File flScreenshot;
	public static File flPassScreenshotFolder;
	public static File flFailScreenshotFolder;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	

	//Get Data From Excel Utility with Data provider
	
	public static Object [][] getTestData(String sheetName) throws Exception{
	FileInputStream file=null;
	try{
		file = new FileInputStream(TEST_DATA_SHEET_PATH);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	try{
		book=WorkbookFactory.create(file);
		
	}catch(InvalidFormatException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();
	}
	 sheet=book.getSheet(sheetName);
	
		


	 Object[][] data=new Object[sheet.getLastRowNum()-1][sheet.getRow(0).getLastCellNum()];
	 System.out.println(sheet.getLastRowNum());
	 System.out.println(sheet.getRow(0).getLastCellNum());
	 for(int i=1;i<sheet.getLastRowNum();i++) 
		 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
			 //data[i][k]=sheet.getRow(i+1).getCell(k) .toString(); // i was 0getlastnum was not -1
			 //data[i-1][k]=sheet.getRow(i).getCell(k) .toString();
			 data[i-1][k]=sheet.getRow(i).getCell(k) .toString();
		 }

	 return data;
	}

//Utility to write the data to excel sheet
  public static void setCellData(String xlsheet,int rownum,int colnum,String data)
  throws IOException {
  
  FileInputStream file= new FileInputStream(TEST_DATA_SHEET_PATH);
  
  wb=new XSSFWorkbook(file); 
  ws=wb.getSheet(xlsheet);
  row=ws.getRow(rownum);
  //ws.createRow(rownum);
  cell=row.createCell(colnum); 
  cell.setCellValue(data);
  fo=new FileOutputStream(TEST_DATA_SHEET_PATH);
  wb.write(fo); 
  //wb.close();
  //fi.close(); fo.close(); }
 

  }	
	
	public static String getCellData(String sheetname,String colname,int rownum) throws IOException
	{
		FileInputStream file= new FileInputStream(TEST_DATA_SHEET_PATH);
		wb=new XSSFWorkbook(file); 
		
		int colum_Num = 0;
		
		//int colum_Num = -1;
		ws = wb.getSheet(sheetname);
		row = ws.getRow(0);

		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colname.trim()))
				colum_Num = i;
		}
		row = ws.getRow(rownum);
		cell = row.getCell(colum_Num);
		
		String data;
		try {	
		DataFormatter formatter = new DataFormatter();
        String cellData = formatter.formatCellValue(cell);
        return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		
		fi.close();
		return data;
	}
	
	
	
	
	public static void writeToExcel(String sheet, int rownum, int colnum, String data)
			throws EncryptedDocumentException, IOException {

		try {
			Thread.sleep(1000);

			File f = new File(TEST_DATA_SHEET_PATH);

			// Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(f);

			// creating workbook instance that refers to .xls file
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);

			// creating a Sheet object using the sheet Name
			XSSFSheet s = wb.getSheet(sheet);

			// Create a row object to retrieve row at index m
			 XSSFRow row=s.getRow(rownum);
		
			 //row = s.createRow(rownum);
            
			XSSFCell cell = row.createCell(colnum);
			cell.setCellValue(data);

			// Write the data back in the Excel file
			FileOutputStream outputStream = new FileOutputStream(TEST_DATA_SHEET_PATH);
			wb.write(outputStream);
			Thread.sleep(1000);

			// wb.close();
			inputStream.close();
			outputStream.close();

		} catch (Exception e) {
			System.out.println("write exception :" + e);
		}
	
	}
	
	
	
	
	
	private static void write() {
		// TODO Auto-generated method stub
		
	}

	//Take Screen shot of failed Test Cases
																																																																																																																																																																																																																																																										
	public static void takeScreenshot(String testmethodName) throws Exception {
		String dateforrmat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
		
		PassScreenShot = "PassScreenShot_"+dateforrmat;
		FailedScreenShot = "FailedScreenShot_"+dateforrmat;
		
		String currentdir=System.getProperty("user.dir");
		Screenshot = currentdir +"\\Screenshot_"+dateforrmat;
		
		PassScreenShotFolder = Screenshot+"\\"+PassScreenShot;
		FailedScreenShotFolder = Screenshot+"\\"+FailedScreenShot;
		
		
		flScreenshot = new File(Screenshot);
		flPassScreenshotFolder = new File(PassScreenShotFolder);
		flFailScreenshotFolder = new File(FailedScreenShotFolder);
		flScreenshot.mkdir();
		flPassScreenshotFolder.mkdir();
		flFailScreenshotFolder.mkdir();
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentdir=System.getProperty("user.dir");
		//FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+testmethodName+"_" +System.currentTimeMillis()+ ".jpg"));
		FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+testmethodName+"_" +dateforrmat+ ".jpg"));
		
		
		
		
		//Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		//ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
	}	

	
	 public static void failScreenshot(String testClassName) throws IOException {
		 String dateforrmat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
		    FailedScreenShot = "FailedScreenShot_"+dateforrmat;
			
		     currentDir=System.getProperty("user.dir");
			Screenshot = currentDir +"\\Screenshot_"+dateforrmat;
			FailedScreenShotFolder = Screenshot+"\\"+FailedScreenShot;

			flScreenshot = new File(Screenshot);
			
			flFailScreenshotFolder = new File(FailedScreenShotFolder);
			flScreenshot.mkdir();
			
			String s1=flScreenshot.getAbsolutePath();
			flFailScreenshotFolder.mkdir();
			
			String s2=flFailScreenshotFolder.getAbsolutePath();
		
			
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+testClassName+"_" +dateforrmat+ ".jpg"));
			//FileUtils.copyFile(srcfile, new File(currentdir+"/Screenshot/"+dateforrmat+"/FailedScreenShotFolder/"+dateforrmat+testClassName+"_" +dateforrmat+ ".jpg"));
			
			//FileUtils.copyFile(srcfile, new File(Screenshot+FailedScreenShotFolder+testClassName+"_" +dateforrmat+ ".jpg"));
			FileUtils.copyFile(srcfile, new File(s1+s2+"/"+testClassName+"_" +dateforrmat+ ".jpg"));
			
			
	 }
	 public static void passScreenshot(String testClassName) throws IOException {
		 String dateforrmat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
		 PassScreenShot = "PassScreenShot_"+dateforrmat;
			
			String currentdir=System.getProperty("user.dir");
			Screenshot = currentdir +"\\Screenshot_"+dateforrmat;
			PassScreenShotFolder = Screenshot+"\\"+PassScreenShot;

			flScreenshot = new File(Screenshot);
			
			flPassScreenshotFolder = new File(PassScreenShotFolder);
			flScreenshot.mkdir();
			flPassScreenshotFolder.mkdir();
			
			
		
			
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+testClassName+"_" +dateforrmat+ ".jpg"));
			FileUtils.copyFile(srcfile, new File(currentdir+"/Screenshot/"+"/PassScreenShotFolder/"+testClassName+"_" +dateforrmat+ ".jpg"));
		 
	 }
     
}
