package com.algaworks.brewer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.algaworks.brewer.validation.SKU;

@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@SKU
	@NotBlank(message="SKU é obrigatório!")
	private String sku;
	
	@NotBlank(message="NOME é obrigatório!")
	private String nome;
	
	@Size(min=5, max = 200, message="DESCRIÇÃO deve ter entre 5 e 200 caracteres!")
	private String descricao;
	
	@NotNull(message="O Valor é obrigatório!")
	@DecimalMin(value="0.50", message="O Valor da cerveja deve ser maior que R$ 0,50!")
	@DecimalMax(value="999999.99", message="O Valor da cerveja deve ser menor que R$ 999.999,99")
	private BigDecimal valor;
	
	@NotNull(message="O Teor alcóolico é obrigatório!")
	@DecimalMax(value="100.0", message="O Teor alcóolico deve ser menor que 100%!")
	@Column(name="teor_alcoolico")
	private BigDecimal teorAlcoolico;
	
	
	@NotNull(message = "A Comissão é obrigatória!")
	@DecimalMax(value="100.0", message="A Comissão deve ser menor ou igual a 100%!")
	private BigDecimal comissao;
	
	@NotNull(message = "O Estoque é obrigatório!")
	@Max(value=9999, message="A Quantidade em estoque deve ser menor que 9999!")
	@Column(name="quantidade_estoque")
	private Integer quantidadeEstoque;
	
	@NotNull(message = "A Origem é obrigatória!")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull(message = "O Sabor é obrigatório!")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	@NotNull(message = "O Estilo é obrigatório!")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;

	//callback jpa
	@PrePersist @PreUpdate
	private void prePersistUpdate(){
		sku = sku.toUpperCase();
	}
	
	private String foto;
	
	@Column(name="content_type")
	private String contentType;
	
	//getters and setters entidade
	
	
	
	public String getSku() {
		return sku;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	

}
