package cn.jasper.java5.enums;


import cn.jasper.java5.utils.Enums;

public enum SecurityCategory {

    STOCK(Security.Stock.class), BOND(Security.Bond.class);

    private final Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.printf("%s: %s%n", category, category.randomSelection());
        }
    }


}
