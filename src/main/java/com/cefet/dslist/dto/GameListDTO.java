package com.cefet.dslist.dto;


import com.cefet.dslist.entities.GameList;

public class GameListDTO {

    private Long id;
    private String nome;

    public GameListDTO() {

    }

    public GameListDTO(GameList gamelist) {
        this.id = gamelist.getId();
        this.nome = gamelist.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}