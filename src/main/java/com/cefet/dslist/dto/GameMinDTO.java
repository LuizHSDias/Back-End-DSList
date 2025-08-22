package com.cefet.dslist.dto;

import com.cefet.dslist.entities.Game;
import com.cefet.dslist.projections.GameMinProjection;

public class GameMinDTO {
    private Long id;
    private String titulo;
    private Integer ano; 
    private String imgUrl;
    private String curtaDescricao;

    public GameMinDTO() {

    }

    public GameMinDTO(Game game) {
        this.id = game.getId();
        this.titulo = game.getTitulo();
        this.ano = game.getAno();
        this.imgUrl = game.getImgUrl();
        this.curtaDescricao = game.getCurtaDescricao();
    }

    public GameMinDTO(GameMinProjection projection) {
        this.id = projection.getId();
        this.titulo = projection.getTitulo();
        this.ano = projection.getAno();
        this.imgUrl = projection.getImgUrl();
        this.curtaDescricao = projection.getCurtaDescricao();
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

    public String getImgUrl() {
        return imgUrl;
    }

    public String getCurtaDescricao() {
        return curtaDescricao;
    }

}