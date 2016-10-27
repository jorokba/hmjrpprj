/*package com.newlec.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlec.web.dao.NoticeDao;
import com.newlec.web.entities.Notice;
import com.newlec.web.model.NoticeModel;

public class OracleNoticeDao extends Notice implements NoticeDao{
	public Notice get(String code) throws SQLException, ClassNotFoundException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "";
    String sql = "select * from notice_view where code = ?";
    Connection con = DriverManager.getConnection(url,"c##sist","dclass");
    
    PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1, code);
    ResultSet rs = pstmt.executeQuery();
    
    Notice notice = new Notice();
    
    if (rs.next()) {
       notice.setCode(rs.getString("code"));
       notice.setTitle(rs.getString("title"));
       notice.setWriter(rs.getString("writer"));
       notice.setContent(rs.getString("content"));
       notice.setRegdate(rs.getDate("regdate"));
       notice.setHit(rs.getInt("hit"));
    }

    rs.close();
    pstmt.close();
    con.close();
    
    return notice;
 }

	@Override
	public List<NoticeModel> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
			String sql = "SELECT * " +
			    	"	FROM ( " +
			    	"		SELECT ROWNUM NUM , N.* " +
			    	"			FROM ( " +
			    	"				SELECT * " + 
			    	"					FROM  " +
			    	"						NOTICE_VIEW  " +
			    	"					WHERE "+field+" LIKE ?  " +
			    	"					ORDER BY REGDATE DESC " +
			    	"				) N  " +
			    	"			) " +
			    	"			WHERE NUM BETWEEN ? AND ?";
			
			int startNum = 1 + (page-1)*10;
			int endNum = startNum*10;
			query = "%" + query + "%";
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
		    
		    PreparedStatement pstmt = con.prepareStatement(sql);
		    
		    pstmt.setString(1, query);
		    pstmt.setInt(2, startNum);
		    pstmt.setInt(3, endNum);
		    
		    ResultSet rs = pstmt.executeQuery();
		    
		    
		    List<NoticeModel> list = new ArrayList<>();
		    
		    while (rs.next()) {
		    	NoticeModel notice = new NoticeModel();
		       notice.setCode(rs.getString("code"));
		       notice.setTitle(rs.getString("title"));
		       notice.setWriter(rs.getString("writer"));
		       notice.setContent(rs.getString("content"));
		       notice.setRegdate(rs.getDate("regdate"));
		       notice.setHit(rs.getInt("hit"));
		       
		       list.add(notice);
		    }

		    rs.close();
		    pstmt.close();
		    con.close();
		    
		return list;
	}

	@Override
	public List<NoticeModel> getList(int page) throws ClassNotFoundException, SQLException {
		return this.getList(page, "TITLE", "");
	}

	@Override
	public List<NoticeModel> getList() throws ClassNotFoundException, SQLException {
		return this.getList(1, "TITLE", "");
	}
	
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		String sqlCode = "SELECT NVL(MAX(TO_NUMBER(CODE)),0)+1 CODE FROM NOTICE";
		
		
		String sql = "INSERT INTO NOTICE("
				+ "CODE, "
				+ "TITLE, "
				+ "WRITER, "
				+ "CONTENT, "
				+ "REGDATE, "
				+ "HIT) "
				+ "VALUES(?, ?, ?, ?, SYSDATE,0)";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Class.forName("oracle.jdbc.driver.OracleDriver");

	    Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	   
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(sqlCode);
	    rs.next();
	    
	    String code = rs.getString("CODE");
	    
	    rs.close();
	    st.close();
	    
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    
	    pstmt.setString(1, code);
	    pstmt.setString(2, notice.getTitle());
	    pstmt.setString(3, notice.getWriter());
	    pstmt.setString(4, notice.getContent());
	    
	    int result = pstmt.executeUpdate();

	    pstmt.close();
	    con.close();
	    
		return result;
	}
	
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE NOTICE SET "
				+ "TITLE=?, "
				+ "WRITER=?, "
				+ "CONTENT=?,"
				+ "WHERE CODE=?";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Class.forName("oracle.jdbc.driver.OracleDriver");

	    Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	    
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    
	    pstmt.setString(1, notice.getTitle());
	    pstmt.setString(2, notice.getWriter());
	    pstmt.setString(3, notice.getContent());
	    pstmt.setString(4, notice.getCode());
	    
	    int result = pstmt.executeUpdate();

	    pstmt.close();
	    con.close();
		
		return result;
	}
	
	public int delete(String code) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM NOTICE WHERE CODE = ?";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		Class.forName("oracle.jdbc.driver.OracleDriver");

	    Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	    
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    
	    pstmt.setString(1, code);
	    
	    int result = pstmt.executeUpdate();

	    pstmt.close();
	    con.close();
		
		return result;
	}
}*/