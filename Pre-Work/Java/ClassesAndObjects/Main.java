class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 300);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 523);

        System.out.println("The book: " + book1.getTitle() + ", written by: " + book1.getAuthor() + ", has " + book1.getLength() + " pages.");
        System.out.println("The book: " + book2.getTitle() + ", written by: " + book2.getAuthor() + ", has " + book2.getLength() + " pages.");
    }
}