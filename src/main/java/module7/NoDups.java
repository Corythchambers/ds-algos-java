package module7;

import java.util.ArrayList;
import java.util.List;

public class NoDups {
    static class Book implements Comparable<Book> {
        String title;
        String author;
        String subject;
        String ISBN;

        public Book(String title, String author, String subject, String ISBN) {
            this.title = title;
            this.author = author;
            this.subject = subject;
            this.ISBN = ISBN;
        }

        @Override
        public String toString() {
            return "Title: " + this.title
                    + "\n Author: " + this.author
                    + "\n Subject: " + this.subject
                    + "\n ISBN: " + this.ISBN;
        }

        @Override
        public int compareTo(Book other) {
            return this.ISBN.compareTo(other.ISBN);
        }

        public String getISBN() {
            return ISBN;
        }
    }

    static class Library {
        private List<Book> unsortedBooks;
        private List<Book> sortedBooks;
        private int sortedSize;
        private int dups;

        public Library() {
            this.unsortedBooks = new ArrayList<>();
            this.sortedBooks = new ArrayList<>();
            this.sortedSize = 0;
            this.dups = 0;
        }

        // create an instance of book class and add it to the array
        public void inputBook(String title, String author, String subject, String ISBN) {
            Book book = new Book(title, author, subject, ISBN);
            unsortedBooks.add(book);
        }

        public int getSortedSize() {
            return sortedBooks.size();
        }

        // Sort the unsorted array
        public int bookSort() {
            if (unsortedBooks.isEmpty()) {
                return 0;
            }

            sortedBooks = mergeSort(unsortedBooks);
            sortedSize = sortedBooks.size();
            return dups;
        }

        private List<Book> mergeSort(List<Book> books) {
            if (books.size() <= 1) {
                return books;
            }

            int mid = books.size() / 2;
            List<Book> left = new ArrayList<>(books.subList(0, mid));
            List<Book> right = new ArrayList<>(books.subList(mid, books.size()));

            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right);
        }

        private List<Book> merge(List<Book> left, List<Book> right) {
            List<Book> merged = new ArrayList<>();
            int i = 0, j = 0;

            while (i < left.size() && j < right.size()) {
                int compare = left.get(i).compareTo(right.get(j));
                if (compare < 0) {
                    merged.add(left.get(i++));
                } else if (compare > 0) {
                    merged.add(right.get(j++));
                } else {
                    merged.add(left.get(i++));
                    j++;
                    dups++;
                }
            }

            while (i < left.size()) {
                merged.add(left.get(i++));
            }

            while (j < right.size()) {
                merged.add(right.get(j++));
            }

            return merged;
        }

        public void display() {
            for (Book book : sortedBooks) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.inputBook("title", "author", "subject", "1234");
        myLibrary.inputBook("title2", "author2", "subject2", "2234");
        myLibrary.inputBook("title3", "author3", "subject3", "31234");
        myLibrary.inputBook("title3", "author3", "subject3", "31234");
        myLibrary.inputBook("title2", "author2", "subject2", "2234");
        System.out.println("bookSort should be 2 dups got: " + myLibrary.bookSort());
        System.out.println("///////");
        System.out.println("sortedSize should = 3. Is: " + myLibrary.getSortedSize());
        System.out.println("///////");
        myLibrary.display();
    }
}
