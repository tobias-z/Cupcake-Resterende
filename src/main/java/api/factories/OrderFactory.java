package api.factories;

import domain.Cupcake;
import domain.Order;
import exeptions.ValidationError;

import java.util.List;

public class OrderFactory {
    private int userId;
    private List<Cupcake> cupcakeList;


    public boolean isValid () {
        if (this.userId < 0) return false;
        if(this.cupcakeList == null || this.cupcakeList.isEmpty()) return false;
        return true;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) throws ValidationError {
        if (userId < 0) throw new ValidationError("User id can't be under 0");
        this.userId = userId;
    }
    public void setUserId(String number) throws ValidationError {
        try {
            setUserId(Integer.parseInt(number));
        } catch(NumberFormatException e) {
            throw new ValidationError(e.getMessage());
        }

    }

    public void setCupcakeList(List<Cupcake> cupcakeList) {
        this.cupcakeList = cupcakeList;
    }


    public List<Cupcake> getCupcakeList() {
        return cupcakeList;
    }



}
