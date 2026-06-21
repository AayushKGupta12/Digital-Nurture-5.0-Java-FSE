//1. Understand Search Algorithms
//        Linear Search
//
//        Linear Search checks each element one by one until the desired element is found or the list ends.
//
//        Characteristics
//        Simple to implement.
//        Works on both sorted and unsorted data.
//        Suitable for small datasets.
//        Time Complexity
//        Best Case: O(1)
//        Average Case: O(n)
//        Worst Case: O(n)
//
//
//        Binary Search
//
//        Binary Search repeatedly divides the sorted list into two halves to locate the desired element.
//
//        Characteristics
//        Much faster than Linear Search.
//        Works only on sorted data.
//        Suitable for large datasets.
//        Time Complexity
//        Best Case: O(1)
//        Average Case: O(log n)
//        Worst Case: O(log n)

package module2.Exercise6_Library_Management_System;

class Book {

    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return bookId + " | " + title + " | " + author;
    }
}

class SearchLibrary {
    // Linear Search
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    // Binary Search (Books must be sorted by title)
    public static Book binarySearch(Book[] books, String title) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int compare = books[mid].getTitle().compareToIgnoreCase(title);

            if (compare == 0)
                return books[mid];

            if (compare < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }
}
public class Main {

    public static void main(String[] args) {

        // Books sorted alphabetically by title
        Book[] books = {

                new Book(101, "Algorithms", "Thomas Cormen"),
                new Book(102, "Clean Code", "Robert Martin"),
                new Book(103, "Computer Networks", "Andrew Tanenbaum"),
                new Book(104, "Data Structures", "Seymour Lipschutz"),
                new Book(105, "Operating Systems", "Galvin")
        };

        Book result1 = SearchLibrary.linearSearch(books, "Clean Code");

        if (result1 != null)
            System.out.println("Linear Search Found:");
        System.out.println(result1);

        Book result2 = SearchLibrary.binarySearch(books, "Data Structures");

        if (result2 != null)
            System.out.println("\nBinary Search Found:");
        System.out.println(result2);
    }
}

//                | Operation    | Linear Search | Binary Search |
//                | ------------ | ------------- | ------------- |
//                | Best Case    | O(1)          | O(1)          |
//                | Average Case | O(n)          | O(log n)      |
//                | Worst Case   | O(n)          | O(log n)      |
//
//                Linear Search
//
//                Advantages
//
//                Works on sorted and unsorted data.
//                Easy to implement.
//                Suitable for small datasets.
//
//                Disadvantages
//
//                Slow for large datasets because every element may need to be checked
//
//
//                Binary Search
//
//                Advantages
//                    Very fast searching.
//                    Efficient for large datasets.
//                    Reduces the search space by half in each iteration.
//
//                Disadvantages
//                    Requires the data to be sorted before searching.
//
//                When to Use Each Algorithm
//                Use Linear Search when:
//                    The dataset is small.
//                    The data is not sorted.
//                    Simplicity is preferred.
//                Use Binary Search when:
//                    The dataset is large.
//                    The data is already sorted.
//                    Fast search performance is required.