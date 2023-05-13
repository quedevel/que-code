import { useCounter3 } from './useCounter';

export default function Counter() {
    const count = useCounter3(1000);
    return <h1>Seconds passed: {count}</h1>;
}
