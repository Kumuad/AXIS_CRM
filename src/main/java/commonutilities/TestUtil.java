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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;



import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import testbase.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=70;
	public static long IMPLICIT_WAIT=80;
	
	
	
	
	//public static String TEST_DATA_SHEET_PATH="C:\\Users\\Kumuad Sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\testdata\\ServiceRequest.xlsx";
	
	
	//public static String TEST_DATA_SHEET_PATH="C:\\Users\\Kumuad Sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\testdata\\AccountCreation.xlsx";
	//kumuad.sagar
	public static String TEST_DATA_SHEET_PATH="C:\\Users\\kumuad.sagar\\eclipse-workspace\\AxisCRM\\src\\main\\java\\testdata\\AccountCreation.xlsx";
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
	
	static String FileDateTime = null;
	static File FilePath = null;
	
	
	public static String outPutFolder;
	public static String ScreenShotFolder;

	public static File flOutput;
	public static File flScreenShotFolder, src, dest;
	public static File flFailedScreenShotFolder;
		
	public static String ScreenShotPath;
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
	
	
	
	public static int getRowCount(String sheetName) throws IOException{
		
		 FileInputStream file= new FileInputStream(TEST_DATA_SHEET_PATH);
		  
		wb=new XSSFWorkbook(file); 
		int index = wb.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
		sheet = wb.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
		return number;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*

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
		
		//File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentdir=System.getProperty("user.dir");
		//FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+testmethodName+"_" +System.currentTimeMillis()+ ".jpg"));
		//FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+testmethodName+"_" +dateforrmat+ ".jpg"));
		
		
		//String ScreenShotPath=Screenshot+"\\"+" "+PassScreenShotFolder+" "+testClassName+".jpeg";
		
		//Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		//ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
	}	

	
	 public static void failScreenshot(String testClassName) throws IOException {
		
		 try
		 {
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
		
			
		//	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+testClassName+"_" +dateforrmat+ ".jpg"));
			//FileUtils.copyFile(srcfile, new File(currentdir+"/Screenshot/"+dateforrmat+"/FailedScreenShotFolder/"+dateforrmat+testClassName+"_" +dateforrmat+ ".jpg"));
			
			//FileUtils.copyFile(srcfile, new File(Screenshot+FailedScreenShotFolder+testClassName+"_" +dateforrmat+ ".jpg"));
			//FileUtils.copyFile(srcfile, new File(s1+s2+"/"+testClassName+"_" +dateforrmat+ ".jpg"));
			
			
             String ScreenShotPath=FailedScreenShotFolder+" " +testClassName+".jpeg";
			
			Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		    ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
		 }
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
			
	 }
	 public static void passScreenshot(String testClassName) throws IOException {
		 String dateforrmat = new SimpleDateFormat("dd-MM-yyyy HH").format(new Date());
		   PassScreenShot = "PassScreenShot_"+dateforrmat;
			
			String currentdir=System.getProperty("user.dir");
			Screenshot = currentdir +"\\Screenshot_"+dateforrmat;
			PassScreenShotFolder = Screenshot+"\\"+PassScreenShot;

			flScreenshot = new File(Screenshot);
			
			flPassScreenshotFolder = new File(PassScreenShotFolder);
			flScreenshot.mkdir();
			flPassScreenshotFolder.mkdir();
			
			
		
			
			///File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//FileUtils.copyFile(srcfile, new File(currentdir +"/Screenshots/"+testClassName+"_" +dateforrmat+ ".jpg"));
			//FileUtils.copyFile(srcfile, new File(currentdir+"/Screenshot/"+"/PassScreenShotFolder/"+testClassName+"_" +dateforrmat+ ".jpg"));
			
			
			String ScreenShotPath=Screenshot+"\\"+" "+PassScreenShotFolder+" "+testClassName+".jpeg";
			
			Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		    ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
		 
	 }
	 
	 
	 
	 
	 */
	 
