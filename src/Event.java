import java.util.ArrayList;
import java.util.List;

public class Event implements Comparable<Event>{
    //kuupäev ja aeg eraldi
    private String nimi;
    private String kuupäev;
    private String aeg;
    private ArrayList<String> detailid; //nt kontserdi ürituse all {"pileti hind 2 eurot", "võta jope kaasa"}

    public Event(String nimi, String kuupäev, String aeg, ArrayList<String> detailid) {
        this.nimi = nimi;
        this.kuupäev = kuupäev;
        this.aeg = aeg;
        this.detailid = detailid;
    }


    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getKuupäev() {
        return kuupäev;
    }

    public void setKuupäev(String kuupäev) {
        this.kuupäev = kuupäev;
    }

    public String getAeg() {
        return aeg;
    }

    public void setAeg(String aeg) {
        this.aeg = aeg;
    }

    public List<String> getDetailid() {
        return detailid;
    }
    //Setter detailidele ei sobi vist

    @Override
    public String toString() { //Seda võiks sobivamaks muuta
        return "" + nimi + ", " + kuupäev + ", " + aeg + ", " + detailid + "\n";
    }
    public void lisaDetail(String detail){
        detailid.add(detail);
    }
    public void kustutaDetail(String detail){ //Kustuta detail täpse stringi järgi.
        detailid.remove(detail);
    }
    public void kustutaDetail(int indeks){ //Kustuta detail indeksi järgi. Mugavam vist, väljasta detailid ja siis kustuta indeksiga.
        detailid.remove(indeks);
    }

    @Override
    public int compareTo(Event o) { //Kuskil peaks vaja minema
        //Kuupäev kujul DD-MM-YYYY
        //Kellaaeg kujul tunnid:minutid:sekundid.millisekundid
        //convertime kõik millisekunditesse ja võrdleme
        //iga kord pole vaja millisekundites võrrelda, programmi tööaja optimiseerimiseks võrdleme alguses aastaid, kui on samad siis võrdleme kuid jne jne

        String esimesekuupäev = this.getKuupäev();
        String esimesekellaaeg = this.getAeg();
        String[] esimesejupid = esimesekuupäev.split("-");
        String teisekuupäev = o.getKuupäev();
        String teisekellaaeg = o.getAeg();
        String[] teisejupid = teisekuupäev.split("-");
        int esimeseaasta = Integer.parseInt(esimesejupid[2]);
        int teiseaasta = Integer.parseInt(teisejupid[2]);
        if(esimeseaasta>teiseaasta){
            return 1;
        }
        else if(teiseaasta>esimeseaasta){
            return -1;
        }
        else{ //Aastad on võrdsed, võrdleme kuid
            int esimesekuu = Integer.parseInt(esimesejupid[1]);
            int teisekuu = Integer.parseInt(teisejupid[1]);
            if(esimesekuu>teisekuu){
                return 1;
            }
            else if(teisekuu>esimesekuu){
                return -1;
            }
            else{ //Kuud on võrdsed, võrdleme päevi.
                int esimesepäev = Integer.parseInt(esimesejupid[0]);
                int teisepäev = Integer.parseInt(teisejupid[0]);
                if(esimesepäev>teisepäev){
                    return 1;
                }
                else if(teisepäev>esimesepäev){
                    return -1;
                }
                else{ //Päevad on võrdsed, võrdleme tunde.
                    String[] esimeseajajupid = esimesekellaaeg.split(":");
                    String[] teiseajajupid = teisekellaaeg.split(":");
                    int esimesetund = Integer.parseInt(esimeseajajupid[0]);
                    int teisetund = Integer.parseInt(teiseajajupid[0]);
                    if(esimesetund>teisetund){
                        return 1;
                    }
                    else if(teisetund>esimesetund){
                        return -1;
                    }
                    else{ //Tunnid on võrdsed, võrdleme minuteid.
                        int esimeseminut = Integer.parseInt(esimeseajajupid[1]);
                        int teiseminut = Integer.parseInt(teiseajajupid[1]);
                        if(esimeseminut>teiseminut){
                            return 1;
                        }
                        else if(teiseminut>esimeseminut){
                            return -1;
                        }
                        else{ //Minutid on võrdsed, võrdleme sekundeid.
                            String[] esimesesekundjamillisekund = esimeseajajupid[2].split(".");
                            int esimesesekund = Integer.parseInt(esimesesekundjamillisekund[0]);
                            String[] teisesekundjamillisekund = teiseajajupid[2].split(".");
                            int teisesekund = Integer.parseInt(teisesekundjamillisekund[0]);
                            if(esimesesekund>teisesekund){
                                return 1;
                            }
                            else if(teisesekund>esimesesekund){
                                return -1;
                            }
                            else{ //Sekundid on võrdsed, võrdleme millisekundeid.
                                int esimesemillisekund = Integer.parseInt(esimesesekundjamillisekund[1]);
                                int teisemillisekund = Integer.parseInt(teisesekundjamillisekund[1]);
                                if(esimesemillisekund>teisemillisekund){
                                    return 1;
                                }
                                else if(teisemillisekund<esimesemillisekund){
                                    return -1;
                                }
                                else{ //Ajad on täiesti võrdsed.
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    //public abstract void meeldetuletus(String kuupäev, String aeg);

    //if aeg kujul "17:00" siis konstruktor ajaga lihtsalt 17:00
    //if lõpuaeg == alguseaeg , siis see mis üleval



    /*Mõtted:
    konstruktorid
    getterid ja setterid
    evendi lisamise meetod
    event.compareTo(event) ?
       ......
     */



}
