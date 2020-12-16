public class Application {
    public static void main(String[] args){
        
        //Checked Exceptions Example
        //AccountManager class handles all account related functions
        AccountManager accountMananger = new AccountManager();
        System.out.println("Checked Exception");
        try {
            //calls verifyAccount method
            accountMananger.VerifyAccount(121121);
        } catch (AccountManagerException msg) {
            //prints all exceptions occured during propagation
            System.out.println(msg.getMessage());
            //msg.printStackTrace();
        }

        //Unchecked Exceptions Example
        System.out.println("Unchecked Exception");
        try {
            //calls withdrawMonney method of AccountManager
            accountMananger.withdrawMoney(100);
        } catch (Exception e) {
            //prints the stack trace if execption is caught
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
        
        
    }
}
