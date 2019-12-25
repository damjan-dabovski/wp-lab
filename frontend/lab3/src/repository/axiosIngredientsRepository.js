import axios from '../custom-axios/axios'
import qs from 'qs'

const IngredientsService = {
    fetchIngredients: () => {
        return axios.get("/api/ingredients");
    },
    addIngredient: (newIngredient) =>{
        const formParams = qs.stringify(newIngredient);
        return axios.post("/api/ingredients",formParams,{
            headers:{
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        });
    },
    editIngredient: (ingredient) =>{
        const name = ingredient.name;
        const formParams = qs.stringify(ingredient);
        return axios.patch("/api/ingredients/"+name,formParams,{
            headers:{
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        });
    },
    deleteIngredient: (ingredientName) =>{
        return axios.delete("/api/ingredients/"+ingredientName);
    },
    fetchPizzas: (ingredientName) =>{
        return axios.get("api/ingredients/"+ingredientName+"/pizzas");
    }
}

export default IngredientsService