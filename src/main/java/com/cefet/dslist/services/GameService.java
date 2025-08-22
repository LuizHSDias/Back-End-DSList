package com.cefet.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.dslist.dto.GameDTO;
import com.cefet.dslist.dto.GameMinDTO;
import com.cefet.dslist.entities.Game;
import com.cefet.dslist.projections.GameMinProjection;
import com.cefet.dslist.repositories.GameRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    // Buscar ID
    public GameDTO findById(Long id){
        Game game = gameRepository.findById(id)
             .orElseThrow(() -> new EntityNotFoundException("Game não encontrado com ID: " + id));
        return new GameDTO(game);
    }

    // Listar
    public List<GameDTO> findAll(){
        List<Game> listaGames = gameRepository.findAll();
	    return listaGames.stream().map(GameDTO::new).toList();
    }

    // Listar
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> listaGames = gameRepository.searchByList(listId);
	    return listaGames.stream().map(GameMinDTO::new).toList();
    }


    // Inserir 
    public GameDTO insert(GameDTO dto){
        Game game = new Game();
        game.setTitulo(dto.getTitulo());
        game.setAno(dto.getAno());
        game.setGenero(dto.getGenero());
        game.setPlataforma(dto.getPlataforma());
        game.setScore(dto.getScore());
        game.setImgUrl(dto.getImgUrl());
        game.setCurtaDescricao(dto.getCurtaDescricao());
        game.setLongaDescricao(dto.getLongaDescricao());
        Game salvo = gameRepository.save(game);
        return new GameDTO(salvo);
    }

    // Atualizar 
    public GameDTO update(Long id, GameDTO dto){
        Game game = gameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Game não encontrado."));

        game.setTitulo(dto.getTitulo());
        game.setAno(dto.getAno());
        game.setGenero(dto.getGenero());
        game.setPlataforma(dto.getPlataforma());
        game.setScore(dto.getScore());
        game.setImgUrl(dto.getImgUrl());
        game.setCurtaDescricao(dto.getCurtaDescricao());
        game.setLongaDescricao(dto.getLongaDescricao());

        Game atualizado = gameRepository.save(game);
        return new GameDTO(atualizado);
        
    }

    public void delete(Long id){
        if(!gameRepository.existsById(id)){
            throw new EntityNotFoundException("Game não encontrado com ID: " + id);
        }
        gameRepository.deleteById(id);
    }

}