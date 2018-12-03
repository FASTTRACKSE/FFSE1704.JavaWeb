package fasttrackse.ffse1704.fbms.dao.thongtinlogwork.quanlythoigian;

	import java.util.List;

import fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian.ThongTinLogwork;

	public interface ThongTinLogworkDAO {
		public List<ThongTinLogwork> findAll();

		public void addNew(ThongTinLogwork logwork);

		public void update(ThongTinLogwork logwork);

		public void delete(String id);

		public ThongTinLogwork findByIdLogwork(String id);

		public List<ThongTinLogwork> findAll(int iDisplayStart, int iDisplayLength, String sql);

		public String getRecordsTotal();

		public String getRecordsFiltered(String sql);
	}
