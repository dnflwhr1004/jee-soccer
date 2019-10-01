var app = (()=>{
	return {
		init : (ctx)=>{
			playerService.login();
			$('#a_join').click(()=>{
				alert('회원가입 이동');
				location.assign(ctx+'/player.do?action=move&page=join');
			});
			
		}
	};
})();

//playerId, playerName, teamId, ePlayerName, nickname,
//joinYyyy, position, backNo, nation, birthDate, solar, height,weight;
var player = (()=>{
	var _playerId, _playerName,_teamId, _ePlayerName, _nickname, 
	_joinYyyy, _position, _backNo, _nation, _birthDate, _solar, _height, _weight;
	var setPlayerId = (playerId)=>{this.playerId = playerId;}
	var setSolar = (solar)=>{this.solar = solar};
	var getPlayerId = ()=>{return this._playerId;}
	var getSolar = ()=>{return this._solar;}
	return{
		setPlayerId : setPlayerId,
		setSolar : setSolar,
		getPlayerId : getPlayerId, 
		getSolar : getSolar
	};
})();


var playerService = (()=>{
	return{
		login : ()=>{
			$('#login_btn').click(()=>{
				if( $('#username').val()=== '' || 
						$('#solar').val()=== ''){
					alert('필수값이 없습니다.');
				}else{
					alert('입력아이디 값 : ' + $('#username').val());
					$('#login_form').attr('action','/jee-soccer/player.do');
					$('#login_form').submit();
				}
			});
		}
	}
})();