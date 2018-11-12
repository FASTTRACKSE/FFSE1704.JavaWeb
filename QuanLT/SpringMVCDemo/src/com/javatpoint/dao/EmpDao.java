package com.javatpoint.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.beans.Emp;
import com.javatpoint.beans.LoginBeans;
import com.javatpoint.beans.ThanhPho;


public class EmpDao {
JdbcTemplate template;

public JdbcTemplate getTemplate() {
	return template;
}

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int add(Emp p) {
	String sql="insert into emp(name,old,idol,image,city) values('"+p.getName()+"',"+p.getOld()+",'"+p.getIdol()+"','"+p.getImage()+"','"+p.getCity()+"')";
	return template.update(sql);
}
public int update(Emp p) {
	String sql="update emp set name='"+p.getName()+"', old="+p.getOld()+"," + 
			"idol='"+p.getIdol()+"', image='"+p.getImage()+"', city='"+p.getCity()+"' where id="+p.getId()+"";  
	return template.update(sql); 
}
public int delete(int id){  
    String sql="delete from emp where id="+id+"";  
    return template.update(sql);  
}
public Emp getEmpById(int id){  
    String sql="select * from emp where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
}
public List<Emp> getEmp(int pageid,int total){  
    String sql="SELECT id, name, old, idol, image, city, vietnam.region_name FROM emp LEFT JOIN vietnam ON emp.city = vietnam.region_id limit "+(pageid-1)+","+total;  
    return template.query(sql,new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
        	 Emp e=new Emp();  
             e.setId(rs.getInt(1)); 
             e.setName(rs.getString(2));  
             e.setOld(rs.getInt(3));  
             e.setIdol(rs.getString(4)); 
             e.setImage(rs.getString(5));
             e.setCity(rs.getInt(6));
             e.setNamecity(rs.getString(7));
             return e;  
        }  
    });  
}  
public List<ThanhPho> getListTinhThanh() {
	return template.query("SELECT region_id, region_name FROM vietnam", new RowMapper<ThanhPho>() {
		public ThanhPho mapRow(ResultSet rs, int row) throws SQLException {
			ThanhPho tp = new ThanhPho();
			tp.setMatp(rs.getInt(1));
			tp.setNametp(rs.getString(2));
			return tp;
		}
	});
}
}
