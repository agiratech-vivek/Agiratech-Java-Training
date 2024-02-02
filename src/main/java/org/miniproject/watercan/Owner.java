package org.miniproject.watercan;

import org.miniproject.watercan.exception.InvalidOwnerException;

public class Owner {
    private String name;
    private String address;
    private String phoneNumber;
    private WaterCan waterCanList;

    public Owner(String name, String address, String phoneNumber) throws InvalidOwnerException {
        if(name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()){
            throw new InvalidOwnerException("Please provide all owner details");
        }
        if(name.contains("@")){
            throw new InvalidOwnerException("Name should not contain any special characters");
        } else if (address.length() > 50){
            throw new InvalidOwnerException("Address provided is too long, Kindly mention address in 50 characters");
        } else if(phoneNumber.length() != 10){
            throw new InvalidOwnerException("Phone number incorrect, it should contain 10 digits");
        }
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.waterCanList = new WaterCan();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public WaterCan getWaterCanList() {
        return waterCanList;
    }

    public void setWaterCanList(WaterCan waterCanList) {
        this.waterCanList = waterCanList;
    }

    public void stockWaterCan(WaterCan waterCan) throws RuntimeException{
        if (this.name.isEmpty() && this.address.isEmpty() && this.phoneNumber.isEmpty()) {
            throw new RuntimeException("Kindly add the owner first");
        }
        if (waterCan.getOneLitre() < 0
                || waterCan.getFiveLitre() < 0
                || waterCan.getTenLitre() < 0
                || waterCan.getTwentyFiveLitre() < 0)
        {
            throw new RuntimeException("Kindly provide correct water-can details to continue");
        }
        waterCanList.setOneLitre(waterCanList.getOneLitre() + waterCan.getOneLitre());
        waterCanList.setFiveLitre(waterCanList.getFiveLitre() + waterCan.getFiveLitre());
        waterCanList.setTenLitre(waterCanList.getTenLitre() + waterCan.getTenLitre());
        waterCanList.setTwentyFiveLitre(waterCanList.getTwentyFiveLitre() + waterCan.getTwentyFiveLitre());
        System.out.println();
        System.out.println("Water-cans inventory has been updated");
        System.out.println(waterCanList.toString());
        System.out.println();
    }

    public void sellWaterCan(WaterCan waterCan) {
        try {
            if (
                    waterCan.getOneLitre() > waterCanList.getOneLitre()
                            || waterCan.getFiveLitre() > waterCanList.getFiveLitre()
                            || waterCan.getTenLitre() > waterCanList.getTenLitre()
                            || waterCan.getTwentyFiveLitre() > waterCanList.getTwentyFiveLitre()
            ) {
                throw new RuntimeException("Cannot sell! You can sell units upto the inventory size of respective water-cans");
            }
            waterCanList.setOneLitre(waterCanList.getOneLitre() - waterCan.getOneLitre());
            waterCanList.setFiveLitre(waterCanList.getFiveLitre() - waterCan.getFiveLitre());
            waterCanList.setTenLitre(waterCanList.getTenLitre() - waterCan.getTenLitre());
            waterCanList.setTwentyFiveLitre(waterCanList.getTwentyFiveLitre() - waterCan.getTwentyFiveLitre());
            System.out.println();
            System.out.println("Water-cans inventory has been updated");
            System.out.println(waterCanList.toString());
            System.out.println();
        } catch (RuntimeException runtimeException) {
            System.err.println(runtimeException.getMessage());
        }
    }
}