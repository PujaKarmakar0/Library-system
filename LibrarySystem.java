import java.util.*;
/**class LibrarySystem
 *       20194981 Puja Karmakar
 *       20195649 Abdulrahman Juma Tawfeeq Aldoseri
 *       20187601 Yousif Hussain Ghuloom
 */
class LibrarySystem {

    //Date Fields

    private LinkedList <Book> booksList;
    private LinkedList <LibMember> membersList;
    private int booksListSize;
    private int membersListSize;

    //Constructors
    LibrarySystem(){
        booksList = new LinkedList<>();
        membersList = new LinkedList<>();
        booksListSize = booksList.size();
        membersListSize = membersList.size();
    }


     //Inserts a book at the end of booksList
    boolean addBook (Book newBook){
        int index = 0;
        for (Book aBooksList : booksList) {
            if (newBook.equals(aBooksList))
                return false;
            index++;
        }
        booksList.add(index, newBook);
        booksListSize++;
        return true;
    }


     // Deletes a book from booksList
    boolean deleteBook (long aNum){
        if (searchBook(aNum)==-1)
            return false;

        int index = 0;
        Book b = booksList.get(index);
        while(index < booksListSize){
            if(b.getAccessionNum() == aNum && b.getIssuedTo()== null){
                booksList.remove(b);
                booksListSize--;
                return true;
            }
            index++;
            if (index < booksListSize)
            b = booksList.get(index);
        }
        return false;
    }


     // Inserts a member at the end of membersList
    boolean addMember(LibMember newMember){
        int index = 0;
        while(index < sizeMembersList()){
            if (newMember.equals(membersList.get(index)))
                return false;
            index++;
        }
        membersList.addLast(newMember);
        membersListSize++;
        return true;
    }


     // Deletes a member from membersList
    boolean deleteMember (long cpr){
        if (searchMember(cpr)==-1)
            return false;

        int index = 0;
        LibMember m = membersList.get(index);
        while(index < membersListSize){
            if (m.getCprNum()== cpr && m.getNumBooksIssued()== 0){
                membersList.remove(m);
                membersListSize--;
                return true;
            }
            index++;
            if (index < membersListSize)
            m = membersList.get(index);
        }
        return false;
    }


     // Searches for a book in booksList and returns its index
    int searchBook (long aNum){
        Iterator <Book> bookIterator = booksList.iterator();
        int index = 0;
        while (bookIterator.hasNext()){
            if (bookIterator.next().getAccessionNum() == aNum) {
                return index;
            }
            index++;
        }
        return -1;
    }


     //Searches for a member in membersList and returns its index
    private int searchMember(long cpr){
        Iterator <LibMember> memberIterator = membersList.iterator();
        int index = 0;
        while(memberIterator.hasNext()){
            if (memberIterator.next().getCprNum() == cpr){
                return index;
            }
            index++;
        }
        return -1;
    }


     // returns true if bookList is empty
      private boolean isEmptyBooksList(){
        return booksList.isEmpty();
    }


     // returns true if membersList is empty
     private boolean isEmptyMembersList(){
        return membersList.isEmpty();
    }


    private int sizeBooksList(){
        return booksListSize;
    }


    private int sizeMembersList(){
        return membersListSize;
    }


         //Issues a book to a member
      boolean issueBook(long aNum, long cpr){
        if (searchBook(aNum) == -1) return false;
        if (searchMember(cpr) == -1) return false;

        if (isEmptyMembersList()) return false;
        if (isEmptyBooksList()) return false;

        int bookCount = 0, bookIndex;
        int memberCount = 0;
        Book b;
        LibMember m;
        while (bookCount < booksListSize){
            b = booksList.get(bookCount);
            if (b.getAccessionNum()== aNum && b.getIssuedTo() == null){
                bookIndex = bookCount;
                while (memberCount < membersListSize){
                    m = membersList.get(memberCount);
                    if (m.getCprNum() == cpr && m.getNumBooksIssued() < 10){
                        m.booksIssued[m.getNumBooksIssued()] = booksList.get(bookIndex);
                        m.setNumBooksIssued(m.getNumBooksIssued()+1);
                        booksList.get(bookIndex).setIssuedTo(membersList.get(memberCount));
                        return true;
                    }
                    memberCount++;
                }
            }
            bookCount++;
        }
        return false;
    }


     // returns true after removing the book from member's issuedBooks
     boolean returnBook(long aNum){
        int index = 0;
        Book b;
        if (searchBook(aNum)== -1)
            return false;
        while (index < booksListSize){
            b = booksList.get(index);
            if (b.getAccessionNum()== aNum && booksList.get(index).getIssuedTo()!= null) {
               booksList.get(index).getIssuedTo().numBooksIssued--;
               booksList.get(index).getIssuedTo().removeBook(booksList.get(index));
               booksList.get(index).setIssuedTo(null);
               return true;
            }
            index++;
        }
        return false;
    }


     // returns details of all books issued to a member
    void printBooksIssued(long cpr){
        int index = 0;
        if (searchMember(cpr) == -1)
            System.out.println("Member doesn't exist.");
        LibMember m = membersList.get(index);
        while (index < sizeMembersList() ){
            if (m.getCprNum() == cpr){
                System.out.println(Arrays.toString(m.getBooksIssued()));
                return;
            }
            index++;
            if (index < sizeMembersList())
            m = membersList.get(index);
        }
    }


     // returns true if book is issued to a member
     boolean isBookIssued(long aNum) {
        int index = 0;
        if (searchBook(aNum) == -1)return false;
        Book b = booksList.get(index);
        while (index < sizeBooksList()){
            if (b.getAccessionNum()== aNum && b.getIssuedTo()!= null)
                return true;
            index++;
            if (index < sizeBooksList())
            b = booksList.get(index);
        }
        return false;
    }
} // End of class LibrarySystem
