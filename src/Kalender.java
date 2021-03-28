import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;


public class Kalender {
    /*boolean isNowBetweenDateTime(final Date s, final Date e)
    {
        final Date now = new Date();
        return now.after(s) && now.before(e);
    }

    public static void meeldetuletusjooksvalt() throws Exception{
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date tuletameelde = formatter.parse("2021-03-28 at 15:08:00");
        while(true){
            Date praeguneAeg = new Date(System.currentTimeMillis());
            if (formatter.format(praeguneAeg).equals(tuletameelde))
                System.out.println("MEELDETULETUS!");
        }
    }*/
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
                    String[] tükid = rida.split(", ");
                    String asenda1 = tükid[3].replace("[","");
                    String asenda2 = asenda1.replace("]","");
                    ArrayList<String> detailidFailist = new ArrayList<String>(Arrays.asList(asenda2.split(",")));
                    Event failistLoetudEvent = new Event(tükid[0], tükid[1], tükid[2], detailidFailist);
                    evendid.add(failistLoetudEvent);
                }
            }
        } catch (IOException e) {
            System.out.println("Error faili tegemisel");
            e.printStackTrace();
        }



        //Thread t1 = new Thread(){
            //public void run(){
                //try {
                /*for (Event event : evendid) {
                   if(event instanceof Meeldetuletus){ //Kui event on Meeldetuletus objekt, siis tal on meeldetuletuse aeg
                       Timer timer = new Timer();
                       Date aeg = ((Meeldetuletus) event).getMeeldetuletuseAeg();
                       timer.schedule(new TimerTask() {
                           public void run() {
                               System.out.println("MEELDETULETUS!");
                               cancel();
                           }
                       },new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss").parse("2021-03-28 at 16:13:00"));
                   }
                }*/
                    //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
                    //Date tuletameelde = formatter.parse("2021-03-28 at 16:00:00");
                    //Timer timer = new Timer();
                    //while (true) {
                        /*//Date praeguneAeg = new Date(System.currentTimeMillis());
                        Calendar praeguneAeg = Calendar.getInstance();
                        praeguneAeg.set(Calendar.MILLISECOND, 0);
                        //if (formatter.format(praeguneAeg).equals(tuletameelde.toString())) {
                        if(praeguneAeg.equals(tuletameelde)){
                            System.out.println("MEELDETULETUS!");
                        }*/
                    /*timer.schedule(new TimerTask() {
                        public void run() {
                            System.out.println("MEELDETULETUS!");
                            cancel();
                        }
                    },new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss").parse("2021-03-28 at 16:13:00"));*/
                    //}
                //}
                //catch(ParseException e){
                    //System.out.println("Error");
                //}
            //}
        //};
        //t1.start();
        
        
        
        
        //Väljastab evendid järjestatult compareTo
        //List<Event>
        //for each event kalendrist
        //Küsib sisestust, mida teha
        //Lisa event new Event
        //Täpsem info evendi kohta event.toString
        //Kindla päeva evendid
        //Sobivad ajad?
        //Randomiga valib programm aja sobivate aegade seast
        //Otsi nime järgi
        //Kustuta event
        //getterid ja setterid iga asja kohta, lisa detaile jne


        //Meeldetuletusega evendi puhul: Event objekti asemel loo Meeldetuletus objekt
        //Selle saab ka lisada List<Event> hulka.
        //Kuidagimoodi saaks kasutada Eventi compareTo meetodit või luua sarnane meetod
        //mis võrdleks Meeldetuletus objekti isendivälja LocalTime meeldetuletuseAeg väärtust
        //konstantselt java.time.LocalTime.now() väärtusega. Kui väärtused on võrdsed, siis väljastab
        //meeldetuletuse sõnumi.


        System.out.println("KALENDER");
        System.out.println("Autorid: Kasper Kaljuste ja Karl-Magnus Laikoja");
        System.out.println("Juhised:");
        System.out.println("Praeguse kuupäeva väljastamiseks sisestage \"kuupäev\"");
        System.out.println("Praeguse kellaaja väljastamiseks sisestage \"kell\"");
        System.out.println("Sündmuse lisamise alustamiseks sisestage \"lisa\"");
        System.out.println("Sündmuste salvestamiseks sisestage \"salvesta\"");
        System.out.println("Sündmuste väljastamiseks sisestage \"väljasta\"");

        //Veel edasi juhised kõige muu jaoks: väljasta evendid, kindla evendi info jne jne



        while (true) {

            for (Event event : evendid) {
                if(event instanceof Meeldetuletus){ //Kui event on Meeldetuletus objekt, siis tal on meeldetuletuse aeg
                    Timer timer = new Timer();
                    Date aeg = ((Meeldetuletus) event).getMeeldetuletuseAeg();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            System.out.println("MEELDETULETUS! "+ event.toString());
                            cancel();
                        }
                    },aeg);
                }
            }



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
            else if (state.equals("lisa")) { //Saab lisada evendi hetkel ainult ühe detailiga
                //Tegin detaili sisestamise optionaliks ning võimalik mitu sisestada.
                //Mis kujul peab kasutaja vastuseid andma?
                System.out.println();
                System.out.println("Sisesta ürituse nimi: ");
                String nimi = scanner.nextLine();
                System.out.println("Sisesta kuupäev: ");
                String päev = scanner.nextLine();
                System.out.println("Sisesta aeg: ");
                String aeg = scanner.nextLine();
                System.out.println("Kas soovite lisada detaile (jah/ei)?: ");
                String vastus = scanner.nextLine();
                ArrayList<String> detailidelist = new ArrayList<String>();
                Event uus = new Event(nimi, päev, aeg, detailidelist);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
                //DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                Date meeldetuletuseAeg = format.parse("0000-01-01 at 00:00:00");
                //Date meeldetuletuseKuupäev = format2.parse("2000-01-01");
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
                        else{ //Siin on midagi valesti, ta lisab 2x detaili ühele evendile. Vist korras
                            uus.lisaDetail(detailvastus);
                            uus2.lisaDetail(detailvastus);
                        }
                    }
                }
                System.out.println("Kas soovite lisada meeldetuletuse (jah/ei) ?: "); //Seda võiks võimalusel nii muuta, et saab panna mitu meeldetuletust
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
                System.out.println(evendid);
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
