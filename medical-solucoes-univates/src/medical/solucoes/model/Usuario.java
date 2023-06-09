package medical.solucoes.model;

import at.favre.lib.crypto.bcrypt.BCrypt;
import medical.solucoes.dao.UsuarioDao;

public class Usuario {

    private Long id;

    private String nome;

    private String email;

    private String login;

    private String senha;

    private boolean ativo;

    public Usuario() {
    }

    public Usuario(String nome, String email, String login, String senha, boolean isAtivo) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = this.criptografarSenha(senha);
        this.ativo = isAtivo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    private String criptografarSenha(String senha) {
        BCrypt.Hasher hasher = BCrypt.withDefaults();
        return hasher.hashToString(10, senha.toCharArray());
    }

}
