package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeneratePdf {
   public int createPdf(String[] data) throws Exception {
	   FileInputStream fsIP= new FileInputStream(new File("E:\\Eclipse Web\\workspace\\ResultManagementSystem\\File\\Demo.xlsx"));
       
	   XSSFWorkbook wb = new XSSFWorkbook(fsIP);
         
       XSSFSheet worksheet = wb.getSheetAt(0);
         
       Cell cell = null;
       
       cell = worksheet.getRow(5).getCell(3);
       cell.setCellValue(data[1]);
       
       cell = worksheet.getRow(5).getCell(6);
       cell.setCellValue(data[2]+"/"+data[3]);
       
       cell = worksheet.getRow(6).getCell(4);
       cell.setCellValue(data[0]);  
       
       cell = worksheet.getRow(10).getCell(7);
       cell.setCellValue(Integer.parseInt(data[4])); 
       
       if(Integer.parseInt(data[4])>=34)
       {
    	   cell = worksheet.getRow(10).getCell(9);
           cell.setCellValue("Pass");
       }
       else
       {
    	   cell = worksheet.getRow(10).getCell(9);
           cell.setCellValue("Fail");
       }
       
       // Grade
       if(Integer.parseInt(data[4])>90 &&Integer.parseInt(data[4])<=100)
       {
           cell = worksheet.getRow(10).getCell(8);
           cell.setCellValue("O");
       }
       else if(Integer.parseInt(data[4])>80 &&Integer.parseInt(data[4])<=90)
       {
           cell = worksheet.getRow(10).getCell(8);
           cell.setCellValue("A+");
       }
       else if(Integer.parseInt(data[4])>70 &&Integer.parseInt(data[4])<=80)
       {
           cell = worksheet.getRow(10).getCell(8);
           cell.setCellValue("A");
       }
       else if(Integer.parseInt(data[4])>60 &&Integer.parseInt(data[4])<=70)
       {
           cell = worksheet.getRow(10).getCell(8);
           cell.setCellValue("B+");
       }
       else if(Integer.parseInt(data[4])>50 &&Integer.parseInt(data[4])<=60)
       {
           cell = worksheet.getRow(10).getCell(8);
           cell.setCellValue("B");
       }
       else if(Integer.parseInt(data[4])>34 &&Integer.parseInt(data[4])<=50)
       {
           cell = worksheet.getRow(10).getCell(8);
           cell.setCellValue("C");
       }
       else
       {
           cell = worksheet.getRow(10).getCell(8);
           cell.setCellValue("F");
       }
       
       cell = worksheet.getRow(11).getCell(7);
       cell.setCellValue(Integer.parseInt(data[5])); 
       
       if(Integer.parseInt(data[5])>=34)
       {
    	   cell = worksheet.getRow(11).getCell(9);
           cell.setCellValue("Pass");
       }
       else
       {
    	   cell = worksheet.getRow(11).getCell(9);
           cell.setCellValue("Fail");
       }
       
       // Grade
       if(Integer.parseInt(data[5])>90 &&Integer.parseInt(data[5])<=100)
       {
           cell = worksheet.getRow(11).getCell(8);
           cell.setCellValue("O");
       }
       else if(Integer.parseInt(data[5])>80 &&Integer.parseInt(data[5])<=90)
       {
           cell = worksheet.getRow(11).getCell(8);
           cell.setCellValue("A+");
       }
       else if(Integer.parseInt(data[5])>70 &&Integer.parseInt(data[5])<=80)
       {
           cell = worksheet.getRow(11).getCell(8);
           cell.setCellValue("A");
       }
       else if(Integer.parseInt(data[5])>60 &&Integer.parseInt(data[5])<=70)
       {
           cell = worksheet.getRow(11).getCell(8);
           cell.setCellValue("B+");
       }
       else if(Integer.parseInt(data[5])>50 &&Integer.parseInt(data[5])<=60)
       {
           cell = worksheet.getRow(11).getCell(8);
           cell.setCellValue("B");
       }
       else if(Integer.parseInt(data[5])>34 &&Integer.parseInt(data[5])<=50)
       {
           cell = worksheet.getRow(11).getCell(8);
           cell.setCellValue("C");
       }
       else
       {
           cell = worksheet.getRow(11).getCell(8);
           cell.setCellValue("F");
       }
       
       cell = worksheet.getRow(12).getCell(7);
       cell.setCellValue(Integer.parseInt(data[6]));
       
       if(Integer.parseInt(data[6])>=34)
       {
    	   cell = worksheet.getRow(12).getCell(9);
           cell.setCellValue("Pass");
       }
       else
       {
    	   cell = worksheet.getRow(12).getCell(9);
           cell.setCellValue("Fail");
       }
       
       // Grade
       if(Integer.parseInt(data[6])>90 &&Integer.parseInt(data[6])<=100)
       {
           cell = worksheet.getRow(12).getCell(8);
           cell.setCellValue("O");
       }
       else if(Integer.parseInt(data[6])>80 &&Integer.parseInt(data[6])<=90)
       {
           cell = worksheet.getRow(12).getCell(8);
           cell.setCellValue("A+");
       }
       else if(Integer.parseInt(data[6])>70 &&Integer.parseInt(data[6])<=80)
       {
           cell = worksheet.getRow(12).getCell(8);
           cell.setCellValue("A");
       }
       else if(Integer.parseInt(data[6])>60 &&Integer.parseInt(data[6])<=70)
       {
           cell = worksheet.getRow(12).getCell(8);
           cell.setCellValue("B+");
       }
       else if(Integer.parseInt(data[6])>50 &&Integer.parseInt(data[6])<=60)
       {
           cell = worksheet.getRow(12).getCell(8);
           cell.setCellValue("B");
       }
       else if(Integer.parseInt(data[6])>34 &&Integer.parseInt(data[6])<=50)
       {
           cell = worksheet.getRow(12).getCell(8);
           cell.setCellValue("C");
       }
       else
       {
           cell = worksheet.getRow(12).getCell(8);
           cell.setCellValue("F");
       }
       
       cell = worksheet.getRow(13).getCell(7);
       cell.setCellValue(Integer.parseInt(data[7])); 
       
       if(Integer.parseInt(data[7])>=34)
       {
    	   cell = worksheet.getRow(13).getCell(9);
           cell.setCellValue("Pass");
       }
       else
       {
    	   cell = worksheet.getRow(13).getCell(9);
           cell.setCellValue("Fail");
       }
       
       // Grade
       if(Integer.parseInt(data[7])>90 &&Integer.parseInt(data[7])<=100)
       {
           cell = worksheet.getRow(13).getCell(8);
           cell.setCellValue("O");
       }
       else if(Integer.parseInt(data[7])>80 &&Integer.parseInt(data[7])<=90)
       {
           cell = worksheet.getRow(13).getCell(8);
           cell.setCellValue("A+");
       }
       else if(Integer.parseInt(data[7])>70 &&Integer.parseInt(data[7])<=80)
       {
           cell = worksheet.getRow(13).getCell(8);
           cell.setCellValue("A");
       }
       else if(Integer.parseInt(data[7])>60 &&Integer.parseInt(data[7])<=70)
       {
           cell = worksheet.getRow(13).getCell(8);
           cell.setCellValue("B+");
       }
       else if(Integer.parseInt(data[7])>50 &&Integer.parseInt(data[7])<=60)
       {
           cell = worksheet.getRow(13).getCell(8);
           cell.setCellValue("B");
       }
       else if(Integer.parseInt(data[7])>34 &&Integer.parseInt(data[7])<=50)
       {
           cell = worksheet.getRow(13).getCell(8);
           cell.setCellValue("C");
       }
       else
       {
           cell = worksheet.getRow(13).getCell(8);
           cell.setCellValue("F");
       }
       
       cell = worksheet.getRow(14).getCell(7);
       cell.setCellValue(Integer.parseInt(data[8])); 
       
       if(Integer.parseInt(data[8])>=34)
       {
    	   cell = worksheet.getRow(14).getCell(9);
           cell.setCellValue("Pass");
       }
       else
       {
    	   cell = worksheet.getRow(14).getCell(9);
           cell.setCellValue("Fail");
       }
       
       // Grade
       if(Integer.parseInt(data[8])>90 &&Integer.parseInt(data[8])<=100)
       {
           cell = worksheet.getRow(14).getCell(8);
           cell.setCellValue("O");
       }
       else if(Integer.parseInt(data[8])>80 &&Integer.parseInt(data[8])<=90)
       {
           cell = worksheet.getRow(14).getCell(8);
           cell.setCellValue("A+");
       }
       else if(Integer.parseInt(data[8])>70 &&Integer.parseInt(data[8])<=80)
       {
           cell = worksheet.getRow(14).getCell(8);
           cell.setCellValue("A");
       }
       else if(Integer.parseInt(data[8])>60 &&Integer.parseInt(data[8])<=70)
       {
           cell = worksheet.getRow(14).getCell(8);
           cell.setCellValue("B+");
       }
       else if(Integer.parseInt(data[8])>50 &&Integer.parseInt(data[8])<=60)
       {
           cell = worksheet.getRow(14).getCell(8);
           cell.setCellValue("B");
       }
       else if(Integer.parseInt(data[8])>34 &&Integer.parseInt(data[8])<=50)
       {
           cell = worksheet.getRow(14).getCell(8);
           cell.setCellValue("C");
       }
       else
       {
           cell = worksheet.getRow(14).getCell(8);
           cell.setCellValue("F");
       }
       
       cell = worksheet.getRow(15).getCell(7);
       cell.setCellValue(Integer.parseInt(data[9])*5); 
       
       cell = worksheet.getRow(17).getCell(8);
       cell.setCellValue(Integer.parseInt(data[9]));
       
       if(Integer.parseInt(data[9])>90 &&Integer.parseInt(data[9])<=100)
       {
           cell = worksheet.getRow(17).getCell(5);
           cell.setCellValue("O");
       }
       else if(Integer.parseInt(data[9])>80 &&Integer.parseInt(data[9])<=90)
       {
           cell = worksheet.getRow(17).getCell(5);
           cell.setCellValue("A+");
       }
       else if(Integer.parseInt(data[9])>70 &&Integer.parseInt(data[9])<=80)
       {
           cell = worksheet.getRow(17).getCell(5);
           cell.setCellValue("A");
       }
       else if(Integer.parseInt(data[9])>60 &&Integer.parseInt(data[9])<=70)
       {
           cell = worksheet.getRow(17).getCell(5);
           cell.setCellValue("B+");
       }
       else if(Integer.parseInt(data[9])>50 &&Integer.parseInt(data[9])<=60)
       {
           cell = worksheet.getRow(17).getCell(5);
           cell.setCellValue("B");
       }
       else if(Integer.parseInt(data[9])>34 &&Integer.parseInt(data[9])<=50)
       {
           cell = worksheet.getRow(17).getCell(5);
           cell.setCellValue("C");
       }
       else
       {
           cell = worksheet.getRow(17).getCell(5);
           cell.setCellValue("F");
       }
       
       fsIP.close(); 
        
       FileOutputStream output_file =new FileOutputStream(new File(System.getProperty("user.dir")+"\\Result.xlsx"));  //Open FileOutputStream to write updates
       System.out.println(System.getProperty("user.dir"));
       wb.write(output_file); 
         
       output_file.close(); 
      wb.close();
      System.out.println("Result.xlsx downloaded successfully");
      return 1;
   }
}