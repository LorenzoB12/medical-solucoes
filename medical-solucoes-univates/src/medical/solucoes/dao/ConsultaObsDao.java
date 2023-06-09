/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.dao;

import conexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import medical.solucoes.model.Consulta;
import medical.solucoes.model.ConsultaObs;
import medical.solucoes.model.Doctor;
import medical.solucoes.model.Paciente;

/**
 *
 * @author loren
 */
public class ConsultaObsDao {

    public boolean salvar(ConsultaObs c) {
        try {
            String sql = "INSERT INTO CONSULTAS_OBS (DES_SINTOMAS, DES_TRATAMENTO, DES_OBSERVACOES, ID_CONSULTA) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);

            pstm.setString(1, c.getDesSintomas());
            pstm.setString(2, c.getDesTratamento());
            pstm.setString(3, c.getDesObservacoes());
            pstm.setLong(4, c.getConsulta().getId());

            pstm.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(ConsultaObs c) {
        try {
            String sql = "UPDATE CONSULTAS_OBS SET DES_SINTOMAS = ?, DES_TRATAMENTO = ?, "
                    + "DES_OBSERVACOES = ?, ID_CONSULTA = ? WHERE id = ?";
            PreparedStatement pstm = ConexaoBD.getInstance().getConnection().prepareStatement(sql);

            pstm.setString(1, c.getDesSintomas());
            pstm.setString(2, c.getDesTratamento());
            pstm.setString(3, c.getDesObservacoes());
            pstm.setLong(4, c.getConsulta().getId());
            pstm.setLong(5, c.getId());

            pstm.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ConsultaObs getByConsulta(Consulta consulta){
        try{
            String sql = "SELECT * FROM CONSULTAS_OBS WHERE ID_CONSULTA = " + consulta.getId();
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                ConsultaObs consultaObs = new ConsultaObs();
                consultaObs.setId(retorno.getLong("id"));
                consultaObs.setDesSintomas(retorno.getString("des_sintomas"));
                consultaObs.setDesTratamento(retorno.getString("des_tratamento"));
                consultaObs.setDesObservacoes(retorno.getString("des_observacoes"));
                consultaObs.setConsulta(consulta);
                
                return consultaObs;
            }
            
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ConsultaObs> listar() {
        ArrayList<ConsultaObs> consultas = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM CONSULTAS_OBS ORDER BY ID_CONSULTA ASC";
            ResultSet retorno = st.executeQuery(sql);

            ConsultaObs consultaObsObj = null;
            while (retorno.next()) {
                consultaObsObj = new ConsultaObs();
                consultaObsObj.setId(retorno.getLong("id"));
                consultaObsObj.setDesSintomas(retorno.getString(2));
                consultaObsObj.setDesTratamento(retorno.getString(3));
                consultaObsObj.setDesObservacoes(retorno.getString(4));
                consultaObsObj.setConsulta(new Consulta(retorno.getLong(5), null, null, null));

                consultas.add(consultaObsObj);
            }

            return consultas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }

}
