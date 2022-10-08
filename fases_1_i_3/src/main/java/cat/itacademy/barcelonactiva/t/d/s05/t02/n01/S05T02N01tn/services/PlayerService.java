package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.services;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto.PlayerPercentageDto;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Game;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Player;
import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.repository.PlayerRepository;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;
	
    public Player add(Player player){
		if(player.getName() == null || player.getName().length() == 0){
			player.setName("ANÒNIM");
		}
		return playerRepository.save(player);
	}

    public Player update(Player player){
		return playerRepository.save(player);
	}
	
    public void delete(int playerId){
		playerRepository.deleteById(playerId);
	}  

	public List<PlayerPercentageDto> getAllPlayers(){
		List<Player> allPLayers = playerRepository.findAll();
		List<PlayerPercentageDto> playersDto = new ArrayList<>();

		for (Player player : allPLayers) {
			playersDto.add(convertToPlayerDto(player, player.getGames()));
		}
		return playersDto;

	}

	private PlayerPercentageDto convertToPlayerDto(Player player, List<Game> games)
	{
		int numberOfWins = 0;
		for (Game game : games) {
			if(game.getIsWin()){
				numberOfWins = numberOfWins+1;
			}
		}
		double percentage = 0;
		if(numberOfWins > 0){
			percentage = ((double)numberOfWins/(double)games.size())*100;
		}
 		return new PlayerPercentageDto(player.getName(),player.getRegisterDate(),new BigDecimal(percentage).setScale(2,RoundingMode.HALF_UP));
	}

    public String rankingAverage(){
        List<PlayerPercentageDto> _list = getAllPlayers();
		double percentage = 0;
		for (PlayerPercentageDto playerPercentageDto : _list) {
			percentage = percentage + playerPercentageDto.getPercentage().doubleValue();
		}
		return String.format("%.2f", ((double)percentage/(double)_list.size())) +"%";
    }

    public PlayerPercentageDto rankingLoser(){
		List<PlayerPercentageDto> _list = getAllPlayers();
		Optional<PlayerPercentageDto> worst = _list.stream().sorted(Comparator.comparing(PlayerPercentageDto::getPercentage)).findFirst();
		if(worst.isPresent()){
			return worst.get();
		}
		return null;
	}

    public PlayerPercentageDto rankingWinner(){
		List<PlayerPercentageDto> _list = getAllPlayers();
		Optional<PlayerPercentageDto> worst = _list.stream().sorted(Comparator.comparing(PlayerPercentageDto::getPercentage).reversed()).findFirst();
		if(worst.isPresent()){
			return worst.get();
		}
		return null;
    }

}
