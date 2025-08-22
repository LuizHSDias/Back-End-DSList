package com.cefet.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cefet.dslist.dto.GameListDTO;
import com.cefet.dslist.dto.GameMinDTO;
import com.cefet.dslist.dto.ReplacementDTO;
import com.cefet.dslist.services.GameListService;
import com.cefet.dslist.services.GameService;

@RestController
@RequestMapping("/lists")

public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

   @GetMapping
   public ResponseEntity <List<GameListDTO>> findAll(){
      List<GameListDTO> dto = gameListService.findAll();
      return ResponseEntity.ok(dto);
   }

   @GetMapping("/{id}")
   public ResponseEntity <GameListDTO> findById(@PathVariable Long id){
      GameListDTO dto = gameListService.findById(id);
      return ResponseEntity.ok(dto);
   }

   @GetMapping("/{listId}/games")
   public ResponseEntity <List<GameMinDTO>> findByList(@PathVariable Long listId){
      List<GameMinDTO> dto = gameService.findByList(listId);
      return ResponseEntity.ok(dto);
   }

   @PostMapping(value = "/{listId}/replacement")
   public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
      gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());}

   @PostMapping
	public ResponseEntity<GameListDTO> create(@RequestBody GameListDTO dto) {
		GameListDTO novoDTO = gameListService.insert(dto);
		return ResponseEntity.status(201).body(novoDTO); 
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<GameListDTO> update(@PathVariable Long id, @RequestBody GameListDTO dto) {
		GameListDTO salvoDTO = gameListService.update(id, dto);
		return ResponseEntity.ok(salvoDTO); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		gameListService.delete(id);
		return ResponseEntity.noContent().build(); 
	}	




}