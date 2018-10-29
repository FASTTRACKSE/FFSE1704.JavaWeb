package monhoc;

import giangvien.GiangVien;

public class MonHocQuyTrinhDuAn implements MonHoc {
    GiangVien giangVien; 
	public String getThongTinMonHoc() {
		return " Lập trình Quy Trình dự án";
	}
public String getTenGiangVien() {
	 return giangVien.getTenGiangVien();
}

public String getEmailGiangVien() {
	 return giangVien.getEmailGiangVien();
}
}
