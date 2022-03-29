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
    }
}
