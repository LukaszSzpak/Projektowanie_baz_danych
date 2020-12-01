import { useContext } from "react";
import { Route, Switch, BrowserRouter, Router } from 'react-router-dom';
import Login from './Login'
import Register from './Register'
import {roleContext} from "./RoleContext"
import * as React from "react";

import { Admin, Resource } from 'react-admin';
import localStorageDataProvider from 'ra-data-local-storage';

//Menus
import AdminMenu from './menus/AdminMenu'
import UserMenu from './menus/UserMenu'
import LibrarianMenu from './menus/LibrarianMenu'

//ListViews
import UserList from './admin-account-system/UserList'
import EmployeeList from './admin-account-system/EmployeeList'
import BooksList from './listViews/BookList'
import AdminBookList from './listViews/AdminBookList'
import WishList from './listViews/WishList'

//Creations
import EmployeeCreate from './admin-account-system/EmployeeCreate'
import UserCreate from './admin-account-system/UserCreate'
import BookCreate from './books/BookCreate'

//Editions
import UserEdit from './admin-account-system/UserEdit'
import EmployeeEdit from './admin-account-system/EmployeeEdit'
import BookEdit from './books/BookEdit'

import simpleRestProvider from 'ra-data-simple-rest'


const [email, setEmail] = React.useState('');
const [role, setRole] = React.useState('');

const httpClient = (url, options = {}) => {
  if (!options.headers) {
      options.headers = new Headers({ Accept: 'application/json' });
  }

  options.headers.set('User-email', {email});
  return fetchUtils.fetchJson(url, options);
};


const dataProvider = simpleRestProvider('http://localhost:8080/api');
const wishListProvider = simpleRestProvider('http://localhost:8080/api', httpClient);

{/**
const App = () => (
  <Admin dataProvider={dataProvider}>
      <Resource name="books" create={BookCreate} edit={BookEdit} />
      <Resource name="users" create={UserCreate} edit={UserEdit} />
      <Resource name="employees" create={EmployeeCreate} edit={EmployeeEdit} />
  </Admin>
);
*/}


function App() {
  return (
    <div className="App">
      <Switch>

      <Route exact path='/login'>
        <Login setEmail={setEmail} setRole={setRole}/>
      </Route>

      <Route exact path='/register'>
        <Register/>
      </Route>

      <Route exact path='/user'>
        <UserMenu />
      </Route>

      <Route exact path='/librarian'>
        <LibrarianMenu/>
      </Route>

      <Route exact path='/admin'>
        <AdminMenu />
      </Route>

      <Route exact path='/booklist'>
        <Admin dataProvider={dataProvider}>
          <Resource name="books" list={BooksList} />
        </Admin>
      </Route>

      <Route exact path='/userlist'>
        <Admin dataProvider={dataProvider}>
          <Resource name="users" list={UserList} />
        </Admin>
      </Route>

      <Route exact path='/employeelist'>
        <Admin dataProvider={dataProvider}>
          <Resource name="employees" list={EmployeeList} />
        </Admin>
      </Route>

      <Route exact path='/adminbooklist'>
        <Admin dataProvider={dataProvider}>
          <Resource name="books" list={AdminBookList} />
        </Admin>
      </Route>

      <Route exact path='/wishlist'>
        <div>
          <Admin dataProvider={wishListProvider}>
          <Resource name="wishlist" list={WishList} />
          </Admin>
      </div>
      </Route>
    </Switch>


    </div>
  );
}

export default App


