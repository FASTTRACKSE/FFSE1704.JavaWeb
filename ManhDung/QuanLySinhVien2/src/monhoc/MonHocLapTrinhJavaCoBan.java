package monhoc;

import giangvien.GiangVien;

public class MonHocLapTrinhJavaCoBan implements MonHoc {
    public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	GiangVien giangVien; 
	public String getThongTinMonHoc() {
		return " Lập trình java cơ bản";
	}
public String getTenGiangVien() {
	 return giangVien.getTenGiangVien();
}

public String getEmailGiangVien() {
	 return giangVien.getEmailGiangVien();
}
}
