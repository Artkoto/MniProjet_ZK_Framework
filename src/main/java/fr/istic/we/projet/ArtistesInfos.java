package fr.istic.we.projet;

import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;
import org.zkoss.json.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
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
    //image récupere via spotify
    private String image;

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

    public String getImage() {
        return image;
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
     * recupérer image de l'artiste via spotify
     */
    public void recupImg() {
       String imgDjArafat = "https://s.rfi.fr/media/display/06774f86-10bf-11ea-98b5-005056bf7c53/w:1280/p:1x1" +
                "/dj_arafat_rfi_legendes_urbaines_canthony_ravera_0.jpg";
       HttpURLConnection connection;

       //token valable 3600 secondes vous devez en regenerer pour faire une connexion avec spotify
        //lien : https://developer.spotify.com/console/get-album/?id=&market=
       String token = "BQDRTqeNm3CknpvhpXehbyLX9UEKwzyGloQzwdYUtI5xV4RnoctUWJeIrjmjxjFox3CBkcuLHfCn9fg_7TrkJKr4YULu1HVBMKshIfHe3ciSswBt5NrfkfFuN0Xq0oN72rYgM7vRbDWWdN6yCXXOY_MaUckgl4C56RArcFHvLX3O84HR6hpezSFXC_5t_w";

       try {
           //recuperation de l'image dans le json
           JSONParser jsonParser = new JSONParser() ;
           JSONArray jsonArray;
           JSONArray imgs;
           JSONObject jsonObject;
           JSONObject jsonObject2;
           JSONObject image1;
           URL url = new URL("https://api.spotify.com/v1/albums?ids="+spotifyInfo.substring(14)+"&market=FR");
           connection = (HttpURLConnection) url.openConnection();
           connection.setRequestMethod("GET");
           connection.setRequestProperty("accept", "application/json");
           connection.setRequestProperty("Content-Type","application/json");
           connection.setRequestProperty("Authorization", "Bearer "+ token);
           connection.setRequestProperty("grant_type", "client_credentials");
           connection.setConnectTimeout(5000);
           connection.setReadTimeout(5000);

           BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           StringBuffer json = new StringBuffer();
           String line;
           while ((line = reader.readLine()) != null) {
               json.append(line);
           }
           reader.close();
           jsonObject = (JSONObject) jsonParser.parse(json.toString());
           jsonArray = (JSONArray) jsonObject.get("albums");
           jsonObject2 = (JSONObject) jsonArray.get(0);
            imgs = (JSONArray) jsonObject2.get("images");
           image1 = (JSONObject) imgs.get(0);
           String imgURL = (String) image1.get("url");

           this.image = (imgURL == null)? imgDjArafat : imgURL;
       }catch (Exception e){
           e.printStackTrace();
            this.image = imgDjArafat ;}

    }

    /**
     * ajouter une salle à la liste
     * @param salle ,
     */
    public void add (Salle salle) {
        if (contientSall(salle.getName())==null) {
            salles.add(salle);
            salle.add(this);
        }
    }

    /**
     * ajouter un evenement à la liste
     * @param even ,
     */
    public void add (Even even){
        if (contientEven(even.getName())==null) {
            evens.add(even);
            even.add(this);
        }
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
/*

    public static void main(String[] args) {
        ArtistesInfos art =new ArtistesInfos("a");
        art.setSpotifyInfo("spotify:album:0Wvz0IHh6iGFMEOfDEh9bv");
        art.recupImg();
        System.out.println(art.getImage());
    }*/
}
