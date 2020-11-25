import { Route, Switch } from 'react-router-dom';
import Login from './Login'
import Register from './Register'


export default function App() {
  return (
    <div className="App">
      <Switch>
        <Route path='/login'>
          <Login/>
        </Route>
        <Route path='/register'>
          <Register/>
        </Route>
      </Switch>
    </div>
  );
}
