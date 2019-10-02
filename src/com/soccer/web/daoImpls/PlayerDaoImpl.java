package com.soccer.web.daoImpls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.soccer.web.daos.PlayerDao;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.factory.DatabaseFactory;
import com.soccer.web.pool.Constants;

public class PlayerDaoImpl implements PlayerDao{
	private static PlayerDaoImpl instance = new PlayerDaoImpl();
	public static PlayerDaoImpl getInstance() {return instance;}
	private PlayerDaoImpl() {}
	
	@Override
	public boolean insertPlayer(PlayerBean param) {
		System.out.println("PlayerDaoImpl_insertPlayer");
		boolean flag = false;
		try {
			String sql = "INSERT INTO PLAYER(PLAYER_ID,SOLAR,TEAM_ID,PLAYER_NAME)\r\n" + 
					"VALUES(?, ?, 'K03','이우연')";
			PreparedStatement stmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			stmt.setString(1, param.getPlayerId());
			stmt.setString(2, param.getSolar());
			int rs = stmt.executeUpdate();
			
			flag = (rs == 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public PlayerBean seletByPlayerIdSolar(PlayerBean param) {
		PlayerBean player = null;
		System.out.println("playerDaoImpl,seletByPlayerIdSolar");
		String sql = "SELECT * \n" + 
				"FROM PLAYER \n" + 
				"WHERE PLAYER_ID LIKE ? \n" + 
				"    AND SOLAR LIKE ?";
		try {
			PreparedStatement pstmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, param.getPlayerId());
			pstmt.setString(2, param.getSolar());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				player = new PlayerBean();
				player.setBackNo(rs.getString("BACK_NO"));
				player.setBirthDate(rs.getString("BIRTH_DATE"));
				player.setEPlayerName(rs.getString("E_PLAYER_NAME"));
				player.setHeight(rs.getString("HEIGHT"));
				player.setJoinYyyy(rs.getString("JOIN_YYYY"));
				player.setNation(rs.getString("NATION"));
				player.setNickName(rs.getString("NICKNAME"));
				player.setPlayerId(rs.getString("PLAYER_ID"));
				player.setPlayerName(rs.getString("PLAYER_NAME"));
				player.setPosition(rs.getString("POSITION"));
				player.setSolar(rs.getString("SOLAR"));
				player.setTeamId(rs.getString("TEAM_ID"));
				player.setWeight(rs.getString("WEIGHT"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}
	@Override
	public List<String> selectPositions() {
		List<String> positions = new ArrayList<>();
		try {
			String sql = "SELECT DISTINCT POSITION position \n" + 
					"FROM PLAYER";
			System.out.println("dao SQL " + sql);
			PreparedStatement stmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			ResultSet rs =	stmt.executeQuery();
			while(rs.next()) {
				positions.add(rs.getString("position"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return positions;
	}

	@Override
	public List<PlayerBean> selectByTeamIdPosition(PlayerBean param) {
		List<PlayerBean> list = new ArrayList<>();
		return list;
	}
	@Override
	public List<PlayerBean> selectByMany(PlayerBean param) {
		List<PlayerBean> list = new ArrayList<>();
		String sql = "-";
		try {
			PreparedStatement pstmt = DatabaseFactory
					.createDatabase(Constants.VENDOR)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, param.getBackNo());
			pstmt.setString(2, param.getBirthDate());
			pstmt.setString(3, param.getHeight());
			pstmt.setString(4, param.getJoinYyyy());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return list;
	}
}