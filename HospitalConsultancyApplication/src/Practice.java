//Yi Ming Tan
import java.util.ArrayList;

public class Practice {
    private ArrayList<Consultant> consultantArrayList;

    public Practice(){
        this.consultantArrayList = new ArrayList<>();
    }

    public void addConsultant(Consultant consultant) {
        consultantArrayList.add(consultant);
    }

    public void showConsultantList(){
        for (Consultant consultant:consultantArrayList) {
            System.out.println(consultant);
        }
    }

    public Consultant findConsultant(String id) {
        Consultant c = null;
        for(Consultant consultant:consultantArrayList) {
            if(consultant.id.equals(id)){
                c = consultant;
            }
        }
        return c;
    }

    public ArrayList<Consultant> getConsultantArrayList() {
        return consultantArrayList;
    }

    public void setConsultantArrayList(ArrayList<Consultant> consultantArrayList) {
        this.consultantArrayList = consultantArrayList;
    }

    public Consultant findConsultant(Name name) {
        Consultant c = null;
        for(Consultant consultant:consultantArrayList) {
            if(consultant.name.equals(name)){
                c = consultant;
            }
        }
        return c;
    }

    public void showAllConsultantsDetails() {
        for (Consultant c:consultantArrayList){
            System.out.println(c);
        }
    }

    public Patient findPatient(String patientId) {
        Patient p = null;
        for(Consultant consultant:consultantArrayList) {
            for (Patient patient:consultant.getPatientArrayList()){
                if (patient.id.equals(patientId)) {
                    p = patient;
                }
            }
        }
        return p;
    }

    @Override
    public String toString() {
        return "Practice{" +
                "consultantArrayList=" + consultantArrayList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Practice practice = (Practice) o;

        return consultantArrayList.equals(practice.consultantArrayList);
    }

    @Override
    public int hashCode() {
        return consultantArrayList.hashCode();
    }
}
