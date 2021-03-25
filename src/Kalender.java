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
                System.out.println();
                System.out.println("Sisesta ürituse nimi: ");
                String nimi = scanner.nextLine();
                System.out.println("Sisesta kuupäev: ");
                String päev = scanner.nextLine();
                System.out.println("Sisesta aeg: ");
                String aeg = scanner.nextLine();
                System.out.println("Sisesta detailid: ");
                String detail = scanner.nextLine();
                Event uus = new Event(nimi, päev, aeg, Arrays.asList(detail)) {
                    @Override
                    public void meeldetuletus(String päev, String aeg) {
                    }
                };
                evendid.add(uus);
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
