package fasttrackse.ffse1704.fbms.dao.DoanhntQLTL;

import java.util.List;

import fasttrackse.ffse1704.fbms.entity.DoanhntQLTL.Icon;

public interface IconDao {
	public List<Icon> listAllIconTaiLieu();

	public void addIC(Icon ic);

	public void updateIC(Icon ic);

	public void deleteIC(String maIcon);

	public Icon getICbyID(String maIcon);
}