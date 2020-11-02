package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetna, krajnja;
    boolean pripadaPocetna, pripadaKrajnja;


    public Interval(double pocetak, double kraj, boolean ukljucenPocetak, boolean ukljucenKraj){
        if(kraj < pocetak)
            throw new IllegalArgumentException();
        this.pocetna = pocetak;
        this.krajnja = kraj;
        this.pripadaPocetna = ukljucenPocetak;
        this.pripadaKrajnja = ukljucenKraj;
    }
    public Interval(){
        pocetna = 0; krajnja = 0;
        pripadaKrajnja = false; pripadaPocetna = false;
    }

    public static Interval intersect(Interval i, Interval i2) {
        return i.intersect(i2);
    }

    public boolean isNull(){
        if(pocetna == 0 && krajnja == 0)
            return true;
        return false;
    }

    public boolean isIn(double tocka) {
        if(tocka >= pocetna && tocka <= krajnja){
            if((pocetna == tocka && !pripadaPocetna) || (krajnja == tocka && !pripadaKrajnja))
                return false;
        }
        return true;
    }

    public Interval intersect(Interval interval1) {
        Interval presjek = new Interval();
        if(interval1.krajnja <= this.pocetna || interval1.pocetna >= this.krajnja){
            if(this.krajnja == interval1.pocetna && this.pripadaKrajnja && interval1.pripadaPocetna)
                return new Interval(this.krajnja, this.krajnja, true, true);
        }
        if(interval1.pocetna < this.krajnja){
            presjek.pocetna=interval1.pocetna;
            presjek.pripadaPocetna=interval1.pripadaPocetna;
        }
        else if(this.pocetna < interval1.krajnja){
            presjek.pocetna=this.pocetna;
            presjek.pripadaPocetna=this.pripadaPocetna;
        }
        if(interval1.krajnja > this.pocetna ){
            presjek.krajnja = interval1.krajnja;
            presjek.pripadaKrajnja = interval1.pripadaKrajnja;
        }
        else if(this.krajnja > interval1.pocetna ){
            presjek.krajnja = this.krajnja;
            presjek.pripadaKrajnja = this.pripadaKrajnja;
        }

        return presjek;
    }

    public String toString(){
        String s = new String();
        if(pocetna == 0 && krajnja == 0)
            return new String("()");
        if(pripadaPocetna)
            s = s + "[";
        else
            s = s + "(";
        s = s + pocetna + "," + krajnja;
        if(pripadaKrajnja)
            s = s + "]";
        else
            s = s + ")";
        return s;
    }

    public double getPocetna() {
        return pocetna;
    }

    public double getKrajnja() {
        return krajnja;
    }



}
