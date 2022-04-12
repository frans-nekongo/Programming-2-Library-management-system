public class Main {

    public static void Main(String  []args) {

        borrowingbook Borrow = new borrowingbook() {



          //Method calls the borrowsBook() function
            @Override
            public void borrowsBook() {

               Customers.borrowingBook();

            }

        };
        }
    }
