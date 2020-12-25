public class ProlinkRouter extends Router {

    //overrides method on Router class to specify router name specific for this child
    @Override
    public String getRouterName() {
        return "Prolink Router";
    }

    //overrides method on Router class to specify router price specific for this child
    @Override
    public int getRouterPrice() {
        return 3600;
    }
    
}
