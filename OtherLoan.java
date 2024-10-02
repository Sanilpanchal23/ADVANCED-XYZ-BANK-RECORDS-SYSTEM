//This class represents an OtherLoan subclass which extends the Loan superclass.
public class OtherLoan extends Loan {

    // The constructor for OtherLoan.
    public OtherLoan() {
    }

    // Initalizes the OtherLoan Subclass.
    public OtherLoan(String recordID, String loanType, float interestRate, int loanTermLeft, int amountToPay) {
        // Calls the superclass constructor to initialize the loan details.
        super(recordID, loanType, interestRate, loanTermLeft, amountToPay);
    }

    // Override method to update loan information for OtherLoan.
    @Override
    public void updateInformation() {
    }

}
