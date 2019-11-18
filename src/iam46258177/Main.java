package iam46258177;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\\r\\n]+");
        int opcio = 0;
        String id;
        String year, season, thumb;
        LlistaElemento llistaElemento = new LlistaElemento();
        Binariclass binariclass = new Binariclass();
        XMLclass xmLclass = new XMLclass();

        while (opcio != 7){
            System.out.println("---------Sel·leciona una opció---------\n");
            System.out.println("1. Introducció de dades");
            System.out.println("2. Llistat de dades");
            System.out.println("3. Guardar dades en arxiu BINARI");
            System.out.println("4. Guardar dades en arxiu XML");
            System.out.println("5. Llegir dades d'arxiu BINARI");
            System.out.println("6. Llegir dades d'arxiu XML");
            System.out.println("7. Sortir");
            System.out.println("----------------------------------------");
            System.out.print("Quina opció sel·leciones?: ");

            opcio = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");


            switch (opcio){
                case 1:
                    System.out.print("Quin ID vols afegir? ");
                    id = scanner.nextLine();
                    System.out.print("\nQuina data vols afegir? (yyyy/MM) ");
                    year = scanner.nextLine();
                    System.out.print("\nQuina temporada vols afegir? ");
                    season = scanner.nextLine();
                    System.out.print("\nQuina foto vols afegir? ");
                    thumb = scanner.nextLine();

                    try {
                        llistaElemento.add(new Elemento(id, year, season, thumb));
                        System.out.println("l'element ha sigut afegit amb exit");
                        System.out.println("Presiona enter per continuar");
                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                        System.out.println("Presiona enter per continuar");
                    }
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println(" -------- Llistat en memoria --------");
                    if (llistaElemento.getLlistaelemento().isEmpty()) {
                        System.out.println(" ---------------buida----------------");
                    }else {
                        Iterator iterator = llistaElemento.getLlistaelemento().iterator();
                        while (iterator.hasNext()) {
                            System.out.println(iterator.next());
                        }
                    }
                    System.out.println(" ------------------------------------");
                    System.out.println("Presiona enter per continuar");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 3:
                    if ( llistaElemento.getLlistaelemento().isEmpty()){
                        System.out.println("No hi cap element en memoria per guardar");
                        System.out.println("Inserta un element en la opció 1.Introducció de dades");
                    }else {
                        try {
                            binariclass.escriureBinari(llistaElemento.getLlistaelemento());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Presiona enter per continuar");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 4:
                    if ( llistaElemento.getLlistaelemento().isEmpty()) {
                        System.out.println("No hi cap element en memoria per guardar");
                        System.out.println("Inserta un element en la opció 1.Introducció de dades");
                    } else {
                        xmLclass.EscriureXML(llistaElemento.getLlistaelemento());
                    }
                    System.out.println("Presiona enter per continuar");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 5:
                    try {
                        System.out.println("----------Dades del arxiu Binari---------");
                        binariclass.llegirBinari();
                        System.out.println("----------------------------------------");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Presiona enter per continuar");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("----------Dades del arxiu XML---------");
                    xmLclass.LlegirXml();
                    System.out.println("----------------------------------------");
                    System.out.println("Presiona enter per continuar");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
            }

            if (opcio > 7){
                System.err.println("Has d'introfuir un número del 1 al 7");
            }

        }
        scanner.close();

    }
}
