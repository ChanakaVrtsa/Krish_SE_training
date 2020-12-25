public class BeginnerUserBundle extends Bundle {

    //overrides method in Bundle class
    //creates new object of DataPlan and Router child class 
    @Override
    protected void createBundle() {
        WebStarterDataPlan webStarterDataPlan = new WebStarterDataPlan();
        HuaweiRouter huaweiRouter = new HuaweiRouter();

        //adds values returned from methods to bundleItemList Arraylist
        bundleItemList.add(webStarterDataPlan.getDataPlanQuota());
        bundleItemList.add(webStarterDataPlan.getDataPlanPrice());
        bundleItemList.add(huaweiRouter.getRouterName());
        bundleItemList.add(huaweiRouter.getRouterPrice());

    }
    
}
