package module7;

import java.util.ArrayList;

public class NoDups {
    static class Book {
        String title;
        String author;
        String subject;
        int ISBN;

        public Book(String title, String author, String subject, int ISBN) {
            this.title = title;
            this.author = author;
            this.subject = subject;
            this.ISBN = ISBN;
        }

        @Override
        public String toString() {
            System.out.println(this.title, this.author, this.)
        }
    }

    static class Library {
        ArrayList<Book> sortedArray;
        ArrayList<Book> unsortedArray;
        int sortedSize;
        int dups;

        public Library() {
            this.sortedArray = new ArrayList<>();
            this.unsortedArray = new ArrayList<>();
            this.sortedSize = 0;
            this.dups = 0;
        }

        // create an instance of book class and add it to the array
        public void inputBook(String title, String author, String subject, int ISBN) {
            Book book = new Book(title, author, subject, ISBN);
            unsortedArray.add(book);
        }

        public int getSortedSize() {
            if (sortedSize == 0) {
                bookSort();
            }
            return sortedSize;
        }

        // Sort the unsorted array
        public void bookSort() {

        }

        public void display() {
            //display the data for each book in sorted array
            for (Book book : sortedArray) {
                book.toString();
            }
        }
    }

    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.inputBook("title", "author", "subject", 1234);
        myLibrary.inputBook("title2", "author2", "subject2", 2234);
        myLibrary.inputBook("title3", "author3", "subject3", 31234);
        myLibrary.inputBook("title3", "author3", "subject3", 31234);
        myLibrary.inputBook("title2", "author2", "subject2", 2234);
        myLibrary.bookSort();
        System.out.println("///////");
        System.out.println("sortedSize should = 3. Is: " + myLibrary.getSortedSize());
        System.out.println("///////");
        myLibrary.display();
    }


}
