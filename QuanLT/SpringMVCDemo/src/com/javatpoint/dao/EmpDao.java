package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.beans.Emp;


public class EmpDao {
JdbcTemplate template;

public JdbcTemplate getTemplate() {
	return template;
}

public void setTemplate(JdbcTemplate template) {
	this.template = template;
}
public int add(Emp p) {
	String sql="insert into emp(name,old,idol) values('"+p.getName()+"',"+p.getOld()+",'"+p.getIdol()+"')";
	return template.update(sql);
}
public int update(Emp p) {
	String sql="update emp set name="+p.getName()+"', salary="+p.getOld()+"," + 
			"designation='"+p.getIdol()+"' where id="+p.getId()+"";  
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
public List<Emp> getEmployees(){  
    return template.query("select * from emp",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setId(rs.getInt(1)); 
            e.setName(rs.getString(2));  
            e.setOld(rs.getInt(3));  
            e.setIdol(rs.getString(4)); 
            return e;  
        }  
    });  
}  
}
