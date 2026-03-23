public class HomeInsurance extends Insurance{
    private String address;
    private String yearBuilt;
    private double deductible;

    //Constructor for AutoInsurance class
    public HomeInsurance(){
        super();
    }

    public HomeInsurance(String policyNumber, String policyOwner, double yearlyPremium, String address, String yearBuilt, double deductible){
        super(policyNumber, policyOwner, yearlyPremium);
        setAddress(address);
        setYearBuilt(yearBuilt);
        setDeductible(deductible);
    }

    //Get methods
    public String getAddress(){
        return this.address;
    }

    public String getYearBuilt(){
        return this.yearBuilt;
    }

    public double getDeductible(){
        return this.deductible;
    }

    //Set methods
    public void setAddress(String address){
        this.address = address;
    }

    public void setYearBuilt(String yearBuilt){
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