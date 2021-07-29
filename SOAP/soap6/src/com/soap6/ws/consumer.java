package com.soap6.ws;

import java.io.IOException;
import java.util.Scanner;



public class consumer {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws IOException{
		
		int seleccion =0;
		// TODO Auto-generated method stub
		ServiceDocenteImplService docneteService = new ServiceDocenteImplService();
		ServiceDocente consumer = docneteService.getServiceDocenteImplPort();
		
		//System.out.println(consumer.getDocente(456321789));
		//consumer.addDocente("Hristo aroquipa, fisica, 456321789");
		
		
		while(true) {
			System.out.println("Ingrese la opcion que desea realizar\n"
					+ "1)Añadir un Docente\n"
					+ "2)Consultar un Docente\n"
					+ "3)Consultar docentes\n"
					+ "4)Salir");
			seleccion=scan.nextInt();
			scan.nextLine();
			if(seleccion==1){
				//String nombreDocente, String apelidoDocente, String departamentoDocente, String correoDocente, String telefonoDocente, String direccionDocente, String DNIDocente
				System.out.println("Ingresar los nombres del Docente");
				String nombres = scan.nextLine();
				System.out.println("Ingresar los apellidos del Docente");
				String apellidos = scan.nextLine();
				System.out.println("Ingresar el departamento del Docente");
				String departamento =  scan.nextLine();
				System.out.println("Ingresar el correo del Docente");
				String correo =  scan.nextLine();
				System.out.println("Ingresar el telefono del Docente");
				String telefono =  scan.nextLine();
				System.out.println("Ingresar el direccion del Docente");
				String direccion =  scan.nextLine();
				System.out.println("Ingresar el DNI del Docente");
				String DNI = scan.nextLine();
				consumer.addDocente(nombres, apellidos, departamento, correo, telefono, direccion, DNI);
			}else if(seleccion==2)
				System.out.println("\tDocente: "+consumer.getDocente(getDocente()));
			else if(seleccion==3)
				System.out.println(consumer.getDocentes());
			else break;	
		}	
		System.out.println("Servicio terminado...");

	}
	public static int getDocente() {
		System.out.println("ingresar el DNI del docente que desea consultar");
		return scan.nextInt();
	}
}
