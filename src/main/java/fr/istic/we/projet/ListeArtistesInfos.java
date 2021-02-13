package fr.istic.we.projet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListeArtistesInfos {

    private static List<ArtistesInfos> artistesInfos;
    public ListeArtistesInfos() {
        artistesInfos = new ArrayList<>();
    }

    public static List<ArtistesInfos> getArtistesInfos() {
        return artistesInfos;
    }

    public void add(ArtistesInfos artiste){
        artistesInfos.add(artiste);
    }

    //Ajout de filtres

    public static List<ArtistesInfos> getFilterArtisteInfos(Filtre filtre) {
        List<ArtistesInfos> someArtistes = new ArrayList<ArtistesInfos>();
       // ArtistesInfos artist = new ArtistesInfos();
        String artiste = Filtre.getArtiste().toLowerCase();
        String salle = Filtre.getSalle().toLowerCase();
        String even = Filtre.getEven().toLowerCase();

        for (Iterator<ArtistesInfos> i = artistesInfos.iterator(); i.hasNext();) {
            ArtistesInfos tmp = i.next();
            if (tmp.getNameInfo().toLowerCase().contains(artiste) &&
                    tmp.contientSall(salle)  &&
                    tmp.contientEven(even)) {
                someArtistes.add(tmp);
            }
        }
        return someArtistes;
    }

    public static List<ArtistesInfos> getArtistesInfosByName() {
        return artistesInfos;
    }

}
