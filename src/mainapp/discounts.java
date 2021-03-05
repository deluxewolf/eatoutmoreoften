package mainapp;

/**
 *
 * @author Shuaib
 */
public class discounts {
    
    private String discountCode;
    private int activations;
    private float dprice;
    
    
    public discounts(String dc, int activate, float dprice ){
        this.discountCode = dc;
        this.activations = activate;
        this.dprice = dprice;
        
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getActivations() {
        return activations;
    }

    public void setActivations(int activations) {
        this.activations = activations;
    }

    public float getDprice() {
        return dprice;
    }

    public void setDprice(float dprice) {
        this.dprice = dprice;
    }
    
    
}
