import { useRef, useState } from 'react' 
import { flushSync } from 'react-dom' 

type Cat = {
    id: number 
    imageUrl: string 
} 

const catList: Cat[] = [] 

for (let i = 0;  i < 10; i++) {
    catList.push({
        id: i,
        imageUrl: 'https://placekitten.com/250/200?image=' + i
    }) 
}

export default function CatFriends() {
    const selectedRef = useRef<HTMLLIElement>(null) 
    const [index, setIndex] = useState(0) 

    const handleNextScroll = () => {
        flushSync(() => {
            if (index < catList.length - 1) {
                setIndex(index + 1) 
            } else {
                setIndex(0) 
            }
        }) 
        if(selectedRef.current){
            selectedRef.current.scrollIntoView({
                behavior: 'smooth',
                block: 'nearest',
                inline: 'center'
            }) 
        }
    } 

    return (
        <>
            <nav>
                <button onClick={handleNextScroll}>
                    Next
                </button>
            </nav>
            <div>
                <ul>
                    {catList.map((cat, i) => (
                        <li
                            key={cat.id}
                            ref={index === i ?
                                selectedRef :
                                null
                            }
                        >
                            <img
                                className={
                                    index === i ?
                                        'active'
                                        : ''
                                }
                                src={cat.imageUrl}
                                alt={'Cat #' + cat.id}
                            />
                        </li>
                    ))}
                </ul>
            </div>
        </>
    ) 
}
