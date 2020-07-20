package sample.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.dtos.UserDTO;
import sample.dtos.UserDTO1;
import sample.utils.DBUtils;

public class UserDAO {

    public UserDTO1 checkLogin(String userID, String password) throws SQLException {
        UserDTO1 dto1 = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userName,roleID FROM tblUsers WHERE userID=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String userName = rs.getString("userName"); 
                    String roleID = rs.getString("roleID");
                    dto1=new UserDTO1(userName, roleID);
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return dto1;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userID, userName, roleID, password" + " from tblUsers "
                        + " WHERE userName like '%" + search + "%'";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String userName = rs.getString("userName");
                    String password = rs.getString("password");
                    String roleID = rs.getString("roleID");
                    list.add(new UserDTO(userID, userName, password, roleID));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
        }
        return list;
    }

    public void delete(String userID) throws SQLException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE tblUsers " + " WHERE userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.executeUpdate();
            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void insert(UserDTO dto) throws SQLException, ClassNotFoundException, NamingException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblUsers(userID, userName, password, roleID)" + " values(?,?,?,?)";


                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getUserID());
                stm.setString(2, dto.getUserName());
                stm.setString(3, dto.getPassword());
                stm.setString(4, dto.getRoleID());

                stm.executeUpdate();
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
    public void insert2(UserDTO dto) throws SQLException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblUsers(userID, userName, password, roleID)" + " values(?,?,?,?)";


                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getUserID());
                stm.setString(2, dto.getUserName());
                stm.setString(3, dto.getPassword());
                stm.setString(4, dto.getRoleID());

                stm.executeUpdate();
            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
     public void update(UserDTO dto) throws SQLException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUsers SET "+" userName=?,roleID=?,password=? "+" WHERE userID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getUserName());
                stm.setString(2, dto.getRoleID());
                stm.setString(3, dto.getPassword());
                stm.setString(4, dto.getUserID());
                stm.executeUpdate();
            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
 public boolean checkExistedID(String userID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT userName FROM tblUsers WHERE userID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);

                rs = stm.executeQuery();
                if (rs.next()) {
                    result=true;
                }
            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
