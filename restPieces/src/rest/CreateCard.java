package rest;

//**************************

//Author: Olle Bergström Jonsson

//Date: 2021-02-20

//Run Database.java to initiate program.

//**************************


public class CreateCard {
    /**
     * Creates a 'business card' via print statements
     * @param person a Person object containing personal
     *               information about a person
     */
    public static void Card(Person person){
        System.out.println("_______________________");
        System.out.println("|      Visitkort       ");
        System.out.println("| name:"+person.name);
        System.out.println("| surName:"+person.surName);
        System.out.println("| telephone:"+person.telephone);
        System.out.println("| email:"+person.email);
        System.out.println("| image:"+person.image);
        System.out.println("________________________");
    }
}
