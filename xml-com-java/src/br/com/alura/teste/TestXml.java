package br.com.alura.teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TestXml {

	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder newDocumentBuilder;
		try {
			newDocumentBuilder = fabrica.newDocumentBuilder();
			Document document = newDocumentBuilder.parse("src/vendas.xml");
			
			NodeList formasDePagamentos = document.getElementsByTagName("FormaDePagamento");
			
			Element element = (Element)formasDePagamentos.item(0);
			
			String textContent = element.getTextContent();
			
			System.out.println("Forma de Pagamento: "+textContent);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
