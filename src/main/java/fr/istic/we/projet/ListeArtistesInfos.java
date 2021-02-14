package fr.istic.we.projet;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import javassist.ClassMap;
import org.zkoss.json.parser.JSONParser;
import org.zkoss.json.JSONObject;
import org.zkoss.json.JSONArray;
import org.zkoss.json.parser.ParseException;



public class ListeArtistesInfos {

    private static final List<ArtistesInfos> artistesInfos =new ArrayList<>();
    private static final List<Salle> salles = new ArrayList<>();
    private static final List<Even> evens = new ArrayList<>();

    //import des données depuis JSON
    static  Path path = Paths.get("out.json");
    static JSONParser jsonParser = new JSONParser() ;
    static JSONArray jsonArray;

    static  {
        try {
            //JSON de la forme un tablea de plusieurs objet
           jsonArray = (JSONArray) jsonParser.parse(new FileReader(String.valueOf(path)));
            for (Object globalObjet : jsonArray) {
                //recupération du filds
                JSONObject fieldsObject = (JSONObject) ((JSONObject) globalObjet).get("fields");
                //recupération de chaque information importante de notre objet
                String artiste = (String) fieldsObject.get("artistes");
                String spotify = (String) fieldsObject.get("spotify");
                String deezer = (String) fieldsObject.get("deezer");
                String anne = (String) fieldsObject.get("annee");
                String pays = (String) fieldsObject.get("origine_pays1");
                String ville =  (String) fieldsObject.get("origine_ville1");
                String even = (String) fieldsObject.get("edition");
                String salle1 = (String) fieldsObject.get("1ere_salle");
                String salle2 = (String) fieldsObject.get("2eme_salle");
                String salle3 = (String) fieldsObject.get("3eme_salle");
                String salle4 = (String) fieldsObject.get("4eme_salle");
                String salle5 = (String) fieldsObject.get("5eme_salle");
                String salle6 = (String) fieldsObject.get("6eme_salle");
                String salle7 = (String) fieldsObject.get("7eme_salle");
                String salle8 = (String) fieldsObject.get("8eme_salle");
                //si l'artiste n'est pas dans la liste , on l'ajoute
                ArtistesInfos artistesInfos1 = new ArtistesInfos(artiste);
                if (!artistesInfos.contains( artistesInfos1)){
                    //on va traiter les informations différentes de null
                    artistesInfos.add(artistesInfos1);
                    artistesInfos1.setAnneeInfo(anne);
                    artistesInfos1.setPaysInfo(pays);
                    artistesInfos1.setDeezerInfo(deezer);
                    artistesInfos1.setVilleInfo(ville);
                    artistesInfos1.setSpotifyInfo(spotify);
                    //ajout des evenements
                    if (even != null){
                        Even even1 = new Even(even);
                        artistesInfos1.add(even1);
                        if (!evens.contains(even1))
                            evens.add(even1);
                    }
                    //ajout des salles de spectacles de 1 à 8
                    if (salle1 != null){
                        Salle salle = new Salle(salle1);
                        artistesInfos1.add(salle);
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                        if (!salles.contains(salle))
                            salles.add(salle);
                    }
                    //salle2
                    if (salle2 != null){
                        Salle salle = new Salle(salle2);
                        artistesInfos1.add(salle);
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                        if (!salles.contains(salle))
                            salles.add(salle);
                    }
                    //sallez3
                    if (salle3 != null){
                        Salle salle = new Salle(salle3);
                        artistesInfos1.add(salle);
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                        if (!salles.contains(salle))
                            salles.add(salle);
                    }
                    //salle4
                    if (salle4 != null){
                        Salle salle = new Salle(salle4);
                        artistesInfos1.add(salle);
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                        if (!salles.contains(salle))
                            salles.add(salle);
                    }
                    //salle5
                    if (salle5 != null){
                        Salle salle = new Salle(salle5);
                        artistesInfos1.add(salle);
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                        if (!salles.contains(salle))
                            salles.add(salle);
                    }
                    //salle6
                    if (salle6 != null){
                        Salle salle = new Salle(salle6);
                        artistesInfos1.add(salle);
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                        if (!salles.contains(salle))
                            salles.add(salle);
                    }
                    //salle7
                    if (salle7 != null){
                        Salle salle = new Salle(salle7);
                        artistesInfos1.add(salle);
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                        if (!salles.contains(salle))
                            salles.add(salle);
                    }
                    //salle8
                    if (salle8 != null){
                        Salle salle = new Salle(salle8);
                        artistesInfos1.add(salle);
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                        if (!salles.contains(salle))
                            salles.add(salle);
                    }

                }
                //veriffication du comportement correcte des artistes
               /* String EvenParDefaut = "Aucun Evenement";
                System.out.println(artistesInfos1.getNameInfo()+" "
                        +artistesInfos1.getAnneeInfo()+" "
                +artistesInfos1.getPaysInfo()+" "
                +artistesInfos1.getDeezerInfo()+" "
                +artistesInfos1.getVilleInfo()+" "
                +((!artistesInfos1.getEvens().isEmpty())?artistesInfos1.getEvens().get(0).getName():EvenParDefaut));
*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //verification du comportement correcte des Salles
        /*for (Salle s : salles){
            System.out.println(s.getName()+"  " +s.getArtistes().get(0).getNameInfo()+  " "+s.getEvens().get(0).getName());
        }*/
        //verification du comportement correcte des evens
        /*for (Even e : evens){
            System.out.println(e.getName()+"  " +e.getArtistes().get(0).getNameInfo()+  " "+e.getSalles().get(0).getName());
        }*/
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
                    tmp.contientSall(salle) != null  &&
                    tmp.contientEven(even) != null) {
                someArtistes.add(tmp);
            }
        }
        return someArtistes;
    }

    public static List<ArtistesInfos> getArtistesInfosByName() {
        return artistesInfos;
    }

    public static void main(String[] args) {
        System.out.println(path);
        JSONObject object = (JSONObject) jsonArray.get(0);
        JSONObject ob2 = (JSONObject) object.get("fields");
        System.out.println(object);
        System.out.println( ob2.get("artistes") );
    }

}
