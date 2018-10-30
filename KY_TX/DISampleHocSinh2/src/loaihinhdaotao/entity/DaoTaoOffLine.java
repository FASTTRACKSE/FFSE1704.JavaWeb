package loaihinhdaotao.entity;

public class DaoTaoOffLine implements LoaiHinhDaoTao {
	String tenLoaiHinhDaoTao;
	String thoiGianDaoTao;
	String diaChiDaoTao;

	public DaoTaoOffLine() {
		super();
	}

	public DaoTaoOffLine(String tenLoaiHinhDaoTao, String thoiGianDaoTao, String diaChiDaoTao) {
		super();
		this.tenLoaiHinhDaoTao = tenLoaiHinhDaoTao;
		this.thoiGianDaoTao = thoiGianDaoTao;
		this.diaChiDaoTao = diaChiDaoTao;
	}

	public String getTenLoaiHinhDaoTao() {
		return tenLoaiHinhDaoTao;
	}

	public void setTenLoaiHinhDaoTao(String tenLoaiHinhDaoTao) {
		this.tenLoaiHinhDaoTao = tenLoaiHinhDaoTao;
	}

	public String getThoiGianDaoTao() {
		return thoiGianDaoTao;
	}

	public void setThoiGianDaoTao(String thoiGianDaoTao) {
		this.thoiGianDaoTao = thoiGianDaoTao;
	}

	public String getDiaChiDaoTao() {
		return diaChiDaoTao;
	}

	public void setDiaChiDaoTao(String diaChiDaoTao) {
		this.diaChiDaoTao = diaChiDaoTao;
	}
}
