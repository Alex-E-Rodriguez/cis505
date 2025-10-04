/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_4.BowlingShopApp;

public class ProductDB {
    
    /** 
     * Method with one argument, which is used to retrieve a list of products in a particular code category.
     * @param String code
     * @return a generic queue of products based on the input code (b for Ball, s for Shoe, a for Bag)
    */
    public static GenericQueue<Product> getProducts(String code) 
    {
        // If the user selection is B/b for bowling ball, create five new Ball instances to put into a queue to return.
        if (code.equalsIgnoreCase("b")) 
        {
            Ball ball1 = new Ball();
            ball1.setCode("B100");
            ball1.setDescription("Black Widow");
            ball1.setPrice(144.95);
            ball1.setColor("Black and Red");
            Ball ball2 = new Ball();
            ball2.setCode("B200");
            ball2.setDescription("Arctic Vibe");
            ball2.setPrice(103.99);
            ball2.setColor("White and Purple");
            Ball ball3 = new Ball();
            ball3.setCode("B300");
            ball3.setDescription("Brunswick Rhino");
            ball3.setPrice(89.99);
            ball3.setColor("Teal and Black");
            Ball ball4 = new Ball();
            ball4.setCode("B400");
            ball4.setDescription("Infinity Quest");
            ball4.setPrice(169.99);
            ball4.setColor("White, Pink, and Blue");
            Ball ball5 = new Ball();
            ball5.setCode("B500");
            ball5.setDescription("Trouble Maker");
            ball5.setPrice(154.95);
            ball5.setColor("White, Black, and Lime");
            GenericQueue<Product> balls = new GenericQueue<Product>();
            balls.enqueue(ball1);
            balls.enqueue(ball2);
            balls.enqueue(ball3);
            balls.enqueue(ball4);
            balls.enqueue(ball5);
            return balls;
        }
        // If the user selection is S/s for bowling shoe, create five new Shoe instances to put into a queue to return.
        else if (code.equalsIgnoreCase("s")) 
        {
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S100");
            shoe1.setDescription("Strikeforce");
            shoe1.setPrice(52.95);
            shoe1.setSize(12);
            Shoe shoe2 = new Shoe();
            shoe2.setCode("S200");
            shoe2.setDescription("Brunswick");
            shoe2.setPrice(44.95);
            shoe2.setSize(6.5);
            Shoe shoe3 = new Shoe();
            shoe3.setCode("S300");
            shoe3.setDescription("Dexter");
            shoe3.setPrice(79.95);
            shoe3.setSize(10.5);
            Shoe shoe4 = new Shoe();
            shoe4.setCode("S400");
            shoe4.setDescription("BSI");
            shoe4.setPrice(49.95);
            shoe4.setSize(8);
            Shoe shoe5 = new Shoe();
            shoe5.setCode("S500");
            shoe5.setDescription("3G Kicks");
            shoe5.setPrice(47.95);
            shoe5.setSize(9);    
            GenericQueue<Product> shoes = new GenericQueue<Product>();
            shoes.enqueue(shoe1);
            shoes.enqueue(shoe2);
            shoes.enqueue(shoe3);
            shoes.enqueue(shoe4);
            shoes.enqueue(shoe5);
            return shoes;
        }
        // If the user selection is a/a for bowling bag, create three new Bag instances to put into a queue to return.
        else if (code.equalsIgnoreCase("a")) 
        {
            Bag bag1 = new Bag();
            bag1.setCode("A100");
            bag1.setDescription("Pro Bowling");
            bag1.setPrice(14.95);
            bag1.setType("Single");
            Bag bag2 = new Bag();
            bag2.setCode("A200");
            bag2.setDescription("Stradivarius Medium");
            bag2.setPrice(35.90);
            bag2.setType("Double");
            Bag bag3 = new Bag();
            bag3.setCode("A300");
            bag3.setDescription("Studded Bowler");
            bag3.setPrice(52.99);
            bag3.setType("Triple");
            Bag bag4 = new Bag();
            bag4.setCode("A400");
            bag4.setDescription("Split Suede");
            bag4.setPrice(149.00);
            bag4.setType("Quadruple");
            Bag bag5 = new Bag();
            bag5.setCode("A500");
            bag5.setDescription("Studio");
            bag5.setPrice(220.00);
            bag5.setType("Quintuple");
            GenericQueue<Product> bags = new GenericQueue<Product>();
            bags.enqueue(bag1);
            bags.enqueue(bag2);
            bags.enqueue(bag3);
            bags.enqueue(bag4);
            bags.enqueue(bag5);
            return bags;
        }
        // Otherwise, return an empty product generic queue.
        else 
        {
            return new GenericQueue<Product>();
        }

    }

}
