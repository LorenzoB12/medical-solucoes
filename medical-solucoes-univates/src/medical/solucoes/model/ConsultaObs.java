/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.model;

/**
 *
 * @author loren
 */
public class ConsultaObs {
    
    private Long id;
    
    private String desSintomas;
    
    private String desTratamento;
    
    private String desObservacoes;
    
    private Consulta consulta;

    public ConsultaObs(Long id, String desSintomas, String desTratamento, String desObservacoes, Consulta consulta) {
        this.id = id;
        this.desSintomas = desSintomas;
        this.desTratamento = desTratamento;
        this.desObservacoes = desObservacoes;
        this.consulta = consulta;
    }

    public ConsultaObs(String desSintomas, String desTratamento, String desObservacoes, Consulta consulta) {
        this.desSintomas = desSintomas;
        this.desTratamento = desTratamento;
        this.desObservacoes = desObservacoes;
        this.consulta = consulta;
    }

    public ConsultaObs(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesSintomas() {
        return desSintomas;
    }

    public void setDesSintomas(String desSintomas) {
        this.desSintomas = desSintomas;
    }

    public String getDesTratamento() {
        return desTratamento;
    }

    public void setDesTratamento(String desTratamento) {
        this.desTratamento = desTratamento;
    }

    public String getDesObservacoes() {
        return desObservacoes;
    }

    public void setDesObservacoes(String desObservacoes) {
        this.desObservacoes = desObservacoes;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
