package quanlyhocsinh.entity.giangvien;

public class ThayThanh implements GiangVien {

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return "Giảng viên: Cao Le Thanh \n"
				+ " 	Email: ThanhCL@gmail.com";
	}

	@Override
	public String getEmailGiangVien() {
		// TODO Auto-generated method stub
		return "ThanhCL@gmail.com";
	}
}
