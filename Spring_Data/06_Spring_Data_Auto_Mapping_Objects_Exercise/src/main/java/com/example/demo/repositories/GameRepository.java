package com.example.demo.repositories;

import com.example.demo.entities.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Optional<Game> findById(int id);

    List<Game> findAll();

    @Transactional
    void deleteById(int id);

    Optional<Game> findByTitle(String title);
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Game g WHERE g.id = :id")
//    Game deleteById(@Param("id") int id);
}
