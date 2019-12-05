package com.springboot.Utils;

import io.swagger.models.auth.In;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/**
 * @author Sheep
 * 这是一个Excel工具类
 */

public class ExcelUtils {

    /**
    判断文件格式
     */
public Workbook getWorkbook(InputStream instr,String fileName) throws Exception{
    Workbook workbook=null;
    String fileType=fileName.substring(fileName.lastIndexOf("."));
    if(".xls".equals(fileType)){
        workbook=new HSSFWorkbook(instr);
    }else if (".xlsx".equals(fileType)){
        workbook=new XSSFWorkbook(instr);
    }else{
        throw new Exception("请上传Excel文件");
    }
    return workbook;
}

/**
 *处理上传的文件
 */
public List analyzeExcel(InputStream in,String fileName) throws Exception{
    List list=new ArrayList();
    Workbook workbook=this.getWorkbook(in, fileName);
    if (workbook==null){
        throw  new Exception("创建的工作簿为空");
    }
    Sheet sheet=null;
    Row row=null;
    Cell cell=null;

    for (int i=0;i<workbook.getNumberOfSheets();i++){
        sheet=workbook.getSheetAt(i);
        if (sheet==null){
            continue;
        }
        for (int j =sheet.getFirstRowNum();j<sheet.getLastRowNum();j++){
            row=sheet.getRow(j);
            if (row==null||row.getFirstCellNum()==j){
                continue;
            }
            List<Object> li=new ArrayList<>();
            for (int k=row.getFirstCellNum();k<row.getLastCellNum();k++){
                cell=row.getCell(k);
                li.add(cell);
            }
        }

    }
    workbook.close();
    return list;


}


}
