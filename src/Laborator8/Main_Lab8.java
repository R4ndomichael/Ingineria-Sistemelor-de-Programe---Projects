import org.apache.poi.ss.usermodel.*;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Main_Lab8 {

    static final String INPUT_FILE = "laborator8_input.xlsx";

    public static void main(String[] args) {
        readExcel(INPUT_FILE);
        writeExcelWithAvg(INPUT_FILE, "laborator8_output2.xlsx");
        writeExcelWithFormula(INPUT_FILE, "laborator8_output3.xlsx");
    }

    // 8.5.1 — Citire si afisare in consola
    static void readExcel(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t");
                        case STRING  -> System.out.print(cell.getStringCellValue() + "\t");
                        default      -> System.out.print("?\t");
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8.5.2 — Copiere + coloana medie calculata in Java
    static void writeExcelWithAvg(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook inputWb = new XSSFWorkbook(fis);
             Workbook outputWb = new XSSFWorkbook()) {

            Sheet inputSheet = inputWb.getSheetAt(0);
            Sheet outputSheet = outputWb.createSheet("Sheet1");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                int lastCol = inputRow.getLastCellNum(); // index dupa ultima celula

                // Copiem toate celulele existente
                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());
                    switch (inputCell.getCellType()) {
                        case NUMERIC -> outputCell.setCellValue(inputCell.getNumericCellValue());
                        case STRING  -> outputCell.setCellValue(inputCell.getStringCellValue());
                        default      -> outputCell.setCellValue("");
                    }
                }

                // Adaugam coloana medie (doar pentru randurile cu date, nu header)
                if (inputRow.getRowNum() == 0) {
                    // rand header
                    outputRow.createCell(lastCol).setCellValue("Medie");
                } else {
                    double nota1 = inputRow.getCell(3).getNumericCellValue();
                    double nota2 = inputRow.getCell(4).getNumericCellValue();
                    double nota3 = inputRow.getCell(5).getNumericCellValue();
                    double medie = (nota1 + nota2 + nota3) / 3.0;
                    outputRow.createCell(lastCol).setCellValue(medie);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                outputWb.write(fos);
            }
            System.out.println("Scris: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8.5.3 — Copiere + coloana medie cu formula Excel AVERAGE
    static void writeExcelWithFormula(String inputFile, String outputFile) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook inputWb = new XSSFWorkbook(fis);
             Workbook outputWb = new XSSFWorkbook()) {

            Sheet inputSheet = inputWb.getSheetAt(0);
            Sheet outputSheet = outputWb.createSheet("Sheet1");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                int lastCol = inputRow.getLastCellNum();

                // Copiem toate celulele
                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());
                    switch (inputCell.getCellType()) {
                        case NUMERIC -> outputCell.setCellValue(inputCell.getNumericCellValue());
                        case STRING  -> outputCell.setCellValue(inputCell.getStringCellValue());
                        default      -> outputCell.setCellValue("");
                    }
                }

                // Coloana medie
                if (inputRow.getRowNum() == 0) {
                    outputRow.createCell(lastCol).setCellValue("Medie");
                } else {
                    // +1 pentru ca Excel are randuri 1-indexed
                    int excelRow = inputRow.getRowNum() + 1;
                    String formula = "AVERAGE(D" + excelRow + ":F" + excelRow + ")";
                    outputRow.createCell(lastCol).setCellFormula(formula);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                outputWb.write(fos);
            }
            System.out.println("Scris: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

