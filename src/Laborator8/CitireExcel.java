package Laborator8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class CitireExcel {

    static final String INPUT_FILE = "src/Laborator8/laborator8_input.xlsx";

    public static void main(String[] args) {
        readExcel(INPUT_FILE);
        writeExcelWithAvg(INPUT_FILE, "src/Laborator8/laborator8_output2.xlsx");
        writeExcelWithFormula(INPUT_FILE, "src/Laborator8/laborator8_output3.xlsx");
    }

    // 8.5.1
    static void readExcel(String fileName) {
        try (InputStream fis = new FileInputStream(fileName)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + "\t");
                    } else if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t");
                    }
                }
                System.out.println();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // 8.5.2
    static void writeExcelWithAvg(String inputFile, String outputFile) {
        try (InputStream fis = new FileInputStream(inputFile)) {
            Workbook inputWorkbook = new XSSFWorkbook(fis);
            Sheet inputSheet = inputWorkbook.getSheetAt(0);

            XSSFWorkbook workbook2 = new XSSFWorkbook();
            XSSFSheet sheet2 = workbook2.createSheet();

            int rowNum = 0;
            for (Row inputRow : inputSheet) {
                Row row2 = sheet2.createRow(rowNum++);
                int colNum = 0;


                for (Cell inputCell : inputRow) {
                    Cell cell2 = row2.createCell(colNum++);
                    if (inputCell.getCellType() == CellType.NUMERIC) {
                        cell2.setCellValue(inputCell.getNumericCellValue());
                    } else if (inputCell.getCellType() == CellType.STRING) {
                        cell2.setCellValue(inputCell.getStringCellValue());
                    }
                }


                Cell cell2 = row2.createCell(colNum);
                if (inputRow.getRowNum() == 0) {
                    cell2.setCellValue("Medie");
                } else {
                    double nota1 = inputRow.getCell(3).getNumericCellValue();
                    double nota2 = inputRow.getCell(4).getNumericCellValue();
                    double nota3 = inputRow.getCell(5).getNumericCellValue();
                    cell2.setCellValue((nota1 + nota2 + nota3) / 3.0);
                }
            }

            try {
                FileOutputStream out = new FileOutputStream(outputFile);
                workbook2.write(out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // 8.5.3
    static void writeExcelWithFormula(String inputFile, String outputFile) {
        try (InputStream fis = new FileInputStream(inputFile)) {
            Workbook inputWorkbook = new XSSFWorkbook(fis);
            Sheet inputSheet = inputWorkbook.getSheetAt(0);

            XSSFWorkbook workbook2 = new XSSFWorkbook();
            XSSFSheet sheet2 = workbook2.createSheet();

            int rowNum = 0;
            for (Row inputRow : inputSheet) {
                Row row2 = sheet2.createRow(rowNum++);
                int colNum = 0;


                for (Cell inputCell : inputRow) {
                    Cell cell2 = row2.createCell(colNum++);
                    if (inputCell.getCellType() == CellType.NUMERIC) {
                        cell2.setCellValue(inputCell.getNumericCellValue());
                    } else if (inputCell.getCellType() == CellType.STRING) {
                        cell2.setCellValue(inputCell.getStringCellValue());
                    }
                }


                Cell cell2 = row2.createCell(colNum);
                if (inputRow.getRowNum() == 0) {
                    cell2.setCellValue("Medie");
                } else {
                    int excelRow = inputRow.getRowNum() + 1;
                    cell2.setCellFormula("AVERAGE(D" + excelRow + ":F" + excelRow + ")");
                }
            }

            try {
                FileOutputStream out = new FileOutputStream(outputFile);
                workbook2.write(out);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}