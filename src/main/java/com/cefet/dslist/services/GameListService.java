package com.cefet.dslist.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cefet.dslist.dto.GameListDTO;
import com.cefet.dslist.entities.GameList;
import com.cefet.dslist.projections.GameMinProjection;
import com.cefet.dslist.repositories.GameListRepository;
import com.cefet.dslist.repositories.GameRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class GameListService {
    
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    // Buscar ID
    public GameListDTO findById(Long id){
        GameList game = gameListRepository.findById(id)
             .orElseThrow(() -> new EntityNotFoundException("Game não encontrado com ID: " + id));
        return new GameListDTO(game);
    }

    // Listar
    public List<GameListDTO> findAll(){
        List<GameList> listaGames = gameListRepository.findAll();
	    return listaGames.stream().map(GameListDTO::new).toList();
    }

     @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
    
    List<GameMinProjection> list = gameRepository.searchByList(listId);
    
    GameMinProjection obj = list.remove(sourceIndex);
    list.add(destinationIndex, obj);

    int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
    int max = sourceIndex < destinationIndex ? destinationIndex:sourceIndex;
    
    for (int i = min; i <= max; i++) {
        gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
      }
    }

    // Inserir 
    public GameListDTO insert(GameListDTO dto){
        GameList gameList = new GameList();
        gameList.setNome(dto.getNome());
        GameList salvo = gameListRepository.save(gameList);
        return new GameListDTO(salvo);
    }

    // Atualizar
    public GameListDTO update(Long id, GameListDTO dto){
        GameList gameList = gameListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("GameList não encontrado: " + id));
        gameList.setNome(dto.getNome());
        GameList atualizado = gameListRepository.save(gameList);
        return new GameListDTO(atualizado);
    }

    // Remover por ID
    public void delete(Long id) {
		if (!gameListRepository.existsById(id)) {
			throw new EntityNotFoundException("GameList não encontrado  com ID: " + id);
		}
		gameListRepository.deleteById(id);
	}

}