package monhoc;

import giangvien.GiangVien;

public class MonHocLapTrinhWebPHP implements MonHoc {
    GiangVien giangVien; 
	public String getThongTinMonHoc() {
		return " Lập trình web PHP";
	}
public String getTenGiangVien() {
	 return giangVien.getTenGiangVien();
}

public GiangVien getGiangVien() {
	return giangVien;
}
public void setGiangVien(GiangVien giangVien) {
	this.giangVien = giangVien;
}
public String getEmailGiangVien() {
	 return giangVien.getEmailGiangVien();
}
}
