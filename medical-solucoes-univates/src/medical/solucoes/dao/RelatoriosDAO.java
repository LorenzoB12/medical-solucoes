package medical.solucoes.dao;

import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import medical.solucoes.beans.BeanConsultasEspecialidadeGenero;
import medical.solucoes.beans.BeanConsultasEspecialidades;
import medical.solucoes.beans.BeanRelatorioConsultasMedicos;
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

    public ArrayList<BeanRelatorioConsultasMedicos> listarConsultasPorMedico(String nome, Integer especialidade, Integer id) {
        ArrayList<BeanRelatorioConsultasMedicos> consultas = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT c.id as id, c.dth_consulta as dataConsulta, p.nome as nomePaciente, p.cpf as cpf, d.nome as nomeMedico, "
                    + "e.descricao as especialidade "
                    + "FROM consultas c "
                    + "INNER JOIN pacientes p ON p.id = c.id_paciente "
                    + "INNER JOIN doctors d ON d.id = c.id_doctor "
                    + "INNER JOIN especialidades e ON e.id = d.especialidades_id "
                    + "WHERE 1=1 ";

            if (nome != null && !nome.trim().isEmpty()) {
                sql += "AND (d.nome LIKE '%" + nome.toLowerCase() + "%' OR d.nome LIKE '%" + nome.toUpperCase() + "%') ";
            }

            if (especialidade != null && especialidade > 0) {
                sql += "AND e.id = " + especialidade + " ";
            }

            if (id != null && id > 0) {
                sql += "AND c.id = " + id;
            }

            ResultSet retorno = st.executeQuery(sql);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            while (retorno.next()) {
                Date data = format.parse(retorno.getString("dataConsulta"));
                String dataConsulta = format2.format(data);

                BeanRelatorioConsultasMedicos bean = new BeanRelatorioConsultasMedicos();
                bean.setDataConsulta(dataConsulta);
                bean.setNomeDoutor(retorno.getString("nomeMedico"));
                bean.setNomePaciente(retorno.getString("nomePaciente"));
                bean.setId(retorno.getInt("id"));
                bean.setCpf(retorno.getString("cpf"));
                bean.setEspecialidade(retorno.getString("especialidade"));

                consultas.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public ArrayList<BeanConsultasEspecialidadeGenero> listarConsultasEspecialidadeGeneros() {
        ArrayList<BeanConsultasEspecialidadeGenero> consultas = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT p.genero as genero, COUNT(c.id) as numeroConsultas, e.descricao AS especialidade FROM consultas c \n"
                    + "INNER JOIN pacientes p ON p.id = c.id_paciente\n"
                    + "INNER JOIN doctors d ON d.id = c.id_doctor\n"
                    + "INNER JOIN especialidades e ON d.especialidades_id = e.id\n"
                    + "GROUP BY p.genero, e.id\n"
                    + "ORDER BY e.descricao";

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                BeanConsultasEspecialidadeGenero bean = new BeanConsultasEspecialidadeGenero();
                bean.setEspecialidade(retorno.getString("especialidade"));
                bean.setGenero(retorno.getString("genero"));
                bean.setNumeroConsultas(retorno.getInt("numeroConsultas"));
                consultas.add(bean);
            }
            return consultas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public ArrayList<BeanConsultasEspecialidades> listarConsultasEspecialidades() {
        ArrayList<BeanConsultasEspecialidades> consultas = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT e.descricao as especialidade, COUNT(c.id) AS numeroConsultas FROM consultas c\n"
                    + "INNER JOIN doctors d ON d.id = c.id_doctor\n"
                    + "INNER JOIN especialidades e ON e.id = d.especialidades_id\n"
                    + "GROUP BY e.id\n"
                    + "ORDER BY numeroConsultas DESC";

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                BeanConsultasEspecialidades bean = new BeanConsultasEspecialidades();
                bean.setEspecialidadeDescricao(retorno.getString("especialidade"));
                bean.setNumeroConsultas(retorno.getInt("numeroConsultas"));
                consultas.add(bean);
            }
            return consultas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public HashMap<String, Integer> getPacientesGenero() {
        HashMap<String, Integer> dados = new HashMap<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT COUNT(*) AS quantidade,\n"
                    + "p.genero AS genero\n"
                    + "FROM pacientes p\n"
                    + "GROUP BY p.genero";

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                dados.put(retorno.getString("genero"), retorno.getInt("quantidade"));
            }
            return dados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados;
    }

    public HashMap<String, Integer> getStatusPacientes() {
        HashMap<String, Integer> dados = new HashMap<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT COUNT(*) as quantidade, p.ativo as ativo FROM pacientes p \n"
                    + "GROUP BY p.ativo";

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                dados.put(retorno.getString("ativo"), retorno.getInt("quantidade"));
            }
            return dados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados;
    }

    public HashMap<String, Integer> getConsultasGenero() {
        HashMap<String, Integer> dados = new HashMap<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT p.genero as genero, COUNT(c.id) as numeroConsultas FROM consultas c \n"
                    + "INNER JOIN pacientes p ON p.id = c.id_paciente\n"
                    + "GROUP BY p.genero";

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                dados.put(retorno.getString("genero"), retorno.getInt("numeroConsultas"));
            }
            return dados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados;
    }

}
