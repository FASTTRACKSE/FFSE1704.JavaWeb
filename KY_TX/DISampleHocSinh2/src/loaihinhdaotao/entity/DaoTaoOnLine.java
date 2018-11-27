package loaihinhdaotao.entity;

public class DaoTaoOnLine implements LoaiHinhDaoTao {
	String tenLoaiHinhDaoTao;
	String thoiGianDaoTao;
	String diaChiDaoTao;

	public DaoTaoOnLine() {
		super();
	}

	public DaoTaoOnLine(String tenLoaiHinhDaoTao, String thoiGianDaoTao, String diaChiDaoTao) {
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
