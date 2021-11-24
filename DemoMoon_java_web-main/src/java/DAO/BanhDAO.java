/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.BanhDTO;
import DTO.CategoryDTO;
import DTO.DetailDTO;
import DTO.DiscountDTO;
import DTO.OrderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class BanhDAO {

    Connection cn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ArrayList<BanhDTO> getListBanh() throws SQLException {
        ArrayList<BanhDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BanhID,BanhName,image,Price,quantity,description,CurrentDate,Status,CategoryID\n"
                        + "from tblBanh\n";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new BanhDTO(rs.getInt("BanhID"),
                            rs.getString("BanhName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public ArrayList<CategoryDTO> getListCategory() throws SQLException {
        ArrayList<CategoryDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select CategoryID,CategoryName\n"
                        + "from tblCategory";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new CategoryDTO(rs.getInt("CategoryID"), rs.getString("CategoryName")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public BanhDTO searchBanhbyID(int ID) throws SQLException {
        BanhDTO b = new BanhDTO();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BanhID,BanhName,image,Price,quantity,description,CurrentDate,Status,CategoryID\n"
                        + "from tblBanh\n"
                        + "where BanhID =?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, ID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    b = new BanhDTO(rs.getInt("BanhID"),
                            rs.getString("BanhName"),
                            rs.getString("image"),
                            rs.getInt("Price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID"));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return b;
    }

    public int updateBanh(BanhDTO b) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "update tblBanh\n"
                        + "set BanhName = ?,image = ?,Price=?,quantity=?,description=?,CurrentDate=?,Status=?,CategoryID=?\n"
                        + "where BanhID = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, b.getBanhName());
                pst.setString(2, b.getImage());
                pst.setFloat(3, b.getPrice());
                pst.setInt(4, b.getQuantity());
                pst.setString(5, b.getDescription());
                pst.setString(6, b.getCurrentDate());
                pst.setBoolean(7, b.isStatus());
                pst.setInt(8, b.getCategoryID());
                pst.setInt(9, b.getBanhID());
                return pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int insertBanh(BanhDTO b) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "insert into tblBanh values(?,?,?,?,?,?,'1',?)\n";
                pst = cn.prepareStatement(sql);
                pst.setString(1, b.getBanhName());
                pst.setString(2, b.getImage());
                pst.setFloat(3, b.getPrice());
                pst.setInt(4, b.getQuantity());
                pst.setString(5, b.getDescription());
                pst.setString(6, b.getCurrentDate());
                pst.setInt(7, b.getCategoryID());
                int result = pst.executeUpdate();
                return result;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int deleteBanh(int id) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "update tblBanh\n"
                        + "set Status=0\n"
                        + "where BanhID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                return pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public ArrayList<BanhDTO> getListBanhByCategoryID(int ID) throws SQLException {
        ArrayList<BanhDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = null;
                if (ID == 0) {
                    sql = "select BanhID,BanhName,image,Price,quantity,description,CurrentDate,Status,CategoryID\n"
                            + "from tblBanh\n"
                            + "where Status = '1'";
                } else {
                    sql = "select BanhID,BanhName,image,Price,quantity,description,CurrentDate,Status,CategoryID\n"
                            + "from tblBanh\n"
                            + "where Status = '1' AND CategoryID = " + ID;

                }
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new BanhDTO(rs.getInt("BanhID"),
                            rs.getString("BanhName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID")));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public ArrayList<BanhDTO> getListBanhByName(String search) throws SQLException {
        ArrayList<BanhDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BanhID,BanhName,image,Price,quantity,description,CurrentDate,Status,CategoryID\n"
                        + "from tblBanh\n"
                        + "where Status = '1' AND BanhName like '%" + search + "%'";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new BanhDTO(rs.getInt("BanhID"),
                            rs.getString("BanhName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public BanhDTO getBanhByBanhID(int ID) throws SQLException {
        BanhDTO b = new BanhDTO();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BanhID,BanhName,image,Price,quantity,description,CurrentDate,Status,CategoryID\n"
                        + "from tblBanh\n"
                        + "where BanhID = ?";

                pst = cn.prepareStatement(sql);
                pst.setInt(1, ID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    b = new BanhDTO(rs.getInt("BanhID"),
                            rs.getString("BanhName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID"));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return b;
    }

    public int getQuantityOfBanh(int ID) throws SQLException {
        int quantity = 0;
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select quantity\n"
                        + "from tblBanh\n"
                        + "where BanhID = " + ID;
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("quantity");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return quantity;
    }

    public int insertDetail(DetailDTO dto) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "insert into tblDetail values(?,?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setFloat(1, dto.getPrice());
                pst.setInt(2, dto.getQuantity());
                pst.setInt(3, dto.getOrderID());
                pst.setInt(4, dto.getBook().getBanhID());
                return pst.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int insertOrder(OrderDTO dto) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "insert into tblOrder values(?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, dto.getDateOrder());
                pst.setFloat(2, dto.getTotal());
                pst.setInt(3, dto.getUserID());
                return pst.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int getOrderID() throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select top 1 OrderID\n"
                        + "from tblOrder\n"
                        + "order by OrderID desc";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt("OrderID");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public int updateQuantityOfBanh(int BanhID, int Banhquantity) throws SQLException {
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "update tblBanh\n"
                        + "set quantity = ?\n"
                        + "where BanhID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Banhquantity);
                pst.setInt(2, BanhID);
                return pst.executeUpdate();

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return -1;
    }

    public ArrayList<OrderDTO> listOrderID(int UserID) throws SQLException {
        ArrayList<OrderDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select OrderID, DateOrder, total\n"
                        + "from tblOrder\n"
                        + "where UserID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, UserID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new OrderDTO(rs.getInt("OrderID"),
                            rs.getString("DateOrder"),
                            rs.getFloat("total"),
                            UserID));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public ArrayList<DetailDTO> getListDetailByOrderID(int ID) throws SQLException {
        ArrayList<DetailDTO> list = new ArrayList<>();
        BanhDAO dao = new BanhDAO();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select Price, quantity,OrderID,BanhID\n"
                        + "from tblDetail\n"
                        + "where OrderID = ?";
                pst = cn.prepareStatement(sql);
                pst.setInt(1, ID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    BanhDTO dto = dao.getBanhByBanhID(rs.getInt("BanhID"));
                    list.add(new DetailDTO(0, rs.getFloat("Price"), rs.getInt("quantity"), rs.getInt("OrderID"), dto));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public ArrayList<BanhDTO> getListBanhByPrice(float num1, float num2) throws SQLException {
        ArrayList<BanhDTO> list = new ArrayList<>();
        try {
            cn = Util.DBUtil.getConnection();
            if (cn != null) {
                String sql = "select BanhID,BanhName,image,Price,quantity,description,CurrentDate,Status,CategoryID\n"
                        + "from tblBanh\n"
                        + "where Price between ? and ?";
                pst = cn.prepareStatement(sql);
                pst.setFloat(1, num1);
                pst.setFloat(2, num2);
                rs = pst.executeQuery();
                while (rs.next()) {
                    list.add(new BanhDTO(rs.getInt("BanhID"),
                            rs.getString("BanhName"),
                            rs.getString("image"),
                            rs.getFloat("Price"),
                            rs.getInt("quantity"),
                            rs.getString("description"),
                            rs.getString("CurrentDate"),
                            rs.getBoolean("Status"),
                            rs.getInt("CategoryID")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BanhDAO dao = new BanhDAO();
        try {
            ArrayList<BanhDTO> list = dao.getListBanhByPrice(4,3);
            for (BanhDTO b : list) {
                System.out.println(b.toString());
            }

        } catch (Exception e) {
        }
    }

}
