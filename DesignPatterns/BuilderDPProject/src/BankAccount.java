public class BankAccount {

    private final String name;
    private final String NIC;
    private final String address;
    private final String occupation;
    private final String branch;
    private final int medianIncome;

    public BankAccount(BankAccountBuilder bankAccountBuilder) {

        this.name = bankAccountBuilder.name;
        this.NIC = bankAccountBuilder.NIC;
        this.address = bankAccountBuilder.address;
        this.occupation = bankAccountBuilder.occupation;
        this.branch = bankAccountBuilder.branch;
        this.medianIncome = bankAccountBuilder.medianIncome;

    }

    //displays bank account details
    public void displayAccountDetails() {

        System.out.println("Name: " + name);
        System.out.println("NIC Number: " + NIC);
        System.out.println("Address: " + address);
        System.out.println("Occupation: " + occupation);
        System.out.println("Branch: " + branch);
        System.out.println("Income: Rs." + medianIncome);
        
    }

    public static class BankAccountBuilder {

        private String name;
        private String NIC;
        private String address;
        private String occupation;
        private String branch;
        private int medianIncome;

        //parameters that must be enforced/must are assigned when initialzing constructors
        public BankAccountBuilder(String name, String NIC, String address) {

            this.name = name;
            this.NIC = NIC;
            this.address = address;

        }

        //sets occupation parameter and returns same object
        public BankAccountBuilder occupation(String occupation) {

            this.occupation = occupation;
            return this;

        }

        //sets branch parameter and returns same object
        public BankAccountBuilder branch(String branch) {

            this.branch = branch;
            return this;

        }

        //sets income parameter and returns same object
        public BankAccountBuilder medianIncome(int medianIncome) {

            this.medianIncome = medianIncome;
            return this;

        }

        public BankAccount build() {

            //returns new BankAccount object along with BankAccountBuilder object as parameter
            return new BankAccount(this);
        }
    }
    
}
