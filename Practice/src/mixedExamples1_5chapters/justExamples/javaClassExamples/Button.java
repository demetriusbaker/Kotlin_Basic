package mixedExamples1_5chapters.justExamples.javaClassExamples;

import mixedExamples1_5chapters.justExamples.allExamplesForMarch.State;
import mixedExamples1_5chapters.justExamples.allExamplesForMarch.ViewInterface;

// interface - kotlin
// class - java

public class Button implements ViewInterface {
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(State state) {
        /*

         */
    }

    public class ButtonState implements State{}
}

/*
class Button : View {
        override fun getCurrentState(): State = ButtonState()
        override fun restoreState(state: State){}
        class ButtonState: State{}
}
 */


