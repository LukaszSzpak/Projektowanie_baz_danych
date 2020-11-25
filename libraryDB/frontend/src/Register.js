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
    const [role, setRole] = useState('');

    const history = useHistory();
    const userRole = useContext(roleContext);

    function handleRegistration(event) {
        event.preventDefault();

        let requestBody = {
            name: name,
            surname: surname,
            email: email,
            password: password,
        }

                    console.log(userRole);

        if(userRole.normalize() === roles.ADMIN.normalize()){
            requestBody.role = role;
        }

        fetch('/api/user', {
            method: "POST",
            body: requestBody
        }).then(response =>{
            if(!response.ok){
                let okRegistrationReturnPath = userRole.normalize() === roles.USER ? '/login' : '/'; 
                history.push(okRegistrationReturnPath);
            }
        })
    }

    function handleRoleMenuItemChange(event) {
        setRole(event.target.value);
      };

      let AdminRolePanel = null;
      if(userRole.normalize() === roles.ADMIN.normalize()){
        AdminRolePanel = (
            <Grid item xs={12}>
            <FormControl>
                <InputLabel id="role-select">Role</InputLabel>
                <Select
                    labelId="role-select"
                    id="role-select"
                    value={role}
                    onChange={handleRoleMenuItemChange}
                    >
                    {() =>{
                        const menuItems = [];
                        for (const [key, value] of Object.entries(roles)) {
                            menuItems.push(<MenuItem value={value}>{key}</MenuItem>);
                          }
                          return menuItems;
                    }}
                </Select>
            </FormControl>
        </Grid>
        );
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
                        <TextField id="password-input" label="password" onInput={ e =>setPassword(e.target.value)} />
                    </Grid>
                    {AdminRolePanel}
                    <Grid item xs={12}>
                        <Button type="submit" variant="contained" size="large" color="primary">Register</Button>
                    </Grid>
                </form>
            </div>
        </Grid>
    );
}