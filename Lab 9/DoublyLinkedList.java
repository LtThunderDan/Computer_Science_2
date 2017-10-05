package com.linkedlist;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
  Doubly-linked list implementation that extends
  AbstractSequentialList&lt;E&gt; and implements List&lt;E&gt;
*/
public class DoublyLinkedList<E> extends AbstractSequentialList<E>
implements List<E>
{
  private Node firstNode;
  private int size;


  /**
    Constructs an emtpy doubly-linked list.
  */
  public DoublyLinkedList()
  {
    //TODO
  }

  /**
    Returns the number of elements in this collection.
    @return the number of elements in this collection
  */
  public int size()
  {
    //TODO
    return this.size;
  }

  /**
    Returns a list iterator over the elements in this list (in proper sequence).
    @param nextIndex index of first element to be returned from the list
    iterator (by a call to the next method)
    @return a list iterator over the elements in this list (in proper sequence)
    @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0
    || index &gt; size())
  */
  public ListIterator<E> listIterator(int nextIndex)
  {
    ListIterator<E> iterator = new DoublyLinkedListIterator();
    for (int i = 0; i<nextIndex; i++){
      iterator.next();
    }
    return iterator;
  }

  /**
    A node with pointers to the next and previous nodes. The node contains an
    element.
  */
  private class Node
  {
    public Node previousNode; // each node has its own referenece to the previous one
    public Node nextNode; // each node has its own reference to the next one
    public E element; // each node is referencing its own element
    /**
      Constructs a node that contains an element. The previous and next nodes
      are initially initially set to null.
      @param e the intitial element in the node
    */
    public Node(E e)
    {
      element = e; // set the element equal to the type passed into the constructor
    }
  }

  /**
    An iterator for lists that allows the programmer to traverse the list in
    either direction, modify the list during iteration, and obtain the
    iterator's current position in the list. A ListIterator has no current
    element; its cursor position always lies between the element that would be
    returned by a call to previous() and the element that would be returned by
    a call to next()
  */
  private class DoublyLinkedListIterator implements ListIterator<E>
  {
    public Node itPrev;//the left arrow of the iterator
    public Node itNext;//the right arrow of the iterator
    public Node returned;//the element to be returned
    public int nextIndex;//the next index of the iterator
    //public int previousIndex;

    /**
      Constructs an iterator that points to the front of the linked list.
    */
    public DoublyLinkedListIterator()
    {
      itNext = firstNode;
    }

    /**
      Returns true if this list iterator has more elements when traversing the
      list in the reverse direction. (In other words, returns true if
      previous() would return an element rather than throwing an exception.)
      @return true if the list iterator has more elements when traversing the
      list in the reverse direction
    */
    public boolean hasPrevious()
    {
      if (itPrev == null){
        return false;
      }
      else {return true;}
    }

    /**
      Returns true if this list iterator has more elements when traversing the
      list in the forward direction. (In other words, returns true if next()
      would return an element rather than throwing an exception.)
      @return true if the list iterator has more elements when traversing the
      list in the forward direction
    */
    public boolean hasNext()
    {
	  if (itNext == null){
        return false;
      }
      else {return true;}
    }

    /**
      Returns the index of the element that would be returned by a subsequent
      call to next(). (Returns list size if the list iterator is at the end of
      the list.)
      @return the index of the element that would be returned by a subsequent
      call to next, or list size if the list iterator is at the end of the list
    */
    public int nextIndex()
    {
	  if (!hasNext()){
      throw new NoSuchElementException();
    }
      return nextIndex;
    }

    /**
      Returns the index of the element that would be returned by a subsequent
      call to previous(). (Returns -1 if the list iterator is at the beginning
      of the list.)
      @return the index of the element that would be returned by a subsequent
      call to previous, or -1 if the list iterator is at the beginning of the
      list
    */
    public int previousIndex()
    {

    if (!hasPrevious()){
      throw new NoSuchElementException();
    }
      return nextIndex -1;
    }

    /**
      Returns the next element in the list and advances the cursor position.
      This method may be called repeatedly to iterate through the list, or
      intermixed with calls to previous() to go back and forth. (Note that
      alternating calls to next and previous will return the same element
      repeatedly.)
      @return the next element in the list
      @throws NoSuchElementException if the iteration has no next element
    */
    public E next()
    {
	  //
      if (!hasNext()){ // if there is no element in the next position
        throw new NoSuchElementException();
      }
      returned = itNext; // update returned value
      itPrev = itNext; // update previous (move it to the right)
      itNext = itNext.nextNode;// update next (move it to the right 1)
      nextIndex +=1;//update the number of indexes
      return returned.element;//return the element
    }

    /**
      Returns the previous element in the list and moves the cursor position
      backwards. This method may be called repeatedly to iterate through the
      list backwards, or intermixed with calls to next() to go back and forth.
      (Note that alternating calls to next and previous will return the same
      element repeatedly.)
      @return the previous element in the list
      @throws NoSuchElementException if the iteration has no previous element
    */
    public E previous()
    {
	  //
    if (!hasPrevious()){//if there is no previous element
      throw new NoSuchElementException();
    }
    returned = itPrev;//update the returned value
    itNext = itPrev;//move the iterators right arrow to the left by 1
    itPrev = itPrev.previousNode;//move the left arrow of the iterator to the left 1
    nextIndex -=1; // shrink the index by one
      return returned.element;//return the element
    }

    /**
      Inserts the specified element into the list (optional operation). The
      element is inserted immediately before the element that would be
      returned by next(), if any, and after the element that would be returned
      by previous(), if any. (If the list contains no elements, the new element
      becomes the sole element on the list.) The new element is inserted before
      the implicit cursor: a subsequent call to next would be unaffected, and a
      subsequent call to previous would return the new element. (This call
      increases by one the value that would be returned by a call to nextIndex
      or previousIndex.)
      @param e the element to insert
    */
    public void add(E e)
    {
      //TODO
      //If there is nothing in the list, set the first node
      if (size == 0){//if the lsit is empty
        firstNode = new Node(e);//the almighty first node
        firstNode.previousNode = null;//there is no reference to previosu for this node
        firstNode.nextNode = null;//there is no reference to next for this node YET
        size +=1;//the size of the list should be incremented
        this.itPrev = firstNode;//set the left arrow of the iterator to this first node
        nextIndex +=1;
      }

     else {
        Node newNode = new Node(e);
          newNode.previousNode = itPrev;
          newNode.nextNode = itNext;
        if (itPrev != null){
          itPrev.nextNode = newNode;
        }
        if (itNext != null){
          itNext.previousNode = newNode;
      }
          itPrev = newNode;
          nextIndex +=1;
          size +=1;
          returned = null;
    }
  }

    /**
      Removes from the list the last element that was returned by next() or
      previous() (optional operation). This call can only be made once per call
      to next or previous. It can be made only if add(E) has not been called
      after the last call to next or previous.
      @throws IllegalStateException if neither next nor previous have been
      called, or remove or add have been called after the last call to next or
      previous
    */
    public void remove()
    {
      //Remove after calling next
      if(returned == null){
        throw new IllegalStateException();
      }

      if(returned == itPrev){
        Node a = itPrev.previousNode;
        Node b = itNext;
        if(a != null){
          itPrev = a;
        }
        if(b != null){
          itNext = b;
        }
        itPrev.nextNode = itNext;
        itNext.previousNode = itPrev;
        returned = null;
        if (nextIndex == 0){
          firstNode = itNext;
        }
        size -=1;
        nextIndex -=1;
      }

      //remove after calling previous
      if(returned == itNext){
        Node a = itPrev;
        Node b = itNext.nextNode;
        if(a != null){
          itPrev = a;
        }
        if(b != null){
          itNext = b;
        }
        itPrev.nextNode = itNext;
        itNext.previousNode = itPrev;
        returned = null;
        if (nextIndex == 0){
          firstNode = itNext;
        }
        size -=1;
      }
    }

    /**
      Replaces the last element returned by next() or previous() with the
      specified element (optional operation). This call can be made only if
      neither remove() nor add(E) have been called after the last call to next
      or previous.
      @param e the element with which to replace the last element returned
      by next or previous
      @throws IllegalStateException if neither next nor previous have been
      called, or remove or add have been called after the last call to next or
      previous
    */
    public void set(E e)
    {
      if(returned == null){ // in case add or remove was called last
        throw new IllegalStateException();
      }

      // replace after calling previous()
        if (returned == itNext){
          Node newNode = new Node(e);
          Node a = itPrev;
          Node b = itNext.nextNode;
          itNext = newNode;
          itNext.nextNode = b;
          b.previousNode = newNode;
          a.nextNode = newNode;
          newNode.previousNode = a;
          returned = itNext;
          size += 0; // size does not change here
        }

      // replace after calling next()
        if (returned == itPrev){
          Node newNode = new Node(e);
          Node a = itPrev.previousNode;
          Node b = itNext;
          itPrev = newNode;
          newNode.nextNode = b;
          b.previousNode = newNode;
          newNode.previousNode = a;
          a.nextNode = newNode;
          returned = itPrev;
          size += 0;
        }
    }
  }
}
