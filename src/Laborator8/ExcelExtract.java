
/*

import org.apache.poi.hssf.usermodel.HSSFWorkbook;



import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;


public class ExcelExtract {

    // 8.5.1
    public static void readExcel(File file) {
        try (InputStream in = new FileInputStream(file)) {

            Workbook workbook = new XSSFWorkbook(in);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {

                    if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + " ");
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + " ");
                    }
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 8.5.2
    public static void copyWithAverage(String input, String output) {
        try (
                InputStream in = new FileInputStream(input);
                Workbook wbIn = new XSSFWorkbook(in)
        ) {
            Sheet sheetIn = wbIn.getSheetAt(0);

            Workbook wbOut = new XSSFWorkbook();
            Sheet sheetOut = wbOut.createSheet();

            int rowNum = 0;

            for (Row row : sheetIn) {
                Row newRow = sheetOut.createRow(rowNum);
                int colNum = 0;

                double[] last3 = new double[3];
                int index = 0;

                for (Cell cell : row) {
                    Cell newCell = newRow.createCell(colNum);

                    if (cell.getCellType() == CellType.NUMERIC) {
                        double val = cell.getNumericCellValue();
                        newCell.setCellValue(val);

                        if (index < 3) {
                            last3[index++] = val;
                        }
                    } else {
                        newCell.setCellValue(cell.toString());
                    }

                    colNum++;
                }

                // media
                double avg = (last3[0] + last3[1] + last3[2]) / 3;
                newRow.createCell(colNum).setCellValue(avg);

                rowNum++;
            }

            FileOutputStream out = new FileOutputStream(output);
            wbOut.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 8.5.3
    public static void copyWithFormula(String input, String output) {
        try (
                InputStream in = new FileInputStream(input);
                Workbook wbIn = new XSSFWorkbook(in)
        ) {
            Sheet sheetIn = wbIn.getSheetAt(0);

            Workbook wbOut = new XSSFWorkbook();
            Sheet sheetOut = wbOut.createSheet();

            int rowNum = 0;

            for (Row row : sheetIn) {
                Row newRow = sheetOut.createRow(rowNum);
                int colNum = 0;

                for (Cell cell : row) {
                    Cell newCell = newRow.createCell(colNum);
                    newCell.setCellValue(cell.toString());
                    colNum++;
                }

                // formula Excel (D:F)
                int excelRow = rowNum + 1;
                Cell formulaCell = newRow.createCell(colNum);
                formulaCell.setCellFormula("AVERAGE(D" + excelRow + ":F" + excelRow + ")");

                rowNum++;
            }

            FileOutputStream out = new FileOutputStream(output);
            wbOut.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 8.5.4 a
    public static void writeStudents(List<Student> students, String fileName) {
        try {
            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet();

            int rowNum = 0;

            for (Student s : students) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.getName());
                row.createCell(1).setCellValue(s.getGrade());
            }

            FileOutputStream out = new FileOutputStream(fileName);
            wb.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 8.5.4 b
    public static List<Student> readStudents(String fileName) {
        List<Student> list = new ArrayList<>();

        try (InputStream in = new FileInputStream(fileName)) {
            Workbook wb = new HSSFWorkbook(in);
            Sheet sheet = wb.getSheetAt(0);

            for (Row row : sheet) {
                String name = row.getCell(0).getStringCellValue();
                double grade = row.getCell(1).getNumericCellValue();

                list.add(new Student(name, grade));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}


*/