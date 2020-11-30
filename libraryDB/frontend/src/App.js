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

import restProvider from 'ra-data-simple-rest'
import UserAdminPanel from "./admin-account-system/EmployeeAdminPanel";
import EmployeeAdminPanel from './admin-account-system/EmployeeAdminPanel'




const dataProvider = restProvider('http://localhost:8080');

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

      <Route path='/booklist'>
        <Admin dataProvider={dataProvider}>
          <Resource name="books" list={BooksList} />
        </Admin>      
      </Route>

      <Route path='/userlist'>
        <UserAdminPanel/>     
      </Route>

      <Route path='/employeelist'>
        <EmployeeAdminPanel />
      </Route>

      <Route path='/adminbooklist'>
        <Admin dataProvider={dataProvider}>
          <Resource name="books" list={AdminBookList} />
        </Admin>      
      </Route>

      <Route path='/wishlist'>
          <Admin dataProvider={dataProvider}>
            <Resource name="wishlist" list={WishList} />
          </Admin>     
      </Route>
    </Switch>
    </div>
  );
}

export default App


