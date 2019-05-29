package com.ms.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 导出导入excel相关工具
 */
public class ExcelUtil<T> {
    /**
     * datas为导出的数据
     * fileName为excel文件名称
     * sheetName为sheet名称
     * 实体类注解通用导出方法
     *
     * @param datas
     * @param fileName
     * @param sheetName
     */
    public static <T> void exportExcel(List<T> datas, String fileName, String sheetName, HttpServletResponse response, boolean displayAll) throws IOException, IllegalAccessException {
        // String fileExcelName = new SimpleDateFormat("yyyyMMddhh").format(new Date()).toString() + fileName;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        HSSFRow row = sheet.createRow(0);//创建第一行
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFDataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("@"));
        Boolean isHasTitle = false;
        for (int i = 0; i < datas.size(); i++) {
            HSSFRow rowBatch = sheet.createRow(i + 1);
            Object o = datas.get(i);
            // Class c = o.getClass();
            if (!isHasTitle) {
                for (Field field : o.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(ExcelDesc.class)) {
                        //获取字段名
                        //String fieldNames = o.getClass().getSimpleName() + "." + field.getName();
                        //获取字段注解
                        ExcelDesc columnConfig = field.getAnnotation(ExcelDesc.class);
                        if (displayAll) {
                            //判断是否已经获取过该code的字典数据 避免重复获取
                            HSSFCell cell = row.createCell(Integer.valueOf(columnConfig.orderBy().toString()));
                            cell.setCellStyle(cellStyle);
                            cell.setCellValue(columnConfig.value().toString());
                        }
                        if (!displayAll && columnConfig.display()) {
                            HSSFCell cell = row.createCell(Integer.valueOf(columnConfig.orderBy().toString()) - 1);
                            cell.setCellStyle(cellStyle);
                            cell.setCellValue(columnConfig.value().toString());
                        }
                    }
                }
                isHasTitle = true;
            }
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(ExcelDesc.class)) {
                    //获取字段名
                    //  String fieldNames = o.getClass().getSimpleName() + "." + field.getName();
                    //获取字段注解
                    ExcelDesc columnConfig = field.getAnnotation(ExcelDesc.class);
                    if (displayAll) {
                        HSSFCell cell = rowBatch.createCell(Integer.valueOf(columnConfig.orderBy().toString()));
                        cell.setCellStyle(cellStyle);
                        //判断是否已经获取过该code的字典数据 避免重复获取
                        cell.setCellValue(field.get(o) == null ? "" : field.get(o).toString());
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                    if (!displayAll && columnConfig.display()) {
                        HSSFCell cell = rowBatch.createCell(Integer.valueOf(columnConfig.orderBy().toString()) - 1);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue(field.get(o) == null ? "" : field.get(o).toString());
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
            }

        }
        // 弹出保存框方式
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook.write(os);

        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xls");

        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }

        // sheet.autoSizeColumn(i);
        // sheet.SetColumnWidth(i, 100 * 256);
    }


    Class<T> clazz;

    public ExcelUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> importExcel(String fileName, String sheetName, InputStream input) {
        int maxCol = 0;
        List<T> list = new ArrayList<T>();
        try {
            Workbook workbook = null;
            String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            if (".xls".equals(fileType.trim().toLowerCase())) {
                workbook = new HSSFWorkbook(input);// 创建 Excel 2003 工作簿对象
            } else if (".xlsx".equals(fileType.trim().toLowerCase())) {
                workbook = new XSSFWorkbook(input);//创建 Excel 2007 工作簿对象
            }//解决Excel导入的兼容2003和2007版本的问题
            Sheet sheet = workbook.getSheet(sheetName);
            if (!sheetName.trim().equals("")) {
                sheet = workbook.getSheet(sheetName);// 如果指定sheet名,则取指定sheet中的内容.
            }
            if (sheet == null) {
                sheet = workbook.getSheetAt(0); // 如果传入的sheet名不存在则默认指向第1个sheet.
            }
            int rows = sheet.getPhysicalNumberOfRows();

            if (rows > 0) {// 有数据时才处理
                // Field[] allFields = clazz.getDeclaredFields();// 得到类的所有field.
                List<Field> allFields = getMappedFiled(clazz, null);

                Map<Integer, Field> fieldsMap = new HashMap<Integer, Field>();// 定义一个map用于存放列的序号和field.
                for (Field field : allFields) {
                    // 将有注解的field存放到map中.
                    if (field.isAnnotationPresent(ExcelDesc.class)) {
                        ExcelDesc attr = field.getAnnotation(ExcelDesc.class);
                        int col = Integer.valueOf(attr.orderBy().toString());
                        maxCol = Math.max(col, maxCol);
                        System.out.println(col + "====" + field.getName());
                        field.setAccessible(true);// 设置类的私有字段属性可访问.
                        fieldsMap.put(col, field);
                    }
                }
                for (int i = 1; i < rows; i++) {// 从第2行开始取数据,默认第一行是表头.
                    Row row = sheet.getRow(i);
                    // int cellNum = row.getPhysicalNumberOfCells();
                    // int cellNum = row.getLastCellNum();
                    int cellNum = maxCol;
                    T entity = null;
                    for (int j = 0; j < cellNum; j++) {
                        Cell cell = row.getCell(j);
                        if (cell == null) {
                            continue;
                        }
                        int cellType = cell.getCellType();
                        String c = "";
                        if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                            c = String.valueOf(cell.getNumericCellValue());
                        } else if (cellType == HSSFCell.CELL_TYPE_BOOLEAN) {
                            c = String.valueOf(cell.getBooleanCellValue());
                        } else {
                            c = cell.getStringCellValue();
                        }
                        if (c == null || c.equals("")) {
                            continue;
                        }
                        entity = (entity == null ? clazz.newInstance() : entity);// 如果不存在实例则新建.
                        // System.out.println(cells[j].getContents());
                        Field field = fieldsMap.get(j + 1);// 从map中得到对应列的field.
                        if (field == null) {
                            continue;
                        }
                        // 取得类型,并根据对象类型设置值.
                        Class<?> fieldType = field.getType();
                        if (String.class == fieldType) {
                            field.set(entity, String.valueOf(c));
                        } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                            field.set(entity, Integer.parseInt(c));
                        } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                            field.set(entity, Long.valueOf(c));
                        } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                            field.set(entity, Float.valueOf(c));
                        } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                            field.set(entity, Short.valueOf(c));
                        } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                            field.set(entity, Double.valueOf(c));
                        } else if (Character.TYPE == fieldType) {
                            if ((c != null) && (c.length() > 0)) {
                                field.set(entity, Character.valueOf(c.charAt(0)));
                            }
                        }

                    }
                    if (entity != null) {
                        list.add(entity);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 得到实体类所有通过注解映射了数据表的字段
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    private List<Field> getMappedFiled(Class clazz, List<Field> fields) {
        if (fields == null) {
            fields = new ArrayList<Field>();
        }

        Field[] allFields = clazz.getDeclaredFields();// 得到所有定义字段
        // 得到所有field并存放到一个list中.
        for (Field field : allFields) {
            if (field.isAnnotationPresent(ExcelDesc.class)) {
                fields.add(field);
            }
        }
        if (clazz.getSuperclass() != null
                && !clazz.getSuperclass().equals(Object.class)) {
            getMappedFiled(clazz.getSuperclass(), fields);
        }

        return fields;
    }
}