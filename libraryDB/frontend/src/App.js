import { useContext } from "react";
import { Route, Switch } from 'react-router-dom';
import Login from './Login'
import Register from './Register'
import {roleContext} from "./RoleContext"

export default function App() {

  return (
    <div className="App">
      <roleContext value="user">
        <Switch>
            <Route path='/login'>
              <Login/>
            </Route>
            <Route path='/register'>
              <Register/>
            </Route>
            <Route path='/'>
              <p>MAIN</p>
            </Route>
        </Switch>
      </roleContext>
    </div>
  );
}