//=====================================================	 
	 
	
	

	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//=====================================================	 
	 //actual code
	 
	
 
	 public static void screenShotFolder()
		{
			
			String folderDate = new SimpleDateFormat("dd-MM-yyyy HH").format(new Date());
			
			
		//
			// FailedScreenShot = "FailedScreenShot_"+folderDate;
		
			currentDir = System.getProperty("user.dir") + "\\Screenshots";

			outPutFolder = currentDir + "\\Output_" + folderDate;
			PassScreenShot = "PassScreenShot_" + folderDate;
			ScreenShotFolder = outPutFolder + "\\" + PassScreenShot;
			
			
			FailedScreenShot = "FailedScreenShot_" + folderDate;
			FailedScreenShotFolder = outPutFolder + "\\" + FailedScreenShot;
           
			flOutput = new File(outPutFolder);
			if (!flOutput.exists()) {
				if (flOutput.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}

			flScreenShotFolder = new File(ScreenShotFolder);
			if (!flScreenShotFolder.exists()) {
				if (flScreenShotFolder.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
				
				//FilePath = flScreenShotFolder;
			}
			FilePath = flScreenShotFolder;
			
			
			
			
			flFailedScreenShotFolder = new File(FailedScreenShotFolder);
			if (!flFailedScreenShotFolder.exists()) {
				if (flFailedScreenShotFolder.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
				
				//FilePath = flFailedScreenShotFolder;
			}
			//FilePath = flFailedScreenShotFolder;
			
			

			//return FilePath;
				
		}
	 
	
	 
	 
	 
	 public static File failscreenShotFolder()
		{
			
			String folderDate = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());

			FailedScreenShot = "FailedScreenShot_" + folderDate;
			currentDir = System.getProperty("user.dir") + "\\Screenshots";

			outPutFolder = currentDir + "\\Output_" + folderDate;

			FailedScreenShotFolder = outPutFolder + "\\" + FailedScreenShot;
			// flFailScreenshotFolder = new File(FailedScreenShotFolder);

			flOutput = new File(outPutFolder);
			if (!flOutput.exists()) {
				if (flOutput.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}

			flScreenShotFolder = new File(FailedScreenShotFolder);
			if (!flScreenShotFolder.exists()) {
				if (flScreenShotFolder.mkdir()) {
					System.out.println("Directory is created!");
				} else {
					System.out.println("Failed to create directory!");
				}
			}
			FilePath = flScreenShotFolder;

			
			return FilePath;
				
		}
	 
	 
 
	
	 
	   //To capture screen shot of complete web page from start to end
		public static String takeScreenShot(String name) throws IOException
		{
			String ScreenShotPath=null;
			try {
			Screenshot ss= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			//ScreenShotPath=screenShotFolder()+"\\"+name+".jpeg";
			 ScreenShotPath=CustomListener.ScreenShotFolder+"\\"+name+".jpeg";
			//ScreenShotPath=outPutFolder+"\\"+" "+ScreenShotFolder+" "+name+".jpeg";
			
			ImageIO.write(ss.getImage(), "jpeg", new File(ScreenShotPath));
			}
			catch(Exception e) {
				
			}
		return ScreenShotPath;
		}


	 
	 
		
		public static String failScreenShot(String methodname) throws IOException
		{
			String ScreenShotPath=null;
			try {
			Screenshot ss= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			
			
			//ScreenShotPath=System.getProperty("user.dir")+"\\Reports\\FailedScreenShot_"+methodname+".jpeg";
			ScreenShotPath=CustomListener.FailedScreenShotFolder+"\\"+methodname+".jpeg";
		//	ScreenShotPath=screenShotFolder()+"\\"   +methodname+".jpeg";
			//ScreenShotPath=screenShotFolder()+"\\"+" "+FailedScreenShotFolder+" "+methodname+".jpeg";
			ImageIO.write(ss.getImage(), "jpeg", new File(ScreenShotPath));
			}
			catch(Exception e) {
				
			}
			return ScreenShotPath;
		}
		
		
		
		
		/* public static void takeScreenShot(String methodName) throws IOException, InterruptedException {

			ScreenShotPath = CustomListener.ScreenShotFolder + "\\" + " " + methodName.toUpperCase() + ".jpeg";

			// String
			// ScreenShotPath="./target/Passcreenshots/"+DS.TestCaseDes+DS.PassScreenShot+".jpeg";
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
					.takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));

		}
*/
		
		
		/*public static void failScreenShot(String methodName) throws IOException, InterruptedException {

			ScreenShotPath=CustomListener.FailedScreenShotFolder+"\\"+" "+methodName.toUpperCase()+".jpeg";
			//String ScreenShotPath="./target/Failscreenshots/"+DS.TestCaseDes+DS.FailedScreenShot+".jpeg";
			Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "JPEG", new File(ScreenShotPath));
			
		}
		 
		
	*/	
		
		
		
		
		
		
		
		
		
}
