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
	public List<DonNghiPhepMinhtq> listDonNghiPhepNhap() {

		return donNghiPhepDao.listDonNghiPhepNhap();
	}

	@Override
	public List<DonNghiPhepMinhtq> listDonNghiPhepChoDuyet() {

		return donNghiPhepDao.listDonNghiPhepChoDuyet();
	}

	@Override
	public List<DonNghiPhepMinhtq> listDonNghiPhepDaDuyet() {

		return donNghiPhepDao.listDonNghiPhepDaDuyet();
	}

	@Override
	public List<DonNghiPhepMinhtq> listDonNghiPhepTuChoi() {

		return donNghiPhepDao.listDonNghiPhepTuChoi();
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
	public TrangThaiVangNghiMinhtq getByIdTrangThai(int maTrangThai) {

		return donNghiPhepDao.getByIdTrangThai(maTrangThai);
	}

	@Override
	public void deleteTrangThai(int maTrangThai) {
		donNghiPhepDao.deleteTrangThai(maTrangThai);

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
	public LoaiNgayNghiMinhtq getByIdLoaiNgayNghi(int maNgayNghi) {

		return donNghiPhepDao.getByIdLoaiNgayNghi(maNgayNghi);
	}

	@Override
	public void deleteLoaiNgayNghi(int maNgayNghi) {
		donNghiPhepDao.deleteLoaiNgayNghi(maNgayNghi);

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

	@Override
	public List<DonNghiPhepMinhtq> findAll(Integer offset, Integer maxResult) {
		
		return donNghiPhepDao.findAll(offset, maxResult);
	}

	

}
