package com.soccer.web.domains;

import java.io.Serializable;

import lombok.Data;
@Data

public class ScheduleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sche_date, stadium_id, gubun, hometeam_id, awayteam_id,
				home_score, away_score;
}
