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
import com.cefet.dslist.dto.GameDTO;
import com.cefet.dslist.services.GameService;

@RestController
@RequestMapping("/games")

public class GameController {

    @Autowired
    private GameService gameService;

   @GetMapping("/{id}")
   public ResponseEntity <GameDTO> findById(@PathVariable Long id){
      GameDTO dto = gameService.findById(id);
      return ResponseEntity.ok(dto);
   }

   @GetMapping
   public ResponseEntity <List<GameDTO>> findAll(){
      List<GameDTO> dto = gameService.findAll();
      return ResponseEntity.ok(dto);
   }


   @PostMapping
	public ResponseEntity<GameDTO> create(@RequestBody GameDTO dto) {
		GameDTO novoDTO = gameService.insert(dto);
		return ResponseEntity.status(201).body(novoDTO); 
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<GameDTO> update(@PathVariable Long id, @RequestBody GameDTO dto) {
		GameDTO salvoDTO = gameService.update(id, dto);
		return ResponseEntity.ok(salvoDTO); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		gameService.delete(id);
		return ResponseEntity.noContent().build(); 
	}	


}