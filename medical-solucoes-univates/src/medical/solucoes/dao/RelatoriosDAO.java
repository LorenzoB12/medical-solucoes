package medical.solucoes.dao;

import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import medical.solucoes.beans.BeanRelatorioConsultasPaciente;

/**
 *
 * @author Carlos
 */
public class RelatoriosDAO {

    public ArrayList<BeanRelatorioConsultasPaciente> listarConsultasPorPaciente(String nome, String cpf, Integer id) {
        ArrayList<BeanRelatorioConsultasPaciente> consultas = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT c.id as id, c.dth_consulta as dataConsulta, p.nome as nomePaciente, p.cpf as cpf, d.nome as nomeMedico "
                    + "FROM consultas c "
                    + "INNER JOIN pacientes p ON p.id = c.id_paciente "
                    + "INNER JOIN doctors d ON d.id = c.id_doctor "
                    + "WHERE 1=1 ";

            if (nome != null && !nome.trim().isEmpty()) {
                sql += "AND (p.nome LIKE '%" + nome.toLowerCase() + "%' OR p.nome LIKE '%" + nome.toUpperCase() + "%') ";
            }

            if (cpf != null && !cpf.trim().isEmpty()) {
                sql += "AND p.cpf = '" + cpf + "' ";
            }

            if (id != null && id > 0) {
                sql += "AND c.id = " + id;
            }

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                Date data = format.parse(retorno.getString("dataConsulta"));
                String dataConsulta = format2.format(data);
                
                BeanRelatorioConsultasPaciente bean = new BeanRelatorioConsultasPaciente();
                bean.setDataConsulta(dataConsulta);
                bean.setNomeDoutor(retorno.getString("nomeMedico"));
                bean.setNomePaciente(retorno.getString("nomePaciente"));
                bean.setId(retorno.getInt("id"));
                bean.setCpf(retorno.getString("cpf"));

                consultas.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }

}
