package br.com.alura.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.bean.Produto;
//classe responsável por pegar os eventos de um XMLReader
public class ProdutosHandler extends DefaultHandler{
	private List<Produto> produtos;
	private StringBuilder conteudo;
	private Produto produto;
	
	public ProdutosHandler() {
		produtos = new ArrayList<Produto>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("produto")) {
			produto = new Produto();
		}
		conteudo = new StringBuilder();
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
//		System.out.println(ch);
//		System.out.println(start);
//		System.out.println(length);
//		System.out.println(new String(ch,start,length));
		conteudo.append(new String(ch,start,length));
//		System.out.println(conteudo);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("produto")) {
			produtos.add(produto);
		}else if (qName.equals("nome")){
			produto.setNome(String.valueOf(conteudo.toString()));
		}else if(qName.equals("preco")) {
			produto.setValor(Double.parseDouble(conteudo.toString()));
		}
			
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public StringBuilder getConteudo() {
		return conteudo;
	}

	public void setConteudo(StringBuilder conteudo) {
		this.conteudo = conteudo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
