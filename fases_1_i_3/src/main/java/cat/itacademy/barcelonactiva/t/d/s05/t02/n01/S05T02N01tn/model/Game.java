package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model;


import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Game;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "Game")
public class Game {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int gameId;
    @Column(name = "dice1")
    private int dice1;
    @Column(name = "dice2")
    private int dice2;
    @Column(name="isWin")
    private boolean isWin;
    @ManyToOne()
    @JoinColumn(name="player_playerId")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Player player;

	public Game(){

	}

	public Game(Player player) {
		this.dice1 = getRandomValue();
		this.dice2 = getRandomValue();
		this.isWin = setIsWin(dice1,dice2);
		this.player = player;
	}
    
	private int getRandomValue(){
		Random r = new Random();
		return r.nextInt(6)+1;
	}

    public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

    public int getDice1() {
		return dice1;
	}

    public int getDice2() {
		return dice2;
	}

	public boolean setIsWin(int dice1, int decie2) {
		if(dice1+dice2 == 7){
			return true;
		}
		return false;
	}
    public boolean getIsWin() {
		return isWin;
	}	

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", dice1=" + dice1 + ", dice2=" + dice2
				+ ", isWin=" + isWin + ", playerId=" + player.getPlayerId() +"]";
	}
}
