//This class represents an AutoLoan subclass which extends the Loan superclass.
public class AutoLoan extends Loan {

    // The constructor for AutoLoan.
    public AutoLoan() {
    }

    // Initalizes the AutoLoan Subclass.
    public AutoLoan(String recordID, String loanType, float interestRate, int loanTermLeft, int amountToPay) {
        // Calls the superclass constructor to initialize the loan details.
        super(recordID, loanType, interestRate, loanTermLeft, amountToPay);
    }

    // Overriding the method to update information, but leaving it empty as no specific implementation is needed for AutoLoan.
    @Override
    public void updateInformation() {
    }
}
