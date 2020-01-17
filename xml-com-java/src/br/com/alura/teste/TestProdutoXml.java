package br.com.alura.teste;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.bean.Produto;

public class TestProdutoXml {
	private List<Produto> listaProdutos;
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		//validando documentos  XML
		fabrica.setValidating(true);
		// pegar arquivo de valida��o pelo name space
		fabrica.setNamespaceAware(true);
		// set a linguagem que estamos usando para o nosso schema
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		//buscando
		
		try {
			//DocumentBuilder carrega o XML na mem�ria da VM, c�digo mais simples, por�m consome mais recursos
			DocumentBuilder newDocumentBuilder = fabrica.newDocumentBuilder();
			Document document = newDocumentBuilder.parse("src/vendas.xml");
			NodeList produtos = document.getElementsByTagName("produto");
			
			Element venda = document.getDocumentElement();
			String moeda = venda.getAttribute("moeda");
			
			System.out.println(moeda);
			String exp = "/venda/produtos/produto[nome='Livro de O.O objetos']";
//			String exp = "/venda/produtos/produto[contains(nome, 'Livro')]";
//			String exp = "/venda/produtos/produto";
			XPath path = XPathFactory.newInstance().newXPath();
			XPathExpression expression = path.compile(exp);
			
			NodeList produt = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
			
			for (int i = 0; i < produt.getLength(); i++) {
				Element itemProd = (Element) produt.item(i);
				String nome = itemProd.getElementsByTagName("nome").item(0).getTextContent();
				Double preco = Double.parseDouble(itemProd.getElementsByTagName("preco").item(0).getTextContent());
				Produto produto =  new Produto(nome,preco);
				System.out.println(produto.getAll());
			}
			
			System.out.println("---------------------");
			
			for (int i = 0; i < produtos.getLength(); i++) {
				
				Element itemProd = (Element) produtos.item(i);
				String nome = itemProd.getElementsByTagName("nome").item(0).getTextContent();
				Double preco = Double.parseDouble(itemProd.getElementsByTagName("preco").item(0).getTextContent());
				Produto produto =  new Produto(nome,preco);
				System.out.println(produto.getAll());
//				System.out.println(produtos.item(i).getTextContent());
//				 Element produto = (Element)produtos.item(i);
//				 System.out.println(produto.getTextContent());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
