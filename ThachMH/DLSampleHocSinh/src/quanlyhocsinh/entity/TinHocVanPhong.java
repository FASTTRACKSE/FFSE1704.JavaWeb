package quanlyhocsinh.entity;

public class TinHocVanPhong implements MonHoc {
	public TinHocVanPhong(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public TinHocVanPhong() {
		super();
	}

	GiangVien giangVien;

	@Override
	public String getThongTonMonHoc() {
		// TODO Auto-generated method stub
		return "Tin Học Văn Phòng";
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
