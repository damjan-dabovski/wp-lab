import React, { useState, useEffect } from 'react';
import axios from '../../custom-axios/axios'
import { useParams } from 'react-router'

const IngredientDetails = () => {
    const [ingredient, setIngredient] = useState({});
    const [pizzas, setPizzas] = useState([])
    const { ingredientId } = useParams();

    useEffect(() => {
        axios.get("/api/ingredients/" + ingredientId).then((data) => {
            setIngredient(data.data);
            //debugger;
        });
        axios.get("/api/ingredients/" + ingredientId + "/pizzas").then((data) => {
            setPizzas(data.data);
        });
    }, [])

    const pizzaList = pizzas.map((pizza) => {
        return (
            <tr key={pizza.name}>
                <td>{pizza.name}</td>
                <td>{pizza.veggie ? "true" : "false"}</td>
            </tr>

        )
    })

    return (
        <div className="container">
            <h2>Name: {ingredient.name} </h2>
            <h2>Amount: {ingredient.amount} </h2>
            <h2>Veggie: {ingredient.veggie ? "true" : "false"} </h2>
            <h2>Spicy: {ingredient.spicy ? "true" : "false"} </h2>

            <table className="table tr-history table-striped small">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Veggie</th>
                    </tr>
                </thead>
                <tbody>
                    {pizzaList}
                </tbody>
            </table>
        </div>
    )
}

export default IngredientDetails;