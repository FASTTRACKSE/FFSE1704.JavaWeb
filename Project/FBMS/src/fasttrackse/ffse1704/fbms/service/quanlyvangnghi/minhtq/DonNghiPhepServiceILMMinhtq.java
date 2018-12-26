package fasttrackse.ffse1704.fbms.service.quanlyvangnghi.minhtq;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.quanlyvangnghi.minhtq.DonNghiPhepDaoMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.DonNghiPhepMinhtq;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghi.minhtq.LoaiNgayNghiMinhtq;
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
	public List<DonNghiPhepMinhtq> listDonNghiPhepNhap(int start, int maxResult) {

		return donNghiPhepDao.listDonNghiPhepNhap(start, maxResult);
	}

	@Override
	public List<DonNghiPhepMinhtq> listDonNghiPhepChoDuyet(int start, int maxResult) {

		return donNghiPhepDao.listDonNghiPhepChoDuyet(start, maxResult);
	}

	@Override
	public List<DonNghiPhepMinhtq> listDonNghiPhepDaDuyet(int start, int maxResult) {

		return donNghiPhepDao.listDonNghiPhepDaDuyet(start, maxResult);
	}

	@Override
	public List<DonNghiPhepMinhtq> listDonNghiPhepTuChoi(int start, int maxResult) {

		return donNghiPhepDao.listDonNghiPhepTuChoi(start, maxResult);
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
	public int count() {
		return donNghiPhepDao.count();
	}

	
	

}
