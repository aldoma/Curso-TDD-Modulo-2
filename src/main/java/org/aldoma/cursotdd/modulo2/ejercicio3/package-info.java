/**
 * Tercer ejercicio del módulo 2.
 * <p>
 * <h2>Enunciado del ejercicio:</h2>
 * <p>
 * Proponga refactorizaciones para mejorar el siguiente método:
 * 
 * <pre>
 * public class TableToExcel {
 * 	public <R,C,V> void tableToExcel(String fN, Table<R,C,V> t)
 * 		throws IOException {
 * 		// 1.Create book and sheet
 * 		Workbook wb = new Workbook();
 * 		CreationHelper createHelper = wb.getCreationHelper();
 * 		Sheet sheet = wb.createSheet("Sheet");
 * 		Row row;
 * 		Cell cell;
 * 		int cellIndex, rowIndex=0;
 * 		for (R r: t.rowKeySet()) {
 * 			// Create a row in book for each row in table.
 * 			//Rows are 0 based.
 * 			row = sheet.createRow(rowIndex);
 * 			rowIndex++;
 * 			cellIndex = 0;
 * 			for (C c: t.columnKeySet()) {
 * 				// Create a cell for each column
 * 				if (t.get(r, c)!= null) {
 * 					cell = row.createCell(cellIndex);
 * 					cell.setCellValue(t.get(r,c).toString());
 * 					cellIndex++;
 * 				}
 * 			}
 * 		}
 * 		/*
 * 		// Write the output to a file
 * 		FileOutputStream fileOut = new FileOutputStream(fN);
 * 		wb.write(fileOut);
 * 		fileOut.close();
 * 	}
 * </pre>
 * <p>
 * <h3>Respuestas:</h3>
 * <p>
 * 
 * @author Alberto Dominguez Matamoros
 */
package org.aldoma.cursotdd.modulo2.ejercicio3;

