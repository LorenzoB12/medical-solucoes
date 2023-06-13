/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loren
 */
public class Paciente {
    
    private Long id;
    
    private Boolean indAtivo;
    
    private String nome;
    
    private String cpf;
    
    private String dataNascimento;
    
    private String telefone;
    
    private String genero;
    
    public Paciente(Long id, String nome, String cpf, String dataNascimento, String telefone, String genero) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.genero = genero;
        this.indAtivo = Boolean.TRUE;
    }
    
    public Paciente(){};
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public Boolean getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(Boolean indAtivo) {
        this.indAtivo = indAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
