/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.trangthaiduan;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.trangthaiduan.TrangThaiDuAn;

/**
 * @author QuangDai
 *
 */
public interface TrangThaiDuAnService {

	public List<TrangThaiDuAn> listTrangThaiDuAn(int iDisPlayStart, int iDinPlayLength);

	public int countTrangThaiDuAn();

	public void addNew(TrangThaiDuAn tt);

	public void update(TrangThaiDuAn tt);

	public void delete(String maTrangThai);

	public TrangThaiDuAn getTrangThaiDuAnByMaTrangThaiDuAn(String maTrangThai);
}
