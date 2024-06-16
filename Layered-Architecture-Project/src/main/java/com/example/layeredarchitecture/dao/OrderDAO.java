package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    public ResultSet genarateNextId() throws SQLException, ClassNotFoundException;

    boolean CheckOrderExist(String orderId) throws SQLException, ClassNotFoundException;

    boolean OrderSave(OrderDTO orderDTO, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

}
