package com.soccer.web.domains;

import java.io.Serializable;

import lombok.Data;
@Data
public class TeamBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String team_id, region_name, team_name, e_team_name, orig_yyyy,
				stadium_id, zip_code1, zip_code2, address, ddd, tel, fax, homepage, owner;
}
