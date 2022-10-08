package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.services;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto.PlayerGamesDto;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Game;

public interface IGameService {
    public Game play(int  IdPlayer);
    public Boolean deleteGame(int id);
    public PlayerGamesDto GamesPlayer(int id);
}
