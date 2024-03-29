package com.rev.xml.parsing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParsing {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		/*
		 * DocumentBuilderFactory
		 * DocumentBuilder
		 * Document -- represents our XML tree
		 */
		File xmlfile = new File("src/com/rev/xml/sample.xml");
		DocumentBuilderFactory dbf = 
				DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.parse(xmlfile);
		document.normalize(); // good practice here
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		
		// get root node name
		String root = document.getDocumentElement().getNodeName();
		
		NodeList people = document.getElementsByTagName("person");
		for(int i=0; i<people.getLength(); i++){
			// ***** grab leaves ***** //
			NodeList leaves = people.item(i).getChildNodes();
			for(int x=0; x<leaves.getLength(); x++){
				if(leaves.item(x).getNodeType() 
						== Node.ELEMENT_NODE){
					System.out.println(leaves.item(x)
							.getTextContent());
				}
			}
			
			System.out.println("NEXT BRANCH...");
		}

		
	}

	public static InputStream getFileInClasspath(String filename){
		return DOMParsing.class.getClassLoader().
			getResourceAsStream(filename);
	}

	
	
}
