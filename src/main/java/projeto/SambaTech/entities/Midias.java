package projeto.SambaTech.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "midias" )
public class Midias implements Serializable {

    private static final long serialVersionUID = 3960436649365666213L;

    private Long id;
    private String nome;
    private String url;
    private Long duracao;
    private Date dataUpload;
    private String deletadoMidias;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Nome", nullable = false, length = 512)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "URL", length = 512)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "Duracao")
    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Data_de_Upload", nullable = false)
    public Date getDataUpload() {
        return this.dataUpload;
    }

    public void setDataUpload(Date dataUpload) {
        this.dataUpload = dataUpload;
    }

    @Column(name = "deleted", nullable = false)
    public String getDeletadoMidias() {
        return deletadoMidias;
    }

    public void setDeletadoMidias(String deletadoMidias) {
        this.deletadoMidias = deletadoMidias;
    }
}

