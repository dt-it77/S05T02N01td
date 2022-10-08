package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Player;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Players")
public class Player {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @Column(name = "name")
    private String name;
    @Column(name = "registerDate")
    private LocalDate registerDate;
	@JsonIgnore
	@OneToMany(mappedBy = "player")
	private List<Game> games = new ArrayList<>();

    public Player() {
	}
	public Player(int playerId, String name, LocalDate registerDate) {
        this.playerId = playerId;
		this.name = name;
		this.registerDate = registerDate;
	}

	public void setPlayerId(int playerId) {
		this.playerId =  playerId;
	}
	public int getPlayerId() {
		return playerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public List<Game> getGames(){
		return games;
	}
	public void setGames(List<Game> games){
		this.games = games;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", name=" + name + ", registerDate=" + registerDate
				+ ", gamesCount=" + games.size()+"]";
	}
}
