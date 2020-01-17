package br.com.alura.teste;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.alura.bean.Produto;
import br.com.alura.bean.Venda;

public class MapeaXMLDireto {

	public static void main(String[] args) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Venda.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Venda vendas = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
			
			System.out.println(vendas.getAll());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void objetoParaXml(JAXBContext jaxbContext) throws Exception {
	    Marshaller marshaller = jaxbContext.createMarshaller();
	    Venda venda = new Venda();
	    venda.setFormaDePagamento("Crediario");
	    List<Produto> produtos = new ArrayList<>();
	    produtos.add(new Produto("Livro de java", 59.90));
	    produtos.add(new Produto("Livro de  xml", 59.90));
	    produtos.add(new Produto("Livro de O.O.", 59.90));
	    venda.setProdutos(produtos);
	    StringWriter writer = new StringWriter();

	    marshaller.marshal(venda, writer);
	    System.out.println(writer.toString());

	}
}
