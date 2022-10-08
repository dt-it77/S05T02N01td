package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    
}