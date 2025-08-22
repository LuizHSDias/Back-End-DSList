package com.cefet.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cefet.dslist.entities.Game;
import com.cefet.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
	
    @Query(nativeQuery = true, value = """
		SELECT 
			tb_game.id, 
			tb_game.titulo AS titulo, 
			tb_game.ano AS ano, 
			tb_game.img_url AS imgUrl,
			tb_game.curta_descricao AS curtaDescricao, 
			tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging 
			ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
		""") 

		/*
			SELECT TB_BELONGING.*,  TB_GAME.TITULO FROM TB_BELONGING 
	        INNER JOIN TB_GAME ON TB_GAME.ID = TB_BELONGING .GAME_ID
	        WHERE LIST_ID = 2
	        ORDER BY POSITION
		 */

List<GameMinProjection> searchByList(Long listId);


}