// This class represents a specific type of loan called BuilderLoan, which is a subclass of the Loan superclass.
public class BuilderLoan extends Loan {
    private float overpaymentOption; // Declaring a private variable to store the overpayment option for this loan.

    // Constructor for creating a BuilderLoan object with essential loan details.
    public BuilderLoan(String recordID, String loanType, float interestRate, int loantermLeft, int amountToPay) {
    }

    // Constructor for creating a BuilderLoan object with additional overpayment option.
    public BuilderLoan(String recordID, String loanType, float interestRate, int loanTermLeft, int amountToPay,
                       float overpaymentOption) {
        // Calling the superclass constructor to initialize the loan details.
        super(recordID, loanType, interestRate, loanTermLeft, amountToPay);
        this.overpaymentOption = overpaymentOption; // Assigning the overpayment option.
    }

    @Override
    public void updateInformation() {
    }

    // Getter method to retrieve the overpayment option.
    public float getOverpaymentOption() {
        return overpaymentOption;
    }

    // Setter method to set the overpayment option.
    public void setOverpaymentOption(float overpaymentOption) {
        this.overpaymentOption = overpaymentOption; // Setting the overpayment option to the provided value.
    }
}
