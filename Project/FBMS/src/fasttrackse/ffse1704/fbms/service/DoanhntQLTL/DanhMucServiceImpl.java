package fasttrackse.ffse1704.fbms.service.DoanhntQLTL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1704.fbms.dao.DoanhntQLTL.DanhMucDao;
import fasttrackse.ffse1704.fbms.entity.DoanhntQLTL.DanhMuc;

@Service
public class DanhMucServiceImpl implements DanhMucService {
	@Autowired
	private DanhMucDao daoDM;

	@Override
	public List<DanhMuc> listAllDanhMuc() {
		return daoDM.listAllDanhMuc();
	}

	@Override
	public void addDM(DanhMuc dm) {
		daoDM.addDM(dm);
	}

	@Override
	public void updateDM(DanhMuc dm) {
		daoDM.updateDM(dm);
	}

	@Override
	public void deleteDM(String id) {
		daoDM.deleteDM(id);
	}

	@Override
	public DanhMuc getDMbyID(String id) {
		return daoDM.getDMbyID(id);
	}

	@Override
	public List<DanhMuc> listAllDanhMuc(int start, int limit,String sql) {
		return daoDM.listAllDanhMuc(start, limit,sql);
	}

	@Override
	public String getRecordTotal() {
		return daoDM.getRecordTotal();
	}

}