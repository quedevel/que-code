
import { useState } from 'react';

type Reducer<S, A> = (state: S, action: A) => S;

export function useReducer<S, A>(
    reducer: Reducer<S, A>,
    initialState: S,
): [S, (action: A) => void] {
    const [state, setState] = useState<S>(initialState);

    function dispatch(action: A) {
        const nextState = reducer(state, action);
        setState(nextState);
    }

    return [state, dispatch];
}