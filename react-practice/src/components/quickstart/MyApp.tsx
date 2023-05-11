import React, {useState} from 'react';
import MyButton from './MyButton'
import Profile from "./Profile";
import ShoppingList from "./ShoppingList";

export default function MyApp(){
    const [count, setCount] = useState<number>(0)

    const handleClick = (): void => {
        setCount(count + 1);
    }

    return (
        <div>
            <Profile /> <br />
            <MyButton count={count} onClick={handleClick}/>
            <MyButton count={count} onClick={handleClick}/>
            <ShoppingList/>
        </div>
    )
}


