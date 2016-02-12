package round2;

public class test331 {
    public static void main(String[] args) {
        System.out.println(new test331().isValidSerialization("1"));
        System.out.println(new test331().isValidSerialization("1,#,2"));
        System.out.println(new test331().isValidSerialization("9,#,#,1"));
        System.out.println(new test331().isValidSerialization(""));
        System.out.println(new test331().isValidSerialization("#"));
        System.out.println(new test331().isValidSerialization("1,#,2,#,#"));
        System.out.println(new test331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    public boolean isValidSerialization(String preorder) {
        String[] trees = preorder.split(",");
        return isValidSerialization2(trees) && idx >= trees.length;
    }

    int idx = 0;

    public boolean isValidSerialization2(String[] trees) {
        if (idx == trees.length) {
            return true;
        }
        if (trees[idx].equals("#")) {
            idx++;
            return true;
        }
        if (idx + 2 >= trees.length) {
            return false;
        }
        idx++;
        return isValidSerialization2(trees) && isValidSerialization2(trees);
    }
}
