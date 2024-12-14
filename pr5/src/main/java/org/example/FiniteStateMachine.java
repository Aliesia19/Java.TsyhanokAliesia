package org.example;
public class FiniteStateMachine {

    public static State processString(String input) { // приймає input і повертає об'єкт типу State

        State currentState = State.S;// початкови стан
        for (char c : input.toCharArray()) {
            switch (currentState) {
                case S:
                    if (c == 'T') currentState = State.STATE_1;
                    break;
                case STATE_1:
                    if (c == 'E') currentState = State.STATE_2;
                    else if (c == 'T') currentState = State.STATE_1; // Залишаємося в STATE_1
                    else currentState = State.S;
                    break;
                case STATE_2:
                    if (c == 'S') currentState = State.STATE_3;
                    else if (c == 'T') currentState = State.STATE_1; // Повертаємось у STATE_1
                    else currentState = State.S;
                    break;
                case STATE_3:
                    if (c == 'T') currentState = State.F;
                    else currentState = State.S;
                    break;
                case F:
                    // Кінцевий стан, залишаємося тут
                    break;
            }
        }
        return currentState; // Повертаємо кінцевий стан
    }
}
