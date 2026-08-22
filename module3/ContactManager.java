import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Phara Reid", new Contact("Phara Reid", "215-887-6345"));
        contacts.put("Holly Pilly", new Contact("Holly Pilly", "267-987-2367"));
        contacts.put("Tessa Smalls", new Contact("Tessa Smalls", "876-932-5720"));
        contacts.put("Jacob Hall", new Contact("Jacob Hall", "917-482-4759"));
        contacts.put("Stanley Baker", new Contact("Stanley Baker", "407-274-2471"));
        
        // Step 5: look up a contact 
            Contact find = contacts.get("Ada Lovelace");
            if(find != null){
                System.out.println("Contact details: "+ find.toString());
            }
            else
            {
                System.out.println("Contact not found");
            }

        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName())); 
        
        System.out.println("===== Sorted Contacts ======");

        for(Contact sort : sorted)
        {
            System.out.println(sort);
        }
    } 
}