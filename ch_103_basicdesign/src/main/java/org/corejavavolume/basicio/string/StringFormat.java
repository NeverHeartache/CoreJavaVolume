package org.corejavavolume.basicio.string;

/**
 * 将整形格式化为字符串类型并且数字前边自动补零；
 */
public class StringFormat {
    public static void main(String[] args) {
        int i = 99;
        String formated = String.format("%03d", i);
        System.out.println(formated);

        String code = "000123";
        Integer parsedInt = Integer.parseInt(code) + 1;
        System.out.println(parsedInt);
        int l = 10;
        for (int j = 0; j < l; j++) {
            for (int k = 0; k <= j; k++) {
                System.out.print("* \t");
            }
            System.out.println();
        }

        String forEqual1 = "他们都是你兔子，好吃懒做还七篇人们！";
        String forEqual2 = "他们都是你兔子，好逸恶劳还七篇人们！";
        extracted(forEqual1, forEqual2);
    }

    private static void extracted(String forEqual1, String forEqual2) {
        char[] v1 = forEqual1.toCharArray();
        char[] v2 = forEqual2.toCharArray();
        int n = v1.length;
        int i = 0;
        while (n-- != 0) {
            if (v1[i] != v2[i])
                System.out.println("fasle");
            i++;
        }
        System.out.println("true");
    }
}
