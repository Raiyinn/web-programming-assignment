package com.packt.webinfo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.packt.webinfo.domain.News;

public class NewsDao {
	JdbcTemplate template;   
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}   
	
	public int addNews(News p){    
	    String sql="insert into news(`idnews`,`type`,`headline`,`description`)" + " values('"+p.getNewsId()+"','"+p.getType()+"','"+p.getHeadline()+"','"+p.getDescription()+"');";    
	    
	    return template.update(sql);    
	}  
	
	public int update(News p){    
	    String sql="update news SET `type` = '"+p.getType()+"', `description` = '"+p.getDescription()+"', `headline` = '"+p.getHeadline()+"' WHERE (`idnews` = '"+p.getNewsId()+"');";    
	    return template.update(sql);
	}    
	public int delete(String id){    
	    String sql="delete from news where idnews='"+id+"'";    
	    return template.update(sql);    
	}    
	public News getNewsById(String id){    
	    String sql="select * from news where idnews=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<News>(News.class));    
	}    
	public List<News> getAllNews(){    
	    return template.query("select * from news",new RowMapper<News>(){    
	        public News mapRow(ResultSet rs, int row) throws SQLException {    
	        	News p=new News();    
	        	p.setNewsId(rs.getString(1));
	        	p.setType(rs.getString(2));
	        	p.setHeadline(rs.getString(3));
	        	p.setDescription(rs.getString(4));
	            return p;   
	        }    
	    });    
	} 
	
	public List<News> getNewNews(){    
	    return template.query("select * from news limit 4",new RowMapper<News>(){    
	        public News mapRow(ResultSet rs, int row) throws SQLException {    
	        	News p=new News();    
	        	p.setNewsId(rs.getString(1));
	        	p.setType(rs.getString(2));
	        	p.setHeadline(rs.getString(3));
	        	p.setDescription(rs.getString(4));
	            return p;   
	        }    
	    });    
	} 
	
	public List<News> getNewsByType(String type){    
	    return template.query("select * from news where type='"+type+"'",new RowMapper<News>(){    
	        public News mapRow(ResultSet rs, int row) throws SQLException {    
	        	News p=new News();    
	        	p.setNewsId(rs.getString(1));
	        	p.setType(rs.getString(2));
	        	p.setHeadline(rs.getString(3));
	        	p.setDescription(rs.getString(4));
	            return p;   
	        }    
	    });    
	}
	
}
