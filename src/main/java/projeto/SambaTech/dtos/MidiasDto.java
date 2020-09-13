package projeto.SambaTech.dtos;
import java.util.Date;

public class MidiasDto {

    private Long id;
    private String nome;
    private String url;
    private Long duracao;
    private Date dataUpload;
    private Boolean delete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    public Date getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(Date dataUpload) {
        this.dataUpload = dataUpload;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "MidiasDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", url='" + url + '\'' +
                ", duracao=" + duracao +
                ", dataUpload=" + dataUpload +
                ", delete=" + delete +
                '}';
    }
}
