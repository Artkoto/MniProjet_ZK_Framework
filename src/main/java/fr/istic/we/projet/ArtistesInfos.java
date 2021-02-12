package fr.istic.we.projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*représente un champ artiste aves ses infotmation*/
public class ArtistesInfos {

    private String spotifyInfo;
    private String deezerInfo;

    private String anneeInfo;
    private String paysInfo;
    private String nameInfo;
    private String VilleInfo;
    private List<Salle> salles ;
    private List<Even> evens ;

    public ArtistesInfos(String name) {
        this.spotifyInfo = "";
        this.deezerInfo = "";
        this.anneeInfo = "";
        this.paysInfo = "";
        this.nameInfo = name;
        this.VilleInfo = "";
        salles = new ArrayList<>();
        evens = new ArrayList<>( );
    }


    public String getSpotifyInfo() {
        return spotifyInfo;
    }

    public String getDeezerInfo() {
        return deezerInfo;
    }

    public String getAnneeInfo() {
        return anneeInfo;
    }

    public String getPaysInfo() {
        return paysInfo;
    }

    public String getVilleInfo() {
        return VilleInfo;
    }

    public String getNameInfo() {
        return nameInfo;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public List<Even> getEvens() {
        return evens;
    }

    /**
     * ajouter une salle à la liste
     * @param salle ,
     */
    public void add (Salle salle) {
        salles.add(salle);
        salle.add(this);
    }

    /**
     * ajouter un evenement à la liste
     * @param even ,
     */
    public void add (Even even){
        evens.add(even);
        even.add(this);
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtistesInfos)) return false;
        ArtistesInfos that = (ArtistesInfos) o;
        return nameInfo.equals(that.nameInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameInfo);
    }
}
