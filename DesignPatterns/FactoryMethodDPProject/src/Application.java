public class Application {
    public static void main(String[] args) {
        //new object is instantiated based on subclass that extends bundle abstract class
        Bundle beginnerBundle = BundleFactory.getBundle(BundleCode.BEGINNER);
        System.out.println("Beginner Bundle Item List");
        beginnerBundle.getBundleItemList();

        Bundle averageBundle = BundleFactory.getBundle(BundleCode.AVERAGE);
        System.out.println("Average Bundle Item List");
        averageBundle.getBundleItemList();

        Bundle proBundle = BundleFactory.getBundle(BundleCode.PRO);
        System.out.println("Pro Bundle Item List");
        proBundle.getBundleItemList();
    }
}
