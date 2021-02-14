package fr.istic.we.projet;

import org.zkoss.zul.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*représente un champ artiste aves ses infotmation*/
public class ArtistesInfos implements Comparable<ArtistesInfos> {

    private String spotifyInfo;
    private String deezerInfo;

    private String anneeInfo;
    private String paysInfo;
    private final String nameInfo;
    private String VilleInfo;
    private final List<Salle> salles ;
    private final List<Even> evens ;

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

    public void setSpotifyInfo(String spotifyInfo) {
        this.spotifyInfo = spotifyInfo;
    }

    public void setDeezerInfo(String deezerInfo) {
        this.deezerInfo = deezerInfo;
    }

    public void setAnneeInfo(String anneeInfo) {
        this.anneeInfo = anneeInfo;
    }

    public void setPaysInfo(String paysInfo) {
        this.paysInfo = paysInfo;
    }

    public void setVilleInfo(String villeInfo) {
        VilleInfo = villeInfo;
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
        return nameInfo.equalsIgnoreCase(that.nameInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameInfo.toLowerCase());
    }

    @Override
    public int compareTo(ArtistesInfos artistesB) {
        return  (getNameInfo().compareTo(artistesB.getNameInfo()));
    }

    /**
     *
     * @param salle
     * @return retourne la salle ou null
     */
    public Salle contientSall(String salle) {
        String salleMiniscule = salle.toLowerCase();
        for (Salle s : salles){
            if(s.getName().toLowerCase().equals(salleMiniscule))
                return s;
        }
        return null;

    }

    /**
     *
     * @param even
     * @return retouren l'even sinon null
     */
    public Even contientEven(String even) {
        String evenMiniscule = even.toLowerCase();
        for (Even e : evens){
            if(e.getName().toLowerCase().equals(evenMiniscule))
                return e;
        }
        return null;

    }
}
