import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] library = new Book[10];
        library[0] = new ProgrammingBook("P01","Java Basic",25000,"ABC","Java","abc");
        library[1] = new ProgrammingBook("P02","Java OOP",40000,"ABC","Java","abc");
        library[2] = new ProgrammingBook("P03","C++ Basic",24000,"ABC","C++","xyz");
        library[3] = new ProgrammingBook("P04","PHP Basic",19000,"CDE","PHP","xyz");
        library[4] = new ProgrammingBook("P05","Python Basic",30000,"CDE","Python","abc");
        library[5] = new FictionBook("F01","FictionBook1",50000,"XYZ","01");
        library[6] = new FictionBook("F02","FictionBook2",15000,"XYZ","02");
        library[7] = new FictionBook("F03","FictionBook3",45000,"MNP","03");
        library[8] = new FictionBook("F04","FictionBook4",27000,"HIJ","04");
        library[9] = new FictionBook("F05","FictionBook5",52000,"MNP","05");

        // Tính tiền sách
        int sumPrice = 0;
        for (Book book : library) {
            sumPrice += book.getPrice();
        }
        System.out.println("Price of all books is: " + sumPrice);

        //Đếm số sách Java
        int countJava = 0;
        for (int i=0; i < library.length; i++) {
            if (library[i] instanceof ProgrammingBook) {
                ProgrammingBook book = (ProgrammingBook) library[i];
                if (book.getLanguage() == "Java") countJava++;
            }
        }
        System.out.println("Number of Java book is: " + countJava);

        //Tìm giá theo tên sách
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book's name: ");
        String name = sc.nextLine();

        boolean check = false;
        for (int i=0; i < library.length; i++) {
            if (library[i].getName().equals(name)) {
                System.out.println("The book " + name + " is " + library[i].getPrice() + " VND");
                check = true;
            }
        }
        if(!check) System.out.println("We don't have this book");

        //Sắp xếp theo giá
        //Bubble sort
//        for (int i=0; i < library.length-1; i++) {
//            for (int j=0; j < library.length-1-i; j++) {
//                if (library[j].getPrice() > library[j+1].getPrice()) {
//                    Book temp = library[j];
//                    library[j] = library[j+1];
//                    library[j+1] = temp;
//                }
//            }
//        }

        //Insertion sort
//        for (int i=1; i < library.length; i++) {
//            int j=i-1;
//            Book key = library[i];
//            while (j >= 0 && library[j].getPrice() > key.getPrice()) {
//                library[j+1] = library[j];
//                j--;
//            }
//            library[j+1] = key;
//        }

        //Selection sort
        for (int i=0; i < library.length-1; i++) {
            int minPrice = library[i].getPrice();
            int minPriceIndex = i;
            for (int j=i+1; j < library.length; j++) {
                if (library[j].getPrice() < minPrice) {
                    minPrice = library[j].getPrice();
                    minPriceIndex = j;
                }
            }
            if (minPriceIndex != i) {
                Book temp = library[i];
                library[i] = library[minPriceIndex];
                library[minPriceIndex] = temp;
            }
        }
        System.out.println("The book list from lowest to highest price: ");
        for (Book value : library) {
            System.out.println("Name: " + value.getName() + " Price: " + value.getPrice());
        }

        //Tìm tên sách theo giá dùng Binary search
        System.out.println("Enter the price: ");
        int price = sc.nextInt();
        boolean checkBook = false;
        int low = 0;
        int high = library.length-1;
        while (!checkBook && low <= high) {
            int mid = (low + high)/2;
            if (library[mid].getPrice() == price) {
                checkBook = true;
                System.out.println("The book is: " + library[mid].getName());
            } else if (library[mid].getPrice() < price) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        if (!checkBook) System.out.println("We don't have book of this price");
    }
}
