import { useContext, useState } from "react";
import { Route, Switch } from 'react-router-dom';
import Login from './login-registration/Login'
import Register from './Register'
import {roleContext} from "./RoleContext"

export default function App() {

  const [role, setRole] = useState('');
  const [email, setEmail] = useState('');


  return (
    <div className="App">
      <Switch>
          <Route path='/login'>
            <Login setRole={setRole} setEmail={setEmail}/>
          </Route>
          <Route path='/register'>
            <Register/>
          </Route>
          <Route path='/'>
            <p>MAIN</p>
          </Route>
      </Switch>
    </div>
  );
}
