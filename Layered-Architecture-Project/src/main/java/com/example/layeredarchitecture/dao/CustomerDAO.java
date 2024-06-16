package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.net.InterfaceAddress;
import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {

    ArrayList<CustomerDTO> loadAllCustomer() throws SQLException, ClassNotFoundException;

    void btnSave_OnAction(String id, String name, String address) throws SQLException, ClassNotFoundException;

    void btnUpdate_OnAction(String id, String name, String address) throws SQLException, ClassNotFoundException;

    void btnDelete_OnAction(String id) throws SQLException, ClassNotFoundException;

    boolean btnExitsCustomer(String id) throws SQLException, ClassNotFoundException;

    ResultSet genarateId() throws SQLException, ClassNotFoundException;

    ResultSet searchCustomer() throws SQLException, ClassNotFoundException;

    ResultSet loadCustomer() throws SQLException, ClassNotFoundException;

    CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException;

}
