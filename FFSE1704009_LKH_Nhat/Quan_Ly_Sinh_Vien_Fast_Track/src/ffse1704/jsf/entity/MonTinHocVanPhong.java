package ffse1704.jsf.entity;

import ffse1704.jsf.entity.monhoc.MonHoc;
import ffse1704.jsf.entity.GiangVien;

public class MonTinHocVanPhong implements MonHoc {
	private String maMonHoc = "LP #0";
	private String tenMonHoc = "Tin Học Văn Phòng";
	GiangVien giangVien;

	public MonTinHocVanPhong() {
		super();
	}

	public MonTinHocVanPhong( GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public String getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	@Override
	public String getTenGiangVien() {
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmailGiangVien() {
		return giangVien.getEmailGiangVien();
	}
}
