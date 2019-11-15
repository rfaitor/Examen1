package iam46258177;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Binariclass {

    public void escriureBinari(List<Elemento> llistaelemento) throws IOException {


        LlistaElemento llistaElemento = new LlistaElemento();

        File fichero = new File("data/out/FichElementos.dat");
        FileOutputStream fileout = new FileOutputStream(fichero,true);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

        Iterator iterator = llistaelemento.iterator();
        System.out.println(fichero.length());
        while (iterator.hasNext()){
            dataOS.writeObject(iterator.next());
        }
        System.out.println(fichero.length());
        dataOS.close();
    }

    public void llegirBinari() throws IOException {
        Elemento elemento;
        File fichero = new File("data/out/FichElementos.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        try {
            while (true) {
                elemento = (Elemento) dataIS.readObject();
                System.out.println(elemento.toString());
            }
        }catch (EOFException eo) {}
        catch (StreamCorruptedException x) {} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dataIS.close();
    }
}
