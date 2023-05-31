package datadriventest_apachepoi;

import java.awt.image.IndexColorModel;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class FormattingCellWithColor_6 {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wrk=new XSSFWorkbook();
		XSSFSheet sht=wrk.createSheet("StyleSheet");
		
		XSSFRow row=sht.createRow(0);
		
		//cell--0
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("Hi..Aniket here");
		//background color-->Creating style
		XSSFCellStyle style=wrk.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());//return index of color and set to cell
		style.setFillPattern(FillPatternType.DIAMONDS);
		//set style to cell
		cell.setCellStyle(style);
		
		//cell-1
		 cell=row.createCell(1);
		 cell.setCellValue("Do you Love me?");
		 //ForegroundColor-->creating style for cell
		style=wrk.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		style.setFillPattern(FillPatternType.FINE_DOTS);
		
		//set style to cell
		cell.setCellStyle(style);
		
      FileOutputStream out=new FileOutputStream(".//datafiles//styles.xlsx");
      wrk.write(out);
      out.close();
      System.out.println("Done!");
      
	}

}
