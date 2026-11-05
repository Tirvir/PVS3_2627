package vyuka.Exams.inheritance;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

// Načtěte ze souboru hospitalData informace o doktorech
// do souboru hospital.txt vypiste nasledujici informace o vsech doktorech:

// 1. Doktora s nejvetsim vydelkem
// 2. Doktora s nejmensjim vydelkem
// 3. Prumerny plat v nemocnici
// 4. Pocet realizovanych operací srdce
// 5. Pocet udelenych penalizaci nemocnici
//     - Nemocnice je penalizovana za kazdy zakrok doktora, na ktery nema kvalifikaci

// Bonus:
//   Vypiste 5 nejlepe placenych doktoru v nemocnici
//   Procentualni zastoupeni zamestnancu. (příklad: 50% Doktoři, 35% Chirurgové, 15% Kardiochirurgové)
//   Kdo způsobil největší penalizaci nemocnici

public class Hospital {
    static int penaltiesNumber = 0;
    static void validateJob(Doctor d, String[] jobs) {
        // TODO: implementujte logiku validace práce:
        // Doktor může dělat práci typu `jobType` jen pokud je kvalifikovan
        // C -> cardiacSurgery
        // S -> surgery
        // D -> diagnose
        for (int i = 0; i < jobs.length; i++) {
            switch (jobs[i]) {
                case "C":
                    if (d instanceof CardiacSurgeon){
                        ((CardiacSurgeon) d).cardiacSurgery();
                    } else penaltiesNumber++;
                    break;
                case "S":
                    if (d instanceof Surgeon){
                        ((Surgeon) d).surgery();
                    } else penaltiesNumber++;
                    break;
                case "D":
                    d.diagnose();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("data/hospital.txt");
        ArrayList<Doctor> doctors = new ArrayList<>();
        int j = 0;
        String line;
        String[] tokens;
        while(di.hasNext()){
            line = di.readLine();
            tokens = line.split(";");
            switch(tokens[1]){
                case "CardiacSurgeon":
                    doctors.add(new CardiacSurgeon(tokens[0]));
                    break;
                case "Surgeon":
                    doctors.add(new Surgeon(tokens[0]));
                    break;
                default:
                    doctors.add(new Doctor(tokens[0]));
                    break;
            }
            Doctor currentDoctor = doctors.get(j);
            j++;
            validateJob(currentDoctor,tokens);


        }
        Doctor richestDoctor = doctors.getFirst();
        Doctor poorestDoctor =doctors.getFirst();
        int wholeSalary = 0;
        for (int i = 0; i < doctors.size(); i++) {
            if (richestDoctor.salary<doctors.get(i).salary){
                richestDoctor=doctors.get(i);
            }
            if (poorestDoctor.salary>doctors.get(i).salary){
                poorestDoctor=doctors.get(i);
            }
            wholeSalary +=doctors.get(i).salary;
        }
        double averageSalary = (double)wholeSalary/doctors.size();
        de.writeLine("The richest doctor is "+richestDoctor);
        de.writeLine("The poorest doctor is "+poorestDoctor);
        de.writeLine("The average salary is "+averageSalary);
        de.writeLine("The number of performed cardiac surgeries is "+CardiacSurgeon.CardiacSurgeries);
        de.writeLine("The number of hospital penalties is "+penaltiesNumber);
        // TODO: napsat test

        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }
}
