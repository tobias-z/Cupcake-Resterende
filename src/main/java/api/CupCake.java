package api;

import api.facades.CupcakeBottomFacade;
import api.facades.CupcakeTopFacade;
import api.facades.OrderFacade;
import api.facades.UserFacade;

public class CupCake {

    private final UserFacade userFacade;
    private final OrderFacade orderFacade;
    private final CupcakeTopFacade cupcakeTopFacade;
    private final CupcakeBottomFacade cupcakeBottomFacade;


    public CupCake(UserFacade userFacade, OrderFacade orderFacade, CupcakeTopFacade cupcakeTopFacade, CupcakeBottomFacade cupcakeBottomFacade) {
        this.userFacade = userFacade;
        this.orderFacade = orderFacade;
        this.cupcakeTopFacade = cupcakeTopFacade;
        this.cupcakeBottomFacade = cupcakeBottomFacade;
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
}
