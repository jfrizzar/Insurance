import javax.swing.JOptionPane;

public class InsuraceImplementation {
    public static void main(String[] args){

    final int MAX_POLICIES = 100;
    int choice = -1;
    Insurance[] insuranceArray = new Insurance[MAX_POLICIES];

        do{
            try{
                choice = customerChoice();
                //Add a Policy Option
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
                //Remove a Policy Option
                else if (choice == 2){
                    insuranceArray = removePolicy(insuranceArray);
                }
                //View a Policy Option
                else if (choice == 3){
                    viewPolicy(insuranceArray, MAX_POLICIES);
                }
                //User Selected Exit
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
        String input = JOptionPane.showInputDialog("""
                                                   Frizzar Insurance Company Selection Menu
                                                   Please one of the following options
                                                   
                                                   (1) Add a new policy
                                                   (2) Remove a policy
                                                   (3) View all policies
                                                   (4) Quit Program""");

        //If user selects cancel
        if (input == null){
            return 4;
        }

        try{
            int option = Integer.parseInt(input);
            if (option == 4){
                    return 4;
                }
            //Check to see if valid option was given
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
        int option = -1;
        String input = JOptionPane.showInputDialog("""
                                                   What kind of insurance policy would you like to add?
                                                   (1) Auto Insurance Policy
                                                   (2) Home Insurance Policy
                                                   (3) Life Insurance Policy
                                                   """);

        //If user selects cancel
        if (input == null){
            JOptionPane.showMessageDialog(null, "Returning to main menu.");
            return null;
        }


        try{
            option = Integer.parseInt(input);
            //Check to see if valid option was given
            if (option < 1 || option > 3){
                JOptionPane.showMessageDialog(null, "Please enter a valid integer associated with an option on the menu.");
                return null;
            }
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please enter a valid integer associated with an option on the menu.");
        }

        //Create auto insurance object
        if (option == 1){
            try{         
            String policyNumber = prompt("Enter a 5 character policy number.");
            String policyOwner = prompt("Enter the full name of the policy owner.");
            String policyPremium = prompt("Enter the yearly premium of this policy.");
            String vinNumber = prompt("Enter the VIN number.");
            String carMake = prompt("Enter the make.");
            String carModel = prompt("Enter the model.");

            //Check if anything has been entered at all
            if (policyNumber == null || policyOwner == null || policyPremium == null || vinNumber == null
                || carMake == null || carModel == null){
                    AutoInsurance.decrementCount();
                    JOptionPane.showMessageDialog(null, "Please enter value for each of the options. Returning to main menu.");
                    return null;
                }
            

                double premium = Double.parseDouble(policyPremium);

                //Create object and assign user input
                AutoInsurance currentAutoPolicy = new AutoInsurance();
                currentAutoPolicy.setPolicyNumber(policyNumber);
                currentAutoPolicy.setPolicyOwner(policyOwner);
                currentAutoPolicy.setYearlyPremium(premium);
                currentAutoPolicy.setVin(vinNumber);
                currentAutoPolicy.setMake(carMake);
                currentAutoPolicy.setModel(carModel);
                JOptionPane.showMessageDialog(null, "Auto Policy Succesfully Created.");
                return currentAutoPolicy;

            }
            catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Decimal input expected.");
                return null;
            }catch (IllegalArgumentException iae){
                JOptionPane.showMessageDialog(null, iae.getMessage());
                AutoInsurance.decrementCount();
                return null;
            }
        }

        //Create home insurance object
        else if (option == 2){
            String policyNumber = prompt("Enter a 5 character policy number.");
            String policyOwner = prompt("Enter the full name of the policy owner.");
            String policyPremium = prompt("Enter the yearly premium of this policy.");
            String address = prompt("Enter the address.");
            String yearBuilt = prompt("Enter the year built.");
            String deductibleString = prompt("Enter the deductible.");

            //Check to see if anything was put in at all
            if (policyNumber == null || policyOwner == null || policyPremium == null || address == null
                || yearBuilt == null || deductibleString == null){
                    JOptionPane.showMessageDialog(null, "Please enter value for each of the options. Returning to main menu.");
                    HomeInsurance.decrementCount();
                    return null;
                }
            
            try{
                double deductible = Double.parseDouble(deductibleString);
                double premium = Double.parseDouble(policyPremium);

                //Create object and assign user input
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
            }catch (IllegalArgumentException iae){
                JOptionPane.showMessageDialog(null, iae.getMessage());
                AutoInsurance.decrementCount();
                return null;
            }
        }
        //Create life insurance object
        else if (option == 3){
            String policyNumber = prompt("Enter a 5 character policy number.");
            String policyOwner = prompt("Enter the full name of the policy owner.");
            String policyPremium = prompt("Enter the yearly premium of this policy.");
            String beneficiary = prompt("Enter a beneficiary.");
            String faceValueString = prompt("Enter the face value.");

            //Check to see if anything was input at all
            if (policyNumber == null || policyOwner == null || policyPremium == null || beneficiary == null
                || faceValueString == null){
                    JOptionPane.showMessageDialog(null, "Please enter value for each of the options. Returning to main menu.");
                    LifeInsurance.decrementCount();
                    return null;
                }
            
            try{
                double faceValue = Double.parseDouble(faceValueString);
                double premium = Double.parseDouble(policyPremium);

                //Create object and assign user input
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
            }catch (IllegalArgumentException iae){
                JOptionPane.showMessageDialog(null, iae.getMessage());
                Insurance.decrementCount();
            }
    }
    return null;
}
    
    //Remove a policy method
    public static Insurance[] removePolicy(Insurance[] InsuranceArray){
        String allPolicies = "";
        int option = 0;

        //Check if there are any policies to remove
        if(Insurance.getPolicyCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no policies currently.");
            return InsuranceArray;
        }

        //Create a formatted string with all policies
        for(int i = 0; i < Insurance.getPolicyCount(); i++){
            allPolicies += "(" + (i + 1) + ") " + InsuranceArray[i].toString() + "\n";
        }
        
        try{
            //Subtract 1 from option for it to correspond to the correct element in array
            option = Integer.parseInt(JOptionPane.showInputDialog(allPolicies + "\nSelect the policy that you want to remove.")) - 1;   
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return InsuranceArray;
        }

        //Check to see if the option is an option in the menu
        if(option < 0 || option > Insurance.getPolicyCount() - 1){
            JOptionPane.showMessageDialog(null, "Error, please enter a number that is available on the menu.");
            return InsuranceArray;
        }
        
        //This for loop shifts the array elements to the left and saves over the option to be removed
        for(int i = option; i < InsuranceArray.length - 1; i++){
            InsuranceArray[i] = InsuranceArray[i + 1];
        }
        
        //Setting the final element to null due to not being able to do it in the for loop without a null pointer exception
        InsuranceArray[InsuranceArray.length - 1] = null;
        Insurance.decrementCount();
        return InsuranceArray;
    }

    //View a policy method
    public static void viewPolicy(Insurance[] InsuranceArray, int MAX_POLICIES){
        String allPolicies = "";
        //Check to see if there are any available policies
        if(Insurance.getPolicyCount() == 0){
            JOptionPane.showMessageDialog(null, "There are no policies currently.\n Returning to main menu");
            return;
        }
        //Build the formatted string
        for(int i = 0; i < Insurance.getPolicyCount(); i++){
            allPolicies += "(" + (i + 1) + ") " + InsuranceArray[i].toString() + "\n";
        }
        //Display the string
        JOptionPane.showMessageDialog(null, allPolicies);
    }

    //String prompt helper
    private static String prompt(String message){
        String input = JOptionPane.showInputDialog(message);
        //Check if input is null or empty
        if(input == null || input.isEmpty()){
            return null;
        }
        return input;
    }
}