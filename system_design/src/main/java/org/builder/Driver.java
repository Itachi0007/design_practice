package org.builder;

public class Driver {
    public static void main(String[] args) {
        PersonBad p1 = new PersonBad("acb@gm.com", "Ahmer")
                                .personBuilder("13-08-1997")
                                .personBuilder(8953219150L)
                                .personBuilder(26).build();
        System.out.println(p1.toString());

        PersonBad p2 = new PersonBad("acb@gm.com", "Itachi")
                .personBuilder("13-08-1007")
                .personBuilder(8953219750L)
                .personBuilder(262).build();
        System.out.println(p2.toString());

    }
}
