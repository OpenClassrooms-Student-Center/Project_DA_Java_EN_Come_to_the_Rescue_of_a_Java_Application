//List of imports

public class MyClass {

    public static void release1() {

/*
Declare a list of the following variables:
Participant list 
Researcher list
Person list (anyone without type)
*/

//open and read the file "people.json", convert it into a usable format.

//Create and save a the person in the correct format 

//            Read the file "people.json" and convert to json . 
            new BufferedReader(new FileReader("people.json"));

            JSONobject obj = new JSONobject(tmp);
            
//          classify people according to type by using the following classes 
            for (int i = 0; i < obj.length; i++) {
                tmp = "person";
                personneList.push(tmp);
                if (tmp.type === "participant") {
                    patientList.push(tmp);
                } 
                else (tmp.type === "rechercher") {
                    
                }
            }
            
//Show the list of participants 

        ParticipantList.forEach((j) -> System.out.prinltn("id:" + j.id + " ")); 

//Show the list of researchers

        Researcher.forEach((j) -> System.out.prinltn("id:" + j.id + " ")); 

//Show the list of people, by ID, without reference to type (researcher, participant).  

        Person.forEach((j) -> System.out.prinltn("id:" + j.id + " ")); 
 
}
    
    public static void main(String args[]) {
        release1();
        release2();
        release3();
    }
}
