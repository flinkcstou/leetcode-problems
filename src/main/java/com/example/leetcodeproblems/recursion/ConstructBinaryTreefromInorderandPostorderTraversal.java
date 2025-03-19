package com.example.leetcodeproblems.recursion;

import java.util.*;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    public static void main(String[] args) {

//        Set<Integer> postSet = new HashSet<>();
//        for (int i : postorder) {
//            postSet.add(i);
//        }
//

//
//        Map<Integer, Integer> postMap = new HashMap<>();
//        for (int i = 0; i < postorder.length; i++) {
//            postMap.put(postorder[i], i);
//        }
//
//        TreeNode treeNode1 = new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//
//        System.out.println(treeNode1);
//
//        TreeNode treeNode2 = new ConstructBinaryTreefromInorderandPostorderTraversal().buildTreeBest(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
//
//        System.out.println(treeNode2);

        TreeNode treeNode2 = new ConstructBinaryTreefromInorderandPostorderTraversal().buildTreeBest2(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

        System.out.println(treeNode2);
    }

    public TreeNode buildTreeBest2(int[] inorder, int[] postorder) {

        Map<Integer, Integer> mapIn = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapIn.put(inorder[i], i);
        }

        return recursionBest2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, mapIn);

    }

    public TreeNode recursionBest2(int[] inorder, int ins, int ine, int[] postorder, int posts, int poste, Map<Integer, Integer> mapIn) {
        if (ins > ine || posts > poste) {
            return null;
        }

        int val = postorder[poste];
        int index = mapIn.get(val);

        TreeNode treeNode = new TreeNode(val);


        int count = index - ins;
        int count2 = ine - index;
        treeNode.left = recursionBest2(inorder, ins, index - 1, postorder, posts, posts + count - 1, mapIn);
        treeNode.right = recursionBest2(inorder, index + 1, ine, postorder, poste - count2, poste - 1, mapIn);

        return treeNode;

    }

    public TreeNode buildTreeBest(int[] inorder, int[] postorder) {

        return recursionBest(inorder, postorder);

    }


    public TreeNode recursionBest(int[] inOrder, int[] postorder) {
        if (inOrder.length <= 0) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        int val = postorder[postorder.length - 1];
        int index = inOrder.length - 1;

        for (int i = postorder.length - 1; i >= 0; i--) {
            if (inMap.containsKey(postorder[i])) {
                val = postorder[i];
                index = inMap.get(postorder[i]);
                break;
            }
        }

        int[] inOrderLeft = Arrays.copyOfRange(inOrder, 0, index);
        int[] inOrderRight = Arrays.copyOfRange(inOrder, index + 1, inOrder.length);

        TreeNode treeNode = new TreeNode(val);
        treeNode.left = recursionBest(inOrderLeft, postorder);
        treeNode.right = recursionBest(inOrderRight, postorder);

        return treeNode;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0, j = postorder.length - 1; i < j; i++, j--) {
            int temp = postorder[i];
            postorder[i] = postorder[j];
            postorder[j] = temp;
        }
//

        return recursion(Arrays.stream(postorder).boxed().toList(), Arrays.stream(inorder).boxed().toList());

    }

    public TreeNode recursion(List<Integer> reversedPostOrder, List<Integer> inOrder) {
        if (inOrder.isEmpty()) {
            return null;
        }

        Set<Integer> inOrderSet = new HashSet<>(inOrder);

        Integer val = reversedPostOrder.stream().filter(inOrderSet::contains).findFirst().get();
        int index = inOrder.indexOf(val);

        List<Integer> firstPart = new ArrayList<>(inOrder.subList(0, index));
        List<Integer> secondPart = new ArrayList<>(inOrder.subList(index + 1, inOrder.size()));

        TreeNode treeNode = new TreeNode(val);

        treeNode.left = recursion(reversedPostOrder, firstPart);
        treeNode.right = recursion(reversedPostOrder, secondPart);

        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
