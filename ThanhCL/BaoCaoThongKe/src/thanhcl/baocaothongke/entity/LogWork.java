package thanhcl.baocaothongke.entity;

public class LogWork {
	private int id;
	private String maNhanVien;
	private String maDuAn;
	private long khoangTG;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getMaDuAn() {
		return maDuAn;
	}
	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}
	public long getKhoangTG() {
		return khoangTG;
	}
	public void setKhoangTG(long khoangTG) {
		this.khoangTG = khoangTG;
	}

	public LogWork() {
		super();
	}

	public LogWork(int id, String maNhanVien, String maDuAn, long khoangTG) {
		super();
		this.id = id;
		this.maNhanVien = maNhanVien;
		this.maDuAn = maDuAn;
		this.khoangTG = khoangTG;
	}

	@Override
	public String toString() {
		return "LogWork [id=" + id + ", maNhanVien=" + maNhanVien + ", maDuAn=" + maDuAn + ", khoangTG=" + khoangTG
				+ "]";
	}
	
	
}
