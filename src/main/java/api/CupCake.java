package api;

import api.facades.*;

public class CupCake {

    private final UserFacade userFacade;
    private final OrderFacade orderFacade;
    private final CupcakeTopFacade cupcakeTopFacade;
    private final CupcakeBottomFacade cupcakeBottomFacade;
    private final CupcakeFacade cupcakeFacade;


    public CupCake(UserFacade userFacade,
                   OrderFacade orderFacade,
                   CupcakeTopFacade cupcakeTopFacade,
                   CupcakeBottomFacade cupcakeBottomFacade,
                   CupcakeFacade cupcakeFacade) {

        this.userFacade = userFacade;
        this.orderFacade = orderFacade;
        this.cupcakeTopFacade = cupcakeTopFacade;
        this.cupcakeBottomFacade = cupcakeBottomFacade;
        this.cupcakeFacade = cupcakeFacade;
    }

    public CupcakeTopFacade getCupcakeTopFacade() {
        return cupcakeTopFacade;
    }

    public CupcakeBottomFacade getCupcakeBottomFacade() {
        return cupcakeBottomFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    public CupcakeFacade getCupcakeFacade() {
        return cupcakeFacade;
    }
}
