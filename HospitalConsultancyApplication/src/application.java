//Yi Ming Tan
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class application {
    public static void main (String[] args) {
        Practice practice = new Practice(); //creates a practice
        while (true) {
            try {
                //Display Menu
                System.out.println("================================");
                System.out.println("Hospital Consultancy Application");
                System.out.println("================================");
                System.out.println("1. Record a Patient visit\n" +
                        "2. Display all patients of a particular Consultant\n" +
                        "3. Display all Consultants followed by their Patients followed by their visits\n" +
                        "4. Load information from a text file\n" +
                        "5. Quit");

                //getting user menu choice
                Scanner input = new Scanner(System.in);
                int option = input.nextInt();

                if (option == 1) {
                    System.out.println("Enter patient id: ");
                    try {
                        // get patient ID
                        input = new Scanner(System.in);
                        String patientId = input.next();
                        Patient patient = practice.findPatient(patientId);

                        //get visit note
                        LocalDate date = LocalDate.now();
                        System.out.println("Enter visit note: ");
                        Scanner noteInput = new Scanner(System.in);
                        String note = noteInput.nextLine();

                        //add visit
                        patient.addPatientVisit(date, note);

                        System.out.println("Patient visit recorded.\n\n\n");
                    } catch (NullPointerException e) {
                        System.out.println("Patient not found!\n\n\n");
                    }

                } else if (option == 2) {
                    System.out.println("===============");
                    System.out.println("Consultant List");
                    System.out.println("===============");
                    if (practice.getConsultantArrayList().size() != 0) {
                        practice.showConsultantList();
                        System.out.println("Select the consultant by entering Consultant ID: ");
                        try {
                            //get consultant by id
                            input = new Scanner(System.in);
                            String consultantID = input.next();
                            Consultant selectedConsultant = practice.findConsultant(consultantID);

                            //showing all patients of the consultant
                            selectedConsultant.showAllPatients();
                        } catch (NullPointerException e) {
                            System.out.println("Consultant Not found!\n\n\n");
                        }
                    } else {
                        System.out.println("There are no consultants in the record!\n\n\n");
                    }


                } else if (option == 3) {
                    //check if there are any consultants
                    if (practice.getConsultantArrayList().size() != 0) {
                        for (Consultant c : practice.getConsultantArrayList()) {
                            System.out.println(c);
                            c.showAllPatientsAndVisits();
                        }
                    } else {
                        System.out.println("There are no consultants in the record!\n\n\n");
                    }
                } else if (option == 4) {
                    FileReader fileReader = new FileReader("Practice.txt");
                    BufferedReader inputFile = new BufferedReader(fileReader);
                    String line = inputFile.readLine();
                    while (line != null) {
                        String[] data = line.split(",");
                        switch (data[0]) {
                            case "Consultant":
                                Consultant consultant = new Consultant(data[2], data[1], data[3], data[4], data[5]);
                                practice.addConsultant(consultant);
                                break;
                            case "Patient":
                                Patient patient = new Patient(data[2], data[1], data[3], data[4], data[5], Patient.Severity.values()[Integer.parseInt(data[6]) - 1]);
                                //getting the last consultant from the consultant list
                                Consultant lastConsultant = practice.getConsultantArrayList().get(practice.getConsultantArrayList().size() - 1);
                                lastConsultant.addPatient(patient);
                                break;
                            case "Visit":
                                String date = data[1].replace('/', '-');
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                LocalDate formattedDate = LocalDate.parse(date, formatter);
                                String note = data[2];
                                Visit visit = new Visit(formattedDate, note);
                                lastConsultant = practice.getConsultantArrayList().get(practice.getConsultantArrayList().size() - 1);
                                //getting the last patient from the patient list of the last consultant
                                Patient lastPatient = lastConsultant.getPatientArrayList().get(lastConsultant.getPatientArrayList().size() - 1);
                                lastPatient.addVisit(visit);
                                break;
                        }
                        line = inputFile.readLine();
                    }
                    inputFile.close();
                    System.out.println("Data read successfully!\n\n\n");
                } else if (option == 5) {
                    System.out.println("Thank you, goodbye");
                    break;
                } else {
                    System.out.println("Enter integers 1 to 5 only\n\n\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter integers 1 to 5 only\n\n\n");
            } catch (FileNotFoundException e) {
                System.out.println("File not found.\n\n\n");
            } catch(IndexOutOfBoundsException e){
                System.out.println("File input record format incorrect. Please check your input file.\n\n\n");
            } catch (IOException e) {
                System.out.println(e + "\n\n\n");
            }
        }
    }
}
