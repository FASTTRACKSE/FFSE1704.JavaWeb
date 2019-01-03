package fasttrackse.ffse1704.fbms.service.quanlynhansu;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlynhansu.NhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuanHuyen;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.QuocTich;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.ThanhPho;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.TrangThaiNhanSu;
import fasttrackse.ffse1704.fbms.entity.quanlynhansu.XaPhuong;
import fasttrackse.ffse1704.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1704.fbms.entity.security.PhongBan;

public interface NhanSuService {
	public List<NhanSu> allNS();
	public void addNS(NhanSu ns);
	public List<NhanSu> GetListNhanSuByPage(int start,int total);
	public long CountNhanSu();
	public NhanSu getNhanSuByID(int id);
	public void update(NhanSu ns);
	public void delete(int id);
	public boolean checkExistMa(String maNS);
	public List<ChucDanh> listChucDanh();
	public List<PhongBan> listPhongBan();
	public List<QuocTich> listQuocTich();
	public List<ThanhPho> listTinhThanhPho();
	public List<TrangThaiNhanSu> listTrangThai();
	public List<QuanHuyen> listQuanHuyen();
	public List<XaPhuong> listXaPhuong();
	public List<QuanHuyen> listQuanHuyenbyID(String maTinhThanh);
	public List<XaPhuong> listPhuongXabyID(String maQuanHuyen);
	public List<NhanSu> listNhanSuByTrangThai(int maTrangThai);
	public TrangThaiNhanSu findNameNhanSuByIdTrangThai(int maTrangThai);
	
}
