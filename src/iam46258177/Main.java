package iam46258177;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio = 0, id;
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
            System.out.println("6. Lledir dades d'arxiu XML");
            System.out.println("7. Sortir");
            System.out.println("----------------------------------------");
            System.out.print("Quina opció sel·leciones?: ");

            opcio = scanner.nextInt();
            System.out.println("\n");


            switch (opcio){
                case 1:
                    System.out.print("Quin ID vols afegir? ");
                    id = scanner.nextInt();
                    System.out.print("\nQuina data vols afegir? (yyyy/MM) ");
                    year = scanner.next();
                    System.out.print("\nQuina temporada vols afegir? ");
                    scanner.nextLine();
                    season = scanner.nextLine();
                    System.out.print("");
                    System.out.print("\nQuina foto vols afegir? ");
                    thumb = scanner.next();

                    try {
                        llistaElemento.add(new Elemento(id, year, season, thumb));
                        System.out.println("l'element ha sigut afegit amb exit");
                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                    System.out.println("Presiona enter per continuar");
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                case 2:
                    Iterator iterator = llistaElemento.getLlistaelemento().iterator();
                    System.out.println(" -------- Llistat en memoria --------");
                    while (iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    System.out.println();
                    break;
                case 3:
                    try {
                        binariclass.escriureBinari(llistaElemento.getLlistaelemento());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    xmLclass.EscriureXML(llistaElemento.getLlistaelemento());
                    break;
                case 5:
                    try {
                        binariclass.llegirBinari();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    xmLclass.LlegirXml();
                    break;
            }

            if (opcio > 7){
                System.err.println("Has d'introfuir un número del 1 al 7");
            }

        }

    }
}
