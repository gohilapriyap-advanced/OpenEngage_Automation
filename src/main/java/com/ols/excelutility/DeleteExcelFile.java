package com.ols.excelutility;

import java.io.File;

public class DeleteExcelFile { 
   public static void deleteExcel() { 
      try { 
         File file = new File(".//TestData//OlsRegistration.xlsx");
         if(file.delete()) { 
            System.out.println(file.getName() + " is deleted!");
         } else {
            System.out.println("Delete operation is failed.");
    		}
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}
