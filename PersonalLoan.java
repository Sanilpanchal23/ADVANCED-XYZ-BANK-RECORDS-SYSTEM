// This class represents an instance of PersonalLoan, a subclass extending the Loan superclass.
public class PersonalLoan extends Loan {

    // Constructor for PersonalLoan instances with no parameters.
    public PersonalLoan() {
    }

    // Constructor for PersonalLoan instances with parameters to initialize loan details.
    public PersonalLoan(String recordID, String loanType, float interestRate, int loanTermLeft, int amountToPay) {
        // Calls the superclass constructor to initialize the loan details.
        super(recordID, loanType, interestRate, loanTermLeft, amountToPay);
    }

    // Overrides the method in the superclass to update loan information specific to PersonalLoan.
    @Override
    public void updateInformation() {
    }

}
