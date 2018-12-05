package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public class ExcelBuilder extends AbstractXlsxView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-disposition", "attachment; filename=\"danhsachphongban.xls\"");

		@SuppressWarnings("unchecked")
		List<PhongBan> list = (List<PhongBan>) model.get("userList");

		Sheet sheet = workbook.createSheet("List Phong Ban");
		
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 15));
		
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 20);
		font.setBold(true);
		
		Font fontTh = workbook.createFont();
		fontTh.setFontHeightInPoints((short) 10);
		fontTh.setBold(true);
		
		Font fontTd = workbook.createFont();
		fontTd.setFontHeightInPoints((short) 10);
		
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		
		CellStyle styleTh = workbook.createCellStyle();
		styleTh.setFont(fontTh);
		
		CellStyle styleTd = workbook.createCellStyle();
		styleTd.setFont(fontTd);
		
		styleTh.setBorderBottom(BorderStyle.THIN);
		styleTh.setBorderTop(BorderStyle.THIN);
		styleTh.setBorderRight(BorderStyle.THIN);
		styleTh.setBorderLeft(BorderStyle.THIN);
		
		styleTd.setBorderBottom(BorderStyle.THIN);
		styleTd.setBorderTop(BorderStyle.THIN);
		styleTd.setBorderRight(BorderStyle.THIN);
		styleTd.setBorderLeft(BorderStyle.THIN);
		
		Row headerrow = sheet.createRow(1);
		Cell cellHeaderHoSoChiTiet = headerrow.createCell(0);
		cellHeaderHoSoChiTiet.setCellValue("Phong Ban");
		cellHeaderHoSoChiTiet.setCellStyle(style);

		Row row = sheet.createRow(2);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MA PHONG BAN");

		int rowNum = 2;

		for (PhongBan phongBan : list) {
			Row rown = sheet.createRow(rowNum++);
			rown.createCell(0).setCellValue(phongBan.getMaPhongBan());
			rown.createCell(1).setCellValue(phongBan.getTenPhongBan());
		}

	}

}
