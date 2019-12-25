import React from 'react';
import { Link } from 'react-router-dom'

const Ingredients = (props) => {
    //debugger;
    if (props.props.length === 0) {
        return (
            <div>
                <h1>There are no ingredients to display.</h1>
                <Link to="/ingredients/new">
                    <button className="btn btn-outline-secondary">
                        <span><strong>Add new ingredient</strong></span>
                    </button>
                </Link>
            </div>
        )
    }
    const ingredients = props.props.map((ingredient) => {
        return (
            <tr key={ingredient.name}>
                <td>{ingredient.name}</td>
                <td>{ingredient.amount}</td>
                <td>{ingredient.spicy.toString()}</td>
                <td>{ingredient.veggie.toString()}</td>
                <td>
                    <Link to={"/ingredients/" + ingredient.name + "/edit"}>
                        <button className="btn btn-sm btn-secondary">
                            <span className="fa fa-edit" />
                            <span><strong>Edit</strong></span>
                        </button>
                    </Link>
                    <button onClick={() => props.onDelete(ingredient.name)} className="btn btn-sm btn-outline-secondary ">
                        <span className="fa fa-remove" />
                        <span><strong>Remove</strong></span>
                    </button>
                    <Link to={"/ingredients/" + ingredient.name + "/details"}>
                        <button className="btn btn-sm btn-outline-dark">
                            <span><strong>Details</strong></span>
                        </button>
                    </Link>
                </td>
            </tr>
        )
    })
    return (
        <div className="container">
            <div className="row">
                <h4 className="text-upper text-left">Ingredients</h4>
                <div className="table-responsive">
                    <table className="table tr-history table-striped small">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Amount</th>
                                <th scope="col">Spicy</th>
                                <th scope="col">Veggie</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {ingredients}
                        </tbody>
                    </table>
                </div>
                <Link to="/ingredients/new">
                    <button className="btn btn-outline-secondary">
                        <span><strong>Add new ingredient</strong></span>
                    </button>
                </Link>
            </div>
        </div>
    )
}

export default Ingredients;