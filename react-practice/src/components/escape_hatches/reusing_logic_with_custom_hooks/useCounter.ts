import { useState, useEffect } from 'react';
import { useInterval } from './useInterval';

export function useCounter() {
    const [count, setCount] = useState<number>(0);
    useEffect(() => {
        const id = setInterval(() => {
            setCount(c => c + 1);
        }, 1000);
        return () => clearInterval(id);
    }, []);
    return count;
}

export function useCounter2(delay: number) {
    const [count, setCount] = useState(0);
    useEffect(() => {
        const id = setInterval(() => {
            setCount(c => c + 1);
        }, delay);
        return () => clearInterval(id);
    }, [delay]);
    return count;
}

export function useCounter3(delay: number) {
    const [count, setCount] = useState(0);
    useInterval(() => {
        setCount(c => c + 1);
    }, delay);
    return count;
}
