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
                if (!Integer.toString(elemento.getId()).isEmpty()) {
                    CrearElemento("id", Integer.toString(elemento.getId()), raiz, document);
                }
                if (!elemento.getYear().isEmpty()) {
                    CrearElemento("year", elemento.getYear(), raiz, document);
                }
                if (!elemento.getSeason().isEmpty()) {
                    CrearElemento("season", elemento.getSeason(), raiz, document);
                }
                if (!elemento.getThumb().isEmpty()) {
                    CrearElemento("thumb", elemento.getThumb(), raiz, document);
                }
                System.out.println("Element guardat amb exit");

            }

            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("data/out/record.xml"));
            TransformerFactory transformerFactory= TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
            transformer.transform(source, result);


        }catch(Exception e){System.err.println("Error: "+e);}
    }

    public void LlegirXml(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            File file = new File("data/out/record.xml");
            if (file.exists()) {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                document.getDocumentElement().normalize();

                NodeList content = document.getElementsByTagName("row");

                for (int i = 0; i < content.getLength(); i++) {
                    Node ar = content.item(i);

                    if (ar.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) ar;

                        Elemento elemento = new Elemento(getNodo("id", element), getNodo("year", element),
                                getNodo("season", element), getNodo("thumb", element));
                        System.out.println(elemento.toString());

                    }
                }
            }else {
                System.out.println("No existeix aquest fitxer");
                System.out.println("Proba a afegir elements de memoria al fitxer");
            }

        } catch (Exception e) { e.printStackTrace();}
    }

    private static String getNodo(String etiqueta, Element elem) {
        String valor = "";
        try {
            NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
            Node valornodo = (Node) nodo.item(0);
            valor = valornodo.getNodeValue();
        } catch (Exception e) {

        }
        return valor;
    }


    static void  CrearElemento(String datoEmple, String valor,
                               Element raiz, Document document){
        Element elem = document.createElement(datoEmple);
        Text text = document.createTextNode(valor);
        raiz.appendChild(elem);
        elem.appendChild(text);
    }
}