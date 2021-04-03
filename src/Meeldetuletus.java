import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeldetuletus extends Event{ //abstrakt sest meeldetuletus ei pea implementeerima Comparable
    //Kalendri klassis loo meeldetuletuse objekt ja õigel hetkel väljastab toString meetodi.
    private Date meeldetuletuseAeg;

    public Meeldetuletus(String nimi, String kuupäev, String aeg, ArrayList<String> detailid, Date meeldetuletuseAeg) {
        super(nimi, kuupäev, aeg, detailid);
        this.meeldetuletuseAeg = meeldetuletuseAeg;
    }

    public void setMeeldetuletuseAeg(Date meeldetuletuseAeg) {
        this.meeldetuletuseAeg = meeldetuletuseAeg;
    }

    public Date getMeeldetuletuseAeg() {
        return meeldetuletuseAeg;
    }

    @Override
    public String toString() {
        return "" + getNimi() + "; " + getKuupäev() + "; " + getAeg() + "; " + getDetailid() +"; "+meeldetuletuseAeg+"\n";
    }

    //@Override
    /*public void meeldetuletus(String kuupäev, String aeg){
        //
    }*/

    //new java.sql.Timestamp(System.currentTimeMillis())
    //while (true) {
    //            System.out.println(java.time.LocalTime.now());
    //            try {
    //                this.wait(2000);
    //            } catch (InterruptedException e) {
    //                e.printStackTrace();
    //            }
    //            //if(java.time.LocalTime.now() == "12:07:00.000")
    //        }
    //    }
}
