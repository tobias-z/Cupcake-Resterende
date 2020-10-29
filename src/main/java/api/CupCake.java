package api;

import api.facades.CupcakeFacade;
import api.facades.UserFacade;

public class CupCake {

    private final UserFacade userFacade;
    private final CupcakeFacade cupcakeFacade;


    public CupCake(UserFacade userFacade, CupcakeFacade cupcakeFacade) {
        this.userFacade = userFacade;
        this.cupcakeFacade = cupcakeFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public CupcakeFacade getCupcakeFacade() {
        return cupcakeFacade;
    }
}
