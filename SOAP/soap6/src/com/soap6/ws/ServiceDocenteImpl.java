package com.soap6.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


@WebService(endpointInterface = "com.soap6.ws.ServiceDocente" )
public class ServiceDocenteImpl implements ServiceDocente {

	@Override
	public String getDocente(int idDocente) {
		String id = idDocente+""; 
		String nombreFichero = "prueba.txt";
		
        //Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
           //Crear un objeto BufferedReader al que se le pasa 
           //   un objeto FileReader con el nombre del fichero
           br = new BufferedReader(new FileReader(nombreFichero));
           //Leer la primera línea, guardando en un String
           String texto = br.readLine();
           //Repetir mientras no se llegue al final del fichero
           while(texto != null)
           {
               //Hacer lo que sea con la línea leída
               //System.out.println(texto);
        	   if (texto.indexOf(id)!=-1)
        		   return texto;
               //Leer la siguiente línea
               texto = br.readLine();
           }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(br != null)
                    br.close();
            }
            catch (Exception e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
		return "Docente no registrado";
	}

	@Override
	public ArrayList<String> getDocentes() {
		ArrayList<String> docentes = new ArrayList<String>();
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document documento = builder.parse(new File ("Docentes.xml"));
			
			
			NodeList listaCD = documento.getElementsByTagName("DOCENTE");
			
			for (int i = 0; i < listaCD.getLength(); i++) {
				org.w3c.dom.Node nodo = listaCD.item(i);
				
				if(nodo.getNodeType()==Node.ELEMENT_NODE){
					Element e = (Element) nodo;
					NodeList hijos = e.getChildNodes();
					String aux="";
					for (int j = 0; j < hijos.getLength(); j++) {
						org.w3c.dom.Node hijo = hijos.item(j);
						if(hijo.getNodeType()==hijo.ELEMENT_NODE){
							Element eHijo = (Element) hijo;
							//System.out.println("Propiedad: "+eHijo.getNodeName()+", Valor: "+eHijo.getTextContent()+"\n");
							aux+="Propiedad: "+eHijo.getNodeName()+"- Valor: "+eHijo.getTextContent()+"\n";
						}
						
					}
					aux += "\n";
					docentes.add(aux);
					aux="";
					
				}
				
			}
			
		}catch(Exception E){
			
		}
		return docentes;
	}

	@Override
	public void addDocente(String nombreDocente, String apelidoDocente, String departamentoDocente, String correoDocente, String telefonoDocente, String direccionDocente, String DNIDocente) {
		// TODO Auto-generated method stub
		try{
			Writer output; 
			output = new BufferedWriter(new FileWriter("prueba.txt", true)); //clears file every time 
			output.append(nombreDocente+"-"+apelidoDocente+"-"+departamentoDocente+"-"+correoDocente+"-"+telefonoDocente+"-"+direccionDocente+"-"+DNIDocente+"\n"); 
			output.close();
		}catch(Exception e){
			
		}
		 
		File xml = new File("Docentes.xml" );
		 try{
	    	   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	           DocumentBuilder db = dbf.newDocumentBuilder();
	           Document document = db.parse(xml);
	           Element root = document.getDocumentElement();
	           Element cd = document.createElement("DOCENTE");
	           root.appendChild(cd);
	           //document.appendChild(cd)
	               Element nombres = document.createElement("NOMBRES");
	               Element apellidos = document.createElement("APELLIDOS");
	               Element departamento = document.createElement("DEPARTAMENTO");
	               Element correo = document.createElement("CORREO");
	               Element telefono = document.createElement("TELEFONO");
	               Element direcccion = document.createElement("DIRECCION");
	               Element DNI = document.createElement("DNI");
	     


	               nombres.appendChild(document.createTextNode(nombreDocente));
	               apellidos.appendChild(document.createTextNode(apelidoDocente));
	               departamento.appendChild(document.createTextNode(departamentoDocente));
	               correo.appendChild(document.createTextNode(correoDocente));	           
	               telefono.appendChild(document.createTextNode(telefonoDocente));
	               direcccion.appendChild(document.createTextNode(direccionDocente));
	               DNI.appendChild(document.createTextNode(DNIDocente));


	               cd.appendChild(nombres);
	               cd.appendChild(apellidos);
	               cd.appendChild(departamento);
	               cd.appendChild(correo);
	               cd.appendChild(telefono);
	               cd.appendChild(direcccion);
	               cd.appendChild(DNI);
	           
	           
	           TransformerFactory factory = TransformerFactory.newInstance();
	           Transformer transformer = factory.newTransformer();
	           DOMSource domSource = new DOMSource(document);
	           StreamResult streamResult = new StreamResult(new File("Docentes.xml"));
	           transformer.transform(domSource, streamResult);
	           DOMSource source = new DOMSource(document);
	       }catch(Exception e){
	    	   
	       }
	}
	

}