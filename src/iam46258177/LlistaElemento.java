package iam46258177;

import java.util.ArrayList;
import java.util.List;

public class LlistaElemento {

    private List<Elemento> llistaelemento = new ArrayList<>();

    public LlistaElemento() {
    }

    public void add(Elemento elemento){
        llistaelemento.add(elemento);
    }

    public List<Elemento> getLlistaelemento() {
        return llistaelemento;
    }

    public void setLlistaelemento(List<Elemento> llistaelemento) {
        this.llistaelemento = llistaelemento;
    }
}
