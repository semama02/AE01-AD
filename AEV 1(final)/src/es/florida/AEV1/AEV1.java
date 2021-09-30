package es.florida.AEV1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AEV1 {
	//Creem el menú
	static void menu() {
		System.out.println("Dime que mètode vols executar:");
		System.out.println("");
		System.out.println("1. getInformacio");
		System.out.println("2. crearCarpeta");
		System.out.println("3. crearFitxer");
		System.out.println("4. elimina");
		System.out.println("5. renomena");
		System.out.println("");
	}
	
	// Creem el mètode getInformacio
	static void getInformacio(String string) {
		 //Agafem el fitxer
		 File fitxer = new File(string);
		 
		 //Mostrem el nom del fitxer o carpeta
		 String x = fitxer.getName();
		 System.out.println("");
		 System.out.println("El nom de la carpeta/fitxer es: " + x);
		 
		 //Creem la variable en la qual guardem si es un fitxer
		 Boolean tipo = fitxer.isFile();

		 //Fem un if per a determinar si es un fitxer o una carpeta
		 if (tipo == true) {
			 //Mostra per pantalla que es un fitxer
			 System.out.println("Es un fitxer.");

			 //Calcula la grandaria i la mostra per pantalla
			 Long grandaria = fitxer.length();
			 System.out.println("Te una grandaria de: " + grandaria + " bytes");
			 
		 }else {
			 //Mostra per pantalla que es un directori
			 System.out.println("Es un directori.");
			 
			 //Guardem els archius i directoris que conté i els mostrem per pantalla
			 String [] ListaArchivos = fitxer.list();
			 System.out.println("Objectes: ");
			 for(int i = 0; i < ListaArchivos.length; i++) {  
					System.out.println("	" + ListaArchivos[i]);
			 }
			 
			 //Calculem l'espai total que te i el mostrem
			 Long total = fitxer.getTotalSpace();
			 System.out.println("Espai total: " + ((total/1024)/1024)/1024 + " gb.");
			 
			 //Calculem l'espai que te usat i el mostrem
			 Long lliure = fitxer.getUsableSpace();
			 System.out.println("Espai lliure: " + ((lliure/1024)/1024)/1024 + " gb.");
			 
			 //Calculem l'espai ocupat i el mostrem
			 System.out.println("Espai ocupat: " + (((total-lliure)/1024)/1024)/1024 + " gb.");
		 }
		 
		 //Agafem i mostrem la rutas absoluta
		 String ruta = fitxer.getAbsolutePath();
		 System.out.println("La ruta es: " + ruta);
		 
		 //Guardem la data d'ultima modificació
		 Long modificacio = fitxer.lastModified();
		 //Guardem en un string el patro que nem a usar per a la data
		 String pattern = "dd-MM-yyyy hh:mm aa";
		 //Li donem format a la data
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		 Date lastModifiedDate = new Date( modificacio );
		 //Mostrem per pantalla la data
		 System.out.println("La última data de modificacio va ser: " + simpleDateFormat.format(lastModifiedDate));
		 
		 //Guardem en una variable si l'arxiu està  ocult i mostrem per pantalla el resultat
		 Boolean ocult = fitxer.isHidden();
		 if (ocult == true) {
			 System.out.println("Esta ocult.");
		 }else {
			 System.out.println("No esta ocult.");
		 }

	}
	
	static void crearCarpeta(String string) {
		 //Li pasem la ruta per a agafar el directori
		 File fitxer = new File(string);
		 
		 //Mostrem per pantalla que mos diga un nom per a la carpeta
		 System.out.println("");
		 System.out.println("Dime el nom per a la carpeta a crear: ");

		 
		 //Li demanem al usuario el nom del directori a crear
		 Scanner sc = new Scanner(System.in);
		 String carpeta = sc.nextLine();
		 
		 //Fem una gestió d'errors
		 try {
			 File directorios = new File(fitxer.getPath() + "/" + carpeta);
			 directorios.mkdir();
		 }catch(SecurityException e) {
			 e.printStackTrace();
		 }
			 
	}
	
	static void crearFitxer(String string) {
		 //Li pasem la ruta per a agafar el directori
		 File fitxer = new File(string);
		 
		 //Mostrem per pantalla que mos diga un nom per al arxiu
		 System.out.println("");
		 System.out.println("Dime el nom per al fitxer a crear: ");

		 
		 //Li demanem al usuario el nom del arxiu a crear
		 Scanner sc = new Scanner(System.in);
		 String nom = sc.nextLine();
		 
		 //Fem una gestió d'errors
		 try {
			 File archius = new File(fitxer.getPath() + "/" + nom);
			 archius.createNewFile(); 
		 }catch(SecurityException e) {
			 e.printStackTrace();
		 }catch( IOException p) {
			 p.printStackTrace();
		 }
			 
	}
	
	static void elimina(String string) {
		 //Li pasem la ruta per a agafar el directori
		 File fitxer = new File(string);
		 
		 //Mostrem per pantalla que mos diga un nom per a eliminar
		 System.out.println("");
		 System.out.println("Dime el nom de la carpeta o arxiu a eliminar: ");

		 
		 //Li demanem al usuario el nom del directori o fitxer a eliminar
		 Scanner sc = new Scanner(System.in);
		 String carpeta = sc.nextLine();
		 
		 //Fem una gestió d'errors
		 try {
			 File eliminar = new File(fitxer.getPath() + "/" + carpeta);
			 eliminar.delete();
		 }catch(SecurityException e) {
			 e.printStackTrace();
		 }
			 
	}
	
	static void renomena(String string) {
		 //Li pasem la ruta per a agafar el directori
		 File fitxer = new File(string);
		 
		 //Mostrem per pantalla que mos diga un nom per a renomenar
		 System.out.println("");
		 System.out.println("Dime el nom del directori/arxiu a renomenar: ");

		 
		 //Li demanem al usuario el nom a renomenar
		 Scanner sc = new Scanner(System.in);
		 String carpeta = sc.nextLine();
		 
		 //Mostrem per pantalla que mos diga un nom per a renomenar
		 System.out.println("");
		 System.out.println("Dime el nom que vols: ");
		 
		 //Li demanem al usuario el nom a renomenar
		 sc = new Scanner(System.in);
		 String nom = sc.nextLine();
		 
		 //Fem una gestió d'errors
		 try {
			 File directori = new File(fitxer.getPath() + "/" + carpeta);
			 File renomena = new File(fitxer.getPath() + "/" + nom);
			 directori.renameTo(renomena);
		 }catch(SecurityException e) {
			 e.printStackTrace();
		 }
			 
	}

	public static void main(String[] args) {
		 //inicialitzem el mètode
		 menu();
		 
		 //Preguntem que mètode vol
		 Scanner sc = new Scanner(System.in);
		 Integer numero = sc.nextInt();
		 
		 switch(numero) {
		  case 1:
			  //Elegim el mètode de getInformacio
			  getInformacio(args[0]);
		    break;
		  case 2:
			  //Elegim el mètode de crearCarpeta
			  crearCarpeta(args[0]);
			  break;
		  case 3:
			  //Elegim el mètode de crearFitxer
			  crearFitxer(args[0]);
			  break;
		  case 4:
			  //Elegim el mètode de elimina
			  elimina(args[0]);
			  break;
		  case 5:
			  //Elegim el mètode de renomena
			  renomena(args[0]);
			  break;
		  default:
		    // code block
			  System.out.println("No has elegido ninguna opción correcta");
		}
	}
}
