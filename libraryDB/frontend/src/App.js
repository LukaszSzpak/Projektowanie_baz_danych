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




const dataProvider = localStorageDataProvider({
      books: [
          { id: '1', title: 'Dziady cz 3' , author: 'Adam Mickiewicz', description: 'baśń', avalible: true},
          { id: '2', title: 'Myszy i Ludzie', author: 'John Steinbeck', description: 'baśń', avalible: true},
          { id: '3', title: 'ewrwe' , author: 'Aderkiewicz', description: 'super książka', avalible: false},
          { id: '4', title: 'were', author: 'John wernbeck', description: 'baśń', avalible: true} ],

      users: [
        {id: '1', name: 'Jan' , surname: 'Kowalski', email: 'kowalskijan@gmail.com'},
        {id: '2', name: 'Adam' , surname: 'Mickiewicz', email: 'adammickiewicz@gmail.com'},
        {id: '3', name: 'Jan' , surname: 'Komputer', email: 'komputer.com'} ],

      employees: [
          {id: '1', name: 'Jan' , surname: 'Kowalski', email: 'jakkow@gmail.com', category: 'librarian'},
          {id: '2', name: 'Adam' , surname: 'Mickiewicz', email: 'kowjan@gmail.com', category: 'admin'},
          {id: '3', name: 'Jan' , surname: 'Komputer', email: 'admic@gmail.com', category: 'librarian'} ]
});

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
        <Admin dataProvider={dataProvider}>
          <Resource name="users" list={UserList} />
        </Admin>      
      </Route>

      <Route path='/employeelist'>
        <Admin dataProvider={dataProvider}>
          <Resource name="employees" list={EmployeeList} />
        </Admin>      
      </Route>

      <Route path='/adminbooklist'>
        <Admin dataProvider={dataProvider}>
          <Resource name="books" list={AdminBookList} />
        </Admin>      
      </Route>

      <Route path='/wishlist'>
        <div> 
          <Admin dataProvider={dataProvider}>
          <Resource name="wishlist" list={WishList} />
          </Admin>
      </div>      
      </Route>
    </Switch>
      

    </div>
  );
}

export default App


