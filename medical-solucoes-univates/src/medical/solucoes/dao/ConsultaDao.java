/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.dao;

import conexao.ConexaoBD;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import medical.solucoes.model.Consulta;
import medical.solucoes.model.Doctor;
import medical.solucoes.model.Paciente;
import medical.utilitarios.ParseTimestamp;

/**
 *
 * @author loren
 */
public class ConsultaDao {

    public boolean salvar(Consulta c) {
        try {
            if(validaConsulta(c)){
                String sql = "INSERT INTO CONSULTAS (dth_consulta, id_paciente, id_doctor) VALUES (?, ?, ?)";
                PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);

                Integer dia = Integer.parseInt(c.getDthConsulta().split("/")[0]);
                Integer mes = Integer.parseInt(c.getDthConsulta().split("/")[1]);
                Integer ano = Integer.parseInt(c.getDthConsulta().split("/")[2].split(" ")[0]);
                Integer hora = Integer.parseInt(c.getDthConsulta().split(" ")[1].split(":")[0]);
                Integer minuto = Integer.parseInt(c.getDthConsulta().split(" ")[1].split(":")[1]);
                LocalDateTime localDate = LocalDateTime.of(ano, mes, dia, hora, minuto);
                Timestamp dthConsulta = Timestamp.valueOf(localDate);

                pstm.setTimestamp(1, dthConsulta);
                pstm.setLong(2, c.getPaciente().getId());
                pstm.setLong(3, c.getDoctor().getId());

                pstm.execute();
                return true;
            } else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Consulta> listar() {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM consultas ORDER BY DTH_CONSULTA ASC";
            ResultSet retorno = st.executeQuery(sql);

            Consulta consultaObj = null;
            while (retorno.next()) {
                consultaObj = new Consulta();
                consultaObj.setId(retorno.getLong("id"));
                consultaObj.setDthConsulta(retorno.getTimestamp("dth_consulta").toString());
                
                Paciente paciente = new PacienteDao().consultarId(retorno.getLong("id_paciente"));
                consultaObj.setPaciente(paciente);
                
                Doctor doctor = new DoctorDao().buscar((int) retorno.getLong("id_doctor"));
                consultaObj.setDoctor(doctor);
                
                consultas.add(consultaObj);
            }

            return consultas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }
    
    public ArrayList<Consulta> listarPorData(String dataIni, String dataFim) {
        ArrayList<Consulta> consultas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CONSULTAS WHERE DTH_CONSULTA BETWEEN ? AND ?;";
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            
            Timestamp dataInicial = ParseTimestamp.parse(dataIni);
            Timestamp dataFinal = ParseTimestamp.parse(dataFim);
            
            pstm.setTimestamp(1, dataInicial);
            pstm.setTimestamp(2, dataFinal);
            ResultSet retorno = pstm.executeQuery();

            Consulta consultaObj = null;
            while (retorno.next()) {
                consultaObj = new Consulta();
                consultaObj.setId(retorno.getLong("id"));
                consultaObj.setDthConsulta(retorno.getTimestamp("dth_consulta").toString());
                
                Paciente paciente = new PacienteDao().consultarId(retorno.getLong("id_paciente"));
                consultaObj.setPaciente(paciente);
                
                Doctor doctor = new DoctorDao().buscar((int) retorno.getLong("id_doctor"));
                consultaObj.setDoctor(doctor);
                
                consultas.add(consultaObj);
            }

            return consultas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }
    
    private Boolean validaConsulta(Consulta c) {
        
        ArrayList<Consulta> consultas = new ArrayList<>();
        
        try {
            Integer dia = Integer.parseInt(c.getDthConsulta().split("/")[0]);
            Integer mes = Integer.parseInt(c.getDthConsulta().split("/")[1]);
            Integer ano = Integer.parseInt(c.getDthConsulta().split("/")[2].split(" ")[0]);
            Integer hora = Integer.parseInt(c.getDthConsulta().split(" ")[1].split(":")[0]);
            Integer minuto = Integer.parseInt(c.getDthConsulta().split(" ")[1].split(":")[1]);
            LocalDateTime localDate = LocalDateTime.of(ano, mes, dia, hora, minuto);
            LocalDateTime dtaInicial = localDate.minusMinutes(59l);
            Timestamp dtaInicialSql = Timestamp.valueOf(dtaInicial);
            LocalDateTime dtaFinal = localDate.plusMinutes(59l);
            Timestamp dtaFinalSql = Timestamp.valueOf(dtaFinal);
            
            String sql = "SELECT * FROM CONSULTAS WHERE DTH_CONSULTA BETWEEN ? AND ? AND (ID_PACIENTE = ? OR ID_DOCTOR = ?)";
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);
            pstm.setTimestamp(1, dtaInicialSql);
            pstm.setTimestamp(2, dtaFinalSql);
            pstm.setLong(3, c.getPaciente().getId());
            pstm.setLong(4,c.getDoctor().getId());
            ResultSet retorno = pstm.executeQuery();

            Consulta consultaObj = null;
            while (retorno.next()) {
                consultaObj = new Consulta();
                consultaObj.setId(retorno.getLong("id"));
                consultaObj.setDthConsulta(retorno.getTimestamp("dth_consulta").toString());
                
                Paciente paciente = new PacienteDao().consultarId(retorno.getLong("id_paciente"));
                consultaObj.setPaciente(paciente);
                
                Doctor doctor = new DoctorDao().buscar((int) retorno.getLong("id_doctor"));
                consultaObj.setDoctor(doctor);
                
                consultas.add(consultaObj);
            }

            if(consultas.size() > 0){
                return Boolean.FALSE;
            } else{
                return Boolean.TRUE;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
}
