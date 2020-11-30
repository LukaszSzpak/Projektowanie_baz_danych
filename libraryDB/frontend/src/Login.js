import {useState} from 'react';
import {Grid, TextField, Button, Tab, Typography} from "@material-ui/core"
import {useHistory, Link} from "react-router-dom";

export default function Login(props) {

    const [emailInput, setEmailInput] = useState('');
    const [password, setPassword] = useState('');

    let {setRole} = props;
    let {setEmail} = props;

    const history = useHistory();

    function handleLogin() {
        fetch(`/api/account?email=${emailInput}&password=${password}`)
            .then(
                response => {
                    if(response.ok) {
                        response.json()
                            .then(account =>{
                                let userRole = account.hasOwnProperty("role") ? account["role"] : "user";
                                setRole = userRole;
                                setEmail = account["email"];
                                history.push(`/${userRole}`);
                            })
                    }
                    else {
                        alert("Incorrect credentials");
                    }
                    return response.ok;
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
                        <TextField id="email-input" label="email" onInput={ e =>setEmailInput(e.target.value)} />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField id="password-input" label="password" onInput={ e =>setPassword(e.target.value)} />
                    </Grid>
                    <Grid item xs={12}>
                        <Link to={handleLogin() ? '/' : '#'}>
                            <Button type="submit" variant="contained" size="large" color="primary">Login</Button>
                        </Link>
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>
                            <Tab label='Register'  to='/register' component={Link} />
                        </Typography>
                    </Grid>
                </form>
            </div>
        </Grid>
    )
}