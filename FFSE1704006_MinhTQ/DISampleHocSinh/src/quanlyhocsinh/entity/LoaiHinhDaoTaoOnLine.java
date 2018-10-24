package quanlyhocsinh.entity;

import hedaotao.LoaiHinhDaoTao;

public class LoaiHinhDaoTaoOnLine implements LoaiHinhDaoTao {

	public LoaiHinhDaoTaoOnLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMaLoaiHinhDaoTao() {
		// TODO Auto-generated method stub
		return "DTOL";
	}

	@Override
	public String getThongTinLoaiHinhDaoTao() {
		// TODO Auto-generated method stub
		return "- Chương trình đào tạo online \n- Thời gian: 24/24 \n- Địa chỉ: trang web LMS.FASTTRACK.EDU.VN" ;
	}

}
