import React from 'react'
import {Grid, TextField, Button} from '@material-ui/core'
import { useHistory } from "react-router-dom";

export default function ShowMenu() {
    const history = useHistory();
    const login = () => history.push('/login'); 
    const signUp = () => history.push('/register')
    const continueAsguest = () => history.push('/home')

    return (
        <Grid
            container
            direction="row"
            justify="center"
            alignItems="center"
            >
            <div>
                <form>
                    <Grid item xs={12}>
                        <h1>
                            Hello, please login up or sign up.
                        </h1>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="login_button" variant ="contained" color="primary" onClick={login}>Login</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="register_button" variant ="contained" color="primary" onClick={signUp}>Sign up</Button>  
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="continue_as_guest" variant ="contained" color="primary" onClick={continueAsguest}>Continue as guest</Button>  
                    </Grid>
                </form>
            </div>
        </Grid>
    );
}