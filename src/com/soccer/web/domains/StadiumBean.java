package com.soccer.web.domains;

import java.io.Serializable;

import lombok.Data;
@Data

public class StadiumBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String stadium_id, stadium_name, hometeam_id, seat_count, address,
				ddd, tel;
}
