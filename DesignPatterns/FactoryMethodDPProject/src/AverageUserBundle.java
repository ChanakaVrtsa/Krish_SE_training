public class AverageUserBundle extends Bundle {

    //overrides method in Bundle class
    //creates new object of DataPlan and Router child class 
    @Override
    protected void createBundle() {
        WebFamilyDataPlan webFamilyDataPlan = new WebFamilyDataPlan();
        DLinkRouter dLinkRouter = new DLinkRouter();

        //adds values returned from methods to bundleItemList Arraylist
        bundleItemList.add(webFamilyDataPlan.getDataPlanQuota());
        bundleItemList.add(webFamilyDataPlan.getDataPlanPrice());
        bundleItemList.add(dLinkRouter.getRouterName());
        bundleItemList.add(dLinkRouter.getRouterPrice());

    }
    
}
