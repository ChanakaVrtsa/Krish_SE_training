import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<SmartPhoneType, SmartPhone> smartPhones = new HashMap<>();

    public Registry() {

        //invokes initiliaze method when object of Registry is created 
        //method creates the initial objects
        this.initialize();
    }

    private void initialize() {
        Samsung samsung = new Samsung();
        samsung.setManufacturer("Samsung Vietnam");
        samsung.setOperatingSystem("Android");
        samsung.setModel("Galaxy");

        Redmi redmi = new Redmi();
        redmi.setManufacturer("Redmi Global Technologies");
        redmi.setOperatingSystem("Android");
        redmi.setVersion("Note");

        Apple apple = new Apple();
        apple.setManufacturer("Apple Inc.");
        apple.setOperatingSystem("IOS");
        apple.setSeries("8");

        //adds the newly created objects to HashMap 
        //so it can be called again without needing to initialize again
        smartPhones.put(SmartPhoneType.SAMSUNG, samsung);
        smartPhones.put(SmartPhoneType.REDMI, redmi);
        smartPhones.put(SmartPhoneType.APPLE, apple);

    }

    public SmartPhone getSmartphone(SmartPhoneType smartPhoneType) {
        SmartPhone smartPhone = null;
        try {
            //retrieves clone from hashMap based on the parameter
            //casting done as clone method returns an Object type
            smartPhone = (SmartPhone) smartPhones.get(smartPhoneType).clone();
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            System.out.println("Cannot create clone object");
        }
        return smartPhone;
    }
    
}
