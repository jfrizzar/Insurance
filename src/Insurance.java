public class Insurance {
    private String policyNumber;
    private String policyOwner;
    private double yearlyPremium;

    //Constructor for our insurance class
    public Insurance(String policyNumber, String policyOwner, double yearlyPremium){
        setPolicyNumber(policyNumber);
        setPolicyOwner(policyOwner);
        setYearlyPremium(yearlyPremium);
    }

    //Get methods
    public String getPolicyNumber(){
        return this.policyNumber;
    }

    public String getPolicyOwner(){
        return this.policyOwner;
    }

    public double getYearlyPremium(){
        return this.yearlyPremium;
    }

    //Set methods
    public void setPolicyNumber(String policyNumber){
        this.policyNumber = policyNumber;
    }

    public void setPolicyOwner(String policyOwner){
        this.policyOwner = policyOwner;
    }

    public void setYearlyPremium(double yearlyPremium){
        this.yearlyPremium = yearlyPremium;
    }

    public String toString(){
        return "The policy number is: " + this.getPolicyNumber() + "\n" +
        "The policy owner is: " + this.getPolicyOwner() + "\n" +
        "The yearly premium is: " + this.getYearlyPremium() + "\n";
    }
}
