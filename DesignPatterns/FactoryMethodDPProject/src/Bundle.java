import java.util.ArrayList;
import java.util.List;

public abstract class Bundle {

    //stores values added from sub class object
    protected List<Object> bundleItemList = new ArrayList<>();

    public Bundle(){
        //invoke createBundle method
        createBundle();
    }

    //method is overriden in child classes to provide specific implementations
    protected abstract void createBundle();
    

    //displays values stored in ArrayList
    public void getBundleItemList(){
        System.out.println("Monthly Quota: " + bundleItemList.get(0));
        System.out.println("Monthly Price: " + bundleItemList.get(1));
        System.out.println("Router Type: " + bundleItemList.get(2));
        System.out.println("Router Price: " + bundleItemList.get(3));
    }
    
}
