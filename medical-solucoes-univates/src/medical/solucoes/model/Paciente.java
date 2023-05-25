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

    //USERS ESTÁTICOS EM MEMÓRIA ENQUANTO NÃO INTEGRAMOS COM O BD
    public static Paciente p1;
    public static Paciente p2;
    public static Paciente p3;
    
    public static List<Paciente> pacientesEstaticos = new ArrayList<>();
    
    static{
        p1 = new Paciente(1l, "Matheus da Silva", "95959584847", "01/07/1995", "52999190347", "MASCULINO");
        
        p2 = new Paciente(2l, "Felipe Santos", "02145547448", "01/05/2000", "52998985574", "MASCULINO");
        
        p3 = new Paciente(3l, "Luis Pinheiro", "0215411475", "22/09/2001", "52919185457", "MASCULINO");
        
        pacientesEstaticos.add(p1);
        pacientesEstaticos.add(p2);
        pacientesEstaticos.add(p3);
    }
    
    public Paciente(Long id, String nome, String cpf, String dataNascimento, String telefone, String genero) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.genero = genero;
        this.indAtivo = Boolean.TRUE;
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
