// The Loan class serves as a blueprint for different types of loans.

public abstract class Loan {
    // These attributes define basic properties of a loan.
    protected String recordID; // Unique identifier for the loan record.
    protected String loanType; // Type of loan.
    protected float interestRate; // Interest rate associated with the loan.
    protected int loanTermLeft; // Remaining term of the loan.
    protected int amountToPay; // Amount left to pay for the loan.

    // Default constructor for the Loan class.
    public Loan() {
    }

    // Parameterized constructor to initialize the Loan object with specific values.
    public Loan(String recordID, String loanType, float interestRate, int loanTermLeft, int amountToPay) {
        // Assigning values to the loan attributes.
        this.recordID = recordID;
        this.loanType = loanType;
        this.interestRate = interestRate;
        this.loanTermLeft = loanTermLeft;
        this.amountToPay = amountToPay;
    }

    // Abstract method to update loan information. Specific implementation is provided by subclasses.
    public abstract void updateInformation();

    // Getter method for retrieving the record ID.
    public String getRecordID() {
        return recordID;
    }

    // Setter method for setting the record ID.
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    // Getter method for retrieving the loan type.
    public String getLoanType() {
        return loanType;
    }

    // Setter method for setting the loan type.
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    // Getter method for retrieving the interest rate.
    public float getInterestRate() {
        return interestRate;
    }

    // Setter method for setting the interest rate.
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    // Getter method for retrieving the remaining loan term.
    public int getLoanTermLeft() {
        return loanTermLeft;
    }

    // Setter method for setting the remaining loan term.
    public void setLoanTermLeft(int loanTermLeft) {
        this.loanTermLeft = loanTermLeft;
    }

    // Getter method for retrieving the amount to pay.
    public int getamountToPay() {
        return amountToPay;
    }

    // Setter method for setting the amount to pay.
    public void setamountToPay(int amountToPay) {
        this.amountToPay = amountToPay;
    }
}
