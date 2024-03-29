package interview.tree;

import interview.tree.entity.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @Author: zhangchunmeng
 * @Date: 2019-10-10
 */
public class HasSubTree {
    public static void main(String[] args) {
    }

    boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1.val == root2.val) {
            result = tree1hasTree2(root1, root2);
        }
        if (!result) {
            result = hasSubTree(root1.left, root2);
        }
        if (!result) {
            result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    boolean tree1hasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }

        return tree1hasTree2(root1.left, root2.left) && tree1hasTree2(root1.right, root2.right);
    }


}
