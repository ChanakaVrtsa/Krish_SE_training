public class Application {
    public static void main(String[] args) {
        
        //creates new registry object
        //executes initialize method on constructor upon creation
        Registry registry = new Registry();
        //retrieves sub class clone from hashMap
        Samsung samsung = (Samsung) registry.getSmartphone(SmartPhoneType.SAMSUNG);
        System.out.println("Manufacturer: " + samsung.getManufacturer());
        System.out.println("Model: " + samsung.getModel());
        System.out.println("Operating System: " + samsung.getOperatingSystem());

    }
}
