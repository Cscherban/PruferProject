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

    private int[] insertVertexData(int n, int arr[]){
        int[] newArr = new int[arr.length];
        int offset = 0;
        int i = 0;
        do{
           if(offset ==0 && (n < arr[i] || arr[i] == 0)){
               newArr[i] = n;
               offset = 1;
           }
           newArr[i + offset] = arr[i];

        }while(newArr[i++ + offset] != 0 || i < arr.length);

        return newArr;
    }


    private Node pruferHelper(Node grandParent, int[] nodeList, int[] prufer){
        return null;
    }


    public static Node treeFromPrufer(int m, int prufer[]){
        int nodeList[] = new int[m];
        boolean found;
        int index = 0;
        for(int i = 1; i <= m; i++){
            found = false;
            for(int j = 0; !found && j < prufer.length && prufer[j] != 0; j++ ){
                found = prufer[j] == i;
            }
            if(!found){
               nodeList[index++] = i;
            }
        }

        return pruferHelper();



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
            children = new ArrayList<>();
        }
        private Node(int data){
            this(data,null);
        }

    }
}






