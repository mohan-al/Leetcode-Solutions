/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
       Queue<Pair> queue = new LinkedList<>();
       queue.offer(new Pair(root, 0));

       int maxWidth = 0;

       while(!queue.isEmpty()) {
        int size = queue.size();
        long start = queue.peek().index;
        long end = start;

        for(int i=0; i<size; i++) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;

            long index = curr.index - start;
            end = index;

            if(node.left != null) {
                queue.offer(new Pair(node.left, 2 * index));
            }
            if(node.right != null) {
                queue.offer(new Pair(node.right, 2 * index + 1));
            }
        }
        maxWidth = Math.max(maxWidth, (int)end+1);
       }
       return maxWidth;
    }
}