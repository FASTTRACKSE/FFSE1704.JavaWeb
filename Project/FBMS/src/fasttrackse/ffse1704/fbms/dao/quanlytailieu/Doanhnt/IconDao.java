package fasttrackse.ffse1704.fbms.dao.quanlytailieu.Doanhnt;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.quanlytailieu.Doanhnt.Icon;

public interface IconDao {
	public List<Icon> listAllIconTaiLieu();

	public void addIC(Icon ic);

	public void updateIC(Icon ic);

	public void deleteIC(String maIcon);

	public Icon getICbyID(String maIcon);
}