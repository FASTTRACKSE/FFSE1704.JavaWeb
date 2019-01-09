package thanhcl.baocaothongke.app;

import java.util.ArrayList;
import java.util.List;

import thanhcl.baocaothongke.entity.LogWork;

public class BaoCaoTongThoiGian {
	
	public List<LogWork> initLogWork() {
		List<LogWork> listLogWork = new ArrayList<LogWork>();
		listLogWork.add(new LogWork(1,"NV001", "DA01", 2));
		listLogWork.add(new LogWork(1,"NV001", "DA01", 2));
		listLogWork.add(new LogWork(1,"NV001", "DA01", 2));
		listLogWork.add(new LogWork(1,"NV001", "DA02", 4));
		listLogWork.add(new LogWork(1,"NV001", "DA03", 8));
		listLogWork.add(new LogWork(1,"NV002", "DA02", 2));
		listLogWork.add(new LogWork(1,"NV003", "DA02", 2));
		listLogWork.add(new LogWork(1,"NV003", "DA04", 2));
		listLogWork.add(new LogWork(1,"NV003", "DA04", 4));
		listLogWork.add(new LogWork(1,"NV003", "DA04", 4));
		listLogWork.add(new LogWork(1,"NV004", "DA04", 4));
		listLogWork.add(new LogWork(1,"NV005", "DA04", 8));
		
		return listLogWork;
	}

	public List<LogWork> createLogWorkReport(List<LogWork> listLogWork) {
		List<LogWork> listLogWorkReport = new ArrayList<LogWork>();
		
		String currentNV = listLogWork.get(0).getMaNhanVien();
		String currentDA = listLogWork.get(0).getMaDuAn();
		long total = 0;
		int stt = 0;

		for (int i=0; i<listLogWork.size(); i++) {
			LogWork lg = listLogWork.get(i);
			
			if (currentNV.equals(lg.getMaNhanVien())) {
				if (currentDA.equals(lg.getMaDuAn())) {
					total += lg.getKhoangTG();
				} else {
					stt += 1;
					listLogWorkReport.add(new LogWork(stt, currentNV, currentDA, total));

					currentDA = lg.getMaDuAn();
					total = lg.getKhoangTG();
				}
			} else {
				stt += 1;
				listLogWorkReport.add(new LogWork(stt, currentNV, currentDA, total));
				
				currentNV = lg.getMaNhanVien();
				currentDA = lg.getMaDuAn();
				total = lg.getKhoangTG();
			}
		}
		// Thêm dữ liệu nhân viên cuối cùng vào danh sách báo cáo 
		listLogWorkReport.add(new LogWork(stt, currentNV, currentDA, total));
		
		return listLogWorkReport;
	}

	public static void main(String[] args) {
		BaoCaoTongThoiGian myApp = new BaoCaoTongThoiGian();
		
		// Khởi tạo mảng LogWork 
		List<LogWork> listLogWork = myApp.initLogWork();
		
		// Tạo mảng báo cáo dựa trên mảng LogWork
		List<LogWork> listLogWorkReport = myApp.createLogWorkReport(listLogWork);
		
		// In thông tin raw
		for (int i=0; i<listLogWork.size(); i++) {
			System.out.println(listLogWork.get(i).toString());
		}
		
		System.out.println("-----------------------------------------------");

		// In báo cáo
		for (int i=0; i<listLogWorkReport.size(); i++) {
			System.out.println(listLogWorkReport.get(i).toString());
		}
		
	}

}
