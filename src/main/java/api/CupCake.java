package api;

import api.facades.UserFacade;

public class CupCake {

    private final UserFacade userFacade;


    public CupCake(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }
}
