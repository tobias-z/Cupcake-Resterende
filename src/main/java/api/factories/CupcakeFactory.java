package api.factories;

import exeptions.ValidationError;

public class CupcakeFactory {

    private int cupcakeBottomId;
    private int cupcakeTopId;
    private double pris;
    private int antal;
    private String cupcakeBottomType;
    private String cupcakeTopType;


    /**
     * Parse String til hvad du nu skal bruge.
     */

    public boolean isValid(){
        if(this.cupcakeBottomId < 0) return false;
        if(this.cupcakeTopId < 0) return false;
        if(this.pris < 0) return false;
        if(this.antal < 0) return false;
        if(this.cupcakeBottomType == null || this.cupcakeBottomType.isBlank()) return false;
        if(this.cupcakeTopType == null || this.cupcakeTopType.isBlank()) return false;
        return true;
    }


    public void setCupcakeBottomId(int cupcakeBottomId) {
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


    public void setPris(double pris) {
        this.pris = pris;
    }
    public void setPris(double topPris, double bottomPris, String antal){
        int newAntal = Integer.parseInt(antal);
        double calculatePrice = topPris + bottomPris;

        setPris(calculatePrice*newAntal);
    }

    public void setPris(String number) throws ValidationError {
        try {
            setPris(Double.parseDouble(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.getMessage());
        }
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public void setAntal(String number) throws ValidationError {
        try {
            setAntal(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }

    public void setCupcakeBottomType(String cupcakeBottomType) {
        this.cupcakeBottomType = cupcakeBottomType;
    }

    public void setCupcakeTopType(String cupcakeTopType) {
        this.cupcakeTopType = cupcakeTopType;
    }

    public String getCupcakeTopType() {
        return cupcakeTopType;
    }

    public String getCupcakeBottomType() {
        return cupcakeBottomType;
    }

    public int getAntal() {
        return antal;
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
