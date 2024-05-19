package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Osoba {
    int pesel;
    String name;
    String nr_i_seria_dowodu;

    public Osoba(int pesel, String name) {
        this.pesel = pesel;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "pesel=" + pesel +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Osoba o1 = new Osoba(111,"Alice");
        Osoba o2 = new Osoba(222,"Bob");
        Osoba o3 = new Osoba(111,"Carl");

        List<Osoba> osoby = new ArrayList<>();
        osoby.add(o1);
        osoby.add(o2);
        osoby.add(o3);

        for ( int i=0;i<osoby.size();i++){
            System.out.println(osoby.get(i));
        }
        osoby.remove(o3);

        System.out.println("//////////PO USUNIECIU///////////");
        for(Osoba o : osoby){
            System.out.println(o);
        }
        osoby.add(o3);

        Map<Integer,Osoba> mapa = new HashMap<>();
        for (int i=0;i<osoby.size();i++){
            Osoba oc = osoby.get(i);
            mapa.put(oc.pesel,oc);
        }

        for(Map.Entry<Integer,Osoba> para: mapa.entrySet()){
            System.out.println(para.getKey() + " -> " + para.getValue());
        }

        for (int pesel : mapa.keySet()){
            System.out.println(pesel);
        }
        for (Osoba o : mapa.values()){
            o.name ="zmienione_"+o.name;
        }
        System.out.println("wyszukanie "+mapa.get(111));
        mapa.remove(111);
        System.out.println(mapa);

        System.out.println(osoby);


    }
}
