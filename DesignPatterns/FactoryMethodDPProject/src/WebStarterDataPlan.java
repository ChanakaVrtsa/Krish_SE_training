public class WebStarterDataPlan extends DataPlan{

    //overrides method on DataPlan class to specify quota specific for this child
    @Override
    public String getDataPlanQuota() {
        return "30GB";
    }

    //overrides method on DataPlan class to specify monthly fee specific for this child
    @Override
    public int getDataPlanPrice() {
        return 990;
    }


}
