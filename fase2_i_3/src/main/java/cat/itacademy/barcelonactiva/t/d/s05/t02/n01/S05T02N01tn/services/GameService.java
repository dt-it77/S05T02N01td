package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Player;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.repository.GameRepository;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto.PlayerGamesDto;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Game;


@Service
public class GameService implements IGameService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameRepository gameRepository;

    public Game play(int playerId){
        try{
            Optional<Player> player = playerRepository.findById(playerId);
            if(player.isPresent()){
                return gameRepository.save(new Game(player.get()));
            }
            return null;            
        }catch(Exception ex){
            System.err.print(ex);
            return null;
        }
    }
    public Boolean deleteGame(int playerId){
        Optional<Player> player = playerRepository.findById(playerId);
        if(player.isPresent()){
            gameRepository.deleteAll(player.get().getGames());
            return true;
        }
        return false;
    }


    public PlayerGamesDto GamesPlayer(int id){
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            return new PlayerGamesDto(player.get().getName(), player.get().getGames());
        }
        return null;
    }



}
