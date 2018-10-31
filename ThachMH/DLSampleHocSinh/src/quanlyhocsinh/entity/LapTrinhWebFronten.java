package quanlyhocsinh.entity;

public class LapTrinhWebFronten implements MonHoc	{	
	
GiangVien giangVien;
	
	public LapTrinhWebFronten(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	public LapTrinhWebFronten() {
		super();
	}
	
	@Override
	public String getThongTonMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Wed Fronten";
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
