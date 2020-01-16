package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.handlers.ProdutosHandler;

public class LerXmlComSax {

	public static void main(String[] args) throws Exception {
		// Criando um XMLReader atraves da XMLReaderFactory
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		ProdutosHandler logica = new ProdutosHandler();
		// executando logica da class LeitorXML usando o conteudo do XML
		leitor.setContentHandler(logica);
		InputStream inputStream =  new FileInputStream("src/vendas.xml");
		InputSource inputSource = new InputSource(inputStream);
		//lendo arquivo XML
		leitor.parse(inputSource);
		
		logica.getProdutos().forEach(s -> System.out.println(s.getAll()));
		

	}

}
