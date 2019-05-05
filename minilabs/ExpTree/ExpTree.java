
// This will implement an "Expression Tree" which stores an arithmetic expression
// TODO: EVALUATES

import java.util.*;

public class ExpTree {
    // -------data
    private ExpNode root;

    // -------constructor
    public ExpTree() {
        root = null;
    }

    // constructor where a string is passed in. It is parsed and stored
    public ExpTree(String expString) {
        // get rid of any blanks in the input String
        expString = expString.replaceAll(" ", "");

        // if there is nothing there, throw exception
        if (expString.length() == 0)
            throw new IllegalArgumentException("Cannot build tree - input String is empty");

        // declare StringTokenizer, Stacks, and other variables used in parsing
        StringTokenizer tokenizer = new StringTokenizer(expString, "()+-*/%", true);
        String token;
        ExpNode operator = null;
        ExpNode leftOperand = null;
        ExpNode rightOperand = null;
        Stack<ExpNode> operators = new Stack<ExpNode>();
        Stack<ExpNode> operands = new Stack<ExpNode>();

        // break up expString into tokens
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();

            // if the current token is a left paren, ignore it
            if (token.equals("("))
                ;

            // if the current token is an operator, put it on the
            // operator stack
            else if ((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/"))
                    || (token.equals("%")))
                operators.push(new ExpNode(token));

            // if the current token is a right paren, pop the operators stack
            // to get the operator, pop the operands stack twice to get the two
            // operands (stored as expression trees). Then make the two operands
            // children of the operator and push back on the operands tree.
            else if (token.equals(")")) {
                try {
                    operator = operators.pop();
                    rightOperand = operands.pop();
                    leftOperand = operands.pop();
                } catch (Throwable ex) {
                    System.out.println("Cannot build tree - expression improperly formed");
                }

                operator.left = leftOperand;
                operator.right = rightOperand;

                operands.push(operator);
            }

            // otherwise, the token should be a number - put it in the operands stack
            else
                operands.push(new ExpNode(token));

        } // while (tokenizer.hasMoreTokens())

        // when finished parsing, the operands stack should contain the fully-built
        // expression tree.
        if (!operands.isEmpty())
            root = operands.pop();
    }

    // -------methods

    // ==================================

    // isEmpty()
    public boolean isEmpty() {
        return (root == null);
    }

    // ==================================

    // seeTree - returns a String that is what it looks like on its side
    public String seeTree() {
        return recursiveSeeTree(root, 0);
    }

    // ==================================

    // recursive version of seeTree
    private String recursiveSeeTree(ExpNode subTree, int indent) {
        String str = "";

        if (subTree == null)
            return str; // return empty String
        else {
            // go down RHS
            str = str + recursiveSeeTree(subTree.right, indent + 1); // go down the RHS with one more indent

            // put your own node on the str
            str = str + "\n\n"; // skip 3 lines for separation
            for (int i = 0; i < indent; i++)
                str = str + "\t\t"; // 2 tabs for each indent
            str = str + subTree.data;
            str = str + "\n\n"; // skip 3 lines for separation

            str = str + recursiveSeeTree(subTree.left, indent + 1); // go down the LHS with one more indent

            return str;
        }
    }

    // ==================================

    // inorder traversal - starts the recursive calls to print inorder
    public String inOrder() {
        return recursiveInOrder(root);
    }

    // ==================================

    // inorder traversal - recursive left side of tree, print node, right side of
    // tree
    private String recursiveInOrder(ExpNode subTree) {
        if (subTree == null)
            return ""; // don't try to do anything if tree is null

        // else build up a String to return. It will involve recursive calls
        String returnString = "";
        if (subTree.left != null) {
            returnString += "(" + recursiveInOrder(subTree.left);
        }
        returnString += subTree.data;
        if (subTree.right != null) {
            returnString += recursiveInOrder(subTree.right) + ")";
        }

        return returnString;
    }

    // ==================================

    // preOrder - returns a String which is the result of an preorder traversal (N L
    // R)
    public String preOrder() {
        return recursivePreOrder(root);
    }

    // ==================================

    // recursivePreOrder - returns a String which is the result of an preorder
    // traversal of this subtree
    private String recursivePreOrder(ExpNode subTree) {
        if (subTree == null)
            return "";
        else {
            String answer = "";
            answer = answer + subTree.data + " "; // data first followed by a space
            if (subTree.left != null)
                answer = answer + recursivePreOrder(subTree.left) + " "; // then left side if it exists, the a space
            if (subTree.right != null)
                answer = answer + recursivePreOrder(subTree.right); // then right side if it exists

            return answer;
        }
    }

    // ==================================

    // numNodes - version that is called from "outside"
    public int numNodes() {
        return recursiveNumNodes(root);
    }

    // ==================================

    // recursive version of numNodes
    private int recursiveNumNodes(ExpNode subTree) {
        if (subTree == null)
            return 0; // empty branch so 0 nodes
        else
            return 1 + recursiveNumNodes(subTree.left) + recursiveNumNodes(subTree.right);
    }

    // ==================================

    	public double evaluate()
	{
		return recursiveEvaluate(root);
	}
	
	// Recursiive version of evaluate()
	private double recursiveEvaluate(ExpNode subTree) {
		if (subTree == null) {
			return 0;
		}

		if (subTree.left == null && subTree.right == null) {
			return Double.parseDouble(subTree.data);
		}

		double leftVal = recursiveEvaluate(subTree.left);
		double rightVal = recursiveEvaluate(subTree.right);

		if (subTree.data.equals("+")) {
			return leftVal + rightVal;
		}
		else if (subTree.data.equals("-")) {
			return leftVal - rightVal;
		}
		else if (subTree.data.equals("*")) {
			return leftVal * rightVal;
		}
		else if (subTree.data.equals("%")) {
			if (rightVal == 0) {
				throw new ArithmeticException("Cannot divide by 0.");
			}
			return leftVal % rightVal;
		}
		else if (subTree.data.equals("/")) {
			if (rightVal == 0) {
				throw new ArithmeticException("Cannot divide by 0.");
			}
			return leftVal / rightVal;

		} else {
			throw new ArithmeticException("Illegal Arithmetic operator.");
		}
		  
	}

}

// ***************************************************************************
// ***************************************************************************

// ExpNode holds a "node" for an ExpTree.
class ExpNode {
    // data (really should be private, but is for convenience while we study this)
    protected String data;
    protected ExpNode left;
    protected ExpNode right;

    // constructor
    public ExpNode(String el) {
        data = el;
        left = right = null;
    }

    // methods
    // toString() - this is how an ExpNode represents itself as a String
    public String toString() {
        return data;
    }

}
