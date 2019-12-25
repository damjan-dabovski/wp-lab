import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Redirect, Route } from 'react-router-dom';
import Header from '../Header/Header';
import Ingredients from '../Ingredient/Ingredients';
import Pizzas from '../Pizzas/Pizzas';
import IngredientsService from '../../repository/axiosIngredientsRepository';
import IngredientAdd from '../IngredientAdd/IngredientAdd';
import IngredientEdit from '../IngredientEdit/IngredientEdit';
import IngredientDetails from '../IngredientDetails/IngredientDetails';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      ingredients: []
    }
  }

  componentDidMount() {
    this.loadIngredients();
  }

  addIngredient = (newIngredient) => {
    IngredientsService.addIngredient(newIngredient)
    .then((response) => {
      const newIngredient = response.data;
      this.setState((prevState) => {
        const newIngredientsRef = [...prevState.ingredients, newIngredient]
        return{
          "ingredients": newIngredientsRef
        }
      });
    });
  }

  loadIngredients = () => {
    IngredientsService.fetchIngredients()
      .then(response => {
        console.log(response.data.content);
        this.setState(prevState => {
          return {
            "ingredients": response.data.content
          }
        })
      })
  }

  editIngredient = ((editedIngredient) => {
    IngredientsService.editIngredient(editedIngredient).then((response) => {
      const newIngredient = response.data;
      this.setState((prevState) => {
        const newIngredientsRef = prevState.ingredients.map((item)=>{
          //debugger;
          if(item.name===newIngredient.name){
            return newIngredient;
          }
          return item;
        })
        return{
          "ingredients":newIngredientsRef
        }
      });
    });
  });

  deleteIngredient = (ingredientName) => {
    IngredientsService.deleteIngredient(ingredientName).
    then((response) => {
      this.setState((state) => {
        const ingredients = state.ingredients.filter((i) => {
          return i.name != ingredientName;
        })
        return {ingredients}
      })
    })
  }

  render() {
    const routing = (
      <Router>
        <Header />
        <Route path={"/ingredients"} exact render={() => <Ingredients props={this.state.ingredients} onDelete={this.deleteIngredient} />}>
        </Route>
        <Route path={"/ingredients/new"} render={() => <IngredientAdd onNewIngredientAdded={this.addIngredient}/>}>
        </Route>
        <Route path={"/ingredients/:ingredientId/edit"} render={() => <IngredientEdit onSubmit={this.editIngredient}/>}>
        </Route>
        <Route path={"/ingredients/:ingredientId/details"} render={() => <IngredientDetails/>}>
        </Route>
        <Route path={"/pizzas"}>
          <Pizzas />
        </Route>
        <Route>
          <Redirect to={"/"} />
        </Route>
      </Router>
    )

    return (
      <div className="App">
        {routing}
      </div>
    )
  }
}

export default App;
