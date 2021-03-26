import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kalender {
    //Kuidas teha nii, et küsib lõpmatult kasutaja käest sisestust.
    public static void main(String[] args) {
        Kell kell = new Kell();
        Kuupäev kuupäev = new Kuupäev();
        String state = new String();
        state = ""; //Algne state on tühi ehk näitab kuupäeva
        Scanner scanner = new Scanner(System.in);
        List<Event> evendid = new ArrayList<>();

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

        //Veel edasi juhised kõige muu jaoks: väljasta evendid, kindla evendi info jne jne

        while (true) {
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
                LocalTime meeldetuletuseAeg = LocalTime.parse("00:00:00.000000000");
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
                        else{ //Siin on midagi valesti, ta lisab 2x detaili ühele evendile.
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
                else{
                    System.out.println("Sisestage meeldetuletus formaadis tund:minut:sekund.millisekund (näiteks 13:04:30.000): ");
                    String meeldetuletusvastus = scanner.nextLine();
                    uus2.setMeeldetuletuseAeg(LocalTime.parse(meeldetuletusvastus));
                    evendid.add(uus2);
                }
                System.out.println(evendid);
                state = ""; //Esialgsesse state tagasi
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
