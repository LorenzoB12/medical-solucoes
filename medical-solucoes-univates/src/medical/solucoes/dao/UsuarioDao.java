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
        return false;
    }

    public boolean atualizar(Usuario usuario) {
        return false;
    }

    public boolean excluir(Usuario usuario) {
        return false;
    }

    public ArrayList<Usuario> listar() {
        return null;
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
