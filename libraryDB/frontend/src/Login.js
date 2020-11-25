import {useState} from 'react';
import {Grid, TextField, Button, Tab, Typography} from "@material-ui/core"
import {useHistory, Link} from "react-router-dom";
import {roles} from "./Roles"
import {roleContext} from "./RoleContext"

export default function Login() {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const history = useHistory();

    let userRole;

    function handleLogin() {
        fetch(`/api/account?email=${email}&password=${password}`)
            .then(
                response => {
                    if(response.ok) {
                        response.json()
                            .then(account =>{
                               userRole = account.hasOwnProperty("role") ? account["role"] : "user";
                            })
                    }
                    else {
                        alert("Incorrect credentials");
                    }
                    return response.ok;
            }).catch(error =>{
                alert("Incorrect credentials");
            })
    }

    return(
        <Grid
            container
            direction="row"
            justify="center"
            alignItems="center"
            >
            <div>
                <form>
                    <Grid item xs={12}>
                        <TextField id="email-input" label="email" onInput={ e =>setEmail(e.target.value)} />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField id="password-input" label="password" onInput={ e =>setPassword(e.target.value)} />
                    </Grid>
                    <roleContext.Provider value={userRole}>
                        <Grid item xs={12}>
                            <Link to={handleLogin() ? '/' : '#'}>  
                                <Button type="submit" variant="contained" size="large" color="primary">Login</Button>
                            </Link>  
                        </Grid>
                    </roleContext.Provider>
                    <roleContext.Provider value={roles.USER}>
                        <Grid item xs={12}>
                            <Typography>
                                <Tab label='Register'  to='/register' component={Link} />
                            </Typography>
                        </Grid>
                    </roleContext.Provider>
                </form>
            </div>
        </Grid>
    )
}