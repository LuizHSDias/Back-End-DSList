package com.cefet.dslist.dto;

import com.cefet.dslist.entities.Game;

public class GameDTO {

    private Long id;
    private String titulo;
    private Integer ano;
    private String genero;
    private String plataforma;
    private Double score;
    private String imgUrl;
    private String curtaDescricao;
    private String longaDescricao;

    public GameDTO() {

    }

    public GameDTO(Game game) {
        this.id = game.getId();
        this.titulo = game.getTitulo();
        this.ano = game.getAno();
        this.genero = game.getGenero();
        this.plataforma = game.getPlataforma();
        this.score = game.getScore();
        this.imgUrl = game.getImgUrl();
        this.curtaDescricao = game.getCurtaDescricao();
        this.longaDescricao = game.getLongaDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public Double getScore() {
        return score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getCurtaDescricao() {
        return curtaDescricao;
    }

    public String getLongaDescricao() {
        return longaDescricao;
    }

    

    
}
