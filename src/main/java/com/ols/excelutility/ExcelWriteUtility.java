package com.ols.excelutility;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteUtility {
   public static void writeDataToExcel() throws Exception {

      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook();
      
      //Create a blank sheet
      XSSFSheet spreadsheetPerson = workbook.createSheet("Persons");

      //Create row object
      XSSFRow row;
      
      String currentTime = getDateTime();

      //This data needs to be written (Object[])
  	 Map < String, Object[] > personInfo = new TreeMap < String, Object[] >();     
      personInfo.put( "1", new Object[] {
         "Forename", "Surname", "Email", "ConfirmEmail"});
      
      personInfo.put( "2", new Object[] { 
         "Mike"+currentTime, "John"+currentTime, "Mike"+currentTime+"@ols.com", "Mike"+currentTime+"@ols.com"});
      
      //Iterate over data and write to sheet
      Set < String > keyPerson = personInfo.keySet();
      int rowPerson = 0;
      
      for (String key : keyPerson) {
         row = spreadsheetPerson.createRow(rowPerson++);
         Object [] objectArr = personInfo.get(key);
         int cellid = 0;
         
         for (Object obj : objectArr){
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }
      
      
   /* //This data needs to be written (Object[])
      Map < String, Object[] > organisationInfo = new TreeMap < String, Object[] >();
      organisationInfo.put( "1", new Object[] {
         "Name", "Building"});
      
      organisationInfo.put( "2", new Object[] {
         "Organisation"+currentTime, "Building"+currentTime });
      
      //Iterate over data and write to sheet
      Set < String > keyOrgnisation = organisationInfo.keySet();
      int rowOrganisation = 0;
      
      for (String key : keyOrgnisation) {
         row = spreadsheetOrganisation.createRow(rowOrganisation++);
         Object [] objectArr = organisationInfo.get(key);
         int cellid = 0;
         
         for (Object obj : objectArr){
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }*/
      
      
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(
         new File(".//TestData//OlsRegistration.xlsx"));
      
      workbook.write(out);
      out.close();
      workbook.close();
      System.out.println(".//TestData//OlsRegistration.xlsx written successfully");
   }
   
   
 //To get date-time
 	public static String getDateTime() {

 		// Create object of SimpleDateFormat class and decide the format
 		DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");

 		// get current date time with Date()
 		Date date = new Date();

 		// Now format the date
 		String currentDate = dateFormat.format(date);

 		String newDate = currentDate.replace('/',' ');
 		String newCurrentDate = newDate.replace(':',' ');
 		return newCurrentDate;

 	}
}