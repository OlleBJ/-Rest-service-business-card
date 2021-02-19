package rest;

/**
 * Class to create a Person object holding
 * personal information
 */
public class Person {
    /**
     * Create placeholders for personal information
     */
    public String name, surName, telephone, email, image;

    /**
     *
     * @param name String first name of person
     * @param surName string surname of person
     * @param telephone string telephone number
     * @param email string email address
     * @param image string image
     */
    public Person(String name, String surName, String telephone, String email, String image){
        setName(name);
        setSurname(surName);
        setTelephone(telephone);
        setEmail(email);
        setImage(image);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surName){
        this.surName = surName;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setImage(String image){
        this.image = image;
    }
}
