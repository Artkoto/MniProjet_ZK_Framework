package fr.istic.we.projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Salle implements Comparable<Salle>{

    private String name;
    private List<ArtistesInfos> artistes ;
    private List <Even> evens;

    public Salle(String nom) {
        name = nom;
        artistes = new ArrayList<>();
        evens = new ArrayList<>();
    }


    /**
     * ajouter un evenement à la liste
     * @param even ,
     */
    public void add (Even even){
        if (!evens.contains(even))
        evens.add(even);
        if (!even.getSalles().contains(this))
        even.add(this);
    }

    /**
     * ajouter un artiste à la liste
     * @param artistesInfos ,
     */
    public void add (ArtistesInfos artistesInfos){
        if (!artistes.contains(artistesInfos))
        artistes.add(artistesInfos);
    }

    public String getName() {
        return name;
    }

    public List<ArtistesInfos> getArtistes() {
        return artistes;
    }

    public List<Even> getEvens() {
        return evens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salle)) return false;
        Salle salle = (Salle) o;
        return name.equalsIgnoreCase(salle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public int compareTo(Salle salleB) {
        return  (getName().compareTo(salleB.getName())) ;
    }
}
