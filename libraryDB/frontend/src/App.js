import { useContext } from "react";
import { Route, Switch, BrowserRouter } from 'react-router-dom';
import Login from './Login'
import Register from './Register'
import {roleContext} from "./RoleContext"

import { Admin, Resource } from 'react-admin';
import localStorageDataProvider from 'ra-data-local-storage';

import AdminMenu from './menus/AdminMenu'
import UserMenu from './menus/UserMenu'
import LibrarianMenu from './menus/LibrarianMenu'

import BooksList from './listVievs/BooksList'
import AdminBookList from './listVievs/AdminBookList'
import WishList from './listVievs/WishList'


/* test */
const dataProvider = localStorageDataProvider({
  defaultData: {
      books: [
          { id: 1, title: 'Dziady cz 3' , author: 'Adam Mickiewicz', description: 'baśń', avalible: true},
          { id: 2, title: 'Myszy i Ludzie', author: 'John Steinbeck', description: 'baśń', avalible: true},
          { id: 3, title: 'ewrwe' , author: 'Aderkiewicz', description: 'super książka', avalible: false},
          { id: 4, title: 'were', author: 'John wernbeck', description: 'baśń', avalible: true} ]
  }
});

//const dataProvider = localStorageDataProvider('api/books')

export default function App() {
  console.log('Provider', BooksList);
  console.log('Provider', localStorageDataProvider);

  return (
    <div className="App">
      <BrowserRouter>
      <Switch>
      <Route path='/login'>
        <Login/>
      </Route>

      <Route path='/register'>
        <Register/>
      </Route>

      <Route path='/user'>
        <UserMenu />
      </Route>

      <Route path='/librarian'>
        <LibrarianMenu/>
      </Route>

      <Route path='/admin'>
        <AdminMenu />          
      </Route>

      <Route path='/books'>
        <Admin dataProvider={dataProvider}>
          <Resource name='books' list={BooksList} />
        </Admin>      
      </Route>

      <Route path='/managebooks'>
        <Admin dataProvider={dataProvider}>
          <Resource name='managebooks' list={AdminBookList} />
        </Admin>      
      </Route>

      <Route path='/wishlist'>
        <Admin dataProvider={dataProvider}>
          <Resource name='wishlist' list={WishList} />
        </Admin>      
      </Route>

      <Route path='/'>
        <p>MAIN</p>
      </Route>

    </Switch>
      </BrowserRouter>
    </div>
  );
}
