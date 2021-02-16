package fr.istic.we.projet;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.A;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class ArtististeDetailViewModel {

    //param pour la recherche
    private static ArtistesInfos artiste ;

    public ArtistesInfos getArtiste() {
        return artiste;
    }

    public void setArtiste(ArtistesInfos artiste1) {
        artiste = artiste1;
    }

        @Command
        @NotifyChange("*")
        public void changerFiltre(){;
        }

    }
