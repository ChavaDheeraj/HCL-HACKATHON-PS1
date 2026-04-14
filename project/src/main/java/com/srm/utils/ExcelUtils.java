package com.srm.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static Object[][] getLoginData() {
        List<Object[]> dataList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/testdata.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("Login");
            if (sheet == null) {
                wb.close();
                return new Object[][] {
                    { ConfigReader.get("username"), ConfigReader.get("password"), true },
                    { "invalid@example.com", "wrongpass", false }
                };
            }
            int rows = sheet.getLastRowNum();
            for (int i = 1; i <= rows; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;
                String email = getCellValue(row.getCell(0));
                String password = getCellValue(row.getCell(1));
                String expected = getCellValue(row.getCell(2));
                if (email.isEmpty()) continue;
                dataList.add(new Object[]{email, password, Boolean.parseBoolean(expected)});
            }
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dataList.isEmpty()) {
            return new Object[][] {
                { ConfigReader.get("username"), ConfigReader.get("password"), true }
            };
        }
        Object[][] data = new Object[dataList.size()][3];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }

    public static Object[][] getSignupData() {

        List<Object[]> dataList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/testdata.xlsx");
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("Sheet1");

            int rows = sheet.getLastRowNum();

            for (int i = 1; i <= rows; i++) {

                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;

                if (row.getCell(0) == null || row.getCell(6) == null) continue;

                String name = getCellValue(row.getCell(0));
                String lastname = getCellValue(row.getCell(1));
                String title = getCellValue(row.getCell(2));
                String day = getCellValue(row.getCell(3));
                String month = getCellValue(row.getCell(4));
                String year = getCellValue(row.getCell(5));
                String email = getCellValue(row.getCell(6));
                String password = getCellValue(row.getCell(7));
                String company = getCellValue(row.getCell(8));
                String address = getCellValue(row.getCell(9));
                String city = getCellValue(row.getCell(10));
                String state = getCellValue(row.getCell(11));
                String zip = getCellValue(row.getCell(12));
                String mobile = getCellValue(row.getCell(13));

                if (email.isEmpty() || password.isEmpty()) continue;

                dataList.add(new Object[]{
                        name, lastname, title, day, month, year,
                        email, password, company, address,
                        city, state, zip, mobile
                });
            }

            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[][] data = new Object[dataList.size()][14];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        return data;
    }

    public static String getCellValue(XSSFCell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}