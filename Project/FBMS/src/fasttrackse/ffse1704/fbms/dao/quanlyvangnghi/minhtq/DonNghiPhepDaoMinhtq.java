package fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.TrangThaiVangNghiMinhtq;

public interface DonNghiPhepDaoMinhtq {

	/////////// phân trang ////////////////
	public int count();

	public List<DonNghiPhepMinhtq> findAll(Integer offset, Integer maxResult);

	/////////// ĐƠN NGHỈ PHÉP//////////////////
	public List<DonNghiPhepMinhtq> listDonNghiPhepNhap();

	public List<DonNghiPhepMinhtq> listDonNghiPhepChoDuyet();

	public List<DonNghiPhepMinhtq> listDonNghiPhepDaDuyet();

	public List<DonNghiPhepMinhtq> listDonNghiPhepTuChoi();

	public DonNghiPhepMinhtq getByIdDonNghiPhep(int id);

	public void deleteDonNghiPhep(int id);

	public void editDonNghiPhep(DonNghiPhepMinhtq donnghiphep);

	public void addDonNghiPhep(DonNghiPhepMinhtq donnghiphep);

	
	

	
	///////////// TRANGTHAI//////////////
	public List<TrangThaiVangNghiMinhtq> listAllTrangThai();

	public TrangThaiVangNghiMinhtq getByIdTrangThai(int maTrangThai);

	public void deleteTrangThai(int maTrangThai);

	public void editTrangThai(TrangThaiVangNghiMinhtq trangthai);

	public void addTrangThai(TrangThaiVangNghiMinhtq trangthai);

	/////////////// LOẠI NGÀY NGHỈ//////////////////
	public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi();

	public LoaiNgayNghiMinhtq getByIdLoaiNgayNghi(int maNgayNghi);

	public void deleteLoaiNgayNghi(int maNgayNghi);

	public void editLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi);

	public void addLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi);

}
