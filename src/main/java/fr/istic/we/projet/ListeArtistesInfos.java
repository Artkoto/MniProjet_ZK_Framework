package fr.istic.we.projet;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import org.zkforge.json.simple.parser.JSONParser;
import org.zkoss.json.JSONObject;
import org.zkoss.json.JSONArray;
import org.zkoss.json.parser.ParseException;



public class ListeArtistesInfos {

    private static List<ArtistesInfos> artistesInfos;
    private static  List<Salle> salles ;
    private static  List<Even> evens ;
    public ListeArtistesInfos() {
        artistesInfos = new ArrayList<>();
        salles = new ArrayList<>();
        evens = new ArrayList<>();
    }

    //import des données depuis JSON
    static  Path path = Paths.get("out.json");
    static JSONParser jsonParser = new JSONParser() ;

    static  {
        try {
            //régler le probleme avec path
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(String.valueOf(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
