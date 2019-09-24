package com.soccer.web.serviceimpls;

import java.util.List;

import com.soccer.web.daoImpls.PlayerDaoImpl;
import com.soccer.web.daos.PlayerDao;
import com.soccer.web.domains.PlayerBean;
import com.soccer.web.services.PlayerService;

public class PlayerServiceImpl implements PlayerService{
	
	private static PlayerServiceImpl instance = new PlayerServiceImpl();
	
	public static PlayerServiceImpl getInstance() {
		return instance;
	}
	
	private PlayerServiceImpl() {}
	
	@Override
	public List<String> findPositions() {
		return PlayerDaoImpl.getInstance().selectPositions();
	}

	// 4. 
	@Override
	public List<PlayerBean> findByTeamIdPosition(PlayerBean param) {
		
		List<PlayerBean> players = PlayerDaoImpl.getInstance().selectByTeamIdPosition(param);
				return players;
	}

	// 5.
	@Override
	public List<PlayerBean> findByTeamIdHeightPlayerName(PlayerBean param) {

		
		List<PlayerBean> players = PlayerDaoImpl.getInstance().selectByTeamIdHeightName(param);
		
		return players;
	}
}
