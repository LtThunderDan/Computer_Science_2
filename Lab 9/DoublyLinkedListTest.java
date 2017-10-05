package com.linkedlist;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class DoublyLinkedListTest {

    //////////////////////////////////////////////////////////////////////////

    public ListIterator<Integer> makeIntegerListIterator(){
      DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
      ListIterator<Integer> iterator = dll.listIterator(0);
      return iterator;

    }

    public ListIterator<String> makeStringListIterator(){
      DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
      ListIterator<String> iterator = dll.listIterator(0);
      return iterator;

    }

    public ListIterator<Character> makeCharacterListIterator(){
      DoublyLinkedList<Character> dll = new DoublyLinkedList<Character>();
      ListIterator<Character> iterator = dll.listIterator(0);
      return iterator;

    }

    public ListIterator<Boolean> makeBooleanListIterator(){
      DoublyLinkedList<Boolean> dll = new DoublyLinkedList<Boolean>();
      ListIterator<Boolean> iterator = dll.listIterator(0);
      return iterator;

    }

    public ListIterator<Double> makeDoubleListIterator(){
      DoublyLinkedList<Double> dll = new DoublyLinkedList<Double>();
      ListIterator<Double> iterator = dll.listIterator(0);
      return iterator;

    }
    ///////////////////////////////////////////////////////////////////////////
    @Test()
    public void canInstantiate(){// can we created a doubly linked list?
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
    }

    @Test()
    public void canRetrieveIterator(){ // can we create an iterator?
      DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
      ListIterator<Integer> iterator = dll.listIterator(0);
      assertNotNull(iterator);
    }

    @Test()
    public void canAddToEmptyList(){// can we add to an empty list?
      DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
      ListIterator<Integer> iterator = dll.listIterator(0);
      iterator.add(1);
    }

    @Test()
    public void canReadFirstListElement(){// can we see what that first element is?
      DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
      ListIterator<Integer> iterator = dll.listIterator(0);
      iterator.add(1);
      assertEquals(Integer.valueOf(1), iterator.previous());
      assertEquals(Integer.valueOf(1) ,iterator.next());
    }

    @Test()
    public void canMoveBackwardsThroughList(){// can we move backwards?
      ListIterator<Integer> iterator = makeIntegerListIterator();
      iterator.add(1);
      iterator.add(2);
      iterator.add(3);
      assertEquals(Integer.valueOf(3), iterator.previous());
      assertEquals(Integer.valueOf(2), iterator.previous());
      assertEquals(Integer.valueOf(1), iterator.previous());
    }

    @Test()
    public void canMoveForwardThroughList(){// can we move forward?
      ListIterator<Integer> iterator = makeIntegerListIterator();
      iterator.add(1);
      iterator.add(2);
      iterator.add(3);
      iterator.previous();
      iterator.previous();
      iterator.previous();
      assertEquals(Integer.valueOf(1), iterator.next());
      assertEquals(Integer.valueOf(2), iterator.next());
      assertEquals(Integer.valueOf(3), iterator.next());

    }

    @Test()
    public void canMoveBothDirections(){// can we do both?
      ListIterator<Integer> iterator = makeIntegerListIterator();
      iterator.add(10);
      iterator.add(20);
      iterator.add(30);
      iterator.add(40);
      iterator.add(50);
      assertEquals(Integer.valueOf(50), iterator.previous());
      assertEquals(Integer.valueOf(40), iterator.previous());
      assertEquals(Integer.valueOf(30), iterator.previous());
      assertEquals(Integer.valueOf(20), iterator.previous());
      assertEquals(Integer.valueOf(10), iterator.previous());
      assertEquals(Integer.valueOf(10), iterator.next());
      assertEquals(Integer.valueOf(20), iterator.next());
      assertEquals(Integer.valueOf(30), iterator.next());
      assertEquals(Integer.valueOf(40), iterator.next());
      assertEquals(Integer.valueOf(50), iterator.next());
    }

    //Can we add arbitrary elements using the iterator

    @Test()
    public void canAddIntegers(){ // INTEGERS
      ListIterator<Integer> iterator = makeIntegerListIterator();
      iterator.add(1);
      assertEquals(Integer.valueOf(1), iterator.previous());
    }

    @Test()
    public void canAddStrings(){ // STRINGS
      ListIterator<String> iterator = makeStringListIterator();
      iterator.add("Hello");
      assertEquals("Hello", iterator.previous());
    }

    @Test()
    public void canAddBooleans(){ // BOOLEANS
      ListIterator<Boolean> iterator = makeBooleanListIterator();
      iterator.add(true);
      assertTrue(iterator.previous());
    }

    @Test()
    public void canAddDoubles(){ // DOUBLES
      ListIterator<Double> iterator = makeDoubleListIterator();
      iterator.add(50.0);
      assertEquals(Double.valueOf(50.0), iterator.previous());

    }

    @Test()
    public void canAddCharacters(){ // CHARACTERS
      ListIterator<Character> iterator = makeCharacterListIterator();
      iterator.add('H');
      assertEquals(Character.valueOf('H'), iterator.previous());
    }

    //Can we READ arbitrary elements using the iterator?
    //(We know it can already read integers)

    @Test()
    public void canReadStrings(){ // READ STRINGS
      ListIterator<String> iterator = makeStringListIterator();
      iterator.add("Hello ");
      iterator.add("Stephen, ");
      iterator.add("How ");
      iterator.add("are ");
      iterator.add("you?");

      assertEquals("you?", iterator.previous());
      assertEquals("are ", iterator.previous());
      assertEquals("How ", iterator.previous());
      assertEquals("Stephen, ", iterator.previous());
      assertEquals("Hello ", iterator.previous());

      assertEquals("Hello ", iterator.next());
      assertEquals("Stephen, ", iterator.next());
      assertEquals("How ", iterator.next());
      assertEquals("are ", iterator.next());
      assertEquals("you?", iterator.next());


    }

    @Test()
    public void canReadBooleans(){ // READ BOOLEANS
      ListIterator<Boolean> iterator = makeBooleanListIterator();
      iterator.add(true);
      iterator.add(false);
      iterator.add(true);
      iterator.add(false);
      iterator.add(true);
      iterator.add(false);

      assertFalse(iterator.previous());
      assertTrue(iterator.previous());
      assertFalse(iterator.previous());
      assertTrue(iterator.previous());
      assertFalse(iterator.previous());
      assertTrue(iterator.previous());

      assertTrue(iterator.next());
      assertFalse(iterator.next());
      assertTrue(iterator.next());
      assertFalse(iterator.next());
      assertTrue(iterator.next());
      assertFalse(iterator.next());

    }

    @Test()
    public void canReadCharacters(){ // READ CHARACTERS
      ListIterator<Character> iterator = makeCharacterListIterator();
      iterator.add('H');
      iterator.add('E');
      iterator.add('L');
      iterator.add('L');
      iterator.add('O');

      assertEquals(Character.valueOf('O'), iterator.previous());
      assertEquals(Character.valueOf('L'), iterator.previous());
      assertEquals(Character.valueOf('L'), iterator.previous());
      assertEquals(Character.valueOf('E'), iterator.previous());
      assertEquals(Character.valueOf('H'), iterator.previous());

      assertEquals(Character.valueOf('H'), iterator.next());
      assertEquals(Character.valueOf('E'), iterator.next());
      assertEquals(Character.valueOf('L'), iterator.next());
      assertEquals(Character.valueOf('L'), iterator.next());
      assertEquals(Character.valueOf('O'), iterator.next());

    }

    @Test()
    public void canReadDoubles(){ // READ DOUBLES
      ListIterator<Double> iterator = makeDoubleListIterator();
      iterator.add(10.0);
      iterator.add(20.0);
      iterator.add(30.0);
      iterator.add(40.0);
      iterator.add(50.0);

      assertEquals(Double.valueOf(50.0), iterator.previous());
      assertEquals(Double.valueOf(40.0), iterator.previous());
      assertEquals(Double.valueOf(30.0), iterator.previous());
      assertEquals(Double.valueOf(20.0), iterator.previous());
      assertEquals(Double.valueOf(10.0), iterator.previous());

      assertEquals(Double.valueOf(10.0), iterator.next());
      assertEquals(Double.valueOf(20.0), iterator.next());
      assertEquals(Double.valueOf(30.0), iterator.next());
      assertEquals(Double.valueOf(40.0), iterator.next());
      assertEquals(Double.valueOf(50.0), iterator.next());

    }

    //Can we REMOVE elements using the iterator?
    // 2 separate cases of remove:
      // after calling next() and moving forward
      //                   OR
      // after calling previous() and moving backwards

    @Test()
      public void canRemoveElementsAfterNextCall(){  // After moving FORWARD
      ListIterator<Integer> iterator = makeIntegerListIterator();
      iterator.add(1);
      iterator.add(2);
      iterator.add(3);
      iterator.previous(); // returns 3 moves to 2 <- | -> 3
      iterator.previous(); // returns 2 moves to 1 <- | -> 2
      iterator.next(); // returns 2 moves to 2 <- | -> 3
      iterator.remove(); // should remove previous, which is 2
      //the previous number should now be 1
      assertEquals(Integer.valueOf(1), iterator.previous());
      // returns 1, moves to NULL <- | -> 1
      assertEquals(Integer.valueOf(1), iterator.next());
      //returns 1, moves to 1 <- | -> 3
      assertEquals(Integer.valueOf(3), iterator.next());
      //returns 3, moves to 3 <- | -> NULL

  }

  @Test()
    public void canRemoveElementsAfterPreviousCall(){ // after moving BACKWARDS
    ListIterator<Integer> iterator = makeIntegerListIterator();
    iterator.add(1);
    iterator.add(2);
    iterator.add(3);
    iterator.previous(); // returns 3, moves to 2 <- | -> 3
    iterator.previous(); // Returns 2, moves to 1 <- | -> 2
    iterator.remove(); // should remove 2
    //the next number should now be three (1 <- | -> 3)
    // we now have [...NULL, 1, 3, NULL...]
    //again, here is our iterator: 1 <- | -> 3, so 3 is next
    assertEquals(Integer.valueOf(3), iterator.next());
    //returns 3, moves to 3 <- | -> null
    assertEquals(Integer.valueOf(3), iterator.previous());
    //returns 3, moves to 1 <- | -> 3
    assertEquals(Integer.valueOf(1), iterator.previous());
    //returns 1, moves to NULL <- | -> 1

  }

  @Test()
    public void canReplaceElementAfterPrevious(){
      ListIterator<Integer> iterator = makeIntegerListIterator();
      iterator.add(1);
      iterator.add(2);
      iterator.add(3);
      iterator.previous();//returns 3, moves to 2 <- | -> 3

      iterator.previous(); //returns 2, moves to 1 <- | -> 2

      //NEXT CALL for set should replace the returned value (2)
      //with 4
      iterator.set(4); // should replace 2 with 4
      // now we have [...NULL, 1, 4, 3, NULL...]
      // Iterator now returns 4 and looks like this: 1 <- | -> 4
      assertEquals(Integer.valueOf(4), iterator.next()); // lets see...
    }

    @Test()
      public void canReplaceElementAfterNext(){
        ListIterator<Integer> iterator = makeIntegerListIterator();
        iterator.add(1);
        iterator.add(2);
        iterator.add(3);
        iterator.add(4);
        iterator.add(5);
        iterator.previous();//returns 5, moves to 4 <- | -> 5

        iterator.previous(); //returns 4, moves to 3 <- | -> 4
        iterator.next(); // returns 4, moves to 4 <- | -> 5

        //NEXT CALL for set should replace the returned value (2)
        //with 4
        iterator.set(7); // should replace 2 with 4
        // now we have [...NULL, 1, 2, 3, 7, 5, NULL...]
        // Iterator now returns 4 and looks like this: 7 <- | -> 5
        assertEquals(Integer.valueOf(7), iterator.previous()); // lets see...
        assertEquals(Integer.valueOf(3), iterator.previous());
        assertEquals(Integer.valueOf(2), iterator.previous());
        assertEquals(Integer.valueOf(1), iterator.previous());

      }

    @Test()
      public void canDetermineIfAtBeginningOfList(){
        ListIterator<Integer> iterator = makeIntegerListIterator();
        iterator.add(1);
        iterator.add(2);
        iterator.add(3);
        iterator.previous();//returns 3, moves to 2 <- | -> 3
        iterator.previous(); //returns 2, moves to 1 <- | -> 2
        iterator.previous();//returns 1, moves to NULL <- | -> 1
        assertFalse(iterator.hasPrevious());
      }

    @Test()
      public void canDetermineIfAtEndOfList(){
        ListIterator<Integer> iterator = makeIntegerListIterator();
        iterator.add(1);
        iterator.add(2);
        iterator.add(3);
        iterator.previous();//returns 3, moves to 2 <- | -> 3
        iterator.previous(); //returns 2, moves to 1 <- | -> 2
        iterator.previous();//returns 1, moves to NULL <- | -> 1
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext()); //we are at 3 <- | -> NULL
      }

  @Test()
    public void canDetermineCurrentIndexWithoutRemoval(){
      ListIterator<Integer> iterator = makeIntegerListIterator();
      iterator.add(1); // index 0
      iterator.add(2); // index 1
      iterator.add(3); // index 2
      assertEquals(2, iterator.previousIndex());
      iterator.previous();
      assertEquals(1, iterator.previousIndex());
      iterator.previous();
      assertEquals(0, iterator.previousIndex());
      iterator.previous();
      assertEquals(0, iterator.nextIndex());
      iterator.next();
      assertEquals(1, iterator.nextIndex());
      iterator.next();
      assertEquals(2, iterator.nextIndex());
      iterator.next();
      assertEquals(2, iterator.previousIndex());
    }

    @Test()
      public void canDetermineCurrentIndexWithRemoval(){
        ListIterator<Integer> iterator = makeIntegerListIterator();
        iterator.add(1); // index 0
        iterator.add(2); // index 1
        iterator.add(3); // index 2
        iterator.previous(); //returns 3, moves to 2 <- | -> 3
        iterator.previous(); //returns 2, moves to 1 <- | -> 2
        iterator.previous(); //returns 1, moves to NULL <- | -> 1
        iterator.next(); //returns 1, moves to 1 <- | -> 2
        iterator.next(); //returns 2, moves to 2 <- | -> 3
        iterator.remove(); //should remove 2
        assertEquals(0, iterator.previousIndex());
        assertEquals(1, iterator.nextIndex());
      }

  @Test()
    public void canRetrieveIteratorObjectAtIndex(){
      DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
      ListIterator<String> iterator1 = dll.listIterator(0);
      iterator1.add("1");
      iterator1.add("2");
      iterator1.add("3");
      ListIterator<String> iterator2 =  dll.listIterator(1);
      assertEquals("2", iterator2.next());
    }

  @Test()
    public void canRetrieveSizeAfterAdd(){
      DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
      ListIterator<String> iterator1 = dll.listIterator(0);
      iterator1.add("1");
      iterator1.add("2");
      iterator1.add("3");
      assertEquals(3, dll.size());
    }

  @Test()
    public void canRetrieveSizeAfterRemove(){
      DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
      ListIterator<String> iterator1 = dll.listIterator(0);
      iterator1.add("1");
      iterator1.add("2");
      iterator1.add("3");
      iterator1.previous();
      iterator1.remove();
      assertEquals(2, dll.size());
    }


    @Test()
      public void canAddAll(){
        DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
        ListIterator<String> iterator1 = dll.listIterator(0);
        iterator1.add("1");
        iterator1.add("2");
        iterator1.add("3");
        ArrayList<String> list = new ArrayList<String>();
        list.add("4");
        list.add("5");
        list.add("6");

        dll.addAll(list);
        ListIterator<String> iterator2 = dll.listIterator(0);
        assertEquals("1", iterator2.next());
        assertEquals("2", iterator2.next());
        assertEquals("3", iterator2.next());
        assertEquals("4", iterator2.next());
        assertEquals("5", iterator2.next());
        assertEquals("6", iterator2.next());
      }

    @Test()
      public void canRead(){
        DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
        ListIterator<String> iterator1 = dll.listIterator(0);
        iterator1.add("1");
        iterator1.add("2");
        iterator1.add("3");
        assertEquals("2", dll.get(1));
      }

    @Test()
      public void canAddByIndex(){
        DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
        ListIterator<String> iterator1 = dll.listIterator(0);
        iterator1.add("1");
        iterator1.add("2");
        iterator1.add("3");
        dll.add(2, "0");
        assertEquals("0", dll.get(2));
      }

      @Test()
        public void canRemoveByIndex(){
          DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
          ListIterator<String> iterator1 = dll.listIterator(0);
          iterator1.add("1");
          iterator1.add("2");
          iterator1.add("3");
          dll.remove(1);
          assertEquals("3", dll.get(1));
        }

      @Test()
        public void canReplaceAtIndex(){
          DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
          ListIterator<String> iterator1 = dll.listIterator(0);
          iterator1.add("1");
          iterator1.add("2");
          iterator1.add("3");
          dll.set(1, "0");
          assertEquals("0", dll.get(1));
        }

      @Test(expected = NoSuchElementException.class)
        public void cantGoPastEndOfList(){
          DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
          ListIterator<String> iterator1 = dll.listIterator(0);
          iterator1.add("1");
          iterator1.add("2");
          iterator1.add("3");
          iterator1.next();
        }

      @Test(expected = NoSuchElementException.class)
        public void cantGoPastBeginningOfList(){
          DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
          ListIterator<String> iterator1 = dll.listIterator(0);
          iterator1.add("1");
          iterator1.add("2");
          iterator1.add("3");
          iterator1.previous();
          iterator1.previous();
          iterator1.previous();
          iterator1.previous();
        }



  }
