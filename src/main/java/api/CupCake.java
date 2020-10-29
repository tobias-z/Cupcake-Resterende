package api;

import api.facades.OrderFacade;
import api.facades.UserFacade;

public class CupCake {

    private final UserFacade userFacade;
    private final OrderFacade orderFacade;


    public CupCake(UserFacade userFacade, OrderFacade orderFacade) {
        this.userFacade = userFacade;
        this.orderFacade = orderFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public OrderFacade getOrderFacade() {
        return orderFacade;
    }
}
