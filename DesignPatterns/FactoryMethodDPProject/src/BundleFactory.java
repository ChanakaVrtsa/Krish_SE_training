public class BundleFactory {

    //returns new class object based on user input passed to switch case
    //value returned to Application.java class
    public static Bundle getBundle(BundleCode bundleCode){

        switch(bundleCode){

            case BEGINNER:
                return new BeginnerUserBundle();
            case AVERAGE:
                return new AverageUserBundle();
            case PRO:
                return new ProUserBundle();
            default:
                return null;
        }
    }
    
}
