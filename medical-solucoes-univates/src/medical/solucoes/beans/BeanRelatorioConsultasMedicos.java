package medical.solucoes.beans;

/**
 *
 * @author Carlos
 */
public class BeanRelatorioConsultasMedicos {

    private String nomePaciente;
    private String nomeDoutor;
    private String dataConsulta;
    private String cpf;
    private String especialidade;
    private int id;

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeDoutor() {
        return nomeDoutor;
    }

    public void setNomeDoutor(String nomeDoutor) {
        this.nomeDoutor = nomeDoutor;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
