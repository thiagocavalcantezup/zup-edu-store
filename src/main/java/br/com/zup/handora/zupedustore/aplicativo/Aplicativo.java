package br.com.zup.handora.zupedustore.aplicativo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "aplicativos")
public class Aplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, columnDefinition = "text")
    @Lob
    private String descricao;

    @Column(nullable = false)
    private String link;

    @OneToOne(mappedBy = "aplicativo", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeDownloadsAplicativo quantidadeDownloads;

    @OneToOne(mappedBy = "aplicativo", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeLikesAplicativo quantidadeLikes;

    @Version
    private int versao;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Aplicativo() {}

    public Aplicativo(String nome, String descricao, String link,
                      QuantidadeDownloadsAplicativo quantidadeDownloads,
                      QuantidadeLikesAplicativo quantidadeLikes) {
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
        this.quantidadeDownloads = new QuantidadeDownloadsAplicativo(this);
        this.quantidadeLikes = new QuantidadeLikesAplicativo(this);
    }

    public void incrementarDownloads() {
        quantidadeDownloads.incrementar();
    }

    public void incrementarLikes() {
        quantidadeLikes.incrementar();
    }

    public Long getId() {
        return id;
    }

}
