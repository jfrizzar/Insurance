public class Insurance {
    private String policyNumber;
    private String policyOwner;
    private double yearlyPremium;
    private static int policyCount;

    //Constructor for our insurance class
    public Insurance(){
        policyCount++;
    }

    public Insurance(String policyNumber, String policyOwner, double yearlyPremium){
        this();
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

    public static int getPolicyCount(){
        return Insurance.policyCount;
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

    //Special purpose methods
    public String toString(){
        return "The policy number is: " + this.getPolicyNumber() + "\n" +
        "The policy owner is: " + this.getPolicyOwner() + "\n" +
        "The yearly premium is: " + this.getYearlyPremium() + "\n";
    }

    public static void decrementCount(){
        policyCount--;
    }
}
