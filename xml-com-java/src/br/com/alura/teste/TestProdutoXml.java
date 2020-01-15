package br.com.alura.teste;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.bean.Produto;

public class TestProdutoXml {
	private List<Produto> listaProdutos;
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		
		
		try {
			DocumentBuilder newDocumentBuilder = fabrica.newDocumentBuilder();
			Document document = newDocumentBuilder.parse("src/vendas.xml");
			NodeList produtos = document.getElementsByTagName("produto");
			
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
