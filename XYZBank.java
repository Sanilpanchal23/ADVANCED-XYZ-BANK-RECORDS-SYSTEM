import java.util.ArrayList; // Importing ArrayList class
import java.util.List; // Importing List interface
import java.util.Scanner; // Importing Scanner class

public class XYZBank {
    // This is a list to store customer objects.
    private static final List<Customer> customers = new ArrayList<>(); // Creating an ArrayList to store customers
    private static int totalRecords = 0; // Variable to keep track of total records added
    private static int maxRecords=0; // Variable to store maximum allowed records

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Creating a Scanner object to get user input

        // Prompting me to enter the maximum number of records
        try (input) {
            while (true) {

                System.out.print("\n Please provide the maximum number of records: ");
                if (input.hasNextInt()) {
                    maxRecords = input.nextInt();
                    if (maxRecords > 0) {
                        break;
                    } else {
                        // Alerting me if a non-positive integer is entered.
                        System.out.println("\nError. Please enter a positive integer.");
                    }
                } else {
                    // Alerting me if an invalid input is provided.
                    System.out.println("\nError. Please enter a valid number.");
                    input.next(); // Clearing the input buffer
                }
            }
            while (true) {
                // Displaying the main menu options.
                System.out.println("\n Welcome to XYZBank.");
                Thread.sleep(1000);
                System.out.println("\n═════════");
                System.out.println("Main Menu");
                System.out.println("═════════");

                System.out.println("(1) [Register a new customer]");
                System.out.println("(2) [Update existing customer information]");
                System.out.println("(3) [Display customer details]");
                System.out.println("(4) [Exit]");
                Thread.sleep(1000);

                System.out.print("\n Please choose one of the following options (1-4): ");
                int num = -1;
                // Validating my input for the menu choice.
                while (num < 1 || num > 4) {
                    if (input.hasNextInt()) {
                        num = input.nextInt();
                        if (num < 1 || num > 4) {

                            System.out.println("\nError. Please choose from the given options (1-4).");
                            Thread.sleep(500);
                            System.out.print("\nEnter your choice from (1-4): ");
                        }
                    } else {

                        System.out.println("\nError. Please choose from the given options (1-4).");

                        System.out.print("\nEnter your choice from (1-4): ");
                        input.next();
                    }
                }

                input.nextLine();

                switch (num) {
                    case 1:
                        // Registering a new customer.
                        NewCustomerreg(input);
                        break;
                    case 2:
                        // Updating existing customer information.
                        updateCustomerInfo(input);
                        break;
                    case 3:
                        // Printing customer details.
                        CustomerDetails(input);
                        break;
                    case 4:
                        // Exiting the program.
                        System.out.println("\n Please Wait, Exiting.");
                        Thread.sleep(1000);
                        System.out.println("\n Exited.");
                        Thread.sleep(1000);
                        System.out.println("\n Have A Nice Day. ");
                        Thread.sleep(1000);
                        return;
                }
            }
        } catch (Exception e) {
            // Handling unexpected errors.
            System.out.println("\nAn unexpected error occurred: " + e.getMessage());
        }
    }



    // Register A New Customer function.
    private static void NewCustomerreg(Scanner input) throws InterruptedException {
        // Checks if the maximum number of records has been reached.
        if (totalRecords >= maxRecords) {

            System.out.println("\n Error. Cannot add more customers as maximum number of records reached. ");
            return;
        }

        System.out.println("══════════════════════════════════════════════════");
        System.out.println("You have selected to register a new customer:");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("\nNew Customer Registeration.");



        // Customer ID Input and Validation.
        System.out.print(
                "\nEnter customer ID (format 'AAAXXX): ");
        String customerID = input.nextLine();
        // Validates the Customer ID input format to ensure correctness.
        if (!customerID.matches("[A-Z]{3}\\d{3}")) {
            // Loop until a valid customer ID is provided.
            while(true) {
                System.out.println("\nError. Customer ID should be in the format 'AAAXXX'.");
                System.out.println("Please provide a valid CustomerID: ");
                customerID = input.nextLine();
                // Check if the newly provided customer ID matches the correct format.
                if (customerID.matches("[A-Z]{3}\\d{3}")) {
                    break;
                }

            }

        }

        // Checks if Customer ID already exists.
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getCustomerID().equals(customerID)) {

                System.out
                        .println("\nError. Customer with ID '" + customerID + "' already exists. New customer registeration failed.");
                return;
            }
        }

        // Proceeds with registration of a loan if the inputted CustomerID format is valid and it doesn't already exist.


        // Customer Income Input and Validation.
        float customerIncome;
        while (true) {

            System.out.print("\nPlease enter customer income: "); // Prompting me to enter customer income.
            if (input.hasNextFloat()) { // Checking if the input is a float.
                customerIncome = input.nextFloat();// Storing the entered value as customer income.
                if (customerIncome >= 0) { // Validating that the income is non-negative.
                    break;
                } else {

                    System.out.println("\nError. Customer income must be a non-negative number.");
                    // Alerting me if the entered income is negative.
                }
            } else {
                // Alerting me if the entered value is not a float.
                System.out.println("\nError. Please enter a valid number: ");
                input.nextLine();
                // Clearing the input buffer.
            }
        }
        input.nextLine();// Clearing the input buffer after reading the float value.

        // Record ID Input and Validation.
        String recordID;
        while (true) {
            System.out.print("\nPlease enter record ID (6-digit number): ");// Prompting me to enter a 6-digit record ID.
            recordID = input.nextLine(); // Read the input as a string
            // Check if the input is a 6-digit number
            if (recordID.matches("\\d{6}")) {
                break;
            } else {
                // Alerting me if the entered record ID does not consist of exactly 6 digits.
                System.out.println("\nError. The Record ID must consist of exactly 6 digits.");
                System.out.println("Please Try Again.");
            }
        }

        // Loan type validation
        String loanType;
        while (true) {
            System.out.print("\nPlease enter loan type (Auto/Builder/Mortgage/Personal/Other): ");
            // Converting input into lowercase for uniformity.
            loanType = input.nextLine().toLowerCase();
            // Checking if the entered loan type is valid.
            if (loanType.equals("auto") || loanType.equals("builder") || loanType.equals("mortgage")
                    || loanType.equals("personal") || loanType.equals("other")) {
                break;// Exiting the loop if the loan type is valid.
            } else {
                // Alerting me if the entered loan type is invalid.
                System.out.println("\nInvalid loan type.Please try again.");
            }
        }

        // Interest Rate Input and Validation.
        float interestRate;
        while (true) {

            System.out.print("\nPlease enter interest rate: ");  // Prompting me to enter the interest rate
            if (input.hasNextFloat()) {// Checking if the input is a float.
                interestRate = input.nextFloat(); // Storing the entered value as interest rate.
                if (interestRate >= 0) { // Validating that the interest rate is non-negative.
                    break; //Exiting the loop if the interest rate is valid.
                } else {
                    // Alerting me if the entered interest rate is negative.
                    System.out.println("\nError. Interest rate must be a non-negative number.");
                }
            } else {
                // Alerting me if the entered value is not a float.
                System.out.println("\nError. Please enter a valid number: ");
                input.nextLine();// Clearing the input buffer.
            }
        }
        input.nextLine();// Clearing the input buffer after reading the float value.

        // Amount To Pay Input and Validation.
        int amountToPay;
        while (true) {
            // Prompting me to enter the amount left to pay.
            System.out.print("\nPlease enter amount left to pay (in thousands pounds): ");
            if (input.hasNextInt()) {// Checking if the input is an integer.
                amountToPay = input.nextInt();// Storing the entered value as amount to pay.
                if (amountToPay >= 0) { // Validating that the amount to pay is non-negative.
                    break;
                } else {
                    // Alerting me if the entered amount to pay is negative.
                    System.out.println("\nError. Amount left to pay must be a non-negative number.");
                }
            } else {
                // Alerting me if the entered value is not an integer.
                System.out.println("\nError. Please enter a valid number: ");
                input.nextLine();// Clearing the input buffer.
            }
        }
        input.nextLine();// Clearing the input buffer after reading the integer value.

        // Loan Term Left Input and Validation.
        int loanTermLeft;
        while (true) {
            // Prompting me to enter the loan term left.
            System.out.print("\nEnter loan term left (in years): ");
            if (input.hasNextInt()) {// Checking if the input is an integer.
                loanTermLeft = input.nextInt();// Checking if the input is an integer.
                if (loanTermLeft >= 0) {// Validating that the loan term left is non-negative.
                    break;
                } else {
                    // Alerting me if the entered loan term left is negative.
                    System.out.println("\nError. Loan term left must be a non-negative integer.");
                }
            } else {
                // Alerting me if the entered value is not an integer.
                System.out.println("\nError. Please enter a valid number.");
                input.nextLine();// Clearing the input buffer.
            }
        }
        input.nextLine();// Clearing the input buffer after reading the integer value.

        // Creates loan record based on loan type.
        Loan loan; // I declare a variable 'loan' of type Loan.
        switch (loanType) {// I start a switch statement based on the value of 'loanType'.
            case "auto":// If 'loanType' is "auto"...
                loan = new AutoLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay);// I create a new AutoLoan object with given parameters and assign it to 'loan'.
                break;// I exit the switch statement.
            case "builder":// If 'loanType' is "builder"...
                float BuilderOP;// I declare a float variable 'BuilderOP'.
                while (true) {// I start an infinite loop.
                    System.out.print("\nPlease enter your overpayment (number between 0 and 2): ");// I prompt the user to enter an overpayment value.
                    if (input.hasNextFloat()) {// I check if the next input is a float.
                        BuilderOP = input.nextFloat(); // I assign the float value to 'BuilderOP'.
                        if (BuilderOP >= 0 && BuilderOP <= 2) {// If 'BuilderOP' is between 0 and 2...
                            break;// I exit the loop.
                        } else {// If 'BuilderOP' is not between 0 and 2...
                            System.out.println("\nError. Overpayment option must be between 0 and 2.");// I display an error message.
                        }
                    } else {// If the input is not a float...
                        System.out.println("\nError. Please enter a valid number.");// I display an error message.
                        input.nextLine();// I consume the invalid input.
                    }
                }
                input.nextLine();
                loan = new BuilderLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay,
                        BuilderOP);  //CONSTRUCTING A LOAN
                break;
            case "mortgage":  //if mortgage is inputted do this.
                float MortgageOP;
                while (true) {
                    System.out.print("\nEnter overpayment option (number between 0 and 2): ");
                    if (input.hasNextFloat()) {
                        MortgageOP = input.nextFloat();
                        if (MortgageOP >= 0 && MortgageOP <= 2) {
                            break;
                        } else {
                            System.out.println("\nError. Overpayment option must be between 0 and 2.");
                        }
                    } else {
                        System.out.println("\nError. Please enter a valid number.");
                        input.nextLine();
                    }
                }
                input.nextLine();
                loan = new MortgageLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay,
                        MortgageOP);
                break;
            case "personal":
                loan = new PersonalLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay);
                break;
            case "other":
                loan = new OtherLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay);
                break;
            default:
                System.out.println("\nInvalid loan type.");
                return;
        }

        // Creates a customer and adds a loan record.
        Customer customer = new Customer(customerID, customerIncome);
        customer.addLoanRecord(loan);
        customers.add(customer);

        Thread.sleep(1000);
        System.out.println("\nCustomer successfully registered with a single loan record.");
        // Increments the totalRecords variable
        totalRecords++;

        System.out.println("Returning back to main menu");
        Thread.sleep(2000);


    }

    // Update Customer Information function.
    private static void updateCustomerInfo(Scanner input) throws InterruptedException {
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("You have selected to update customer information:");
        System.out.println("══════════════════════════════════════════════════");;
        // Customer ID Input and Validation.

        System.out.print( "\nPlease Enter customer ID (format 'AAAXXX): ");
        String customerID = input.nextLine();
        // Validates the Customer ID input format is correct.
        if (!customerID.matches("[A-Z]{3}\\d{3}")) {

            while(true) {
                System.out.println("\nError. Customer ID should be in the format 'AAAXXX'.");
                Thread.sleep(1000);
                System.out.println("Please provide a valid CustomerID: ");
                customerID = input.nextLine();

                if (customerID.matches("[A-Z]{3}\\d{3}")) {
                    break;
                }


            }
        }

        // Checks if the CustomerID exists if not returns an error message.
        Customer customer = findCustomerByID(customerID);
        if (customer == null) {

            System.out.println("\nError. Customer not found. Customer may not exist.");
            Thread.sleep(1000);
            System.out.println("Returning back to Main menu");
            Thread.sleep(3000);

            return;
        }

        // If the CustomerID exists it moves on.

        // Choice Input and Validation.
        int choice;
        while (true) {

            System.out.println("\n1. Add new loan record");
            System.out.println("2. Update customer income");
            System.out.println("3. Remove a loan record");

            System.out.print("\nEnter your choice: ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    // validates if the input is between 1 and 3.

                    System.out.println("\n Error. Please enter a number between 1 and 3.");
                }
            } else {
                // Validates if the input is a number.

                System.out.println("\nError. Please enter a number between 1 and 3.");
                input.nextLine();
            }
        }
        input.nextLine();

        switch (choice) {
            case 1:
                addLoanRecord(customer, input);
                break;
            case 2:
                // Validation for new customer income.
                float newIncome;
                while (true) {

                    System.out.print("\nEnter new customer income: ");
                    if (input.hasNextFloat()) {
                        newIncome = input.nextFloat();
                        break;
                    } else {
                        // Validates if the input is a number.

                        System.out.println("\nError. Please enter a valid number.");
                        input.nextLine();
                    }
                }

                input.nextLine();
                customer.setCustomerIncome(newIncome);

                System.out.println("\nCustomer income updated successfully.");
                System.out.println("Returning back to main menu");
                Thread.sleep(2000);
                break;
            case 3:
                // Remove a loan record for a customer.
                removeLoanRecord(customer, input);
                break;
            default:

                System.out.println("\nInvalid choice.");
        }

    }

    // Remove Loan Record Function.
    private static void removeLoanRecord(Customer customer, Scanner input) {
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("You have selected to register a new customer:");
        System.out.println("══════════════════════════════════════════════════");


        // Display existing loan records for the customer.
        List<Loan> loanRecords = customer.getCreditRecords();
        if (loanRecords.isEmpty()) {
            System.out.println("No loan records found for this customer.");
            return;
        }

        System.out.println("Existing loan records:");
        System.out.printf("\n%-8s %-9s %-10s %-10s %-9s%n", "RecordID", "LoanType", "IntRate", "AmountLeft",
                "TimeLeft");
        for (Loan loan : loanRecords) {
            System.out.printf("%-8s %-9s %-10s %-10s %-9s%n", loan.getRecordID(), loan.getLoanType(),
                    loan.getInterestRate(), loan.getamountToPay(), loan.getLoanTermLeft());
        }

        // Input and validation for the record ID to be removed.
        String recordID;
        while (true) {
            System.out.print("\nEnter record ID to remove (6-digit number): ");
            recordID = input.nextLine(); // Read the input as a string
            // Check if the input is a 6-digit number
            if (recordID.matches("\\d{6}")) {
                break;
            } else {
                System.out.println("\nError. Record ID must be a 6-digit number.");
            }
        }
        boolean removed = customer.removeLoanRecord(recordID);

        if (removed) {
            System.out.println("\nLoan record removed successfully.");
            totalRecords--;
        } else {
            System.out.println("\nLoan record not found or could not be removed.");
        }
    }

    // Add Loan Record Function.
    private static void addLoanRecord(Customer customer, Scanner input) throws InterruptedException {
        // Checks if the maximum number of records has been reached.
        if (totalRecords >= maxRecords) {

            System.out.println("\nMaximum number of records reached. Cannot add more loan records.");
            System.out.println("Returning back to main menu");
            Thread.sleep(2000);
            return;
        }
        // If the Customer is eligible it will run the rest of the code.
        if (customer.checkEligibility(customer)) {
            // Record ID Input and Validation.
            String recordID;
            while (true) {
                System.out.print("\nEnter record ID (6-digit number): ");
                recordID = input.nextLine(); // Read the input as a string
                // Check if the input is a 6-digit number
                if (recordID.matches("\\d{6}")) {
                    break;
                } else {
                    System.out.println("\nError. Record ID must be a 6-digit number.");
                }
            }

            // Loan type validation
            String loanType;
            while (true) {
                System.out.print("\nEnter loan type (Auto/Builder/Mortgage/Personal/Other): ");
                // Converts input into lowercase.
                loanType = input.nextLine().toLowerCase();
                if (loanType.equals("auto") || loanType.equals("builder") || loanType.equals("mortgage")
                        || loanType.equals("personal") || loanType.equals("other")) {
                    break;
                } else {
                    System.out.println("\nInvalid loan type.");
                }
            }

            // Interest Rate Input and Validation.
            float interestRate;
            while (true) {

                System.out.print("\nEnter interest rate: ");
                if (input.hasNextFloat()) {
                    interestRate = input.nextFloat();
                    if (interestRate >= 0) {
                        break;
                    } else {

                        System.out.println("\nError. Interest rate must be a non-negative number.");
                    }
                } else {

                    System.out.println("\nError. Please enter a valid number.");
                    input.nextLine();
                }
            }
            input.nextLine();

            // Amount To Pay Input and Validation.
            int amountToPay;
            while (true) {

                System.out.print("\nEnter amount left to pay (in thousands pounds): ");
                if (input.hasNextInt()) {
                    amountToPay = input.nextInt();
                    if (amountToPay >= 0) {
                        break;
                    } else {

                        System.out.println("\nError. Amount left to pay must be a non-negative number.");
                    }
                } else {

                    System.out.println("\nError. Please enter a valid number.");
                    input.nextLine();
                }
            }
            input.nextLine();

            // Loan Term Left Input and Validation.
            int loanTermLeft;
            while (true) {

                System.out.print("\nEnter loan term left (in years): ");
                if (input.hasNextInt()) {
                    loanTermLeft = input.nextInt();
                    if (loanTermLeft >= 0) {
                        break;
                    } else {

                        System.out.println("\nError. Loan term left must be a non-negative integer.");
                    }
                } else {

                    System.out.println("\nError. Please enter a valid number.");
                    input.nextLine();
                }
            }
            input.nextLine();

            // Creates loan record based on loan type.
            Loan loan;
            switch (loanType) {
                case "auto":
                    loan = new AutoLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay);
                    break;
                case "builder":
                    float BuilderOP;
                    while (true) {
                        System.out.print("\nEnter overpayment option (float between 0 and 2): ");
                        if (input.hasNextFloat()) {
                            BuilderOP = input.nextFloat();
                            if (BuilderOP >= 0 && BuilderOP <= 2) {
                                break;
                            } else {
                                System.out.println("\nError. Overpayment option must be between 0 and 2.");
                            }
                        } else {
                            System.out.println("\nError. Please enter a valid number.");
                            input.nextLine();
                        }
                    }
                    input.nextLine();
                    loan = new BuilderLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay,
                            BuilderOP);
                    break;
                case "mortgage":
                    float MortgageOP;
                    while (true) {
                        System.out.print("\nEnter overpayment option (number between 0 and 2): ");
                        if (input.hasNextFloat()) {
                            MortgageOP = input.nextFloat();
                            if (MortgageOP >= 0 && MortgageOP <= 2) {
                                break;
                            } else {
                                System.out.println("\nError. Overpayment option must be between 0 and 2.");
                            }
                        } else {
                            System.out.println("\nError. Please enter a valid number.");
                            input.nextLine();
                        }
                    }
                    input.nextLine();
                    loan = new MortgageLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay,
                            MortgageOP);
                    break;
                case "personal":
                    loan = new PersonalLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay);
                    break;
                case "other":
                    loan = new OtherLoan(recordID, loanType, interestRate, loanTermLeft, amountToPay);
                    break;
                default:
                    System.out.println("\nInvalid loan type.");
                    return;
            }

            // Add loan record to customer.
            customer.addLoanRecord(loan);

            System.out.println("\nLoan record added successfully.");
            // Increment the totalRecords variable
            totalRecords++;

            // If the Customer is not eligible it will output this message.
        } else {

            System.out.println("\nCustomer not eligible for new loan.");
        }
    }

    // Customer details Function.
    private static void CustomerDetails(Scanner input) {
        // Displays the options for printing customer details.
        System.out.println("====================================================");
        System.out.println("Print customer details");
        System.out.println("====================================================");
        int choice = -1;
        // Validates user input for printing options.
        while (choice != 1 && choice != 2) {

            System.out.println("\n1. Print information for a specific customer");
            System.out.println("2. Print information for all customers");

            System.out.print("\nEnter your choice: ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
                if (choice != 1 && choice != 2) {

                    System.out.println("\nInvalid choice. Please enter either 1 or 2.");
                }
            } else {

                System.out.println("\nError. Please enter a number.");
                input.nextLine();
            }
        }

        switch (choice) {
            case 1:
                // Prints details for a specific customer.
                SpecificCustomerDetails(input);
                break;
            case 2:
                // Prints details for all customers.
                printAllCustomersDetails();
                break;
            default:

                System.out.println("\nInvalid choice.");
        }
    }

    // Function to print details for a specific customers.
    private static void SpecificCustomerDetails(Scanner input) {
        // Customer ID Input and Validation.

        System.out.print(
                "\nEnter customer ID (format 'AAAXXX): ");
        String customerID = input.nextLine();
        // Validates the Customer ID input format is correct.
        if (!customerID.matches("[A-Z]{3}\\d{3}")) {


            while (true) {
                System.out.println("\nError. Customer ID should be in the format 'AAAXXX'.");
                System.out.println("Please provide a valid CustomerID: ");
                customerID = input.nextLine();

                if (customerID.matches("[A-Z]{3}\\d{3}")) {
                    break;
                }

            }
        }

        // Checks if the CustomerID exists if not returns an error message.
        Customer customer = findCustomerByID(customerID);
        if (customer == null) {
            System.out.println("\nCustomer not found.");
            System.out.println("Returning to Main Menu");
            return;
        }

        System.out.println("\nMaximum Records: " + maxRecords);
        System.out.println("Registered records: " + totalRecords);
        System.out.println("====================================================");
        System.out.println("CustomerID: " + customer.getCustomerID());
        System.out.println("Eligible to arrange new loans – " + (customer.checkEligibility(customer) ? "YES" : "NO"));

        System.out.printf("\n%-8s %-9s %-10s %-10s %-9s%n", "RecordID", "LoanType", "IntRate", "AmountLeft",
                "TimeLeft");
        for (Loan loan : customer.getCreditRecords()) {
            System.out.printf("%-8s %-9s %-10s %-10s %-9s%n", loan.getRecordID(), loan.getLoanType(),
                    loan.getInterestRate(), loan.getamountToPay(), loan.getLoanTermLeft());

        }
    }

    // Function to print details for all customers.
    private static void printAllCustomersDetails() {
        System.out.println("\nMaximum Records: " + maxRecords);
        System.out.println("Registered records: " + totalRecords);
        for (Customer customer : customers) {
            System.out.println("====================================================");
            System.out.println("CustomerID: " + customer.getCustomerID());
            System.out
                    .println("Eligible to arrange new loans – " + (customer.checkEligibility(customer) ? "YES" : "NO"));
            System.out.printf("\n%-8s %-9s %-10s %-10s %-9s%n", "RecordID", "LoanType", "IntRate", "AmountLeft",
                    "TimeLeft");
            for (Loan loan : customer.getCreditRecords()) {
                System.out.printf("%-8s %-9s %-10s %-10s %-9s%n", loan.getRecordID(), loan.getLoanType(),
                        loan.getInterestRate(), loan.getamountToPay(), loan.getLoanTermLeft());
            }
        }
    }

    // Function that checks if a customer exists or not
    private static Customer findCustomerByID(String customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }
        return null;
    }
}
