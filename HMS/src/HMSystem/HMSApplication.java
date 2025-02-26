
package HMSystem;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HMSApplication {

    private static PatientDAO patientDAO = new PatientDAO();
    private static DoctorDAO doctorDAO = new DoctorDAO();
    private static AppointmentDAO appointmentDAO = new AppointmentDAO();
    private static StaffDAO staffDAO = new StaffDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("********* Hospital Management System *********");
            System.out.println();
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Manage Staff");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    managePatients();
                    break;
                case 2:
                    manageDoctors();
                    break;
                case 3:
                    manageAppointments();
                    break;
                case 4:
                    manageStaff();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void managePatients() {
        while (true) {
        	
        	System.out.println("-------------------------------");
            System.out.println("Manage Patients");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. View appointment");
            System.out.println("6. Back to Main Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    viewAppointmentsByPatientId();
                    break;
                case 6:
                	System.out.println("Exit manage patients");
                    return;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageDoctors() {
        while (true) {
        	System.out.println("-------------------------------");
            System.out.println("Manage Doctors");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    viewAllDoctors();
                    break;
                case 3:
                    updateDoctor();
                    break;
                case 4:
                    deleteDoctor();
                    break;
                case 5:
                	System.out.println("Exiting Manage Doctors");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageAppointments() {
        while (true) {
        	System.out.println("-------------------------------");
            System.out.println("Manage Appointments");
            System.out.println("1. Book Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookAppointment();
                    break;
                case 2:
                    viewAllAppointments();
                    break;
                case 3:
                    cancelAppointment();
                    break;
                case 4:
                	System.out.println("Exiting Manage Appointments");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void manageStaff() {
        while (true) {
        	System.out.println("-------------------------------");
            System.out.println("Manage Staff");
            System.out.println("1. Add Staff");
            System.out.println("2. View All Staff");
            System.out.println("3. Update Staff");
            System.out.println("4. Delete Staff");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    viewAllStaff();
                    break;
                case 3:
                    updateStaff();
                    break;
                case 4:
                    deleteStaff();
                    break;
                case 5:
                	System.out.println("Exiting Manage Staff");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    // ---------------------------------------- patient ---------------------------------------------------------------

    private static void addPatient() {
        try {
            System.out.print("Enter first name: ");
            String fname = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lname = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();
            System.out.print("Enter contact number: ");
            String contactNumber = scanner.nextLine();

            Patient patient = new Patient(0, fname, lname, age, gender, contactNumber);
            patientDAO.addPatient(patient);
            System.out.println("Patient added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewAllPatients() {
        try {
            List<Patient> patients = patientDAO.getAllPatients();
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updatePatient() {
        try {
            System.out.print("Enter patient ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new first name: ");
            String fname = scanner.nextLine();
            System.out.print("Enter new last name: ");
            String lname = scanner.nextLine();
            System.out.print("Enter new age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new gender: ");
            String gender = scanner.nextLine();
            System.out.print("Enter new contact number: ");
            String contactNumber = scanner.nextLine();

            Patient patient = new Patient(id, fname, lname, age, gender, contactNumber);
            patientDAO.updatePatient(patient);
            System.out.println("Patient updated successfully.");
        } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   private static void deletePatient() {
       try {
           System.out.print("Enter patient ID to delete: ");
           int id = scanner.nextInt();
           scanner.nextLine();

           patientDAO.deletePatient(id);
           System.out.println("Patient deleted successfully.");
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   private static void viewAppointmentsByPatientId() {
       try {
           System.out.print("Enter patient ID to view appointments: ");
           int patientId = scanner.nextInt();
           scanner.nextLine(); // Consume newline

           List<Appointment> appointments = appointmentDAO.getAppointmentsByPatientId(patientId);
           for (Appointment appointment : appointments) {
               System.out.println(appointment);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   // ------------------------------------ doctor -------------------------------------------------------

   private static void addDoctor() {
       try {
           System.out.print("Enter doctor's name: ");
           String name = scanner.nextLine();
           System.out.print("Enter speciality: ");
           String speciality = scanner.nextLine();
           System.out.print("Enter contact number: ");
           String contact = scanner.nextLine();

           Doctor doctor = new Doctor(0, name, speciality, contact);
           doctorDAO.addDoctor(doctor);
           System.out.println("Doctor added successfully.");
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   private static void viewAllDoctors() {
       try {
           List<Doctor> doctors = doctorDAO.getAllDoctors();
           for (Doctor doctor : doctors) {
               System.out.println(doctor);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   private static void updateDoctor() {
       try {
           System.out.print("Enter doctor ID to update: ");
           int id = scanner.nextInt();
           scanner.nextLine();

           System.out.print("Enter new name: ");
           String name = scanner.nextLine();
           System.out.print("Enter new speciality: ");
           String speciality = scanner.nextLine();
           System.out.print("Enter new contact number: ");
           String contact = scanner.nextLine();

           Doctor doctor = new Doctor(id, name, speciality, contact);
           doctorDAO.updateDoctor(doctor);
           System.out.println("Doctor updated successfully.");
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   private static void deleteDoctor() {
       try {
           System.out.print("Enter doctor ID to delete: ");
           int id = scanner.nextInt();
           scanner.nextLine();

           doctorDAO.deleteDoctor(id);
           System.out.println("Doctor deleted successfully.");
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   
   //--------------------------------------- appointment ------------------------------------------

   private static void bookAppointment() {
       try {
           System.out.print("Enter patient ID: ");
           int patientId = scanner.nextInt();
           scanner.nextLine();

           System.out.print("Enter doctor ID: ");
           int doctorId = scanner.nextInt();
           scanner.nextLine();

           System.out.print("Enter appointment date: ");
           String dateStr = scanner.nextLine();

           Date appointmentDate = Date.valueOf(dateStr);

           System.out.print("Enter reason for appointment: ");
           String reason = scanner.nextLine();

           Appointment appointment = new Appointment(0, patientId, doctorId, appointmentDate, reason);
           appointmentDAO.bookAppointment(appointment);
       } catch (SQLException e) {
          e.printStackTrace(); 
      }
  }

  private static void viewAllAppointments() { 
      try { 
          List<Appointment> appointments=appointmentDAO.getAllAppointments(); 
          for(Appointment appointment : appointments){ 
              System.out.println(appointment); 
          } 
      }catch(SQLException e){ 
          e.printStackTrace(); 
      } 
  }

  private static void cancelAppointment(){ 
      try{ 
          System .out .print ("Enter appointment ID to cancel: "); 
          int id=scanner .nextInt (); 
          scanner .nextLine (); 

          appointmentDAO.cancelAppointment(id); 
          System .out .println ("Appointment canceled successfully."); 
      }catch(SQLException e){ 
          e .printStackTrace (); 
      } 
  }
  
  // --------------------------- staff ----------------------------------------------
  private static void addStaff(){

      try{
          System.out.println("Enter staff's name: "); 
          String name=scanner.nextLine(); 
          System.out.println("Enter role: ");
          String role=scanner.nextLine(); 
          System.out.print ("Enter contact number: ");
          String contactNumber=scanner.nextLine();
          Staff staff=new Staff(0,name,role,contactNumber); 
          staffDAO.addStaff(staff); 
          System.out.println ("Staff added successfully.");

         }catch(SQLException e) {
        	 e.printStackTrace();
         }

      }
  private static void viewAllStaff(){

      try{

          List<Staff> staffList=staffDAO.getAllStaff(); 
          for(Staff staff : staffList){
        	  System.out.println (staff);

              }

              }catch(SQLException e){
                  e.printStackTrace();
                  }

           }
  
  private static void updateStaff(){

      try{

          System.out.println("Enter staff ID to update: ");
          int id=scanner.nextInt(); 
          scanner.nextLine();

          System.out.println("Enter new name: ");

          String name=scanner.nextLine();
          System.out.println("Enter new role: ");

          String role=scanner.nextLine(); 
          System.out.println("Enter new contact number: ");

          String contactNumber=scanner.nextLine();

          Staff staff=new Staff(id,name,role,contactNumber); 
          staffDAO.updateStaff(staff);
          System.out.println("Staff updated successfully.");

              }catch(SQLException e){
            	  e.printStackTrace();
                  }

               }
  private static void deleteStaff(){

      try{

          	System.out.println("Enter staff ID to delete: "); 
          	int id=scanner.nextInt(); 
          	scanner.nextLine();
          	staffDAO.deleteStaff(id); 
          	System.out.println ("Staff deleted successfully.");
          }catch(SQLException e){

              e.printStackTrace();

              }

           }

             
}
