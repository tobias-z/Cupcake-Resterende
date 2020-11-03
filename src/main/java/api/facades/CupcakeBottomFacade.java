package api.facades;

import domain.CupcakeBottom;
import infrastucture.Database.DBCupcakeBottom;

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
        return dbCupcakeBottom.findCupcakeBottoms();
    }
    public CupcakeBottom findCupcakeById(int id){


        return dbCupcakeBottom.findCupcakeById(id);
    }

    public void addBottom(String type, double newAmount) {
        dbCupcakeBottom.addBottom(type, newAmount);
    }
}
