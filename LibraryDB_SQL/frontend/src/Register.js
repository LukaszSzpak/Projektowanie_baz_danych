import { Select, Grid, TextField, Button, FormControl, InputLabel, MenuItem } from "@material-ui/core"
import { useContext, useState } from "react";
import { roleContext } from "./RoleContext"
import { roles } from "./Roles"
import {useHistory} from "react-router-dom";


export default function Register() {

    const [name, setName] = useState('');
    const [surname, setSurname] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const history = useHistory();

    function handleRegistration(event) {
        event.preventDefault();

        let requestBody = {
            name: name,
            surname: surname,
            email: email,
            password: password,
        }

        fetch('/api/users', {
            method: "POST",
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        }).then(response =>{
            if(response.ok){
                alert("Account created succesfully");
                history.push('/login');
            } else {
                history.push('#');
                alert("Wrong data !");
            }
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
                <form onSubmit={handleRegistration}>
                    <Grid item xs={12}>
                        <TextField id="name-input" label="name" onInput={ e =>setName(e.target.value)} />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField id="surname-input" label="surname" onInput={ e =>setSurname(e.target.value)} />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField id="email-input" label="email" onInput={ e =>setEmail(e.target.value)} />
                    </Grid>
                    <Grid item xs={12}>
                        <TextField id="password-input" label="password" type="password" onInput={ e =>setPassword(e.target.value)} />
                    </Grid>
                    <Grid item xs={12}>
                        <Button type="submit" variant="contained" size="large" color="primary">Register</Button>
                    </Grid>
                </form>
            </div>
        </Grid>
    );
}