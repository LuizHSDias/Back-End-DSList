package com.cefet.dslist.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private String plataforma;

    @Column(nullable = false)
    private Double score;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "curta_descricao", columnDefinition = "TEXT", nullable = false)
    private String curtaDescricao;

    @Column(name = "longa_descricao", columnDefinition = "TEXT", nullable = false)
    private String longaDescricao;

    public Game() {

    }

    public Game(Long id, String titulo, Integer ano, String genero, String plataforma, Double score, String imgUrl,
            String curtaDescricao, String longaDescricao) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.plataforma = plataforma;
        this.score = score;
        this.imgUrl = imgUrl;
        this.curtaDescricao = curtaDescricao;
        this.longaDescricao = longaDescricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCurtaDescricao() {
        return curtaDescricao;
    }

    public void setCurtaDescricao(String curtaDescricao) {
        this.curtaDescricao = curtaDescricao;
    }

    public String getLongaDescricao() {
        return longaDescricao;
    }

    public void setLongaDescricao(String longaDescricao) {
        this.longaDescricao = longaDescricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((ano == null) ? 0 : ano.hashCode());
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
        result = prime * result + ((score == null) ? 0 : score.hashCode());
        result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
        result = prime * result + ((curtaDescricao == null) ? 0 : curtaDescricao.hashCode());
        result = prime * result + ((longaDescricao == null) ? 0 : longaDescricao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (ano == null) {
            if (other.ano != null)
                return false;
        } else if (!ano.equals(other.ano))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        if (plataforma == null) {
            if (other.plataforma != null)
                return false;
        } else if (!plataforma.equals(other.plataforma))
            return false;
        if (score == null) {
            if (other.score != null)
                return false;
        } else if (!score.equals(other.score))
            return false;
        if (imgUrl == null) {
            if (other.imgUrl != null)
                return false;
        } else if (!imgUrl.equals(other.imgUrl))
            return false;
        if (curtaDescricao == null) {
            if (other.curtaDescricao != null)
                return false;
        } else if (!curtaDescricao.equals(other.curtaDescricao))
            return false;
        if (longaDescricao == null) {
            if (other.longaDescricao != null)
                return false;
        } else if (!longaDescricao.equals(other.longaDescricao))
            return false;
        return true;
    }

    

    
}