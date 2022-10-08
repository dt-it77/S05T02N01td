package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto.PlayerGamesDto;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Game;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.services.IGameService;


@RestController
public class GamesController {
    @Autowired
    private IGameService gameService;

	@DeleteMapping("/players/{id}/games")
	public ResponseEntity<HttpStatus> deleteGames(@PathVariable("id") int id) {
		try {
            Boolean _deleteResult = gameService.deleteGame(id);
            if (_deleteResult) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    @PostMapping("/players/{id}/games")
	public ResponseEntity<Game> playGame(@PathVariable("id") int id) {
		try {

			Game _game = gameService.play(id);
			if(_game != null){
				return new ResponseEntity<Game>(_game, HttpStatus.CREATED);
			}
			return new ResponseEntity<Game>(_game, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/players/{id}/games")
	public ResponseEntity<PlayerGamesDto> getPlayerGames(@PathVariable("id") int id) {
		try {
			PlayerGamesDto _result = gameService.GamesPlayer(id);
			if(_result != null){
				return new ResponseEntity<PlayerGamesDto>(_result, HttpStatus.OK);
			}else{
				return new ResponseEntity<PlayerGamesDto>(_result, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}
