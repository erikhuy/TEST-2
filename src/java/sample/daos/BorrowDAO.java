/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import sample.dtos.BorrowDTO;
import sample.utils.DBUtils;

/**
 *
 * @author Huy
 */
public class BorrowDAO {
    
//public List<BorrowDTO> getListBorrow(String search) throws SQLException {
//        List<BorrowDTO> list = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "SELECT bookID, bookName, author, price, quantity" + " from tblBookDetails "
//                        + " WHERE bookName like '%" + search + "%'";
//                stm = conn.prepareStatement(sql);
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    String bookID = rs.getString("bookID");
//                    String bookName = rs.getString("bookName");
//                    String author = rs.getString("author");
//                    int price = rs.getInt("price");
//                    int quantity= rs.getInt("quantity");
//                    list.add(new BorrowDTO(bookID, bookName, author, price,quantity));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//        }
//        return list;
//    }
//    public List<BorrowDTO> getListBook2(String userID) throws SQLException {
//        List<BorrowDTO> list = new ArrayList<>();
//        Connection conn = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "SELECT bookID, bookName, author, price, quantity" + " from tblBookDetails "
//                        + " WHERE bookName like '%" + userID + "%'";
//                stm = conn.prepareStatement(sql);
//                rs = stm.executeQuery();
//                while (rs.next()) {
//                    String bookID = rs.getString("bookID");
//                    String bookName = rs.getString("bookName");
//                    String author = rs.getString("author");
//                    int price = rs.getInt("price");
//                    int quantity= rs.getInt("quantity");
//                    list.add(new BorrowDTO(bookID, bookName, author, price,quantity));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (stm != null) {
//                stm.close();
//            }
//        }
//        return list;
//    }
//    
//
//

    public void insert(BorrowDTO dto) throws SQLException, ClassNotFoundException, NamingException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblBorrow(userID, bookID, borrowDate)" + " values(?,?,?)";


                stm = conn.prepareStatement(sql);
                stm.setNString(1, dto.getUserID());
                stm.setNString(2, dto.getBookID());
                stm.setDate(3, (Date) dto.getBorrowDate());


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
//    public void update(BorrowDTO dto) throws SQLException {
//
//        Connection conn = null;
//        PreparedStatement stm = null;
//
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "UPDATE tblBookDetails SET "+" bookName=?,author=?,price=?,quantity=?"+" WHERE bookID=? ";
//                stm = conn.prepareStatement(sql);
//                stm.setString(1, dto.getBookName());
//                stm.setString(2, dto.getAuthor());
//                stm.setInt(3, dto.getPrice());
//                stm.setInt(4, dto.getQuantity());
//                stm.setString(5, dto.getBookID());
//                stm.executeUpdate();
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        } finally {
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//
//    }
//
//    public void delete(String bookID) throws SQLException {
//        Connection conn = null;
//        PreparedStatement stm = null;
//
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                String sql = "DELETE tblBookDetails " + " WHERE bookID=?";
//                stm = conn.prepareStatement(sql);
//                stm.setString(1, bookID);
//                stm.executeUpdate();
//            }
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        } finally {
//            if (stm != null) {
//                stm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//
//    }
}
