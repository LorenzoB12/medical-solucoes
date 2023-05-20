package medical.solucoes.model;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    
    //USERS ESTÁTICOS EM MEMÓRIA ENQUANTO NÃO INTEGRAMOS COM O BD
    public static Doctor doc1;
    public static Doctor doc2;
    public static Doctor doc3;
    
    public static List<Doctor> doutoresEstaticos = new ArrayList<>();
    
    static{
        doc1 = new Doctor("Pedro", "111.222.333", "Cirurgia");
        doc1.codDoc = 1l;
        
        doc2 = new Doctor("Marcos", "444.555.666", "Cardiologista");
        doc2.codDoc = 2l;
        
        doc3 = new Doctor("João", "777.888.999", "Obstetra");
        doc3.codDoc = 3l;
    }
    
    private Long codDoc;
    
    private String nome;
    
    private String crm;
    
    private String especializacao;

    public Doctor(String nome, String crm, String especializacao) {
        this.nome = nome;
        this.crm = crm;
        this.especializacao = especializacao;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(Long codDoc) {
        this.codDoc = codDoc;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    
    
}
