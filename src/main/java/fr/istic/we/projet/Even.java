package fr.istic.we.projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Even  implements Comparable<Even>{
    private String name;
    private List<ArtistesInfos> artistes ;
    private List <Salle> salles;

    public Even(String nom ) {
        name = nom;
        artistes = new ArrayList<>();
        salles = new ArrayList<>();

    }

    /**
     * ajouter une salle à la liste
     * @param salle ,
     */
    public void add (Salle salle){
        if (!salles.contains(salle))
        salles.add(salle);
        if (!salle.getEvens().contains(this))
        salle.add(this);
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

    public List<Salle> getSalles() {
        return salles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Even)) return false;
        Even even = (Even) o;
        return name.equalsIgnoreCase(even.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public int compareTo(Even evnB) {
        return  (getName().compareTo(evnB.getName()));
    }
}
