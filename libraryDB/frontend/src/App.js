import { useContext } from "react";
import { Route, Switch, BrowserRouter, Router } from 'react-router-dom';
import Login from './Login'
import Register from './Register'
import {roleContext} from "./RoleContext"
import * as React from "react";

import { Admin, Resource, fetchUtils } from 'react-admin';
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






function App() {
    const [email, setEmail] = React.useState('');
    const [role, setRole] = React.useState('');

    const httpClient = (url, options = {}) => {
        if (!options.headers) {
            options.headers = new Headers({ Accept: 'application/json' });
        }
        console.log(email)
        options.headers.set('User-email', email);
        return fetchUtils.fetchJson(url, options);
    };

    function handleEmailChange(value){
      setEmail(value);
    }

    function handleRoleChange(value){
      setRole(value);
    }


    const dataProvider = simpleRestProvider('http://localhost:8080/api');
    const wishListProvider = simpleRestProvider('http://localhost:8080/api', httpClient);

  return (
    <div className="App">
      <Switch>

      <Route exact path='/login'>
        <Login setEmail={handleEmailChange} setRole={handleRoleChange}/>
      </Route>

      <Route exact path='/register'>
        <Register/>
      </Route>

      {/**
      <Route exact path='/user'>
        <UserMenu />
        <p>Email: {email}</p>
      </Route>
      */}
      

      <Route exact path='/librarian'>
        <LibrarianMenu/>
      </Route>

      <Route exact path='/admin'>
        <AdminMenu />
      </Route>

      {/*
        <Admin dataProvider={dataProvider}>
          <Resource name="users" list={UserList} />
        </Admin>


        <Admin dataProvider={dataProvider}>
          <Resource name="books" list={BooksList} />
        </Admin>
     
      

        

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
      <Resource name="books" list = {BooksList} create={BookCreate} edit={BookEdit} />
          <Resource name="users" list = {UserList} create={UserCreate} edit={UserEdit} />
          <Resource name="employees" list = {EmployeeList} create={EmployeeCreate} edit={EmployeeEdit} />
 */}

    <Route exact path='/home'>
      <div>
        <GetPanel role = {role} dataProvider = {dataProvider}/>
      </div>
    </Route>
      

    </Switch>


    </div>
  );
}


function GetPanel(props) {
  if (props.role === 'admin') {
    return (
    <Admin dataProvider={props.dataProvider}>
      <Resource name="books" list = {AdminBookList} create={BookCreate} edit={BookEdit} />
      <Resource name="users" list = {UserList} create={UserCreate} edit={UserEdit} />
      <Resource name="employees" list = {EmployeeList} create={EmployeeCreate} edit={EmployeeEdit} />
    </Admin>)
    }
    else if (props.role === 'user') {
      return (
      <Admin dataProvider={props.dataProvider}>
        <Resource name="books" list = {BooksList}/>
        <Resource name="wishlist" list = {WishList}/>
      </Admin>)
    }
    else if (props.role === 'librarian') {
      return (
      <Admin dataProvider={props.dataProvider}>
        <Resource name="books" list = {AdminBookList} create={BookCreate} edit={BookEdit} />
        <Resource name="users" list = {UserList} create={UserCreate} edit={UserEdit} />
      </Admin>)
    }
    else {
      return(
        <h1>Login or sign up</h1>
      )
    }
}
export default App


