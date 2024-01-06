/** Class Book
 *         20194981 Puja Karmakar
 *         20195649 Abdulrahman Juma Tawfeeq Aldoseri
 *         20187601 Yousif Hussain Ghuloom
*/
class Book {
    // Data Fields

    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int yearPublication;
    private String isbn;
    private long accessionNum;
    private LibMember issuedTo= 0;

    //Constructors
    //Construct a default Book
    Book(){
        this.setTitle("Unknown");
        this.setAuthor1("Unknown");
        this.setAuthor2("Unknown");
        this.setPublisher("Unknown");
        this.setYearPublication(1000);
        this.setIsbn("0000000000000");
        this.setAccessionNum(1000);
    }

    //Constructs a book with given data
    Book (String title, String author1, String author2, String publisher,
                 int yearPublication, String isbn, long accessionNum){
        this.setTitle(title);
        this.setAuthor1(author1);
        this.setAuthor2(author2);
        this.setPublisher(publisher);
        this.setYearPublication(yearPublication);
        this.setIsbn(isbn);
        this.setAccessionNum(accessionNum);
    }

    String getTitle() {
        return title;
    }


    private void setTitle(String title) {
        this.title = title;
    }


    String getAuthor1() {
        return author1;
    }


    private void setAuthor1(String author1) {
        this.author1 = author1;
    }


    String getAuthor2() {
        return author2;
    }


    private void setAuthor2(String author2) {
        this.author2 = author2;
    }


     // Returns the publisher of the book.
      String getPublisher() {
        return publisher;
    }

 //Replaces publisher with a new value
     private void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    private int getYearPublication() {
        return yearPublication;
    }

    // Replaces yearPublication with a new value
    private void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    private String getIsbn() {
        return isbn;
    }

    private void setIsbn(String isbn) {
        if(isbn.length()==13) //Checking for validity
            this.isbn = isbn;

        else
            System.out.println("Invalid value for isbn.");
    }


    long getAccessionNum() {
        return accessionNum;
    }


     // Replaces accessionNum with a new value
    private void setAccessionNum(long accessionNum) {
        if(accessionNum>=1001)//checking for validity
            this.accessionNum = accessionNum;

        else
            System.out.println("Invalid value for accession number.");
    }


    LibMember getIssuedTo() {
        return issuedTo;
    }


    void setIssuedTo(LibMember issuedTo) {
        this.issuedTo = issuedTo;
    }


     // Returns a string of every data field in Book class.
    @Override
    public String toString() {
        if (issuedTo == null)
            return "\n\nBook { Title = '" + title + "' \nAuthor 1 = '" + author1 +
                "' \nAuthor 2 = '" + author2 + "' \nPublisher = '" + publisher +
                "' \nYear Of Publication = '" + yearPublication + "' \nISBN = '" +
                isbn + "' \nAccession Number = '" + accessionNum + "' \nIssued To = '" +
                issuedTo + "' }";

        return "\n\nBook { Title = '" + title + "' \nAuthor 1 = '" + author1 +
                "' \nAuthor 2 = '" + author2 + "' \nPublisher = '" + publisher +
                "' \nYear Of Publication = '" + yearPublication + "' \nISBN = '" +
                isbn + "' \nAccession Number = '" + accessionNum + "' \nIssued To = '" +
                issuedTo.getCprNum() + "' }";
    }


     // Indicate whether two Book objects are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

              Book book = (Book) o;

        if (getIsbn() != null ? !getIsbn().equals(book.getIsbn()) : book.getIsbn() != null) return false;
    else
        return getIssuedTo() != null ? getIssuedTo().equals(book.getIssuedTo()) : book.getIssuedTo() == null;
        }
} //End of class Book
