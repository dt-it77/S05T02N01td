package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Game;

import java.util.List;


public class PlayerGamesDto {
    
    private String name;
    private List<Game> games;

    public PlayerGamesDto(String name, List<Game> games){
        this.name = name;
        this.games = games;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setGames(List<Game> games){
        this.games = games;
    }
    public List<Game> getGames(){
        return games;
    }
}
