var app = (()=>{
	return {
		init : (ctx)=>{
			playerService.login(ctx);
			playerService.join(ctx);
			playerService.move_join(ctx);
			playerService.question(ctx);
			playerService.page_back(ctx);
		}
	};
})();

var player = (()=>{
	var _playerId, _playerName, _teamId, _ePlayerName, _nickname, _joinYyyy,
	_position, _backNo, _nation, _birthDate, _solar, _height, _weight;
	var setPlayerId = (playerId)=>{this._playerId = playerId;}
	var setSolar = (solar)=>{this._solar = solar;}
	var getPlayerId = ()=>{return this._playerId;}
	var getSolar = ()=>{return this._solar;}
	return {
		setPlayerId : setPlayerId,
		setSolar : setSolar,
		getPlayerId : getPlayerId,
		getSolar : getSolar
	};
})();
var playerService = (()=>{
	return {
		login: (ctx)=>{
			$('#login_btn').click(()=>{
				if($('#username').val()==='' || 
						$('#solar').val()===''){
					alert('필수값이 없습니다.');
				}else{
					alert('입력한 아이디 값: '+$('#username').val());
					$('#login_form').attr('action', ctx + '/player.do' );
					$('login_form').attr('method', 'POST');
					$('#login_form').submit();	
				}
				
			});
		},
		join : (ctx)=>{
			$('#join_btn').click(()=>{
				if($('#join_playerId').val()==='' || 
						$('#join_solar').val()===''){
					alert('필수값이 없습니다.');
				}else{
					alert('입력한 아이디 값: '+$('#join_playerId').val());
					$('#join_form').attr('action', ctx + '/player.do' );
					$('login_form').attr('method', 'POST');
					$('#join_form').submit();	
				}
			});	
		},
		move_join : (ctx)=>{
		
			$('#a_join').click(()=>{
				location.assign(ctx+'/facade.do?action=move&page=join');
			});
			},
			question : (ctx)=> {
				
				$('#btn2').click(()=>{
					location.assign(ctx+'/player.do?action=search&page=2_positions_a');
				});
			},
			page_back : (ctx)=>{
				
				$('#page_back').click(()=>{
					alert('page_back');
					location.assign(ctx+'/player.do?action=move&page=main');
				});
			}
	};
})();
