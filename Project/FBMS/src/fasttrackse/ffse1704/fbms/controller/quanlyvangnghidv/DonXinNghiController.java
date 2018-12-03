package fasttrackse.ffse1704.fbms.controller.quanlyvangnghidv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.DonNghi;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.LoaiNghi;
import fasttrackse.ffse1704.fbms.entity.quanlyvangnghidv.TinhTrangNghi;
import fasttrackse.ffse1704.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1704.fbms.entity.security.UserAccount;
import fasttrackse.ffse1704.fbms.service.quanlyvangnghidv.QuanLyVangNghiService;

@Controller
@RequestMapping("/QuanLyVangNghi")
public class DonXinNghiController {
	
	@Autowired
	private QuanLyVangNghiService service;
	
	public void setService(QuanLyVangNghiService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/donxinnghi", method = RequestMethod.GET)
	public String viewChucDanh(Model model, Authentication auth) {
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		model.addAttribute("nhanVien",nhanVien);
		TinhTrangNghi tinhTrangNghi = service.getTinhTrang(nhanVien.getMaNhanVien());
		model.addAttribute("tinhTrangNghi", tinhTrangNghi);
		List<LoaiNghi> arrLoaiNghi = new ArrayList<LoaiNghi>();
		arrLoaiNghi = service.listLoaiNghi();
		model.addAttribute("arrLoaiNghi", arrLoaiNghi);
		model.addAttribute("donNghi", new DonNghi());
		return "QuanLyVangNghi/donxinnghi";
	}
	
	@RequestMapping(value = "/savechoduyet", method =  RequestMethod.POST)
	public String saveSaveChoDuyet(Model model, @ModelAttribute("donnghi") DonNghi dn, @RequestParam int ngaydanghi,
			@RequestParam int ngayconlai) {
		dn.setTinhtrang(1);
		dn.getTgbatdau();
		TinhTrangNghi tt = new TinhTrangNghi();
		tt.setIdnv(dn.getIdnv());
		service.addDon(dn);
		int days = (int) ((dn.getTgketthuc().getTime() - dn.getTgbatdau().getTime())/(1000 * 60 *60 *24));
		if (ngaydanghi == 0) {
			tt.setIdnv(dn.getIdnv());
			tt.setNgaydanghi((ngaydanghi + days));
			tt.setNgayconlai((12 - days));
			service.insertUpdateTinhTrang(dn.getIdnv(), tt);
		}else {
			tt.setIdnv(dn.getIdnv());
			tt.setNgaydanghi((ngaydanghi + days));
			tt.setNgayconlai((ngayconlai - days));
			TinhTrangNghi ttCu = service.getTinhTrang(dn.getIdnv());
			tt.setIdtinhtrang(ttCu.getIdtinhtrang());
			service.updateTinhTrang(tt);
		}
				return "redirect:/QuanLyVangNghi/choduyet";
	}
	
	@RequestMapping(value = "/luunhap", method = RequestMethod.GET)
	public String viewLuuNhap(Model model, Authentication auth) {
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		List<DonNghi> dn = new ArrayList<DonNghi>();
		System.out.println(nhanVien.getMaNhanVien());
		dn = service.listDonNghiNhap(nhanVien.getMaNhanVien());
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/luunhap";	
	}
	
	@RequestMapping(value = "/savenhap", method = RequestMethod.POST)
	public String saveNhapPost(Model model, @ModelAttribute("donNghi") DonNghi dn) {
		dn.setTinhtrang(0);
		service.addDon(dn);
		return "redirect:/QuanLyVangNghi/luunhap";
	}
	
	@RequestMapping(value = "/choduyet" , method = RequestMethod.GET)
	public String viewChoDuyet(Model model, Authentication auth) {
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDonNghiChoDuyet(nhanVien.getMaNhanVien());
		model.addAttribute("list", dn);
		return "QuanLyVanNghi/choduyet";
	}
	
	@RequestMapping(value = "/edit/{iddon}", method = RequestMethod.GET)
	public String viewSua(@PathVariable("iddon") int iddon, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghinv(iddon);
		model.addAttribute("donNghi", donNghi);
		TinhTrangNghi tinhTrangNghi = service.getTinhTrang(donNghi.getIdnv());
		model.addAttribute("tinhTrangNghi", tinhTrangNghi);
		List<LoaiNghi> arrLoaiNghi = new ArrayList<LoaiNghi>();
		arrLoaiNghi = service.listLoaiNghi();
		model.addAttribute("arrLoaiNghi", arrLoaiNghi);
		return "QuanLyVangNghi/sua";	
	}
	
	@RequestMapping(value = "/duyetvong1", method = RequestMethod.GET)
	public String viewDuyetvong1(Model model, Authentication auth) {
		List<DonNghi> dn = new ArrayList<DonNghi>();
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		dn = service.listDonNghiPhepDuyet1(nhanVien.getPhongBan().getTenPhongBan());
		model.addAttribute("list", dn);
		if(nhanVien.getChucDanh().getMaChucDanh().equals("TP")) {
			return "QuanLyVangNghi/duyetvong1";
		}else {
			return "QuanLyVangNghi/ghichutp";	
		}
	}
	
	@RequestMapping(value = "/pheduyetvong1/{iddon}", method = RequestMethod.GET)
	public String pheDuyetVong1(@PathVariable("iddon")int iddon, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghinv(iddon);
		donNghi.setTinhtrang(2);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong1";
	}
	
	@RequestMapping(value = "/duyetvong2", method =  RequestMethod.GET)
	public String viewDuyetVong2(Model model, Authentication auth) {
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDonNghiPhepDuyet2();
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/duyetvong2";
	}
	
	@RequestMapping(value = "/pheduyetvong2/{iddon}", method = RequestMethod.GET)
	public String pheDuyetVong2(@PathVariable("iddon")int iddon, Model model, DonNghi donNghi) {
		donNghi = service.getDonNghinv(iddon);
		donNghi.setTinhtrang(3);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong2";
	}
	
	@RequestMapping(value = "/saveedit", method = RequestMethod.POST)
	public String saveEditPost(Model model, @ModelAttribute("donNghi") DonNghi dn) {
		dn.setTinhtrang(0);
		service.addDon(dn);
		return "redirect:/QuanLyVangNghi/luunhap";
	}
	
	@RequestMapping(value = "/savechoduyetnhap/{iddon}", method = RequestMethod.GET)
	public String saveChoDuyetNhap(@PathVariable("iddon") int iddon, Model model,DonNghi donNghi) {
		donNghi = service.getDonNghinv(iddon);
		TinhTrangNghi tinhTrangNghi = service.getTinhTrang(donNghi.getIdnv());
		donNghi.setTinhtrang(1);
		donNghi.getTgbatdau();
		int days = (int) ((donNghi.getTgketthuc().getTime() - donNghi.getTgbatdau().getTime()) / (1000 * 60 * 60 * 24));
		TinhTrangNghi tt = new TinhTrangNghi();
		if(tinhTrangNghi == null) {
			tt.setIdnv(donNghi.getIdnv());
			tt.setNgaydanghi(days);
			tt.setNgayconlai((12 - days));
			service.insertUpdateTinhTrang(donNghi.getIdnv(), tt);
		}else {
			tt.setIdnv(donNghi.getIdnv());
			tt.setNgaydanghi(tinhTrangNghi.getNgaydanghi() + days);
			tt.setNgayconlai(tinhTrangNghi.getNgayconlai() - days);
			TinhTrangNghi ttCu = service.getTinhTrang(donNghi.getIdnv());
			tt.setIdtinhtrang(ttCu.getIdtinhtrang());
			service.updateTinhTrang(tt);
		}
		
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/choduyet";
	}
	
	@RequestMapping(value = "/dontuchoi/{iddon}", method = RequestMethod.GET)
	public String dontuchoi(@PathVariable("iddon") int iddon, Model model,DonNghi donNghi) {
		donNghi = service.getDonNghinv(iddon);
		donNghi.setTinhtrang(4);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong1";
	}
	
	@RequestMapping(value = "/tuchoi/{pageId}", method =  RequestMethod.GET)
	public String viewTuChoi(Model model, Authentication auth, @PathVariable int pageId) {
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		Long tongSo = service.countListTuChoi(nhanVien.getMaNhanVien());
		int total = 2;
		int soTrang = (int)Math.ceil(tongSo/(total*1.0));
		int pageTrang = pageId;
		
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDonNghiTuChoi(nhanVien.getMaNhanVien(),((pageTrang -1)*total),total);
		model.addAttribute("page", pageTrang);
		model.addAttribute("soTrang",soTrang);
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/dontuchoi";
	}
	
	@RequestMapping(value = "/tuchoi")
	public String viewTuChoiPage0(Model model) {
		return "redirect:/QuanLyVangNghi/tuchoi/1";
	}
	
	@RequestMapping(value = "/dondaduyet/{iddon}", method = RequestMethod.GET)
	public String dondaduyet(@PathVariable("iddon") int iddon,Model model,DonNghi donNghi) {
		donNghi = service.getDonNghinv(iddon);
		donNghi.setTinhtrang(3);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong2";
	}
	
	@RequestMapping(value = "/daduyet")
	public String viewDaDuyetPage0(Model model) {
		return "redirect:/QuanLyVangNghi/daduyet/1";
	}
	
	@RequestMapping(value = "/daduyet/{pageId}", method = RequestMethod.GET)
	public String viewDaDuyet(Model model, Authentication auth,@PathVariable int pageId) {
		
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		Long tongSo = service.countListDaDuyet(nhanVien.getMaNhanVien());
		int total = 2;
		int soTrang = (int)Math.ceil(tongSo/(total*1.0));
		int pageTrang = pageId;
		
		List<DonNghi> dn = new ArrayList<DonNghi>();
		dn = service.listDanhSachPheDuyet(nhanVien.getMaNhanVien(),((pageTrang-1)*total),total);
		model.addAttribute("page", pageTrang);
		model.addAttribute("soTrang",soTrang);
		model.addAttribute("list", dn);
		return "QuanLyVangNghi/daduyet";
	}
	
	@RequestMapping(value = "/dontuchoi2/{iddon}", method = RequestMethod.GET)
	public String dontuchoi2(@PathVariable("iddon") int iddon,Model model,DonNghi donNghi) {
		donNghi = service.getDonNghinv(iddon);
		donNghi.setTinhtrang(4);
		service.updateDon(donNghi);
		return "redirect:/QuanLyVangNghi/duyetvong2";
	}
	
	@RequestMapping(value = "/xemdanhsachdaduyet")
	public String viewXemDanhSachPheDuyet(Model model, Authentication auth) {
		UserAccount user = service.getthongtinuser(auth.getName());
		HoSoNhanVien nhanVien = user.getNhanVien();
		List<DonNghi> dn = service.listdanhsachpheduyetcty();
		model.addAttribute("list", dn);
		if(nhanVien.getPhongBan().getMaPhongBan().equals("PNS")) {
			return "QuanLyVangNghi/xemdanhsachpheduyet";
		}else {
			return "QuanLyVangNghi/ghichu";
		}
	}
	
	@RequestMapping(value ="/delete/{iddon}")
	public String deleteNhap(@PathVariable("iddon") int iddon) {
		service.deleteDon(iddon);
		return "redirect:/QuanLyVangNghi/luunhap";
	}
	
}
