package Practice06.Ex04;

import java.util.ArrayList;

public class DrawBinaryTree {
    // ----------- Start drawing trees -------------------
    static void startDrawing(BinarySearchTree tree)
    {
        int height = tree.height();
        // create an array of ArrayList, each ArrayList is a level of the tree.
        ArrayList[] classes = new ArrayList[height];
        for (int i=0; i<height; i++) {
            classes[i] = new ArrayList<>();
        }

        // divide the trees into level.
        // Each level has 2^level elements. (each level's maximum number of trees)
        // 'null' values represent not-(yet-)existing trees.
        divideTreeIntoLevels(tree, height, classes);

        // Print the resulted list for debugging.
        // showLevelsList(classes);

        // After 'divided', the tree is ready to be "drawn"
        drawTree(classes);
    }

    // ----------- divide the tree into levels -------------------
    static void divideTreeIntoLevels(BinarySearchTree current, int height, ArrayList[] classes) {
        // empty/undefined tree can not be 'divided'
        if(current == null || height==0) {
            return;
        }

        // if current tree is empty
        // -> there will be no children from this tree any more.
        // -> All the positions linked to this root filled with value 'null'
        if(current.isEmpty()) {
            int index = classes.length - 1;
            while(index >= classes.length-height) {
                // calculate the trees to be filled
                int times = calculateExponent(2, index-(classes.length-height));
                for(int i=0; i<times; i++) {
                    classes[index].add(null);
                }
                index--;
            }
            return;
        } else {
            // if the current tree is not empty
            if(height >= 1) {
                // recursively "dividing" the left's and the right's children "into levels"
                divideTreeIntoLevels(current.getLeftChild(), height-1, classes);
                divideTreeIntoLevels(current.getRightChild(), height-1, classes);

                // save node's content to list.
                // Empty trees have 'null' content.
                classes[classes.length - height].add(current.getContent());
            }
        }
    }

    // This should work with the Integer objects.
    // The graph consists of "number lines" and "separating lines"
    // Take a look at line 40-50 in Main.java for the visualization, which is useful for a better comprehension
    static void drawTree(ArrayList<Integer>[] classes) {
        // Define the patterns that we're gonna use.
        final String P1 = "   ";
        final String P2 = "  _";
        final String P3 = "_  ";
        final String P4 = "___";
        final String P5 = " | ";

        // loop through each level of the tree
        // (which has been divided into levels/classes)
        for (int i=0; i<classes.length; i++) {
            String sep = "";  // separation line
            String line = ""; // number line

            // length of "spacing" for the patterns
            // It depends on your decision, how the diagram should look like
            // This number works for my diagram
            int times = (classes[classes.length-i-1].size() / 2) - 1; // -1, 0, 1, 3, 7, 12

            // loop through each element of the level's ArrayList
            for(int j=0; j<classes[i].size(); j++) {

                // add gap before each pattern
                if(j != 0) { // (not before the first one)
                    sep += P1;
                    line += P1;
                }

                //------------ 1. Separation line(s) -----------
                if(i > 0) { // after the first number line
                    // duplication times of P1.
                    int sepTimes = times * 2 + 1; // 7 3 1 0

                    // if the corresponding element is null -> microPattern is P1, else: P5
                    String microPattern = classes[i].get(j) != null ? P5 : P1;
                    // add the pattern to separation line
                    sep += patternTimes(P1, sepTimes) + microPattern + patternTimes(P1, sepTimes);
                }

                //------------ 2. Number line(s) -----------

                // add element when it's not null
                if(classes[i].get(j) != null) {

                    // if it's the last line => just add number, no pattern needed.
                    if(i == classes.length-1) {
                        line += fillNumber(classes[i].get(j));

                    } else {

                        // the leftChild of the current tree exists:
                        if(classes[i+1].get(j*2) != null) {
                            line += patternTimes(P1, times) + P2 + patternTimes(P4, times);
                        } else {

                            // If not, add P1 (corresponding blank spaces)
                            line += patternTimes(P1, times * 2 + 1);
                        }

                        // Add number between 2 (micro)patterns
                        line += fillNumber(classes[i].get(j));

                        // the rightChild of the current tree exists:
                        if(classes[i+1].get(j*2+1) != null) {
                            line += patternTimes(P4, times) + P3 + patternTimes(P1, times);
                        } else {

                            // If not, add P1 (corresponding blank spaces)
                            line += patternTimes(P1, times * 2 + 1);
                        }
                    }
                } else {

                    // if the element's null: add corresponding blank spaces
                    int extra = i != classes.length-1 ? 3 : 1;
                    line += patternTimes(P1, times * 4) + patternTimes(P1, extra);
                }


            }
            // Print them out !!!
            System.out.println(sep);
            System.out.println(line);
        }
    }

    static void showLevelsList (ArrayList[] classes) {
        for (ArrayList arr : classes) {
            String line = "";
            for (Object el : arr) {
                line = line + (el != null ? el.toString() : null) + " ";
            }
            System.out.println(line);
        }
    }

    // --------- HELPERS -------

    // calculate exponent (for integers only)
    static int calculateExponent(int base, int expo) {
        if(base == 0 || base == 1) {
            return base;
        }
        int res = 1;
        for (int i=0; i<expo; i++) {
            res *= base;
        }
        return res;
    }

    // duplicate pattern "times" times
    static String patternTimes(String pattern, int times) {
        String str = "";
        for(int i=0; i<times; i++) {
            str += pattern;
        }
        return str;
    }

    // turn the number to a 3-digit-long string
    public static String fillNumber(Integer num) {
        if(num >= 0 && num < 10) {
            return " " + num.toString() + " ";
        }
        if(num < 0 && num > -10 || num >= 10 && num <100) {
            return " " + num.toString();
        }
        return "" + num;
    }
}