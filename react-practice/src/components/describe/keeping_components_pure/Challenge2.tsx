import Panel from './Panel';
import {getImageUrl, Person} from './utils';

type ProfileProps = {
    person: Person;
}

export default function Profile({ person }: ProfileProps) {
    return (
        <Panel>
            <Header person={person}/>
            <Avatar person={person}/>
        </Panel>
    )
}

function Header({person}: ProfileProps) {
    return <h1>{person.name}</h1>;
}

function Avatar({person}: ProfileProps) {
    return (
        <img
            className="avatar"
            src={getImageUrl(person)}
            alt={person.name}
            width={50}
            height={50}
        />
    );
}
