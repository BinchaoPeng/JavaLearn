package AlgorithmPractice;

/**
 * 深度遍历二叉树
 */
public class DFS {
    public static void main(String[] args) {
        TreeNode bt = Tools.BinaryTree();
        midSearch(bt);
    }

    public static void midSearch(TreeNode root) {
//        if (root.right==null&&root.left==null){
//            // 表示是 叶子 节点
//            return;
//        }

        if (root.left != null) {
            // 有左子树
            midSearch(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            //有右子树
            midSearch(root.right);
        }

    }


}
