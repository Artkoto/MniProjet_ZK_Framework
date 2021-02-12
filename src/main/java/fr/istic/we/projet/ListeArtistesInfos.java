package fr.istic.we.projet;

import java.util.ArrayList;
import java.util.List;

public class ListeArtistesInfos {
    List<ArtistesInfos> artistesInfos;

    public ListeArtistesInfos() {
        artistesInfos = new ArrayList<>();
    }

    public List<ArtistesInfos> getArtistesInfos() {
        return artistesInfos;
    }

    public void add(ArtistesInfos artiste){
        artistesInfos.add(artiste);
    }
}
