package fasttrackse.ffse1704.fbms.dao.quanlynhansu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;

public class ExcelBuilder extends AbstractXlsxView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-disposition", "attachment; filename=\"thongtinnhanvien.xls\"");

		NhanSu nhanSu = (NhanSu) model.get("thongTinNhanVien");

		Sheet sheet = workbook.createSheet("Thông Tin Hồ Sơ");

		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 15));

		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 20);
		font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
		font.setBold(true);

		Font fontTh = workbook.createFont();
		fontTh.setFontHeightInPoints((short) 10);
		fontTh.setBold(true);

		Font fontTd = workbook.createFont();
		fontTd.setFontHeightInPoints((short) 10);

		CellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
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
		cellHeaderHoSoChiTiet.setCellValue("Thông Tin Nhân Viên");
		cellHeaderHoSoChiTiet.setCellStyle(style);

		Row row = sheet.createRow(4);
		row.createCell(0).setCellValue("Mã Nhân Viên");
		row.createCell(1).setCellValue("Họ đệm");
		row.createCell(2).setCellValue("Tên");
		row.createCell(3).setCellValue("Năm sinh");
		row.createCell(4).setCellValue("Giới tính");
		row.createCell(5).setCellValue("Dân tộc");
		row.createCell(6).setCellValue("Số CMND");
		row.createCell(7).setCellValue("Ngày cấp");
		row.createCell(8).setCellValue("Nơi cấp");

		Row rown = sheet.createRow(5);
		
		Date datens = nhanSu.getNamSinh();
		DateFormat dateFormatns = new SimpleDateFormat("yyyy-MM-dd");
		String strDatens = dateFormatns.format(datens);
		
		Date datenccmnd = nhanSu.getNgayCap();
		DateFormat dateFormatnccmnd = new SimpleDateFormat("yyyy-MM-dd");
		String strDatenccmnd = dateFormatnccmnd.format(datenccmnd);

		rown.createCell(0).setCellValue(nhanSu.getMaNhanVien());
		rown.createCell(1).setCellValue(nhanSu.getHoLot());
		rown.createCell(2).setCellValue(nhanSu.getTen());
		rown.createCell(3).setCellValue(strDatens);
		rown.createCell(4).setCellValue(nhanSu.getGioiTinh());
		rown.createCell(5).setCellValue(nhanSu.getDanToc());
		rown.createCell(6).setCellValue(nhanSu.getSoCMND());
		rown.createCell(7).setCellValue(strDatenccmnd);
		rown.createCell(8).setCellValue(nhanSu.getNoiCap());

		Sheet sheet2 = workbook.createSheet("Thông Tin Liên Hệ");

		sheet2.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));

		Row headerThongTinLienHe = sheet2.createRow(1);
		Cell cellHeaderThongTinLienHe = headerThongTinLienHe.createCell(0);
		cellHeaderThongTinLienHe.setCellValue("Thông Tin Liên Hệ");
		cellHeaderThongTinLienHe.setCellStyle(style);

		Row rowThongTinLienHe = sheet2.createRow(4);
		rowThongTinLienHe.createCell(0).setCellValue("Quê quán");
		rowThongTinLienHe.createCell(1).setCellValue("Quốc tịch");
		rowThongTinLienHe.createCell(2).setCellValue("Nơi tạm trú");
		rowThongTinLienHe.createCell(3).setCellValue("Số điện thoại");
		rowThongTinLienHe.createCell(4).setCellValue("Email");

		Row rowThongTinLienHeCT = sheet2.createRow(5);
		rowThongTinLienHeCT.createCell(0).setCellValue(nhanSu.getQueQuan());
		rowThongTinLienHeCT.createCell(1).setCellValue(nhanSu.getQuocTich().getTenQuocTich());
		rowThongTinLienHeCT.createCell(2).setCellValue(nhanSu.getNoiTamTru());
		rowThongTinLienHeCT.createCell(3).setCellValue(nhanSu.getSoDienThoai());
		rowThongTinLienHeCT.createCell(4).setCellValue(nhanSu.getEmail());

		Sheet sheet3 = workbook.createSheet("Thông Tin Bằng Cấp");

		sheet3.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));

		Row headerThongTinBangCap = sheet3.createRow(1);
		Cell cellHeaderThongTinBangCap = headerThongTinBangCap.createCell(0);
		cellHeaderThongTinBangCap.setCellValue("Thông Tin Bằng Cấp");
		cellHeaderThongTinBangCap.setCellStyle(style);

		Row rowThongTinBangCap = sheet3.createRow(4);
		rowThongTinBangCap.createCell(0).setCellValue("Trình độ");
		rowThongTinBangCap.createCell(1).setCellValue("Ngành");
		rowThongTinBangCap.createCell(2).setCellValue("Thời gian");
		rowThongTinBangCap.createCell(3).setCellValue("Xếp loại");
		rowThongTinBangCap.createCell(4).setCellValue("Nơi cấp");

		Row rowThongTinBangCapCT = sheet3.createRow(5);
		int rowTTBCCT = 5;
		for (int i = 0; i < nhanSu.getListBangCap().size(); i++) {
			Date date = nhanSu.getListBangCap().get(i).getThoiGian();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String strDate = dateFormat.format(date);

			rowThongTinBangCapCT = sheet3.createRow(rowTTBCCT);
			rowThongTinBangCapCT.createCell(0)
					.setCellValue(nhanSu.getListBangCap().get(i).getTrinhDo().getTenTrinhDo());
			rowThongTinBangCapCT.createCell(1).setCellValue(nhanSu.getListBangCap().get(i).getTenNganh());
			rowThongTinBangCapCT.createCell(2).setCellValue(strDate);
			rowThongTinBangCapCT.createCell(3).setCellValue(nhanSu.getListBangCap().get(i).getXepLoai());
			rowThongTinBangCapCT.createCell(4).setCellValue(nhanSu.getListBangCap().get(i).getNoiCap());
		}
		Sheet sheet4 = workbook.createSheet("Thông Tin Gia Đình");

		sheet4.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));

		Row headerThongTinGiaDinh = sheet4.createRow(1);
		Cell cellHeaderThongTinGiaDinh = headerThongTinGiaDinh.createCell(0);
		cellHeaderThongTinGiaDinh.setCellValue("Thông Tin Gia Đình");
		cellHeaderThongTinGiaDinh.setCellStyle(style);

		Row rowThongTinGiaDinh = sheet4.createRow(4);
		rowThongTinGiaDinh.createCell(0).setCellValue("Họ và tên");
		rowThongTinGiaDinh.createCell(1).setCellValue("Quan hệ");
		rowThongTinGiaDinh.createCell(2).setCellValue("Năm sinh");
		rowThongTinGiaDinh.createCell(3).setCellValue("Nghề nghiệp");
		rowThongTinGiaDinh.createCell(4).setCellValue("Địa chỉ");

		Row rowThongTinGiaDinhCT = sheet4.createRow(5);
		int rowTTGDCT = 5;
		for (int i = 0; i < nhanSu.getListGiaDinh().size(); i++) {
			Date datettgd = nhanSu.getListGiaDinh().get(i).getNamSinh();
			DateFormat dateFormatttgd = new SimpleDateFormat("yyyy-MM-dd");
			String strDatettgd = dateFormatttgd.format(datettgd);
			
			rowThongTinGiaDinhCT = sheet4.createRow(rowTTGDCT);
			rowThongTinGiaDinhCT.createCell(0).setCellValue(nhanSu.getListGiaDinh().get(i).getHoVaTen());
			rowThongTinGiaDinhCT.createCell(1).setCellValue(nhanSu.getListGiaDinh().get(i).getQuanHe());
			rowThongTinGiaDinhCT.createCell(2).setCellValue(strDatettgd);
			rowThongTinGiaDinhCT.createCell(3).setCellValue(nhanSu.getListGiaDinh().get(i).getNgheNghiep());
			rowThongTinGiaDinhCT.createCell(4).setCellValue(nhanSu.getListGiaDinh().get(i).getDiaChi());
		}
		
		Sheet sheet5 = workbook.createSheet("Thông Tin Chứng chỉ");

		sheet5.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));

		Row headerThongTinChungChi = sheet5.createRow(1);
		Cell cellHeaderThongTinChungChi = headerThongTinChungChi.createCell(0);
		cellHeaderThongTinChungChi.setCellValue("Thông Tin Chứng chỉ");
		cellHeaderThongTinChungChi.setCellStyle(style);

		Row rowThongTinChungChi = sheet5.createRow(4);
		rowThongTinChungChi.createCell(0).setCellValue("Chứng ch");
		rowThongTinChungChi.createCell(1).setCellValue("Ngày cấp");
		rowThongTinChungChi.createCell(2).setCellValue("Nơi cấp");

		Row rowThongTinChungChiCT = sheet5.createRow(5);
		int rowTTCTCT = 5;
		for (int i = 0; i < nhanSu.getListChungChi().size(); i++) {
			Date datettcc = nhanSu.getListChungChi().get(i).getNgayCap();
			DateFormat dateFormatttcc = new SimpleDateFormat("yyyy-MM-dd");
			String strDatettcc = dateFormatttcc.format(datettcc);
			
			rowThongTinChungChiCT = sheet5.createRow(rowTTCTCT);
			rowThongTinChungChiCT.createCell(0).setCellValue(nhanSu.getListChungChi().get(i).getTenChungChi());
			rowThongTinChungChiCT.createCell(1).setCellValue(strDatettcc);
			rowThongTinChungChiCT.createCell(2).setCellValue(nhanSu.getListChungChi().get(i).getDonViCap());
		}
		
		Sheet sheet6 = workbook.createSheet("Thông Tin Hợp Đồng");

		sheet6.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));

		Row headerThongTinHopDong = sheet6.createRow(1);
		Cell cellHeaderThongTinHopDong = headerThongTinHopDong.createCell(0);
		cellHeaderThongTinHopDong.setCellValue("Thông Tin Hợp Đồng");
		cellHeaderThongTinHopDong.setCellStyle(style);

		Row rowThongTinHopDong = sheet6.createRow(4);
		rowThongTinHopDong.createCell(0).setCellValue("Loại hợp đồng");
		rowThongTinHopDong.createCell(1).setCellValue("Ngày bắt đầu");
		rowThongTinHopDong.createCell(2).setCellValue("Ngày kết thúc");
		rowThongTinHopDong.createCell(3).setCellValue("Lương tháng 13");

		Row rowThongTinHopDongCT = sheet6.createRow(5);
		int rowTTHDCT = 5;
		for (int i = 0; i < nhanSu.getListHopDong().size(); i++) {
			Date datetthd_ngaybatdau = nhanSu.getListHopDong().get(i).getNgayBatDau();
			DateFormat dateFormatthd_ngaybatdau = new SimpleDateFormat("yyyy-MM-dd");
			String strDatetthd_ngaybatdau = dateFormatthd_ngaybatdau.format(datetthd_ngaybatdau);
			
			Date datetthd_ngayketthuc = nhanSu.getListHopDong().get(i).getNgayKetThuc();
			DateFormat dateFormattthd_ngayketthuc = new SimpleDateFormat("yyyy-MM-dd");
			String strDatetthd_ngayketthuc = dateFormattthd_ngayketthuc.format(datetthd_ngayketthuc);
			
			rowThongTinHopDongCT = sheet6.createRow(rowTTHDCT);
			rowThongTinHopDongCT.createCell(0).setCellValue(nhanSu.getListHopDong().get(i).getLoaihopDong().getTenHopDong());
			rowThongTinHopDongCT.createCell(1).setCellValue(strDatetthd_ngaybatdau);
			rowThongTinHopDongCT.createCell(2).setCellValue(strDatetthd_ngayketthuc);
			rowThongTinHopDongCT.createCell(3).setCellValue(nhanSu.getListHopDong().get(i).getCheDoHuong().getLuong());
		}
		
		Sheet sheet7 = workbook.createSheet("Thông Tin Dự Án");

		sheet7.addMergedRegion(new CellRangeAddress(1, 1, 0, 5));

		Row headerThongTinDuAn = sheet7.createRow(1);
		Cell cellHeaderThongTinDuAn = headerThongTinDuAn.createCell(0);
		cellHeaderThongTinDuAn.setCellValue("Thông Tin Dự Án");
		cellHeaderThongTinDuAn.setCellStyle(style);

		Row rowThongTinDuAn = sheet7.createRow(4);
		rowThongTinDuAn.createCell(0).setCellValue("Dự Án");
		rowThongTinDuAn.createCell(1).setCellValue("Quân");
		rowThongTinDuAn.createCell(2).setCellValue("Lê");
		rowThongTinDuAn.createCell(3).setCellValue("Trọng");

//		Row rowThongTinDuAnCT = sheet7.createRow(5);
//		int rowTTDACT = 5;
	}
}
