package org.exceptionhandling;

public class User {
    private String name;
    private String address;
    private String email;
    private String contact;

    public User(String name, String address, String email, String contact) {
        try{
            if(name.isEmpty() || address.isEmpty() || email.isEmpty() || contact.isEmpty()){
                throw new RuntimeException("Kindly fill all the details");
            }
            if(name.contains("@")){
                throw new RuntimeException("Name should not contain special character");
            }
            if(address.length() > 100){
                throw new RuntimeException("Address should be less than 100 characters");
            }
            if(!email.contains("@")){
                throw new RuntimeException("Email id is not valid, Kindly provide correct email id");
            }
            if(contact.length() > 10){
                throw new RuntimeException("Contact should not be more than 10 digits");
            }
            this.name = name;
            this.address = address;
            this.email = email;
            this.contact = contact;
        } catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
