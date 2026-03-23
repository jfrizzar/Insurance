import javax.swing.JOptionPane;

public class InsuraceImplementation {
    public static void main(String[] args){

    final int MAX_POLICIES = 5;
    int choice = -1;
    Insurance[] insuranceArray = new Insurance[MAX_POLICIES];

        do{
            try{
                choice = customerChoice();
                //Add Policy Option
                if (choice == 1){
                    if(Insurance.getPolicyCount() >= MAX_POLICIES){
                        JOptionPane.showMessageDialog(null, "The maximum number of policies has been reached.");
                    }
                    else{
                        Insurance currentPolicy = addPolicy();
                        if (Insurance.getPolicyCount() == 0 || currentPolicy == null){
                            continue;
                        }
                        else{
                            insuranceArray[Insurance.getPolicyCount() - 1] = currentPolicy;
                        }
                    }
                }
                else if (choice == 2){
                    insuranceArray = removePolicy(insuranceArray);
                }
                else if (choice == 3){
                    viewPolicy(insuranceArray, MAX_POLICIES);
                }
                else if (choice == 4){
                    JOptionPane.showMessageDialog(null, "Exiting, thank you for using my program.");
                    return;
                }
            }
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Please enter a valid integer associated with an option on the menu.");
            }
        }while (choice != 4);
    }








    //Customer choice function
    public static int customerChoice(){
        String input = JOptionPane.showInputDialog("Frizzar Insurance Company Selection Menu\n" +
        "Please one of the following options\n\n" +
        "(1) Add a new policy\n" +
        "(2) Remove a policy\n" +
        "(3) View all policies\n" +
        "(4) Quit Program");

        if (input == null){
            return 4;
        }

        try{
            int option = Integer.parseInt(input);
            if (option == 4){
                    return 4;
                }
            else if (option < 1 || option > 4){
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer associated with an option on the menu.");
                    return -1;
                }
            return option;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer associated with an option on the menu.");
            return -1;
        }
    }

    //Add a policy method
    public static Insurance addPolicy(){
        String input = JOptionPane.showInputDialog("What kind of insurance policy would you like to add?\n" +
        "(1) Auto Insurance Policy\n" +
        "(2) Home Insurance Policy\n" +
        "(3) Life Insurance Policy\n");

        //User input was cancelled insurance counter is decremented and method is exited.
        if (input == null){
            JOptionPane.showMessageDialog(null, "Returning to main menu.");
            return null;
        }
        int option = Integer.parseInt(input);
        
        //Create Auto Insurance Object
        if (option == 1){
            String policyNumber = prompt("Enter a 5 character policy number.");
            String policyOwner = prompt("Enter the first and last name of the policy owner.");
            String policyPremium = prompt("Enter the yearly premium of this policy.");
            String vinNumber = prompt("Enter the VIN number.");
            String carMake = prompt("Enter the make.");
            String carModel = prompt("Enter the model.");

            if (policyNumber == null || policyOwner == null || policyPremium == null || vinNumber == null
                || carMake == null || carModel == null){
                    AutoInsurance.decrementCount();
                    JOptionPane.showMessageDialog(null, "Please enter value for each of the options. Returning to main menu.");
                    return null;
                }
            
            try{
                double premium = Double.parseDouble(policyPremium);

                AutoInsurance currentAutoPolicy = new AutoInsurance();
                currentAutoPolicy.setPolicyNumber(policyNumber);
                currentAutoPolicy.setPolicyOwner(policyOwner);
                currentAutoPolicy.setYearlyPremium(premium);
                currentAutoPolicy.setVin(vinNumber);
                currentAutoPolicy.setMake(carMake);
                currentAutoPolicy.setModel(carModel);
                JOptionPane.showMessageDialog(null, "Auto Policy Succesfully Created.");
                return currentAutoPolicy;

            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Decimal input expected.");
                return null;
            }
        }

        //Create Home Insurance Object
        else if (option == 2){
            String policyNumber = prompt("Enter a 5 character policy number.");
            String policyOwner = prompt("Enter the first and last name of the policy owner.");
            String policyPremium = prompt("Enter the yearly premium of this policy.");
            String address = prompt("Enter the address.");
            String yearBuilt = prompt("Enter the year built.");
            String deductibleString = prompt("Enter the deductible.");

            if (policyNumber == null || policyOwner == null || policyPremium == null || address == null
                || yearBuilt == null || deductibleString == null){
                    JOptionPane.showMessageDialog(null, "Please enter value for each of the options. Returning to main menu.");
                    HomeInsurance.decrementCount();
                    return null;
                }
            
            try{
                double deductible = Double.parseDouble(deductibleString);
                double premium = Double.parseDouble(policyPremium);

                HomeInsurance currentHomePolicy = new HomeInsurance();
                currentHomePolicy.setPolicyNumber(policyNumber);
                currentHomePolicy.setPolicyOwner(policyOwner);
                currentHomePolicy.setYearlyPremium(premium);
                currentHomePolicy.setAddress(address);
                currentHomePolicy.setYearBuilt(yearBuilt);
                currentHomePolicy.setDeductible(deductible);
                JOptionPane.showMessageDialog(null, "Home Policy Succesfully Created.");
                return currentHomePolicy;

            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Decimal input expected.");
                return null;
            }
        }
        //Create Life Insurance Object
        else if (option == 3){
            String policyNumber = prompt("Enter a 5 character policy number.");
            String policyOwner = prompt("Enter the first and last name of the policy owner.");
            String policyPremium = prompt("Enter the yearly premium of this policy.");
            String beneficiary = prompt("Enter a beneficiary.");
            String faceValueString = prompt("Enter the face value.");

            if (policyNumber == null || policyOwner == null || policyPremium == null || beneficiary == null
                || faceValueString == null){
                    JOptionPane.showMessageDialog(null, "Please enter value for each of the options. Returning to main menu.");
                    LifeInsurance.decrementCount();
                    return null;
                }
            
            try{
                double faceValue = Double.parseDouble(faceValueString);
                double premium = Double.parseDouble(policyPremium);

                LifeInsurance currentLifePolicy = new LifeInsurance();
                currentLifePolicy.setPolicyNumber(policyNumber);
                currentLifePolicy.setPolicyOwner(policyOwner);
                currentLifePolicy.setYearlyPremium(premium);
                currentLifePolicy.setBeneficiary(beneficiary);
                currentLifePolicy.setFaceValue(faceValue);
                JOptionPane.showMessageDialog(null, "Home Policy Succesfully Created.");
                return currentLifePolicy;

            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Decimal input expected.");
                return null;
            }
    }
    return null;
}
    

    public static Insurance[] removePolicy(Insurance[] InsuranceArray){
        String allPolicies = "";
        int option = 0;

        if(Insurance.getPolicyCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no policies currently.");
            return InsuranceArray;
        }

        for(int i = 0; i < Insurance.getPolicyCount(); i++){
            allPolicies += "(" + (i + 1) + ") " + InsuranceArray[i].toString() + "\n";
        }
        
        try{
            //Take user option an subtract 1 from it to correspond to element in array
            option = Integer.parseInt(JOptionPane.showInputDialog(allPolicies + "\nSelect the policy that you want to remove.")) - 1;   
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return InsuranceArray;
        }

        if(option < 0 || option > Insurance.getPolicyCount() - 1){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return InsuranceArray;
        }
        
        for(int i = option; i < InsuranceArray.length - 1; i++){
            InsuranceArray[i] = InsuranceArray[i + 1];
        }
        
        //Setting the final element to null due to not being able to do it in the for loop
        InsuranceArray[InsuranceArray.length - 1] = null;
        Insurance.decrementCount();
        return InsuranceArray;
    }

    public static void viewPolicy(Insurance[] InsuranceArray, int MAX_POLICIES){
        String allPolicies = "";

        if(Insurance.getPolicyCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no policies currently.\n Returning to main menu");
            return;
        }

        for(int i = 0; i < Insurance.getPolicyCount(); i++){
            allPolicies += "(" + (i + 1) + ") " + InsuranceArray[i].toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, allPolicies);
    }

    private static String prompt(String message){
        String input = JOptionPane.showInputDialog(message);
        //Check if input is null or empty
        if(input == null || input.isEmpty()){
            return null;
        }
        return input;
    }
}