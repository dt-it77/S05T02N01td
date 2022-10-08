package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto.PlayerPercentageDto;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Player;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.services.IPlayerService;

@RestController
public class PlayersController {
    @Autowired
    private IPlayerService playerService;

    @PostMapping("/players")
	public ResponseEntity<Player> add(@RequestBody Player player) {
		try {
			Player _player =  playerService.add(player);
			return new ResponseEntity<>(_player, HttpStatus.CREATED);
		} catch (Exception e) {
			System.err.print(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/players")
	public ResponseEntity<Player> update(@RequestBody Player player) {
		try {
			Player _player =  playerService.add(player);
			return new ResponseEntity<>(_player, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/players")
    public ResponseEntity<List<PlayerPercentageDto>> getAllPlayers(){
		try{
			List<PlayerPercentageDto> result = playerService.getAllPlayers();	
			if(result != null){
				return new ResponseEntity<List<PlayerPercentageDto>>(result, HttpStatus.OK);
			}else{
				return new ResponseEntity<List<PlayerPercentageDto>>(result, HttpStatus.NO_CONTENT);
			}
		}catch(Exception ex){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }


	@GetMapping("/players/ranking")
    public ResponseEntity<String> rankingAverage(){
		try{
			String result = playerService.rankingAverage();	
			if(result != null){
				return new ResponseEntity<String>(result, HttpStatus.OK);
			}else{
				return new ResponseEntity<String>(result, HttpStatus.NO_CONTENT);
			}
		}catch(Exception ex){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@GetMapping("/players/ranking/loser")
    public ResponseEntity<PlayerPercentageDto> rankingLoser(){
		try {
			PlayerPercentageDto _playerPercentage = playerService.rankingLoser();
			if(_playerPercentage != null){
				return new ResponseEntity<PlayerPercentageDto>(_playerPercentage, HttpStatus.OK);
			}else{
				return new ResponseEntity<PlayerPercentageDto>(_playerPercentage, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	@GetMapping("/players/ranking/winner")
    public ResponseEntity<PlayerPercentageDto> rankingWinner(){
		try {
			PlayerPercentageDto _playerPercentage = playerService.rankingWinner();
			if(_playerPercentage != null){
				return new ResponseEntity<PlayerPercentageDto>(_playerPercentage, HttpStatus.OK);
			}else{
				return new ResponseEntity<PlayerPercentageDto>(_playerPercentage, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

}
