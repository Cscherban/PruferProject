package com.company;

import java.util.List;
import java.util.ArrayList;
public class Main {

    private Node getNode(Node head, int data){
        if(head.parent != null){
            System.out.print("please give me a \"root\", otherwise the method might not terminate");
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
           if(offset ==0 && (n > arr[i] || arr[i] == 0)){
               newArr[i] = n;
               offset = 1;
           }
           newArr[i + offset] = arr[i];

        }while(newArr[i++ + offset] != 0 || i < arr.length);

        return newArr;
    }

    private boolean contains(int n, int[] arr){
        for(int i :arr){
            if(n == i){
                return true;
            }
        }
        return false;
    }


    private int[][] arrayRepresentation(int m, int lastLeaf ,int[] leafList, int[] prufer){
       int[][] arr = new int[m][m];
       for(int i = 0; i < prufer.length; i++){
           int index = prufer[i];
           prufer[i] = 0;

           int smallest = leafList[lastLeaf];
           leafList[lastLeaf--] = 0;

           int insertIndex = 0;
           while(arr[index][insertIndex] != 0 && insertIndex < m){
               insertIndex++;
           }
           arr[index][insertIndex] = smallest;

           if(!contains(index,prufer)){
               leafList = insertVertexData(index,leafList);
               lastLeaf++;
           }
       }
       return arr;

    }

    private Node treeFromArrayRepresentation(int[][] array, int index, Node parent){
        if(array[index][0] == 0){
            return new Node(index + 1, parent);
        }else{
            Node n = new Node(index + 1, parent);
            for(int i = 0; i < array[index].length && array[index][i] != 0; i++){
                n.children.add(treeFromArrayRepresentation(array,array[index][i] - 1,n));
            }
            return n;
        }
    }


    public Node treeFromPrufer(int m, int prufer[]){
        int leafList[] = new int[m];
        boolean found;
        int index = 0;
        for(int i = m; i >= 1; i--){
            found = false;
            for(int j = 0; !found && j < prufer.length && prufer[j] != 0; j++ ){
                found = prufer[j] == i;
            }
            if(!found){
               leafList[index++] = i;
            }
        }

        int[][] arrayRepresentation = arrayRepresentation( m, index -1,leafList,prufer);

        int parentIndex = 0;
        while(arrayRepresentation[parentIndex][0] == 0 && parentIndex < m){
            parentIndex++;
        }
        if(parentIndex == m){
            return null;
        }

        return treeFromArrayRepresentation(arrayRepresentation,parentIndex, null);



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






