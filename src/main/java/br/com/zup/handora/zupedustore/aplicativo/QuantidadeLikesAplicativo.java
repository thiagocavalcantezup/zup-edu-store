package br.com.zup.handora.zupedustore.aplicativo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "quantidades_likes_aplicativo")
public class QuantidadeLikesAplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantidade;

    @OneToOne(optional = false)
    private Aplicativo aplicativo;

    @Version
    private int versao;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public QuantidadeLikesAplicativo() {}

    public QuantidadeLikesAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
        this.quantidade = 0;
    }

    public void incrementar() {
        quantidade++;
    }

    public Long getId() {
        return id;
    }

}
