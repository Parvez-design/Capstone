package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public Object[] Read(FileInputStream fis, String index) throws IOException {
//		ArrayList<ArrayList<String>> lis = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<>();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sht =  wb.getSheetAt(0);
		int rowTot = sht.getLastRowNum();
		int colTot = sht.getRow(0).getLastCellNum();
		XSSFRow row = sht.getRow(Integer.parseInt(index));
		for(int i=1; i<colTot; i++) {
			XSSFCell cell = row.getCell(i);
			System.out.print(cell.getCellType()+" ");
			temp.add(cell.getStringCellValue());
			System.out.print(cell.getStringCellValue()+"\t");
		}
		return temp.toArray();
//		for(int i=0; i<=rowTot; i++) {
//			XSSFRow row = sht.getRow(i);
//			
//			for(int j=0; j<colTot; j++) {
//				XSSFCell cell = row.getCell(j);
////				System.out.print(cell.getCellType()+" ");
//				temp.add(cell.getStringCellValue());
////				System.out.print(cell.getStringCellValue()+"\t");
//			}
//			lis.add(new ArrayList<>(temp));
//			temp.clear();
////			System.out.println();
//		}
//		return lis.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
		
	}
}
