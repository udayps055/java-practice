import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode c = new TreeNode(3, null, null);
        TreeNode b = new TreeNode(2, null, null);
        TreeNode a = new TreeNode(1, c, b);
        bottomView(a, 0, 0);
        System.out.println(map);
        System.out.println(list);
    }

    //    public static TreeNode reverseList(TreeNode node) {
//        TreeNode prev = null, curr = null;
//        while (node != null) {
//            curr = node;
//            node = node.next;
//            curr.next = prev;
//            prev = curr;
//        }
//        return prev;
//    }
//
//    public static void printList(TreeNode node) {
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
//    }
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void bottomView(TreeNode node, int ver, int hor) {
        if (node == null) {
            return;
        }
        try {
            if (map.get(ver) > hor) {
                list.add(node.val);
            }
        } catch (Exception e) {
            list.add(node.val);
        }
        map.put(ver, hor);
        bottomView(node.left, ver - 1, hor + 1);
        try {
            if (map.get(ver) > hor) {
                list.add(node.val);
            }
        } catch (Exception e) {
            list.add(node.val);
        }
        map.put(ver, hor);
        bottomView(node.right, ver + 1, hor + 1);
    }
}
