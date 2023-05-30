package medical.solucoes.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    //USERS ESTÁTICOS EM MEMÓRIA ENQUANTO NÃO INTEGRAMOS COM O BD
    public static Usuario user1;
    public static Usuario user2;
    public static Usuario user3;
    public static Usuario user4;
    
    public static List<Usuario> usuariosEstaticos = new ArrayList<>();
    
    static{
        user1 = new Usuario("Lorenzo", "lorenzo@univates.com.br", "LORENZO", "123456");
        user1.codUsuario = 1l;
        
        user2 = new Usuario("Carlos", "carlos@univates.com.br", "CARLOS", "654321");
        user2.codUsuario = 2l;
        
        user3 = new Usuario("Fabricio", "fabricio@univates.com.br", "FABRICIO", "999999");
        user3.codUsuario = 3l;
        
        user4 = new Usuario("ADMIN", "admin@admin.com", "ADMIN", "ADMIN");
        user4.codUsuario = 4l;
        
        usuariosEstaticos.add(user1);
        usuariosEstaticos.add(user2);
        usuariosEstaticos.add(user3);
        usuariosEstaticos.add(user4);
    }
    
    private Long codUsuario;
    
    private String nome;
    
    private String email;
    
    private String login;
    
    private String senha;
    
    public Usuario(String nome, String email, String login, String senha){
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }
    
    public Long getCodUsuario() {
        return codUsuario;
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
    
}
