package Practice06.Ex04;

public class BinarySearchTree<T extends Comparable<T>> {
    private T content;
    private BinarySearchTree<T> leftChild, rightChild;

    public BinarySearchTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    // ----------------- get data -----------------
    public T getContent() {
        if (!isEmpty() ) {
            return content;
        } else {
            throw new RuntimeException();
        }
    }


    public int size() {
        if ( isEmpty() ) {
            return 0;
        }
        return 1 + leftChild.size() + rightChild.size();
    }

    public int height() {
        if(isEmpty()) {
            return 0;
        }

        int left = leftChild.height();
        int right = rightChild.height();
        if(left > right) {
            return left + 1;
        }
        return right + 1;
    }

    public BinarySearchTree<T> getLeftChild() {return leftChild;}
    public BinarySearchTree<T> getRightChild() {return rightChild;}

    // ----------------- check condition -----------------
    public boolean isEmpty() {
        return content == null;
    }

    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    // ----------------- add elements -----------------
    public void add( T t ) {
        if ( isEmpty() ) {
            content = t;
            leftChild = new BinarySearchTree<T>();
            rightChild = new BinarySearchTree<T>();
        }
        else {
            if ( content.compareTo( t ) > 0 ) {
                leftChild.add( t );
            }
            else if ( content.compareTo( t ) < 0 ) {
                rightChild.add( t );
            }
        }
    }

    // ----------------- InOrder show -----------------
    public void show() {
        if ( !isEmpty() ) {
            leftChild.show();
            System.out.println( content );
            rightChild.show();
        }
    }
}