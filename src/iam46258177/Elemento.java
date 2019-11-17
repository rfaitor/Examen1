package iam46258177;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Elemento implements Serializable {
    private int id;
    private String year, season, thumb;
    private SimpleDateFormat simpleDateFormat;

    public Elemento(int id, String year, String season, String thumb) throws Exception {

        try {

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM");
            formatoFecha.setLenient(false);
            formatoFecha.parse(year);
            this.id = id;
            this.year = year;
            this.season = season;
            this.thumb = thumb;

        } catch (ParseException e) {
            throw new Exception("Has introduit malament la data (\"yyyy/MM\")");
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "Foto: Id = " + id + " Year = " + year + " Season = "  + season + " Thumb = " + thumb;
    }
}
