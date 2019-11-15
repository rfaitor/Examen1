package iam46258177;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class XMLclass {
    public void EscriureXML(List<Elemento> llistaelemento){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "record", null);
            document.setXmlVersion("1.0");

            for(Elemento elemento: llistaelemento) {
                Element raiz = document.createElement("row"); //nodo empleado
                document.getDocumentElement().appendChild(raiz);
                CrearElemento("id",Integer.toString(elemento.getId()), raiz, document);
                CrearElemento("year",elemento.getYear(), raiz, document);
                CrearElemento("season",elemento.getSeason(), raiz, document);
                CrearElemento("thumb",elemento.getThumb(), raiz, document);

            }

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("data/out/Elementos.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            Result console= new StreamResult(System.out);
            transformer.transform(source, console);


        }catch(Exception e){System.err.println("Error: "+e);}
    }

    public void LlegirXml(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("data/out/Elementos.xml"));
            document.getDocumentElement().normalize();

            NodeList content = document.getElementsByTagName("row");

            for (int i = 0; i < content.getLength(); i++ ) {
                Node ar = content.item(i);

                if (ar.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) ar;

                    Elemento elemento = new Elemento(Integer.valueOf(getNodo("id",element)),getNodo("year",element),
                            getNodo("season",element),getNodo("thumb",element));
                    System.out.println(elemento.toString());

                }
            }

        } catch (Exception e) { e.printStackTrace();}
    }

    private static String getNodo(String etiqueta, Element elem)
    {
        NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }


    static void  CrearElemento(String datoEmple, String valor,
                               Element raiz, Document document){
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }
}