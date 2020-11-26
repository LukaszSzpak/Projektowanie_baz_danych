import './App.css';
import UserMenu from './UserMenu'
import LibrarianMenu from './LibrarianMenu'
import AdminMenu from './AdminMenu'
import { BrowserRouter, Route, Switch } from 'react-router-dom';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
      <Switch>
      
        <Route path='/user'>
          <UserMenu/>
        </Route>

        <Route path='/librarian'>
          <LibrarianMenu/>
        </Route>

        <Route path='/admin'>
          <AdminMenu/>
        </Route>

        <Route path='/'>
          <p>MAIN</p>
        </Route>

      </Switch>
    </BrowserRouter>
    </div>
  );
}

export default App;
