package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import bean.Ordine;
import connectionPool.DriverMaagerConnectionPool;

public class AmministratoreOrdineManager {

	/**
	 * 
	 * @param numOrdine
	 * @throws SQLException 
	 */
	public Ordine ricercaOrdine(int numOrdine) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		String selectQ= "SELECT * FROM ordine WHERE numero = ?";
		Ordine ordine= null;
		
		try {
			pStatement= connection.prepareStatement(selectQ);
			pStatement.setInt(1, numOrdine);
			ResultSet rs= pStatement.executeQuery();
			
			if(rs.next()) {
				ordine= new Ordine();
				ordine.setCitt�(rs.getString("citt�"));
				ordine.setDataEffettuata(rs.getDate("dataOrdine"));
				ordine.setDataConsegna(rs.getDate("dataConsegna"));
				ordine.setOra(rs.getTime("oraConsegna"));
				ordine.setIdOrdine(rs.getInt("numero"));
				ordine.setStato(rs.getString("stato"));
			}
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return ordine;
		
	}

	/**
	 * 
	 * @param numOrdine
	 * @param stato
	 * @throws SQLException 
	 */
	public boolean cambiaStato(int numOrdine, String stato) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String updateQ= "UPDATE ordine SET stato = ? WHERE numero = ?";
		
		try {
			pStatement= connection.prepareStatement(updateQ);
			pStatement.setString(1, stato);
			pStatement.setInt(2, numOrdine);
			if(pStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param numOrdine
	 * @param data
	 * @param ora
	 * @throws SQLException 
	 */
	public boolean cambiaDataEOra(int numOrdine, Date data, Time ora) throws SQLException {
		Connection connection= DriverMaagerConnectionPool.getConnection();
		PreparedStatement pStatement= null;
		
		boolean result= false;
		String updateQ= "UPDATE ordine SET dataConsegna = ?, oraConsegna = ? WHERE numero = ?";
		
		try {
			pStatement= connection.prepareStatement(updateQ);
			pStatement.setDate(1, data);
			pStatement.setTime(2, ora);
			pStatement.setInt(3, numOrdine);
			if(pStatement.executeUpdate()==1) {
				result= true;
			}
			connection.commit();
		}finally {
			try {
				if(pStatement!=null) pStatement.close();
			}finally {
				DriverMaagerConnectionPool.releaseConnection(connection);
			}
		}
		return result;
	}

}