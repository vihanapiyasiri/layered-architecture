package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {

    ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException;

    void btnDeleteOnAction(String code) throws SQLException, ClassNotFoundException;

    void btnSaveOnAction(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;

    void btnUpdateOnAction(String code, String description, BigDecimal unitPrice, int qtyOnHand) throws SQLException, ClassNotFoundException;

    ResultSet genareteId() throws SQLException, ClassNotFoundException;

    boolean exitsItem(String code) throws SQLException, ClassNotFoundException;

    ResultSet loadItem() throws SQLException, ClassNotFoundException;

    ResultSet findItem(String code) throws SQLException, ClassNotFoundException;

    ItemDTO findItemCode(String newItemCode) throws SQLException, ClassNotFoundException;
}
