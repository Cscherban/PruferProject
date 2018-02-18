package com.company;

import java.util.List;
import java.util.ArrayList;
public class Main {
    private int size = 0;


    private static Node getNode(Node head, int data){
        if(head.parent != null){
            System.out.print("please give me a \"root\", otherwise the method might not terminate")
        }
        if(head.data == data){
            return head;
        } else if(head.children == null){
            return null;
        }else{
            for(Node node : head.children){
                Node holder = getNode(node,data);
                if(holder != null){
                    return holder;
                }
            }
        }
        return null;
    }


    public static Node treeFromPrufer(){

    }



    public static void main(String[] args) {
	// write your code here


        //TODO WRTIE CODE
    }









    private class Node {
        private int data;
        private List<Node> children;
        private Node parent;


        private Node(int data, Node parent,List<Node> children){
            this.data = data;
            this.parent = parent;
            this.children = children;
        }

        private Node(int data, Node parent){
            this(data,parent,null);
        }
        private Node(int data){
            this(data,null,null);
        }

    }
}






