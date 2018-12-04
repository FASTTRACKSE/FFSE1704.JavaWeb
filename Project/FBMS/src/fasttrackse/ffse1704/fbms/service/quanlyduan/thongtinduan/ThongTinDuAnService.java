/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.thongtinduan;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.thongtinduan.ThongTinDuAn;

/**
 * @author QuangDai
 *
 */
public interface ThongTinDuAnService {

	public List<ThongTinDuAn> listThongTinDuAn(int iDisPlayStart, int iDinPlayLength);

	public int countThongTinDuAn();

	public void addNew(ThongTinDuAn tt);

	public void update(ThongTinDuAn tt);

	public void delete(String maDuAn);

	public ThongTinDuAn getThongTinDuAnByMaThongTinDuAn(String maDuAn);
}
