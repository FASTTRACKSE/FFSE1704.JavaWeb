package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq.DonNghiPhepDaoMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.HoSoNhanVienMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.PhongBanMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.TrangThaiVangNghiMinhtq;

@Service
@Transactional
public class DonNghiPhepServiceILMMinhtq implements DonNghiPhepServiceMinhtq {

	@Autowired
	DonNghiPhepDaoMinhtq donNghiPhepDao;

	public DonNghiPhepDaoMinhtq getDonNghiPhepDao() {
		return donNghiPhepDao;
	}

	public void setDonNghiPhepDao(DonNghiPhepDaoMinhtq donNghiPhepDao) {
		this.donNghiPhepDao = donNghiPhepDao;
	}

	@Override
	public List<DonNghiPhepMinhtq> listDonNghiPhep(int start, int perPage, String idTT) {

		return donNghiPhepDao.listDonNghiPhep(start, perPage, idTT);
	}

	@Override
	public List<DonNghiPhepMinhtq> listAllDonNghiPhep(String idTT) {

		return donNghiPhepDao.listAllDonNghiPhep(idTT);
	}

	@Override
	public DonNghiPhepMinhtq getByIdDonNghiPhep(int id) {

		return donNghiPhepDao.getByIdDonNghiPhep(id);
	}

	@Override
	public void deleteDonNghiPhep(int id) {
		donNghiPhepDao.deleteDonNghiPhep(id);

	}

	@Override
	public void editDonNghiPhep(DonNghiPhepMinhtq donnghiphep) {
		donNghiPhepDao.editDonNghiPhep(donnghiphep);

	}

	@Override
	public void addDonNghiPhep(DonNghiPhepMinhtq donnghiphep) {
		donNghiPhepDao.addDonNghiPhep(donnghiphep);

	}

	@Override
	public List<TrangThaiVangNghiMinhtq> listAllTrangThai() {

		return donNghiPhepDao.listAllTrangThai();
	}

	@Override
	public TrangThaiVangNghiMinhtq getByIdTrangThai(int id) {

		return donNghiPhepDao.getByIdTrangThai(id);
	}

	@Override
	public void deleteTrangThai(int id) {
		donNghiPhepDao.deleteTrangThai(id);

	}

	@Override
	public void editTrangThai(TrangThaiVangNghiMinhtq trangthai) {
		donNghiPhepDao.editTrangThai(trangthai);

	}

	@Override
	public void addTrangThai(TrangThaiVangNghiMinhtq trangthai) {
		donNghiPhepDao.addTrangThai(trangthai);

	}

	@Override
	public List<LoaiNgayNghiMinhtq> listLoaiNgayNghi() {

		return donNghiPhepDao.listLoaiNgayNghi();
	}

	@Override
	public LoaiNgayNghiMinhtq getByIdLoaiNgayNghi(int id) {

		return donNghiPhepDao.getByIdLoaiNgayNghi(id);
	}

	@Override
	public void deleteLoaiNgayNghi(int id) {
		donNghiPhepDao.deleteLoaiNgayNghi(id);

	}

	@Override
	public void editLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi) {
		donNghiPhepDao.editLoaiNgayNghi(loaingaynghi);

	}

	@Override
	public void addLoaiNgayNghi(LoaiNgayNghiMinhtq loaingaynghi) {
		donNghiPhepDao.addLoaiNgayNghi(loaingaynghi);

	}

	@Override
	public DonNghiPhepMinhtq read(int id) {
		return donNghiPhepDao.read(id);
	}

	@Override
	public DonNghiPhepMinhtq getByIdApproved(String maTrangThai) {
		return donNghiPhepDao.getByIdApproved(maTrangThai);
	}

	@Override
	public List<PhongBanMinhtq> listPhongBan() {
		return donNghiPhepDao.listPhongBan();
	}

	@Override
	public List<HoSoNhanVienMinhtq> listMaNhanVien() {
		return donNghiPhepDao.listMaNhanVien();
	}

}
