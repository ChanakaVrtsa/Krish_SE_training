public class ProUserBundle extends Bundle {

    //overrides method in Bundle class
    //creates new object of DataPlan and Router child class 
    @Override
    protected void createBundle() {
        WebLifeDataPlan webLifeDataPlan = new WebLifeDataPlan();
        ProlinkRouter prolinkRouter = new ProlinkRouter();

        //adds values returned from methods to bundleItemList Arraylist
        bundleItemList.add(webLifeDataPlan.getDataPlanQuota());
        bundleItemList.add(webLifeDataPlan.getDataPlanPrice());
        bundleItemList.add(prolinkRouter.getRouterName());
        bundleItemList.add(prolinkRouter.getRouterPrice());

    }
    
}
