package api.factories;

import exeptions.ValidationError;

public class CupcakeFactory {

    private int cupcakeBottomId;
    private int cupcakeTopId;
    private double pris;


    /**
     * Parse String til hvad du nu skal bruge.
     */

    public boolean isValid(){
        return false;
    }


    public void setCupcakeBottomId(int cupcakeBottomId) throws ValidationError {
        if(cupcakeBottomId < 0) throw new ValidationError("The Cupcake bottom id was less than 0");
        this.cupcakeBottomId = cupcakeBottomId;
    }

    public void setCupcakeBottomId(String number) throws ValidationError {
        try {
            setCupcakeBottomId(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.getMessage());
        }
    }

    public void setCupcakeTopId(int cupcakeTopId) throws ValidationError {
        if(cupcakeTopId< 0) throw new ValidationError("Cupcake top id was less than 0");
        this.cupcakeTopId = cupcakeTopId;
    }

    public void setCupcakeTopId(String number) throws ValidationError {
        try {
            setCupcakeTopId(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.getMessage());
        }
    }


    public void setPris(double pris) throws ValidationError {
        if(pris < 0) throw new ValidationError("prisen er på en eller anden måde blevet mindre end 0");
        this.pris = pris;
    }

    public void setPris(String number) throws ValidationError {
        try {
            setPris(Double.parseDouble(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.getMessage());
        }
    }


    public int getCupcakeBottomId() {
        return cupcakeBottomId;
    }

    public int getCupcakeTopId() {
        return cupcakeTopId;
    }

    public double getPris() {
        return pris;
    }
}
