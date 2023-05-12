export function getFinalState(baseState: number, queue: Array<number | ((prevState: number) => number)>): number {
    let finalState = baseState;

    for (const element of queue) {
        if (typeof element === 'function') {
            finalState = element(finalState);
        } else {
            finalState = element;
        }
    }

    return finalState;
}