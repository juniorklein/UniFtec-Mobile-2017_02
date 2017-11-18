package br.com.uniftec.fteclistview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by marioklein on 16/11/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioResponse {

    private String cpf;
    private String email;
    private String nome;
    private String senha;
    private String telefone;
    private Long id;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
