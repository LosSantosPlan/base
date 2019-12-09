package com.springboot.Utils;
import com.springboot.Entity.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;
import java.util.*;

/**
 * @author Sheep
 * 这是一个Excel工具类
 */

public class ExcelUtils {

    /**
     * 判断文件格式
     * @param instr 读取上传的Excel
     * @param fileName Excel文件名称
     */
    public Workbook getWorkbook(InputStream instr, String fileName) throws Exception {
        Workbook workbook = null;
        //截取文件名"."之后的内容
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        //判断生成的工作簿类型
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(instr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(instr);
        } else {
            throw new Exception("请上传Excel文件");
        }
        return workbook;
    }

    /**
     * 处理上传的文件
     * @param in 读取上传的Excel文件
     * @param fileName 文件名称
     */
    public List analyzeExcel(InputStream in, String fileName) throws Exception {
        //获取工作簿，进行判断
        Workbook workbook = this.getWorkbook(in, fileName);
        //获取第一个sheet
        Sheet sheet=workbook.getSheetAt(0);
        List<Person> list=new ArrayList<>();
        //循环获取这一个sheet中所有的行row
        for (int i=0;i<sheet.getPhysicalNumberOfRows();i++){
            Row row=sheet.getRow(i);
            //循环获取这一行里所有的单元格Cell
            for (int j=0;j<row.getPhysicalNumberOfCells();j++);{
                Person person=new Person();
                //按位置获取单元格内的数据，并进行类型转换
                person.setName(row.getCell(0).getStringCellValue());
                person.setAge(Integer.valueOf((int)row.getCell(1).getNumericCellValue()));
                person.setSalary(Integer.valueOf((int)row.getCell(2).getNumericCellValue()));
                list.add(person);
            }

        }
        return list;

    }

}