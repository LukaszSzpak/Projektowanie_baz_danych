import { useContext } from "react";
import { Route, Switch, BrowserRouter } from 'react-router-dom';
import Login from './Login'
import Register from './Register'
import {roleContext} from "./RoleContext"
import * as React from "react";

import { Admin, Resource } from 'react-admin';
import localStorageDataProvider from 'ra-data-local-storage';

import AdminMenu from './menus/AdminMenu'
import UserMenu from './menus/UserMenu'
import LibrarianMenu from './menus/LibrarianMenu'

import BooksList from './listVievs/BooksList'
import AdminBookList from './listVievs/AdminBookList'
import WishList from './listVievs/WishList'



const dataProvider = localStorageDataProvider({
  defaultData: {
      books: [
          { id: 1, title: 'Dziady cz 3' , author: 'Adam Mickiewicz', description: 'baśń', avalible: true},
          { id: 2, title: 'Myszy i Ludzie', author: 'John Steinbeck', description: 'baśń', avalible: true},
          { id: 3, title: 'ewrwe' , author: 'Aderkiewicz', description: 'super książka', avalible: false},
          { id: 4, title: 'were', author: 'John wernbeck', description: 'baśń', avalible: true} ]
  }
});

const App = () => {
  return (
      <div>
      <BrowserRouter>
    <Switch>
    
    <Route path='/books'>
      <Admin dataProvider={dataProvider}>
          <Resource name="books" list={AdminBookList} />
      </Admin>
    </Route>

    <Route path='/'>
      <p>MAIN</p>
    </Route>

  </Switch>
    </BrowserRouter>
   </div>)
}

export default App


