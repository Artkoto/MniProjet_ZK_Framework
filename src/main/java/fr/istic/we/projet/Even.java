package fr.istic.we.projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Even {
    private String name;
    private List<ArtistesInfos> artistes ;
    private List <Salle> salles;
    private String date ;

    public Even(String nom , String date) {
        name = nom;
        artistes = new ArrayList<>();
        salles = new ArrayList<>();
        this.date =date;
    }

    /**
     * ajouter une salle à la liste
     * @param salle ,
     */
    public void add (Salle salle){
        salles.add(salle);
        salle.add(this);
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

    public List<Salle> getSalles() {
        return salles;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Even)) return false;
        Even even = (Even) o;
        return name.equals(even.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
