package br.com.uniftec.fteclistview.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by marioklein on 26/10/17.
 */

public class PopularResponse {

    @JsonProperty("page")
    private int pagina;
    @JsonProperty("total_results")
    private int totalResultados;
    @JsonProperty("total_pages")
    private int totalPaginas;
    @JsonProperty("results")
    private List<Filme> filmes;

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTotalResultados() {
        return totalResultados;
    }

    public void setTotalResultados(int totalResultados) {
        this.totalResultados = totalResultados;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }
}
