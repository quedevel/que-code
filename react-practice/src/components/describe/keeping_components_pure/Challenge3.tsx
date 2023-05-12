type Story = {
    id: string;
    label: string;
}

type StoryTrayProps = {
    stories: Story[];
}

export default function StoryTray({ stories }: StoryTrayProps) {
    const arr: Story[] = [...stories, { id: 'create', label: 'Create Story' }];

    return (
        <ul>
            {arr.map((story) => (
                <li key={story.id}>
                    {story.label}
                </li>
            ))}
        </ul>
    );
}