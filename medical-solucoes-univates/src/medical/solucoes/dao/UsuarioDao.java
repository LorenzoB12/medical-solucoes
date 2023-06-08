package medical.solucoes.dao;

import at.favre.lib.crypto.bcrypt.BCrypt;
import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import medical.solucoes.model.Usuario;

/**
 *
 * @author loren
 */
public class UsuarioDao {

    public boolean salvar(Usuario usuario) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO usuarios (nome, email, login, senha, ativo) VALUES (";
            sql += " '" + usuario.getNome() + "', ";
            sql += " '" + usuario.getEmail() + "', ";
            sql += " '" + usuario.getLogin() + "', ";
            sql += " '" + usuario.getSenha() + "', ";
            sql += " " + usuario.isAtivo() + ") ";

            st.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Usuario usuario) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuarios SET ";
            sql += " nome = '" + usuario.getNome() + "', ";
            sql += " email = '" + usuario.getEmail() + "', ";
            sql += " login = '" + usuario.getLogin() + "', ";
            sql += " senha = '" + usuario.getSenha() + "', ";
            sql += " ativo = " + usuario.isAtivo() + " WHERE id = " + usuario.getId();

            st.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(Usuario usuario) {
        return false;
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * FROM usuarios ORDER BY id ASC";
            ResultSet retorno = st.executeQuery(sql);

            Usuario usuarioObj = null;
            while (retorno.next()) {
                usuarioObj = new Usuario();
                usuarioObj.setId(retorno.getLong("id"));
                usuarioObj.setNome(retorno.getString("nome"));
                usuarioObj.setEmail(retorno.getString("email"));
                usuarioObj.setLogin(retorno.getString("login"));
                usuarioObj.setSenha(retorno.getString("senha"));
                usuarioObj.setAtivo(retorno.getBoolean("ativo"));
               
                usuarios.add(usuarioObj);
            }

            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario getByLogin(String login) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            login = login.toLowerCase();

            String sql = "SELECT * FROM usuarios WHERE login = '" + login + "' AND ativo = true LIMIT 1";
            ResultSet retorno = st.executeQuery(sql);

            Usuario usuarioObj = null;
            while (retorno.next()) {
                usuarioObj = new Usuario();
                usuarioObj.setId(retorno.getLong("id"));
                usuarioObj.setNome(retorno.getString("nome"));
                usuarioObj.setEmail(retorno.getString("email"));
                usuarioObj.setLogin(retorno.getString("login"));
                usuarioObj.setSenha(retorno.getString("senha"));
                usuarioObj.setAtivo(retorno.getBoolean("ativo"));
                break;
            }

            return usuarioObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean doLogin(String senha, String senhaBanco) {
        BCrypt.Verifyer verifyer = BCrypt.verifyer();
        BCrypt.Result check = verifyer.verify(senha.toCharArray(), senhaBanco);
        return check.verified;
    }

}
