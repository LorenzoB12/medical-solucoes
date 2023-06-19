/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.model;

import java.time.LocalDateTime;

/**
 *
 * @author loren
 */
public class Consulta {
    
    private Long id;
    
    private String dthConsulta;
    
    private Paciente paciente;
    
    private Doctor doctor;

    public Consulta(Long id, String dthConsulta, Paciente paciente, Doctor doctor) {
        this.id = id;
        this.dthConsulta = dthConsulta;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    public Consulta(){}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDthConsulta() {
        return dthConsulta;
    }

    public void setDthConsulta(String dthConsulta) {
        this.dthConsulta = dthConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
   
}
