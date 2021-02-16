package fr.istic.we.projet;

public class ArtististeDetailViewModel {

    //param pour la recherche
    private static ArtistesInfos artiste ;

    //pour les détails de salles
    private static Salle salle;

//    pour les details des evenements
    private static Even even;

    public  Salle getSalle() {
        return salle;
    }

    public  Even getEven() {
        return even;
    }

    public  void setSalle(Salle salle) {
        ArtististeDetailViewModel.salle = salle;
    }

    public  void setEven(Even even) {
        ArtististeDetailViewModel.even = even;
    }

    public ArtistesInfos getArtiste() {
        return artiste;
    }

    public void setArtiste(ArtistesInfos artiste1) {
        artiste = artiste1;
    }


    }
