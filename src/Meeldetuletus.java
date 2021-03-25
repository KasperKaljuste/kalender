import java.time.LocalTime;
import java.util.List;

public abstract class Meeldetuletus extends Event{ //abstrakt sest meeldetuletus ei pea implementeerima Comparable
    //Kalendri klassis loo meeldetuletuse objekt ja õigel hetkel väljastab toString meetodi.
    private LocalTime meeldetuletuseAeg;

    public Meeldetuletus(String nimi, String kuupäev, String aeg, List<String> detailid, LocalTime meeldetuletuseAeg) {
        super(nimi, kuupäev, aeg, detailid);
        this.meeldetuletuseAeg = meeldetuletuseAeg;
    }

    @Override
    public void meeldetuletus(String kuupäev, String aeg){
        //
    }

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
