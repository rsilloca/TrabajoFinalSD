package com.epis.demoGraphQL.graphql;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
public class GraphQLDataFetchers {

    private List<Map<String, String>> docentes;

    public graphql.schema.DataFetcher getDocenteDNIIdDataFetcher() {
        docentes = new ArrayList<Map<String, String>>();
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
                        Map<String, String> data = new HashMap<String, String>() {{
                            put("nombres", e.getElementsByTagName("NOMBRES").item(0).getTextContent());
                            put("apellidos", e.getElementsByTagName("APELLIDOS").item(0).getTextContent());
                            put("departamento", e.getElementsByTagName("DEPARTAMENTO").item(0).getTextContent());
                            put("correo", e.getElementsByTagName("CORREO").item(0).getTextContent());
                            put("telefono", e.getElementsByTagName("TELEFONO").item(0).getTextContent());
                            put("direccion", e.getElementsByTagName("DIRECCION").item(0).getTextContent());
                            put("dni", e.getElementsByTagName("DNI").item(0).getTextContent());
                        }};
                        docentes.add(data);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return dataFetchingEnvironment -> {
            String docenteDNI = dataFetchingEnvironment.getArgument("dni"); // "45612389";
            return docentes
                    .stream()
                    .filter(docente -> docente.get("dni").equals(docenteDNI))
                    .findFirst()
                    .orElse(null);
        };
    }
}