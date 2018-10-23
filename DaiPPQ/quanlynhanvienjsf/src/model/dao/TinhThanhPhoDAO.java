package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import common.database.DatabaseUltil;
import common.database.DatabaseUltil.IPareEntity;
import common.database.DatabaseUltil.IPrePareStatementSetParam;
import model.entity.TinhThanhPho;

@ManagedBean
@SessionScoped
public class TinhThanhPhoDAO {

	private static IPareEntity<TinhThanhPho> iPareEntity = new IPareEntity<TinhThanhPho>() {
		public TinhThanhPho pare(ResultSet result) throws SQLException {
			return new TinhThanhPho(result.getString("matp"), result.getString("name"));
		}
	};

	public static List<TinhThanhPho> getAllTinhThanhPho() {
		String sql = "SELECT * FROM devvn_tinhthanhpho";
		List<TinhThanhPho> arrList = DatabaseUltil.selectForList(sql, iPareEntity);
		return arrList;
	}
}
