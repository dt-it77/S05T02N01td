package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.model.Game;

@Repository
public interface GameRepository extends MongoRepository<Game, Integer> {
    
}