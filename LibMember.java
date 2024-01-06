import java.util.*;
/**Class LibMember
 *        20194981 Puja Karmakar
 *       20195649 Abdulrahman Juma Tawfeeq Aldoseri
 *       20187601 Yousif Hussain Ghuloom
*/class LibMember {
    //Data fields
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String telephoneNum;
    Book [] booksIssued = new Book [10];
    int numBooksIssued = 0;

    //Constructors
    LibMember(){
       this.setFirstName("Unknown");
       this.setLastName("Unknown");
       this.setGender('N');
       this.setCprNum(111111111);
       this.setTelephoneNum("00000000");
       this.setNumBooksIssued(0);
    }


     // Constructor with 5 parameters
     LibMember (String fName, String lName, char g, long cpr, String tNum){
        this.setFirstName(fName);
        this.setLastName(lName);
        this.setGender(g);
        this.setCprNum(cpr);
        this.setTelephoneNum(tNum);
    }


    String getFirstName() {
        return firstName;
    }


    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    String getLastName() {
        return lastName;
    }


    private void setLastName(String lastName) {
        this.lastName = lastName;
    }


    char getGender() {
        return gender;
    }

    private  void setGender(char gender) {
        this.gender = gender;
    }


    long getCprNum() {
        return cprNum;
    }


    private void setCprNum(long cprNum) {
        this.cprNum = cprNum;
    }


    String getTelephoneNum() {
        return telephoneNum;
    }


    private void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }


    Book[] getBooksIssued() {
        return booksIssued;
    }


    void setBooksIssued(Book[] booksIssued) {
        System.arraycopy(booksIssued,0, this.booksIssued,
                0, 10  );
    }


    int getNumBooksIssued() {
        return numBooksIssued;
    }


    void setNumBooksIssued(int numBooksIssued) {
        this.numBooksIssued = numBooksIssued;
    }


    @Override
    public String toString() {
        return "LibMember { \nFirst Name = '" + firstName + "', \nlast Name = '" +
                lastName + "', \nGender = '" + gender + "', \nCPR Number = '" +
                cprNum + "', \nTelephone Number = '" + telephoneNum + "', \nBooks Issued = '" +
                Arrays.toString(booksIssued) + "', \nNumber of books issued = '" +
                numBooksIssued + "' }";
    }


      //Removes a book from array booksIssued
    void removeBook (Book book){
        for (int i = 0; i < 10; i++){
            if (booksIssued[i] == book){
                for (int j = i + 1; j < booksIssued.length; j++)
                    booksIssued[j-1] = booksIssued[j];
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibMember)) return false;

        LibMember member = (LibMember) o;
        return getCprNum() == member.getCprNum();
    }
} //End of class LibMember
