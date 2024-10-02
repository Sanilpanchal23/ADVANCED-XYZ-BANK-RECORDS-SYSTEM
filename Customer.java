// Imports required for ArrayList and List
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Definition of the Customer class implementing the CheckerPrinter interface
public class Customer implements CheckerPrinter {
    // Private member variables for customerID, customerIncome, and eligibilityStatus
    private String customerID;
    private float customerIncome;
    private boolean eligibilityStatus;
    // List to hold credit records associated with the customer
    private List<Loan> creditRecords;

    // Constructor initializing creditRecords with an ArrayList
    public Customer() {
        this.creditRecords = new ArrayList<>();
    }

    // Constructor initializing customerID, customerIncome, eligibilityStatus, and creditRecords with an ArrayList
    public Customer(String customerID, float customerIncome) {
        this.customerID = customerID;
        this.customerIncome = customerIncome;
        this.eligibilityStatus = true;
        this.creditRecords = new ArrayList<>();
    }

    // Override method to check eligibility based on total amount left to pay and customer income
    @Override
    public boolean checkEligibility(Customer customer) {
        int totalAmountLeftToPay = 0;
        // Calculate total amount left to pay by iterating through credit records
        for (Loan loan : customer.getCreditRecords()) {
            totalAmountLeftToPay += loan.getamountToPay();
        }
        // Check if total amount left to pay is within four times the customer's income
        return totalAmountLeftToPay <= (4 * customer.getCustomerIncome());
    }

    // Override method to print customer details (not implemented here)
    @Override
    public void printCustomerDetails(Customer customer) {
    }

    // Method to add a new loan record if it doesn't already exist
    public void addLoanRecord(Loan loan) {
        // Check if a loan with the same record ID already exists
        for (Loan existingLoan : creditRecords) {
            if (existingLoan.getRecordID() == loan.getRecordID()) {
                // Print a message if the record ID already exists
                System.out.println("Record ID '" + loan.getRecordID()
                        + "' already exists for this customer. Please enter a different record ID.");
                return;
            }
        }
        // If the record ID doesn't exist, add the loan record
        creditRecords.add(loan);
    }

    // Method to remove a loan record based on its record ID
    public boolean removeLoanRecord(String recordID) {
        // Iterate through credit records
        for (Loan loan : getCreditRecords()) {
            Iterator<Loan> iterator = getCreditRecords().iterator();
            loan = iterator.next();
            // If the record ID matches, remove the loan record
            if (loan.getRecordID().equals(recordID)) {
                iterator.remove();
                return true;
            }
        }
        // Return false if the record ID doesn't exist
        return false;
    }

    // Getter method for customerID
    public String getCustomerID() {
        return customerID;
    }

    // Setter method for customerID
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    // Getter method for customerIncome
    public float getCustomerIncome() {
        return customerIncome;
    }

    // Setter method for customerIncome
    public void setCustomerIncome(float customerIncome) {
        this.customerIncome = customerIncome;
    }

    // Getter method for eligibilityStatus
    public boolean isEligibilityStatus() {
        return eligibilityStatus;
    }

    // Setter method for eligibilityStatus
    public void setEligibilityStatus(boolean eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    // Getter method for creditRecords
    public List<Loan> getCreditRecords() {
        return creditRecords;
    }

    // Setter method for creditRecords
    public void setCreditRecords(List<Loan> creditRecords) {
        this.creditRecords = creditRecords;
    }
}
