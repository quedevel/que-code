import { recipes } from './data'

interface RecipeProps {id: string, name: string, ingredients: string[]}
export default function RecipeList() {
    return (
        <div>
            <h1>Recipes</h1>
            {recipes.map((recipe: RecipeProps) => (
                <Recipe key={recipe.id} {...recipe} />
            ))}
        </div>
    )
}

function Recipe({ name, ingredients }: RecipeProps ) {
    return (
        <div>
            <h2>
                {name}
            </h2>
            <ul>
                {ingredients.map((ingredient) => (
                    <li key={ingredient}>
                        {ingredient}
                    </li>
                ))}
            </ul>
        </div>
    )
}