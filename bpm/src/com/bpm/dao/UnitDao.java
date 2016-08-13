package com.bpm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bpm.bean.Unit;
import com.bpm.db.DBO;

public class UnitDao {

	private Unit root;

	public Unit getRoot() {
		return root;
	}

	public void setRoot(Unit root) {
		this.root = root;
	}
	
	public ArrayList<Unit> getUnitsByParentName(String parentName){
		ArrayList<Unit> units = new ArrayList<Unit>();
		
		Connection conn = DBO.getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from tb_organization where parent_name='" + parentName + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Unit unit = new Unit();
				unit.setId(rs.getInt("id"));
				unit.setName(rs.getString("o_name"));
				unit.setParentName(parentName);
				units.add(unit);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return units;
	}
	
	public void getBranches(Unit root){
		root.setChildren(getUnitsByParentName(root.getName()));
		for(int i = 0; i < root.getChildren().size(); i++){
			getBranches(root.getChildren().get(i));
		}
	}
}
