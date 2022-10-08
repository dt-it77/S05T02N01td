package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.services;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto.PlayerPercentageDto;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Player;
import java.util.List;

public interface IPlayerService {
    public Player add(Player player);
    public Player update(Player player);
    public void delete(int id);
    public List<PlayerPercentageDto> getAllPlayers();
    public String rankingAverage();    
    public PlayerPercentageDto rankingLoser();
    public PlayerPercentageDto rankingWinner();

}
