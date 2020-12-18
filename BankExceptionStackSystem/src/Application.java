public class Application {
    public static void main(String[] args){
        
        //Checked Exceptions Example
        //AccountManager class handles all account related functions
        AccountManager accountMananger = new AccountManager();
        System.out.println("Checked Exception");
        try {
            //calls verifyAccount method to do account verification
            accountMananger.verifyAccount(121121);
        } catch (AccountManagerException accountManagerException) {
            System.out.println(accountManagerException.getMessage());
            //prints all exceptions occured during propagation
            //accountManagerException.printStackTrace();
        }

        //Unchecked Exceptions Example
        System.out.println("Unchecked Exception");
        try {
            //calls withdrawMoney method to do withdrawal
            accountMananger.withdrawMoney(100);
        } catch (ArithmeticException arithmeticException) {
            System.out.println(arithmeticException.getMessage());
            //prints the stack trace if execption is caught
            //arithmeticException.printStackTrace();
        } catch(Exception exception){
            System.out.println(exception.getMessage());
            //prints the stack trace if execption is caught
            //exception.printStackTrace();
        }
        
        
    }
}
