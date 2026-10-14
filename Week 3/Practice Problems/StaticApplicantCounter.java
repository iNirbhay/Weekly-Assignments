class Applicant {
    static int totalApplicants = 0;

    Applicant() {
        totalApplicants++;
    }
}

public class StaticApplicantCounter {
    public static void main(String[] args) {
        Applicant applicant1 = new Applicant();
        Applicant applicant2 = new Applicant();
        Applicant applicant3 = new Applicant();

        System.out.println("Total applicants: " + Applicant.totalApplicants);
    }
}
