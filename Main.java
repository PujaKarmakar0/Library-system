import java.util.*;
/** Main class
 *       20194981 Puja Karmakar
 *       20195649 Abdulrahman Juma Tawfeeq Aldoseri
 *       20187601 Yousif Hussain Ghuloom
 */
public class Main {
    public static void main(String[] args){
        long aNum = 1001;
        Scanner kbd = new Scanner(System.in);
        LibrarySystem ITLib = new LibrarySystem();

        System.out.println("Welcome to Library System!");
        System.out.println("How can we help you? :)");

        System.out.println("Enter \n 'A' to \"Add a new Member\"" +
                "\n 'B' to \"Add a new Book\"" +
                "\n 'C' to \"Delete a member\"" +
                "\n 'D' to \"Delete a book\"" +
                "\n 'E' to \"Search for a book\"" +
                "\n 'F' to \"Print details of all books issued to a member\"" +
                "\n 'G' to \"Issue a book\"" +
                "\n 'H' to \"Return a book\"" +
                "\n 'Exit' to \"exit program\"");
        String input = kbd.next();

        while (true){

            // Exits the program if user enters exit.
            if (input.equalsIgnoreCase("exit")){
                System.out.println("Thank you for coming. \nHave a nice day :) ");
                System.exit(0);
            } //end of if

            // Adds a new member in linkedList membersList from class LibrarySystem
            else if (input.equalsIgnoreCase("A")){

                System.out.println("Enter full name of the member (First and Last Name only :D)");
                String firstName = kbd.next();
                String lastName = kbd.next();

                System.out.println("Enter gender");
                char gender = kbd.next().charAt(0);

                System.out.println("Enter CPR number");
                long cprNum = kbd.nextLong();

                System.out.println("Enter telephone number");
                String teleNum = kbd.next();

                LibMember newMember = new LibMember(firstName, lastName, gender, cprNum, teleNum);
                if (!ITLib.addMember(newMember))
                    System.out.println("Member already exists!");
                else
                    System.out.println("Member added successfully.");
            } //end of else if

            // Adds a new book in linkedList books from class LibrarySystem
            else if (input.equalsIgnoreCase("B")){

                System.out.println("Enter Title of the book (Use - in place of space)");
                String title = kbd.next();

                System.out.println("Enter Author 1 (Use - in place of space)");
                String author1 = kbd.next();

                System.out.println("Enter Author 2 (Use - in place of space)");
                String author2 = kbd.next();

                System.out.println("Enter Publisher (Use - in place of space)");
                String publisher = kbd.next();

                System.out.println("Enter Publication year");
                int pyear = kbd.nextInt();

                System.out.println("Enter ISBN of the book");
                String isbn = kbd.next();

                Book newBook = new Book(title, author1, author2, publisher, pyear, isbn, aNum);
                if (ITLib.addBook(newBook)){
                    System.out.println("Book added successfully." +
                            "\nAccession Number of this book is: " + aNum);
                    aNum++;
                }
                else
                    System.out.println("Book already exists!");
            } //end of else if

            /**
             * Takes CPR Number of the member from user and deletes
             * the respective member from the membersList
             * @param cpr CPR Number of the member to be deleted
             */
            else if (input.equalsIgnoreCase("C")){
                System.out.println("Enter CPR number of the member.");
                long cpr = kbd.nextLong();
                if (ITLib.deleteMember(cpr))
                    System.out.println("Member deleted successfully.");
                else
                    System.out.println("Can't delete member!");
            } //end of else if

            /**
             * Takes Accession  number of the book from user and deletes
             * the respective book from the booksList
             * @param anum Accession number of the book to be deleted
             */
            else if (input.equalsIgnoreCase("D")){
                System.out.println("Enter Accession number of the book.");
                long anum = kbd.nextLong();
                if (ITLib.deleteBook(anum))
                    System.out.println("Book deleted successfully.");
                else
                    System.out.println("Book doesn't exist!");
            } //end of else if

            /**
             * Takes Accession number of a book from user and searches if book is available
             * @param anum Accession number of the book to be searched
             */
            else if (input.equalsIgnoreCase("E")){
                System.out.println("Enter Accession number of the book.");
                long anum = kbd.nextLong();
                if (ITLib.searchBook(anum)!=-1 && !ITLib.isBookIssued(anum))
                    System.out.println("Book available.");
                if (ITLib.searchBook(anum) == -1)
                    System.out.println("Book doesn't exist.");
                if (ITLib.isBookIssued(anum))
                    System.out.println("Book is issued to some other member.");
            } //end of else if

            /**
             * Takes CPR number of the member from user and prints details of all
             * books issued to that member
             * @param cpr CPR number of the member whose issued books are to be printed
             */
            else if (input.equalsIgnoreCase("F")){
                System.out.println("Enter CPR Number of the member.");
                long cpr = kbd.nextLong();
                ITLib.printBooksIssued(cpr);

            } //end of else if

            /**
             * Takes Accession number of a book and CPR number of a member and issues that
             * book to that member
             * @param anum Accession number of the book
             * @param cpr CPR number of the member
             */
            else if (input.equalsIgnoreCase("G")){
                System.out.println("Enter Accession number of the book");
                long anum = kbd.nextLong();
                System.out.println("Enter CPR number of the member");
                long cpr = kbd.nextLong();
                if (ITLib.issueBook(anum, cpr))
                    System.out.println("Book issued successfully");
                else
                    System.out.println("Book couldn't be issued. Try again later.");
            } //end of else if

            /**
             * Takes Accession number of a book and returns the book
             * @param anum Accession number of the book
             */
            else if (input.equalsIgnoreCase("H")){
                System.out.println("Enter Accession number of the book.");
                long anum = kbd.nextLong();
                if (ITLib.returnBook(anum))
                    System.out.println("Book returned successfully.");
                else
                    System.out.println("Book couldn't be returned. Try again later.");

            } //end of else if
            else
                System.out.println("Invalid code. Try again.");

            System.out.println("Enter \n 'A' to \"Add a new Member\"" +
                    "\n 'B' to \"Add a new Book\"" +
                    "\n 'C' to \"Delete a member\"" +
                    "\n 'D' to \"Delete a book\"" +
                    "\n 'E' to \"Search for a book\"" +
                    "\n 'F' to \"Print details of all books issued to a member\"" +
                    "\n 'G' to \"Issue a book\"" +
                    "\n 'H' to \"Return a book\"" +
                    "\n 'Exit' to \"exit program\"");
            input = kbd.next();
        } //End of while loop
    } //End of main
} //End of class Main
