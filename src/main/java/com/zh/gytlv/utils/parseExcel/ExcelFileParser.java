package com.zh.gytlv.utils.parseExcel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * Created by Hiiso on 2017/11/22.
 */
public class ExcelFileParser {
	private static Logger myLogger = LoggerFactory.getLogger(ExcelFileParser.class);

    //获取excel工作簿
    public static Workbook getWb(String path) {
        try {
            return WorkbookFactory.create(new File(path));
        } catch (Exception e) {
            throw new RuntimeException("读取EXCEL文件出错", e);
        }
    }

    //判断工作簿的sheet页
    public static Sheet getSheet(Workbook wb, int sheetIndex) {
        if (wb == null) {
            throw new RuntimeException("工作簿对象为空");
        }
        int sheetSize = wb.getNumberOfSheets();
        if (sheetIndex < 0 || sheetIndex > sheetSize - 1) {
            throw new RuntimeException("工作表获取错误");
        }
        return wb.getSheetAt(sheetIndex);
    }

    @SuppressWarnings("unused")
	public static List<List<String>> getExcelRows(Sheet sheet, int startLine, int endLine) {
        List<List<String>> list = new ArrayList<List<String>>();
        String province="";
        String city="";
        // 如果开始行号和结束行号都是-1的话，则全表读取
        if (startLine == -1) startLine = 0;
        if (endLine == -1) endLine = sheet.getLastRowNum() + 1;
        int provinceCount=0;
        for (int i = startLine; i < endLine; i++) {
            Row row = sheet.getRow(i);//获取每一行
            if(row.getCell(0).getCellType()==Cell.CELL_TYPE_STRING){
                provinceCount++;
                myLogger.info(String.valueOf(provinceCount));
                province=row.getCell(0).getStringCellValue().toString();
                myLogger.info(row.getCell(0).getStringCellValue().toString());
            }
            if (row == null) continue;//该行为空则直接跳过
            //int rowSize = row.getLastCellNum();//获取行总数
            List<String> rowList = new ArrayList<String>();
            for (int j = 2; j < 6; j++) {//遍历行
                if(result(city,row.getCell(1))!=null){
                    city=row.getCell(1).getStringCellValue().toString();
                }
                Cell cell = row.getCell(j);
                String temp = "";
                if (cell != null) {//如果单元格不为空
                    temp = result(temp, cell);
                }
                rowList.add(temp);
            }
            if(rowList!=null){
                rowList.add(province);
                rowList.add(city);
            }
            list.add(rowList);
        }
        return list;
    }

    public static String result(String temp, Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                double d = cell.getNumericCellValue();
                int i = (int) d;
                temp = String.valueOf(i);
                break;
            case Cell.CELL_TYPE_STRING:
                temp = cell.getStringCellValue().trim();
                temp = StringUtils.isEmpty(temp) ? "" : temp.trim();
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                temp = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                temp = String.valueOf(cell.getCellFormula().trim());
                break;
            case Cell.CELL_TYPE_BLANK:
                temp = null;
                break;
            case Cell.CELL_TYPE_ERROR:
                temp = "ERROR";
                break;
            default:
                temp = cell.toString().trim();
                break;
        }
        return temp;
    }

    ;

    public static void main(String a[]) {
        String path = "C:/Users/Hiiso/Desktop/kstore/2017-11-22/营业厅信息表全国盖章的test.xlsx";
        Workbook wb = getWb(path);
        List<List<String>> list = getExcelRows(getSheet(wb, 0), 1, -1);
        //int bjCityCount=0;
        //int zjCityCount=0;
        for (int i = 0; i < list.size(); i++) {
            List<String> row = list.get(i);
            if(row.get(0)==null){
                continue;
            }
            for (int j = 0; j < row.size(); j++) {
                /*if("北京".equals(row.get(j))){
                    bjCityCount++;
                    System.out.println("北京");
                    System.out.println("bjCityCount:"+bjCityCount);
                }
                if("zj".equals(row.get(j))){
                    zjCityCount++;
                    System.out.println("zj");
                    System.out.println("zjCityCount:"+zjCityCount);
                }*/
                System.out.print(row.get(j).replaceAll(" ", "") + "\t");
            }
            System.out.println();
            System.out.println("===============================================================================================================================================");
        }
    }

}
