package fr.istic.we.projet;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class ArtististeDetailViewModel {

        private static final String artisteInfoMessag = " %d artistes";
        private final Filtre filtre = new Filtre();
        static List<ArtistesInfos> currentArtisteInf = ListeArtistesInfos.getArtistesInfos() ;

        public Filtre getFiltre() {
            return filtre;
        }

        public ListModel<ArtistesInfos> getArtisteInfosMode() {
            return new ListModelList<ArtistesInfos>(currentArtisteInf);
        }

        public String getArtisteInfoMessag() {
            return String.format(artisteInfoMessag, currentArtisteInf.size());
        }

        @Command
        @NotifyChange({"artisteInfosMode", "artisteInfoMessag"})
        public void changerFiltre() {
            currentArtisteInf = ListeArtistesInfos.getFilterArtisteInfos(filtre);
        }

    }
