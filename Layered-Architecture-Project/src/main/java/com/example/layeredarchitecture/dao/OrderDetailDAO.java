package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {

    boolean addOrderDetails(String orderId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    Boolean saveOrderDetails(String orderId, OrderDetailDTO orderDetailDTO) throws SQLException;

}
