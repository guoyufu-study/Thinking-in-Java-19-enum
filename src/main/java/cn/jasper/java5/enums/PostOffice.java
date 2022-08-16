package cn.jasper.java5.enums;

import cn.jasper.java5.utils.Enums;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

import static cn.jasper.java5.utils.Print.print;

public class PostOffice {


    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        print("Using general delivery for " + mail);
                        return true;
                    default: return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSCANNABLE: return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT: return false;
                            default:
                                print("Delivering " + mail + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail mail) {
                switch (mail.readability) {
                    case ILLEGIBLE: return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT: return false;
                            default:
                                print("Delivering " + mail + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case MISSING: return false;
                    default:
                        print("Returning " + mail + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail mail);
    }


    static void handle(Mail mail) {
        if (Arrays.stream(MailHandler.values())
                .anyMatch(mailHandler -> mailHandler.handle(mail))) return;
        System.out.printf("%s is a dead letter%n", mail);
    }

    public static void main(String[] args) {
        Mail.generator(10).forEach(mail -> {
            print(mail.details());
            handle(mail);
            print("*****");
        });
    }


}

class Mail {

    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;

    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return this +
                ", General Delivery: " + generalDelivery +
                ", Address Scannability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }

    public static Mail randomMail() {
        Mail mail = new Mail();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        return mail;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<>() {

            int n = count;

            @NotNull
            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                };
            }
        };
    }
}
