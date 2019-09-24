package com.soccer.web.services;

import java.util.List;

import com.soccer.web.domains.PlayerBean;

public interface PlayerService {
	// 2. 포지션 종류(중복제거,없으면 빈공간)
	public List<String> findPositions();
	// 4. 수원팀(ID: K02)골키퍼
	public List<PlayerBean>  findByTeamIdPosition(PlayerBean param);
	// 5. 수원팀(ID: K02)키가 170 이상 선수 이면서 성이 고씨인 선수
	public List<PlayerBean> findByTeamIdHeightPlayerName(PlayerBean param);

}
