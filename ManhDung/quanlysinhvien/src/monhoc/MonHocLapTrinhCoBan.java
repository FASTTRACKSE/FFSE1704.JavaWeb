package monhoc;

import giangvien.GiangVien;

public class MonHocLapTrinhCoBan implements MonHoc {
      GiangVien giangVien; 
	public String getThongTinMonHoc() {
		return " Lập trình cơ bản";
	}
 public String getTenGiangVien() {
	 return giangVien.getTenGiangVien();
 }
 
 public String getEmailGiangVien() {
	 return giangVien.getEmailGiangVien();
 }
}
