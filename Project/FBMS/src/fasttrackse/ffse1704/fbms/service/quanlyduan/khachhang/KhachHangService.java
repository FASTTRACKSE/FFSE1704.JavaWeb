/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.khachhang;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.khachhang.KhachHang;

/**
 * @author QuangDai
 *
 */
public interface KhachHangService {

	public List<KhachHang> listKhachHang(int iDisPlayStart, int iDinPlayLength);

	public int countKhachHang();

	public void addNew(KhachHang kh);

	public void update(KhachHang kh);

	public void delete(String maKhachHang);

	public KhachHang getKhachHangByMaKhachHang(String maKhachHang);
}
