package medical.solucoes.model;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
     
    
    private int id;
    
    private String nome;
    
    private String crm;
    
    private Especialidade especializacao;
    
    private boolean ativo;

    public Doctor(int id,String nome, String crm, Especialidade especializacao) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.especializacao = especializacao;
    }

    public Doctor() {
        this.nome = "";
        this.crm = "";
        this.especializacao = new Especialidade();
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especialidade especializacao) {
        this.especializacao = especializacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    

    
    
}
