public class HomeInsurance extends Insurance{
    private String address;
    private int yearBuilt;
    private double deductible;

    //Constructor for AutoInsurance class
    public HomeInsurance(String policyNumber, String policyOwner, double yearlyPremium, String address, int yearBuilt, double deductible){
        super(policyNumber, policyOwner, yearlyPremium);
        setAddress(address);
        setYearBuilt(yearBuilt);
        setDeductible(deductible);
    }

    //Get methods
    public String getAddress(){
        return this.address;
    }

    public int getYearBuilt(){
        return this.yearBuilt;
    }

    public double getDeductible(){
        return this.deductible;
    }

    //Set methods
    public void setAddress(String address){
        this.address = address;
    }

    public void setYearBuilt(int yearBuilt){
        this.yearBuilt = yearBuilt;
    }

    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    //Special purpose methods
    public String toString(){
        return super.toString() +
        "The address is: " + this.getAddress() + "\n" +
        "The year built is: " + this.getYearBuilt() + "\n" +
        "The deductible is: " + this.getDeductible() + "\n";
    }

}