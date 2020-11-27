import './App.css';
import UserMenu from './UserMenu'
import LibrarianMenu from './LibrarianMenu'
import AdminMenu from './AdminMenu'
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import * as React from "react";
import localStorageDataProvider from 'ra-data-local-storage';
import BooksList from './BooksList';
import { Admin, Resource } from 'react-admin';


const dataProvider = localStorageDataProvider({
    defaultData: {
        books: [
            { id: 1, title: 'Dziady cz 3' , author: 'Adam Mickiewicz', category: 'baśń'},
            { id: 2, title: 'Myszy i Ludzie', author: 'John Steinbeck', category: 'baśń' },
            { id: 3, title: 'ewrwe' , author: 'Aderkiewicz', category: 'bawerśń'},
            { id: 4, title: 'were', author: 'John wernbeck', category: 'bwerwń' } ]
    }
}); 


const App = () => (
    <div className="App">
    <BrowserRouter>
      <Switch>

        <Route path='/user'>
            <UserMenu />
        </Route>

        <Route path='/librarian'>
            <LibrarianMenu />
        </Route>

        <Route path='/admin'>
            <AdminMenu />
        </Route>

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
</div>
);

export default App;

/*
    <Admin dataProvider={dataProvider}>
       <Resource name="books" list={BooksList} />
    </Admin>
*/