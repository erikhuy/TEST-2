/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.dtos.BookDTO;
import sample.dtos.UserDTO;
import sample.utils.DBUtils;

/**
 *
 * @author Huy
 */
public class BookDAO {
    public List<BookDTO> getListBook(String search) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, img,bookName, author, price, quantity" + " from tblBookDetails "
                        + " WHERE bookName like '%" + search + "%'";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String img = rs.getString("img");
                    String bookName = rs.getString("bookName");
                    String author = rs.getString("author");
                    int price = rs.getInt("price");
                    int quantity= rs.getInt("quantity");
                    list.add(new BookDTO(bookID, img,bookName, author, price,quantity));
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
    public List<BookDTO> getListBook2(String search) throws SQLException {
        List<BookDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID, img,bookName, author, price, quantity" + " from tblBookDetails "
                        + " WHERE bookName like '%" + search + "%' AND quantity >= 1";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String img = rs.getString("img");
                    String bookName = rs.getString("bookName");
                    String author = rs.getString("author");
                    int price = rs.getInt("price");
                    int quantity= rs.getInt("quantity");
                    list.add(new BookDTO(bookID, img,bookName, author, price,quantity));
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
    

    public boolean checkExistedID(String bookID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT bookName FROM tblBookDetails WHERE bookID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, bookID);

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

    public void insert(BookDTO dto) throws SQLException, ClassNotFoundException, NamingException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblBookDetails(bookID, img, bookName, author, price, quantity)" + " values(?,?,?,?,?,?)";


                stm = conn.prepareStatement(sql);
                stm.setNString(1, dto.getBookID());
                stm.setNString(2, dto.getImg());
                stm.setNString(3, dto.getBookName());
                stm.setNString(4, dto.getAuthor());
                stm.setInt(5, dto.getPrice());
                stm.setInt(6, dto.getQuantity());

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
    public void update(BookDTO dto) throws SQLException {

        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblBookDetails SET "+" img=?,bookName=?,author=?,price=?,quantity=?"+" WHERE bookID=? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getImg());
                stm.setString(2, dto.getBookName());
                stm.setString(3, dto.getAuthor());
                stm.setInt(4, dto.getPrice());
                stm.setInt(5, dto.getQuantity());
                stm.setString(6, dto.getBookID());
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

    public void delete(String bookID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE tblBookDetails " + " WHERE bookID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, bookID);
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
}





















































