public class WebLifeDataPlan extends DataPlan{

    //overrides method on DataPlan class to specify quota specific for this child
    @Override
    public String getDataPlanQuota() {
        return "150GB";
    }

    //overrides method on DataPlan class to specify monthly fee specific for this child
    @Override
    public int getDataPlanPrice() {
        return 2400;
    }

}
