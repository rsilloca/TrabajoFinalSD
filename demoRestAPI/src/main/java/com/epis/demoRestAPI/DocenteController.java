package com.epis.demoRestAPI;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class DocenteController {

    @GetMapping("/docentes")
    public List<Docente> getDocentes() {
        ArrayList<Docente> docentes = new ArrayList<Docente>();
        try {
            File xmlFile = ResourceUtils.getFile("src/main/resources/Docentes.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            if (xmlFile.exists()) {
                Document doc = db.parse(xmlFile);
                doc.getDocumentElement().normalize();
                NodeList nodeList = doc.getElementsByTagName("DOCENTE");
                for (int i = 0; i < nodeList.getLength(); i++)  {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) node;
                        System.out.println();
                        Docente d = new Docente(
                                e.getElementsByTagName("NOMBRES").item(0).getTextContent(),
                                e.getElementsByTagName("APELLIDOS").item(0).getTextContent(),
                                e.getElementsByTagName("DEPARTAMENTO").item(0).getTextContent(),
                                e.getElementsByTagName("CORREO").item(0).getTextContent(),
                                e.getElementsByTagName("TELEFONO").item(0).getTextContent(),
                                e.getElementsByTagName("DIRECCION").item(0).getTextContent(),
                                e.getElementsByTagName("DNI").item(0).getTextContent()
                                );
                        docentes.add(d);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return docentes;
    }

}
