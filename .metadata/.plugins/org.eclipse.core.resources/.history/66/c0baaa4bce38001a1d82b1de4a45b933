package br.com.alura.bean;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String formaDePagamento;
	
	@XmlElementWrapper(name="produtos")
	@XmlElement(name = "produto")
	private List<Produto> produtos;
	
	
	
	public Venda() {
		super();
	}
	public Venda(String formaDePagamento, List<Produto> produtos) {
		this.formaDePagamento = formaDePagamento;
		this.produtos = produtos;
	}
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String getAll() {
		return "Forma De Pagamento" + formaDePagamento + "\n"+
				"Produtos: " + produtos;
	}
	
	

}
