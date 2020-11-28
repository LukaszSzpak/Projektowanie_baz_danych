import './App.css';
import UserMenu from './UserMenu'
import LibrarianMenu from './LibrarianMenu'
import AdminMenu from './AdminMenu'
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import * as React from "react";
import localStorageDataProvider from 'ra-data-local-storage';
import BooksList from './BooksList';
import AdminBookList from './AdminBookList'
import WishList from './WishList'
import { Admin, Resource } from 'react-admin';

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
            <Resource name="books" list={BooksList} />
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
