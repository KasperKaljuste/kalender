import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Kalender {

    public static String suvalineAeg(){
        int tund = (int)(Math.random()*25);
        int minut = (int)(Math.random()*61);
        String tagastatav = tund+":"+minut;
        return tagastatav;
    }
    public static void main(String[] args) throws Exception{
        

        Kell kell = new Kell();
        Kuupäev kuupäev = new Kuupäev();
        String state = new String();
        state = ""; //Algne state on tühi ehk näitab kuupäeva
        Scanner scanner = new Scanner(System.in);
        List<Event> evendid = new ArrayList<>();

        try {
            File evendidFail = new File("evendid.txt");
            if (evendidFail.createNewFile()) {
                System.out.println("File tehtud: " + evendidFail.getName());
            } else {
                System.out.println("Fail on olemas, loen evendid programmi");
                FileInputStream evendidInput=new FileInputStream("evendid.txt");
                Scanner sc=new Scanner(evendidInput);    //file to be scanned
                while(sc.hasNextLine()){
                    String rida = sc.nextLine();
                    String[] tükid = rida.split("; ");
                    String asenda1 = tükid[3].replace("[","");
                    String asenda2 = asenda1.replace("]","");
                    ArrayList<String> detailidFailist = new ArrayList<String>(Arrays.asList(asenda2.split(", ")));
                    if(tükid.length==4) {
                        Event failistLoetudEvent = new Event(tükid[0], tükid[1], tükid[2], detailidFailist);
                        evendid.add(failistLoetudEvent);
                    }
                    else{ //meeldetuletus on ka
                        SimpleDateFormat failistFormaat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
                        Date meeldetuletusFailist = failistFormaat.parse(tükid[4]);
                        Meeldetuletus failistLoetudEvent = new Meeldetuletus(tükid[0], tükid[1], tükid[2], detailidFailist, meeldetuletusFailist);
                        evendid.add(failistLoetudEvent);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error faili tegemisel");
            e.printStackTrace();
        }





        System.out.println("KALENDER");
        System.out.println("Autorid: Kasper Kaljuste ja Karl-Magnus Laikoja");
        System.out.println("Juhised:");
        System.out.println("Praeguse kuupäeva väljastamiseks sisestage \"kuupäev\"");
        System.out.println("Praeguse kellaaja väljastamiseks sisestage \"kell\"");
        System.out.println("Sündmuse lisamise alustamiseks sisestage \"lisa\"");
        System.out.println("Sündmuste salvestamiseks sisestage \"salvesta\"");
        System.out.println("Sündmuste väljastamiseks sisestage \"väljasta\"");
        System.out.println("Sündmuse muutmise alustamiseks sisestage \"muuda\"");
        System.out.println("Sündmuse kustutamiseks sisestage \"kustuta\"");



        //boolean meeldetuletusVäljastatud = false;
        while (true) {
            //if(meeldetuletusVäljastatud==false) {
            Kuupäev täna = new Kuupäev();
            Kell praegu = new Kell();
            String tänanekuupäev = täna.getTäna();
            String[] tänanekuupäevjupid = tänanekuupäev.split(" ");
            String praegunePäev = tänanekuupäevjupid[1];
            String praeguneAasta = tänanekuupäevjupid[3];
            String praeguneKuu = "";
            if(tänanekuupäevjupid[2].equals("jaanuar"))
                praeguneKuu = "01";
            if(tänanekuupäevjupid[2].equals("veebruar"))
                praeguneKuu = "02";
            if(tänanekuupäevjupid[2].equals("märts"))
                praeguneKuu = "03";
            if(tänanekuupäevjupid[2].equals("aprill"))
                praeguneKuu = "04";
            if(tänanekuupäevjupid[2].equals("mai"))
                praeguneKuu = "05";
            if(tänanekuupäevjupid[2].equals("juuni"))
                praeguneKuu = "06";
            if(tänanekuupäevjupid[2].equals("juuli"))
                praeguneKuu = "07";
            if(tänanekuupäevjupid[2].equals("august"))
                praeguneKuu = "08";
            if(tänanekuupäevjupid[2].equals("september"))
                praeguneKuu = "09";
            if(tänanekuupäevjupid[2].equals("oktoober"))
                praeguneKuu = "10";
            if(tänanekuupäevjupid[2].equals("november"))
                praeguneKuu = "11";
            if(tänanekuupäevjupid[2].equals("detsember"))
                praeguneKuu = "12";
            String praeguneKuupäev = praegunePäev+"."+praeguneKuu+"."+praeguneAasta;
            Event praeguneHetk = new Event("", praeguneKuupäev, praegu.getKell(), new ArrayList<>());
            for (Event event : evendid) {
                if (event instanceof Meeldetuletus) { //Kui event on Meeldetuletus objekt, siis tal on meeldetuletuse aeg
                    Date evendiMeeldetuletus = ((Meeldetuletus) event).getMeeldetuletuseAeg();
                    String evendiMeeldetuletusStringina = evendiMeeldetuletus.toString();
                    //Mon Apr 05 17:28:00 EEST 2021
                    String[] evendiMeeldetuletusjupid = evendiMeeldetuletusStringina.split(" ");
                    String meeldetuletuseAeg = evendiMeeldetuletusjupid[3].substring(0, 5);
                    String aasta = evendiMeeldetuletusjupid[5];
                    String päev = evendiMeeldetuletusjupid[2];
                    String kuu = "00";
                    if(evendiMeeldetuletusjupid[1].equals("Jan"))
                        kuu = "01";
                    if(evendiMeeldetuletusjupid[1].equals("Feb"))
                        kuu = "02";
                    if(evendiMeeldetuletusjupid[1].equals("Mar"))
                        kuu = "03";
                    if(evendiMeeldetuletusjupid[1].equals("Apr"))
                        kuu = "04";
                    if(evendiMeeldetuletusjupid[1].equals("May"))
                        kuu = "05";
                    if(evendiMeeldetuletusjupid[1].equals("Jun"))
                        kuu = "06";
                    if(evendiMeeldetuletusjupid[1].equals("Jul"))
                        kuu = "07";
                    if(evendiMeeldetuletusjupid[1].equals("Aug"))
                        kuu = "08";
                    if(evendiMeeldetuletusjupid[1].equals("Sep"))
                        kuu = "09";
                    if(evendiMeeldetuletusjupid[1].equals("Oct"))
                        kuu = "10";
                    if(evendiMeeldetuletusjupid[1].equals("Nov"))
                        kuu = "11";
                    if(evendiMeeldetuletusjupid[1].equals("Dec"))
                        kuu = "12";

                    String meeldetuletuseKuupäev = päev+"."+kuu+"."+aasta;
                    Event evendiMeeldetuletusEvendina = new Event("", meeldetuletuseKuupäev, meeldetuletuseAeg, new ArrayList<>());
                    if (evendiMeeldetuletusEvendina.compareTo(praeguneHetk) == 1) {
                        Timer timer = new Timer();
                        Date aeg = ((Meeldetuletus) event).getMeeldetuletuseAeg();
                        timer.schedule(new TimerTask() {
                            public void run() {
                                System.out.println("MEELDETULETUS! " + event.toString());
                                cancel();
                            }
                        }, aeg);
                    }
                }
            }
                //meeldetuletusVäljastatud = true;
            //}

            if (state.equals("") || state.equals("kuupäev")) {
                System.out.print("\r" + kuupäev.getTäna());
                System.out.println();
                state = scanner.nextLine(); //Mis state järgmises tsüklis läheb
                System.out.println("Valisite: " + state);
            }
            else if (state.equals("kell")) {
                System.out.print("\r" + kell.getKell());
                System.out.println();
                state = scanner.nextLine(); //Mis state järgmises tsüklis läheb
                System.out.println("Valisite: " + state);
            }
            else if(state.equals("salvesta")){
                try {
                    FileWriter evendiKirjutaja = new FileWriter("evendid.txt");
                    for (Event event:evendid) {
                        evendiKirjutaja.write(event.toString());
                    }

                    evendiKirjutaja.close();
                    System.out.println("Kirjutasin evendid faili.");
                } catch (IOException e) {
                    System.out.println("Error faili kirjutamisel.");
                    e.printStackTrace();
                }
                state="";
            }
            else if (state.equals("lisa")) {

                System.out.println();
                System.out.println("Sisesta ürituse nimi: ");
                String nimi = scanner.nextLine();
                System.out.println("Sisesta kuupäev kujul päev.kuu.aasta : ");
                String päev = scanner.nextLine();
                System.out.println("Sisesta aeg kujul tunnid:minutid, kui soovite lasta programmil aja valida, sisestage \"suvaline\": ");
                String aegvastus = scanner.nextLine();
                String aeg = aegvastus;
                if(aegvastus.equals("suvaline")){
                    aeg = suvalineAeg();
                    System.out.println("Arvuti valis ajaks: "+aeg);
                }
                System.out.println("Kas soovite lisada detaile (jah/ei)?: ");
                String vastus = scanner.nextLine();
                ArrayList<String> detailidelist = new ArrayList<String>();
                Event uus = new Event(nimi, päev, aeg, detailidelist);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
                Date meeldetuletuseAeg = format.parse("0000-01-01 at 00:00:00");
                Meeldetuletus uus2 = new Meeldetuletus(nimi, päev, aeg, detailidelist, meeldetuletuseAeg);
                if(vastus.equals("jah")){
                    boolean tingimus = true;
                    System.out.println("Sisestage ükshaaval detaile. Kui rohkem pole vaja lisada, kirjutage \"lõpeta\"");
                    while(tingimus==true){
                        String detailvastus = scanner.nextLine();
                        if(detailvastus.equals("lõpeta")){
                            tingimus = false;
                            break;
                        }
                        else{
                            uus2.lisaDetail(detailvastus); //uus2-le lisamine lisab ka uus-le
                        }
                    }
                }
                System.out.println("Kas soovite lisada meeldetuletuse (jah/ei) ?: ");
                String meeldetuletusjahei = scanner.nextLine();
                if(meeldetuletusjahei.equals("ei")) {
                    evendid.add(uus);
                }
                else if(meeldetuletusjahei.equals("jah")){
                    System.out.println("Sisestage meeldetuletuse aeg formaadis aasta-kuu-päev at tund:minut:sekund (näiteks 2021-12-01 at 12:00:00): ");
                    String meeldetuletusaegvastus = scanner.nextLine();
                    Date meeldetuletusaeg = format.parse(meeldetuletusaegvastus);
                    uus2.setMeeldetuletuseAeg(meeldetuletusaeg);
                    evendid.add(uus2);
                }
                else{
                    System.out.println("Vigane sisestus.");
                }
                System.out.println(evendid);
                state = ""; //Esialgsesse state tagasi
            }
            else if (state.equals("väljasta")) {
                Collections.sort(evendid);
                System.out.println(evendid);
                state = "";
            }
            else if (state.equals("kustuta")){
                System.out.println("Millist sündmust soovite kustutada(sisestage nimi või indeks): ");
                String kustutaVastus = scanner.nextLine();
                try{
                    evendid.remove(Integer.parseInt(kustutaVastus)); //indeksi järgi
                }
                catch(Exception d){
                    for (Event event : evendid) { //nime järgi
                        if(event.getNimi().equals(kustutaVastus)){
                            evendid.remove(event);
                            break;
                        }
                    }
                }
                state="";
            }
            else if(state.equals("muuda")){
                System.out.println("Sisestage sündmuse nimi, mida soovite muuta: ");
                String muudetavaNimi = scanner.nextLine();
                boolean lõpetamiseTingimus = false;
                while(lõpetamiseTingimus==false) {
                    System.out.println("Sündmuse muutmise lõpetamiseks sisestage: \"lõpeta\"");
                    System.out.println("Mida soovite sündmuse juures muuta (sisestage \"nimi\", \"kuupäev\", \"aeg\", \"detail\" või \"meeldetuletus\")");
                    String muutmisevastus = scanner.nextLine();
                    if (muutmisevastus.equals("lõpeta")) {
                        lõpetamiseTingimus=true;
                        break;
                    }
                    else if (muutmisevastus.equals("nimi")){
                        System.out.println("Sisestage uus nimi: ");
                        String uusnimi = scanner.nextLine();
                        for (Event event : evendid) {
                            if(event.getNimi().equals(muudetavaNimi)){
                                event.setNimi(uusnimi);
                            }
                        }
                    }
                    else if (muutmisevastus.equals("kuupäev")){
                        System.out.println("Sisestage uus kuupäev kujul päev.kuu.aasta: ");
                        String uuskuupäev = scanner.nextLine();
                        for (Event event : evendid) {
                            if(event.getNimi().equals(muudetavaNimi)){
                                event.setKuupäev(uuskuupäev);
                            }
                        }
                    }
                    else if (muutmisevastus.equals("aeg")){
                        System.out.println("Sisestage uus aeg kujul tunnid:minutid: ");
                        String uusaeg = scanner.nextLine();
                        for (Event event : evendid) {
                            if(event.getNimi().equals(muudetavaNimi)){
                                event.setAeg(uusaeg);
                            }
                        }
                    }
                    else if (muutmisevastus.equals("detail")){
                        System.out.println("Kas soovite detaili lisada või kustutada (\"lisa\"/\"kustuta\"): ");
                        String detailimuutmisevastus = scanner.nextLine();
                        if (detailimuutmisevastus.equals("lisa")){
                            System.out.println("Sisestage lisatav detail: ");
                            String uusdetail = scanner.nextLine();
                            for (Event event : evendid) {
                                if(event.getNimi().equals(muudetavaNimi)){
                                    event.lisaDetail(uusdetail);
                                }
                            }
                        }
                        else if (detailimuutmisevastus.equals("kustuta")){
                            System.out.println("Sisestage kustutatav detail kas nime või indeksi järgi: ");
                            String kustutatavdetail = scanner.nextLine();
                            try{
                                int kustutatavaindeks = Integer.parseInt(kustutatavdetail);
                                for (Event event : evendid) {
                                    if(event.getNimi().equals(muudetavaNimi)){
                                        event.kustutaDetail(kustutatavaindeks);
                                    }
                                }
                            }
                            catch(Exception e){
                                for (Event event : evendid) {
                                    if(event.getNimi().equals(muudetavaNimi)){
                                        event.kustutaDetail(kustutatavdetail);
                                    }
                                }
                            }
                        }
                        else{
                            System.out.println("Vigane sisestus.");
                        }
                    }
                    else if (muutmisevastus.equals("meeldetuletus")){
                        //Loo uus Meeldetuletus, kustuta vana event ja pane asemele Meeldetuletus
                        System.out.println("Sisestage meeldetuletuse aeg kujul aasta-kuu-päev at tund:minut:sekund");
                        String Mvastus = scanner.nextLine();
                        SimpleDateFormat formaat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
                        Date Mmeeldetuletus = formaat.parse(Mvastus);
                        String Mnimi = "";
                        String Mkuupäev = "";
                        String Maeg = "";
                        ArrayList<String> Mdetailid = new ArrayList<>();

                        for (Event event : evendid) {
                            if(event.getNimi().equals(muudetavaNimi)){
                                Mnimi = event.getNimi();
                                Mkuupäev = event.getKuupäev();
                                Maeg = event.getAeg();
                                Mdetailid = event.getDetailid();
                                evendid.remove(event); //eemaldame evendi
                                break;
                            }
                        }
                        Meeldetuletus uusM = new Meeldetuletus(Mnimi, Mkuupäev, Maeg, Mdetailid, Mmeeldetuletus);
                        evendid.add(uusM); //lisame asemele Meeldetuletuse
                    }
                    else{
                        System.out.println("Vigane sisestus.");
                    }
                }
                state = "";
            }
            else{
                state = ""; //Kui kirjutatakse mingi suvaline käsklus siis läheb ka esialgsesse state tagasi
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
