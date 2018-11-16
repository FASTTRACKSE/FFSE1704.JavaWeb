package quanlyhocsinh.entity;

public class QuyTrinhDuAn implements MonHoc {
	GiangVien giangVien;

	public QuyTrinhDuAn(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public QuyTrinhDuAn() {
		super();
	}

	@Override
	public String getThongTonMonHoc() {
		// TODO Auto-generated method stub
		return "Quy Trình Dự Án";
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmailGV() {
		// TODO Auto-generated method stub
		return giangVien.getEmailGV();
	}

}
