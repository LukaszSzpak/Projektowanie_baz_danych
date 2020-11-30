import React from 'react'
import {Grid, TextField, Button} from '@material-ui/core'
import { useHistory } from "react-router-dom";


export default function ShowMenu() {
    const history = useHistory();
    const manageBooks = () => history.push('/managebooks');

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
                            Hello Admin
                        </h1>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="change_data_button_adm" variant ="contained" color="primary" >Manage personel</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="manage_clients_adm" variant ="contained" color="primary" >Manage clients</Button>  
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="manage_books_adm" variant ="contained" color="primary" onClick={manageBooks}>Manage books</Button>  
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="add_new_title_adm" variant ="contained" color="primary" >Add new title</Button>    
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="add_new_book_adm" variant ="contained" color="primary" >Add new book</Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="button_log_out_adm" variant ="contained" color="primary" >Log out</Button>
                    </Grid>
                </form>
            </div>
        </Grid>
    );
}