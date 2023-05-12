import { people } from './data'
import { getImageUrl, Person } from './utils'

export default function List() {
    const getScientists = ( scientists: Person[] ) => {
        return scientists.map( person =>
            <li key={person.id}>
                <img
                    src={getImageUrl(person)}
                    alt={person.name}
                />
                <p>
                    <b>{person.name}:</b>
                    {' ' + person.profession + ' '}
                    known for {person.accomplishment}
                </p>
            </li>
        )
    }
    return (
        <article>
            <h1>Chemists</h1>
            <ul>
                {getScientists(people.filter(person => person.profession === 'chemist'))}
            </ul>
            <h1>Everyone Else</h1>
            <ul>
                {getScientists(people.filter(person => person.profession !== 'chemist'))}
            </ul>
        </article>
    )
}
