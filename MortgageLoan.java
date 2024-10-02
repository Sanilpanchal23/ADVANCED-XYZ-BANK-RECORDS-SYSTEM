//This class represents an MortgageLoan subclass which extends the Loan superclass.
public class MortgageLoan extends Loan {
    private float overpaymentOption; // Declare a private field to store the overpayment option for the mortgage loan.

    // The constructor for MortgageLoan.
    public MortgageLoan(String recordID, String loanType, float interestRate, int loantermLeft, int amountToPay) {
    }

    // Initalizes the MortgageLoan Subclass.
    public MortgageLoan(String recordID, String loanType, float interestRate, int loanTermLeft, int amountToPay,
                        float overpaymentOption) {
        // Calls the superclass constructor to initialize the loan details.
        super(recordID, loanType, interestRate, loanTermLeft, amountToPay); // Call the superclass constructor to initialize loan details.
        this.overpaymentOption = overpaymentOption; // Set the overpayment option for the mortgage loan.
    }

    @Override
    public void updateInformation() {
    }

    // Get method for the overpayment option.
    public float getOverpaymentOption() {
        return overpaymentOption; // Return the overpayment option for the mortgage loan.
    }

    // Set method for the overpayment option.
    public void setOverpaymentOption(float overpaymentOption) {
        this.overpaymentOption = overpaymentOption; // Set the overpayment option for the mortgage loan.
    }
}
