package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.util.List;

public class OrderDAOImpl implements OrderDAO{

    private Connection connection = DBConnection.getDbConnection().getConnection();

    public OrderDAOImpl() throws SQLException, ClassNotFoundException {
    }

    public boolean CheckOrderExist(String orderId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);
        return stm.executeQuery().next();
    }

    public boolean OrderSave(OrderDTO orderDTO, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
        connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm;
        stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderDTO.getOrderId());
        stm.setDate(2, Date.valueOf(orderDTO.getOrderDate()));
        stm.setString(3, orderDTO.getCustomerId());

        if (stm.executeUpdate() == 1) {
            if(orderDetailDAO.addOrderDetails(orderDTO.getOrderId(),orderDetails)){

                connection.commit();
                connection.setAutoCommit(true);
                return true;

            }

            connection.rollback();
            connection.setAutoCommit(true);

        }connection.rollback();
        connection.setAutoCommit(true);
        return false;
    }

    @Override
    public ResultSet genarateNextId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst;
    }
}
