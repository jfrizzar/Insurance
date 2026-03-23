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
        if (policyNumber.isEmpty() || policyNumber.length() != 5){
            throw new IllegalArgumentException("The policy must be 5 characters long.");
        }
        this.policyNumber = policyNumber;
    }

    public void setPolicyOwner(String policyOwner){
        if (policyOwner.isEmpty()){
            throw new IllegalArgumentException("The policy owner cannot be blank.");
        }
        this.policyOwner = policyOwner;
    }

    public void setYearlyPremium(double yearlyPremium){
        if (yearlyPremium < 0){
            throw new IllegalArgumentException("The yearly premium is must be positive.");
        }
        this.yearlyPremium = yearlyPremium;
    }

    //Special purpose methods
    public String toString(){
        return "The policy number is: " + this.getPolicyNumber() + "\n" +
        "The policy owner is: " + this.getPolicyOwner() + "\n" +
        "The yearly premium is: $" + String.format("%.2f", this.getYearlyPremium()) + "\n";
    }

    public static void decrementCount(){
        policyCount--;
    }
}
