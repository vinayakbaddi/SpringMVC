package com.way2learnonline.controllers;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.way2learnonline.entity.Course;

	
	public class CoursesExcelView extends AbstractExcelView {	
	
		@Override
		@SuppressWarnings("unchecked")
		protected void buildExcelDocument(Map<String, Object> model,
				HSSFWorkbook workbook, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			
			
			List<Course> courses = (List<Course>)model.get("courses");
	
			
			HSSFSheet sheet = workbook.createSheet();
	
		
			for (short i = 0; i < courses.size(); i++) {
				Course course = courses.get(i);
				HSSFRow row = sheet.createRow(i);
				addStringCell(row, 0, course.getCourseId());
				addStringCell(row, 1, course.getName());
				addStringCell(row, 2, course.getPrice()+"");
			}
		}
	
		
		private HSSFCell addStringCell(HSSFRow row, int index, String value) {
			HSSFCell cell = row.createCell((short) index);
			if (value != null)
				cell.setCellValue(new HSSFRichTextString(value));
			return cell;
		}
	
		
	
	}
