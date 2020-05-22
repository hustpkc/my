/**
 * @author Pario
 * @description
 * @date 2020/5/21 17:31
 */
public class DeleteBSTNode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            /*左子树为空，直接返回右子树*/
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                /*左右子树都不为空，要删除当前节点，并在右子树中找到最小的节点*/
                TreeNode tmp = min(root.right);
                /*tmp.left = root.left;
                tmp.right = deleteMin(root.right);*/
                /*此处不能按照以上写法，调换前后顺序才能通过检测*/
                tmp.right = deleteMin(root.right);
                tmp.left = root.left;
                return tmp;
            }
        }
    }

    /*找到树种的最小节点*/
    private TreeNode min(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    /*删除最小的节点*/
    private TreeNode deleteMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }
        /*左子树不为空，在左子树中找到最小值*/
        node.left = deleteMin(node.left);
        return node;
    }
}
