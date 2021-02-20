package rest;
import java.util.*;
import java.util.ArrayList;

//**************************

//Author: Olle Bergström Jonsson

//Date: 2021-02-20

//Description: Class with main method for a program which resembles a REST service
//Takes input from user to manipulate a database of business cards. Run Database.java to initiate program.

//**************************

/**
 * Creates a database from user input.
 * Stores input values as objects Persons and
 *      keys as integers.
 */
public class Database  {
    public static HashMap<Integer, Person> personMap = new HashMap<>();
    // create hashmap to hold Keys and Persons
    public static ArrayList<Integer> keyList = new ArrayList<Integer>();
    // create an arraylist of integers to hold keys

    /**
     * Method takes parameters and creates a new Person object, stores
     * the telephone number as a key to the object in the key list
     * and adds the Person to the person map under the given key
     *
     * @param name String first name of person
     * @param surName string surname of person
     * @param telephone string telephone number
     * @param email string email address
     * @param image string image
     */

    public static void create(String name, String surName, String telephone, String email, String image){

        int key = Integer.parseInt(telephone);
        keyList.add(key);
        personMap.put(key,new Person(name, surName, telephone, email, image));
    }


    /**
     * method to collect all persons from the personMap
     * and create business cards for each person
     */
    public static void read(){
        for (Integer integer : keyList) {
            Person tempPerson = personMap.get(integer);
            CreateCard.Card(tempPerson);
        }
    }


    /**
     * Method to update the information about
     * a certain person
     */
    public static void update(){
        Scanner updateScanKey = new Scanner(System.in);
        System.out.println("Please enter the telephone number of the " +
                "contact you wish to update: ");
        try{
            int updateKey = updateScanKey.nextInt();
            if(personMap.containsKey(updateKey)){
                Person toBeUpdated = personMap.get(updateKey);
                Scanner updateScan = new Scanner(System.in);
                System.out.println("Please enter the new information," +
                        " first name, last name, telephone number, email address, " +
                        "path to image (separated by commas).");
                String lineUpd = updateScan.nextLine();
                String[] listUpd = lineUpd.split("[ ,]+");
                int newKey = Integer.parseInt(listUpd[2]);
                if(newKey!=updateKey){
                    // if the new phone number is not
                    // the same as the old one, delete
                    // the person and create a new person
                    delete(updateKey);
                    create(listUpd[0],listUpd[1],listUpd[2],listUpd[3],listUpd[4]);

                }
                // if the new telephone number is
                // the same as the old one, update
                // the following properties of person
                toBeUpdated.setName(listUpd[0]);
                toBeUpdated.setSurname(listUpd[1]);
                toBeUpdated.setEmail(listUpd[3]);
                toBeUpdated.setImage(listUpd[4]);
        }
            else{
                System.out.println("Key does not exist in database, please try again");
            }

        }

        catch (Exception InputMismatchException){
            System.out.println("Invalid key, please try again (integers only)");
        }
    }


    /**
     * Method to delete a given person from the map
     * @param keyToDelete integer key (telephone number)
     *                   for the person to be deleted
     */
    public static void delete(int keyToDelete){
        personMap.remove(keyToDelete);
        keyList.remove((Integer) keyToDelete);
    }


    public static void main(String[] args){
        System.out.println("Welcome to the business card database!");
        boolean going = true;
        // creating a never ending while loop just for the purpose of being
        // able to test the program thoroughly
        while (going){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please type \"create\" to create, \"read\" to read, " +
                    "\"update\" to update, or \"delete\" to delete.");
            String input = scanner.nextLine();
            // 4 if statements to interpret the input from the user
            if(input.equalsIgnoreCase("create")){
                try{
                    Scanner scanCreate = new Scanner(System.in);
                    System.out.println("Please type first name, last name, telephone number, " +
                            "email address, path to image (separated by commas).");
                    String line = scanCreate.nextLine();
                    String[] list = line.split("[ ,]+");
                    create(list[0],list[1],list[2],list[3],list[4]);
                }
                catch (Exception ArrayIndexOutOfBoundsException){
                    System.out.println("Invalid input, please try again");
                }
            }
            if(input.equalsIgnoreCase("read")){
                read();
                }
            if(input.equalsIgnoreCase("update")){
                update();
            }
            if(input.equalsIgnoreCase("delete")){
                System.out.println("Please enter the telephone number of the person" +
                        "you wish to delete from the record: ");
                Scanner scanDelete = new Scanner(System.in);
                try{
                    int keyToDelete = scanDelete.nextInt();
                    System.out.println("Are you sure you want to delete "+ personMap.get(keyToDelete).name + "from the database?");
                    Scanner yesNo = new Scanner(System.in);
                    System.out.println("Y/N:");
                    if(yesNo.nextLine().equalsIgnoreCase("Y")){
                        delete(keyToDelete);
                    }
                }
                catch (Exception InputMismatchException){
                    System.out.println("Invalid key, please try again (integers only)");
                }
            }
        }
    }
}
