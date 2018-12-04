/**
 * 
 */
package fasttrackse.ffse1704.fbms.service.quanlyduan.vendor;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlyduan.vendor.Vendor;

/**
 * @author QuangDai
 *
 */
public interface VendorService {

	public List<Vendor> listVendor(int iDisPlayStart, int iDinPlayLength);

	public int countVendor();

	public void addNew(Vendor vd);

	public void update(Vendor vd);

	public void delete(String maVendor);

	public Vendor getVendorByMaVendor(String maVendor);
}
