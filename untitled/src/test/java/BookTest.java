import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
//test klasy book
public class BookTest {

    String title = "tytul";
    Double price = 12.24;

    //test konstruktora, wartosci == takie same
    @Test
    public void initializedObjectShouldHaveConstructorValues(){
        Book book = new Book(title, price);
        assertTrue(book.getTitle().equals(title) && book.getPrice() == price);
    }
    //test konstruktora, wartosci nie powinny sie rownac
    @Test
    public void initializedObjectShouldHaveDifferentValuesThanInConstructor(){
        Book book = new Book(title, price);
        assertFalse(book.getTitle().equals("notConstructor") && book.getPrice()== 32.32);
    }
    //test wartosci dwuch odentycznych obiektow
    @Test
    public void sameBookConbooktructorValuesCompareReturnTrue(){
        Book bookOne = new Book(title, price);
        Book bookTwo = new Book(title, price);
        assertTrue(bookOne.getTitle().equals(bookTwo.getTitle()) && bookOne.getPrice() == bookTwo.getPrice());
    }
    //test wartoci dwoch inncyh obiektow
    @Test
    public void differentBookConstructorValuesCompareShouldReturnFalse(){
        Book bookOne = new Book(title, price);
        Book bookTwo = new Book(title, price);
        assertFalse(bookOne.getTitle().equals("asdasd") && bookOne.getPrice() == 123);
    }
    @Test
    public void deleteBookShouldBeNull(){
        Book one = new Book(title, price);
        one = null;
        assertNull(one);
    }
}
