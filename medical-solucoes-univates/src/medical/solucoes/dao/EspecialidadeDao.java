/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.solucoes.dao;

import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import medical.solucoes.model.Especialidade;

/**
 *
 * @author Carlos
 */
public class EspecialidadeDao {
    
    public boolean salvar(Especialidade especialidade){
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO especialidades (descricao) VALUES "
                    + "('" + especialidade.getDescricao().toUpperCase() + "')";
            st.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean atualizar(Especialidade especialidade){
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE especialidades SET "
                    + "descricao = '" + especialidade.getDescricao().toUpperCase() + "' "
                    + "WHERE id = " + especialidade.getId();

            st.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Especialidade> listar(){
        ArrayList<Especialidade> especialidades = new ArrayList<>();
        try{
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM especialidades ORDER BY id ASC";
            ResultSet retorno = st.executeQuery(sql);
            
            Especialidade especialidadeObj = null;
            while (retorno.next()) {
                especialidadeObj = new Especialidade();
                especialidadeObj.setId(retorno.getInt("id"));
                especialidadeObj.setDescricao(retorno.getString("descricao"));
               
                especialidades.add(especialidadeObj);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return especialidades;
    }
    
}
