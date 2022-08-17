package cn.jasper.java5.enums;

import cn.jasper.java5.utils.Generator;
import cn.jasper.java5.utils.TextFile;
import cn.jasper.java5.utils.Tuple;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;

import static cn.jasper.java5.enums.Input.*;
import static cn.jasper.java5.utils.Print.print;

public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration {// tagging enum
        TRANSIENT
    }
    enum State {
        RESTING {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        print("adding money " + input +": "+ input.amount() );
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        print("shut down :" + input);
                        state = TERMINAL;
                    default:
                        print("invalid input: " + input);
                }
            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {
                 switch (Category.categorize(input)) {
                    case MONEY:
                        print("adding money " + input +": "+ input.amount() );
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        print("select item: " + input + ": " + input.amount());
                        selection = input;
                        if (amount < selection.amount())
                            print("Insufficient money for " + selection);
                        else  state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        print("quite transaction: " + input);
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        print("shut down :" + input);
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            @Override
            void next() {
                print("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            @Override
            void next() {
                if (amount > 0) {
                    print("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            @Override
            void output() {
                print("Halted");
            }
        };

        private boolean isTransient = false;
        State() {}
        State(StateDuration ignoredTrans) {
            isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("Only call next(Input input) for non-transient states");
        }
        void next() {
            throw new RuntimeException("Only call next() for StateDuration.TRANSIENT states");
        }

        void output() {
            print(amount);
        }
    }

    static void run(Generator<Input> gen) {
        int count = 0;
        while (state != State.TERMINAL) {
            count++;
            state.next(gen.next());
            while (state.isTransient) state.next();
            state.output();
            if (count == 30) break;
        }
    }

    public static void main(String[] args) {
        // 创建生成器
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1) gen = new FileInputGenerator(args[0]);

        // 运行
        run(gen);
    }
}

/**
 * For a basic sanity check 进行基本的健全性检查
 */
class RandomInputGenerator implements Generator<Input> {

    @Override
    public Input next() {
        return Input.randomSelection();
    }
}

class FileInputGenerator implements Generator<Input> {

    private final Iterator<String> input;

    public FileInputGenerator(String fileName) {
        this.input = new TextFile(fileName, ";").iterator();
    }

    @Override
    public Input next() {
        if (!input.hasNext()) return null;
        return Enum.valueOf(Input.class, input.next().trim());
    }
}

enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private final Input[] values;
    Category(Input ... types) {
        values = types;
    }
    private static final EnumMap<Input, Category> categories = new EnumMap<>(Input.class);

    static {
        Arrays.stream(Category.class.getEnumConstants())
                .flatMap(category ->
                        Arrays.stream(category.values)
                                .map(input -> Tuple.tuple(input, category)))
                .forEach(t -> categories.put(t.first, t.second));
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}
