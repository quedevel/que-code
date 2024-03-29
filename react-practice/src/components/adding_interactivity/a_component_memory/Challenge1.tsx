import { useState } from 'react'
import { sculptureList } from './data'

export default function Gallery() {
    const [index, setIndex] = useState<number>(0)
    const [showMore, setShowMore] = useState<boolean>(false)

    const handleNextClick = () => {
        setIndex(index + 1)
    }

    const handlePreviousClick = () => {
        setIndex(index - 1)
    }

    const handleMoreClick = () => {
        setShowMore(!showMore)
    }

    let sculpture = sculptureList[index]
    return (
        <>
            {index !== 0 && <button onClick={handlePreviousClick}>Previous</button>}
            {index !== sculptureList.length-1 && <button onClick={handleNextClick}>Next</button>}
            <h2>
                <i>{sculpture.name} </i>
                by {sculpture.artist}
            </h2>
            <h3>
                ({index + 1} of {sculptureList.length})
            </h3>
            <button onClick={handleMoreClick}>
                {showMore ? 'Hide' : 'Show'} details
            </button>
            {showMore && <p>{sculpture.description}</p>}
            <img
                src={sculpture.url}
                alt={sculpture.alt}
            />
        </>
    )
}
