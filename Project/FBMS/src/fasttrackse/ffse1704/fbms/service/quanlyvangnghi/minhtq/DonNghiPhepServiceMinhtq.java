package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.HoSoNhanVienMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.PhongBanMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.TrangThaiVangNghiMinhtq;

public interface DonNghiPhepServiceMinhtq {

	/////////// ĐƠN NGHỈ PHÉP//////////////////
	public List<PhongBanMinhtq> listPhongBan();

	public List<HoSoNhanVienMinhtq> listMaNhanVien();

	public List<DonNghiPhepMinhtq> listDonNghiPhep(int start, int perPage, String idTT);

	public List<DonNghiPhepMinhtq> listAllDonNghiPhep(String idTT);

	public DonNghiPhepMinhtq getByIdDonNghiPhep(int id);

	public DonNghiPhepMinhtq read(int id);

	public void deleteDonNghiPhep(int id);

	public void editDonNghiPhep(DonNghiPhepMinhtq donnghiphep);

	public void addDonNghiPhep(DonNghiPhepMinhtq donnghiphep);

	///////////// TRANGTHAI//////////////
	public List<TrangThaiVangNghiMinhtq> listAllTrangThai();

	public DonNghiPhepMinhtq getByIdApproved(String maTrangThai);

	public TrangThaiVangNghiMinhtq getByIdTrangThai(int id);

	public void deleteTrangThai(int id);

	public void editTrangThai(TrangThaiVangNghiMinhtq trangthai);

	public void addTrangThai(TrangThaiVangNghiMinhtq trangthai);

	/////////////// LOẠI NGÀY NGHỈ//////////////////
	public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi();

	public LoaiNgayNghiMinhtq getByIdLoaiNgayNghi(int id);

	public void deleteLoaiNgayNghi(int id);

	public void editLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi);

	public void addLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi);

}
