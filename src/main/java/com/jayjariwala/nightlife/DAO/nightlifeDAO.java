package com.jayjariwala.nightlife.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jayjariwala.nightlife.MODEL.NightlifeModel;
import com.mysql.jdbc.PreparedStatement;

public class nightlifeDAO {

	public int goingclub(NightlifeModel model )
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection conn=dao.openconnection();
		String check="SELECT COUNT(clubId) FROM club_Assign WHERE clubId=? AND UserId=?";
		try {
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(check);
			pst.setString(1,model.getClubid());
			pst.setString(2, model.getUserid());
			ResultSet rslt=pst.executeQuery();
			int result = 0;
			while(rslt.next())
			{
				result=rslt.getInt(1);
			}
			if(result==0)
			{
				String sql="INSERT INTO club_Assign VALUES (?,?)";
				PreparedStatement pst1=(PreparedStatement) conn.prepareStatement(sql);
				pst1.setString(1,model.getClubid());
				pst1.setString(2, model.getUserid());
				int j=pst1.executeUpdate();
				if(j==1)
				{
					 String checkcount = "SELECT COUNT(clubId) from club_count where clubId=?";
					PreparedStatement prepared=(PreparedStatement) conn.prepareStatement(checkcount);
					prepared.setString(1,model.getClubid());
					ResultSet rs=prepared.executeQuery();
					int clubcount=0;
					while(rs.next())
					{
						clubcount=rs.getInt(1);
					}
					if(clubcount==0)
					{
						String  addcount="INSERT INTO club_count VALUES (?,count+1)";
						PreparedStatement pst3=(PreparedStatement) conn.prepareStatement(addcount);
						pst3.setString(1,model.getClubid());
						int i=pst3.executeUpdate();
						return i;
					}
					else
					{
						String updatecount="UPDATE club_count SET count=count+1 WHERE clubId=? ";
						PreparedStatement pst4=(PreparedStatement) conn.prepareStatement(updatecount);
						pst4.setString(1, model.getClubid());
						pst4.executeUpdate();
						return 2;
					}
					
				}
				
			}
			else
			{
				String deleteassign="delete from club_Assign WHERE clubId=? AND UserId=?";
				PreparedStatement pst7=(PreparedStatement)conn.prepareStatement(deleteassign);
				pst7.setString(1,model.getClubid());
				pst7.setString(2, model.getUserid());
				pst7.executeUpdate();
				String update="UPDATE club_count SET count=count-1 WHERE clubId=?";
				PreparedStatement pst5=(PreparedStatement) conn.prepareStatement(update);
				pst5.setString(1,model.getClubid());
				pst5.executeUpdate();
				return 3;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	public int getbarcount(String barId)
	{
		String query="SELECT count from club_count where clubId=?";
		ConnectionDAO dao=new ConnectionDAO();
		Connection conn=dao.openconnection();
		try {
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(query);
			pst.setString(1,barId);
			ResultSet rs=pst.executeQuery();
			int count=0;
			while(rs.next())
			{
				count=rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
