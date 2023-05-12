import { getImageUrl2, Person } from './utils';

interface AvatarProps {
    person: Person
    size: number
}

function Avatar({ person, size }: AvatarProps) {
    return (
        <img
            className="avatar"
            src={getImageUrl2(person, size < 90? 's':'b')}
            alt={person.name}
            width={size}
            height={size}
        />
    );
}

export default function Profile() {
    return (
        <Avatar
            size={120}
            person={{
                name: 'Gregorio Y. Zara',
                imageId: '7vQD0fP'
            }}
        />
    );
}