public class Semester {
    private int year;
    private season season;

    public enum season{Summer,Spring,Fall};

    public Semester(){
        this.year = -1;
        this.season = null;
    }

    public Semester(String season, String year) {
        this.year = Integer.parseInt(year);
        this.season = this.season.valueOf(season);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSeason(season season) {
        this.season = season;
    }

    public int getYear() {
        return year;
    }

    public Semester.season getSeason() {
        return season;
    }

    @Override

    public boolean equals(Object obj) {
        return( ((Semester)obj).getSeason().equals(season) && ((Semester)obj).getYear()==year);
    }
}
