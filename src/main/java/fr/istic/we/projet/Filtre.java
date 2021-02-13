package fr.istic.we.projet;

public class Filtre {
    
        private static String artiste="", salle="", even="";

        public  static String getArtiste() {
            return artiste;
        }

        public static void setArtiste(String artiste) {
            artiste = artiste==null?"":artiste.trim();
        }

        public static String getSalle() {
            return salle;
        }

        public static void setSalle(String salle) {
            salle = salle==null?"":salle.trim();
        }

        public static String getEven() {
            return even;
        }

        public static void setEven(String even) {
            even = even==null?"":even.trim();
        }
    
}
