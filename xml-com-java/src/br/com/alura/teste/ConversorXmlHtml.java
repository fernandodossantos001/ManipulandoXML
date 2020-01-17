package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConversorXmlHtml {

	public static void main(String[] args) {
		try {
			InputStream xsl = new FileInputStream("src/xmlParaHtml.xsl");
			StreamSource xslSource = new StreamSource(xsl); 
			
			InputStream xml = new FileInputStream("src/vendas.xml");
			StreamSource xmlSource = new StreamSource(xml); 
			Transformer parse = TransformerFactory.newInstance().newTransformer(xslSource);
			StreamResult output = new StreamResult("src/vendas.html");
			parse.transform(xmlSource, output);
			
			    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
