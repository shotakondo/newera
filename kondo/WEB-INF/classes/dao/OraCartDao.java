package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exp.ResourceAccessException;

import beans.*;

public class OraCartDao implements CartDao{
	
	public CartBean addCart(CartBean cb){
		return cb;
	}
}