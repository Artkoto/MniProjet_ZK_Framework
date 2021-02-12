package fr.istic.we.projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Salle {

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
        evens.add(even);
        even.add(this);
    }

    /**
     * ajouter un artiste à la liste
     * @param artistesInfos ,
     */
    public void add (ArtistesInfos artistesInfos){
        artistes.add(artistesInfos);
    }

    public String getName() {
        return name;
    }

    public List<ArtistesInfos> getArtistes() {
        return artistes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salle)) return false;
        Salle salle = (Salle) o;
        return name.equals(salle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
