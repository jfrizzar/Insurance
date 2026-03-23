public class LifeInsurance extends Insurance{
    private String beneficiary;
    private double faceValue;

    //Constructor for AutoInsurance class
    public LifeInsurance(){
        super();
    }

    public LifeInsurance(String policyNumber, String policyOwner, double yearlyPremium, String beneficiary, double faceValue){
        super(policyNumber, policyOwner, yearlyPremium);
        setBeneficiary(beneficiary);
        setFaceValue(faceValue);
    }

    //Get methods
    public String getBeneficiary(){
        return this.beneficiary;
    }

    public double getFaceValue(){
        return this.faceValue;
    }

    //Set methods
    public void setBeneficiary(String beneficiary){
        this.beneficiary = beneficiary;
    }

    public void setFaceValue(double faceValue){
        if (faceValue < 0){
            throw new IllegalArgumentException("The face value must be positive.");
        }
        this.faceValue = faceValue;
    }

    //Special purpose methods
    public String toString(){
        return super.toString() +
        "The beneficiary is: " + this.getBeneficiary() + "\n" +
        "The face value is: $" + String.format("%.2f", this.getFaceValue()) + "\n";
    }

}