package api.facades;

import domain.CupcakeBottom;
import domain.CupcakeTop;
import infrastucture.Database.DBCupcakeBottom;
import infrastucture.Database.DBCupcakeTop;

import java.util.List;

public class CupcakeBottomFacade {
    private static CupcakeBottomFacade instance;
    private final DBCupcakeBottom dbCupcakeBottom;

    public CupcakeBottomFacade(DBCupcakeBottom dbCupcakeBottom) {
        this.dbCupcakeBottom = dbCupcakeBottom;
    }

    public static CupcakeBottomFacade getInstance() {
        if (instance == null){
            instance = new CupcakeBottomFacade(new DBCupcakeBottom());
        }

        return instance;
    }

    public List<CupcakeBottom> findCupcakeBottoms() {
        List<CupcakeBottom> cupcakeBottom= dbCupcakeBottom.findCupcakeBottoms();
        return cupcakeBottom;
    }
}
